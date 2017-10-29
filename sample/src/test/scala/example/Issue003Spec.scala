package example

import java.sql.Timestamp
import java.util.Calendar

import com.folio_sec.example.domain.issue003.scala_api._
import com.folio_sec.reladomo.scala_api.TransactionProvider.withTransaction
import com.folio_sec.reladomo.scala_api.configuration.DatabaseManager
import com.folio_sec.reladomo.scala_api.util.TimestampUtil
import org.scalatest.{ FunSpec, Matchers }
import unit.DatabasePreparation

class Issue003Spec extends FunSpec with Matchers with DatabasePreparation {

  initializeIssue003Database()
  DatabaseManager.loadRuntimeConfig("ReladomoRuntimeConfig.xml")

  describe("Related object with non existent condition") {
    it("should return None") {
      withTransaction { implicit tx =>
        NewParentObject(name = "name1").insert()
      }

      val maybeParent = ParentObjectFinder.findOneWith(_.name.eq("name1"))

      maybeParent match {
        case Some(parent) =>
          //since there is no child object inserted, it should return None.
          parent.relatedObject(TimestampUtil.now()) should equal(None)
        case _ =>
          fail()
      }
    }
  }

  describe("Bi-temporal object") {
    it("updates attributes with non-infinite businessTo attribute without touching primary key") {
      withTransaction { implicit tx =>
        val parentObject = NewParentObject(name = "name2").insert()
        NewBitemporalChildObject(name = "name", state = 1, parentObject.id)
          .insertUntil(createTimestamp(9000, 1, 1)) //using long time away so that the test is practically deterministic
      }

      ParentObjectFinder.findOneWith(_.name.eq("name2")) match {
        case Some(parent) =>
          parent.relatedObject(TimestampUtil.now()) match {
            case Some(child: BitemporalChildObject) =>
              withTransaction { implicit tx =>
                child.copy(name = "updated name").update()
              }
            case _ => fail()
          }
        case _ => fail()
      }

      val maybeUpdatedChild = BitemporalChildObjectFinder.findOneWith(_.businessDate.eq(TimestampUtil.now()))

      maybeUpdatedChild match {
        case Some(child) =>
          child.name should equal("updated name")
        case _ =>
          fail()
      }
    }

  }

  private[this] def createTimestamp(year: Int, month: Int, dayOfMonth: Int): Timestamp = {
    val cal = Calendar.getInstance
    cal.set(Calendar.YEAR, year)
    cal.set(Calendar.MONTH, month - 1)
    cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
    cal.set(Calendar.AM_PM, Calendar.AM)
    cal.set(Calendar.HOUR_OF_DAY, 0)
    cal.set(Calendar.MINUTE, 0)
    cal.set(Calendar.SECOND, 0)
    cal.set(Calendar.MILLISECOND, 0)
    new Timestamp(cal.getTimeInMillis)
  }

}
