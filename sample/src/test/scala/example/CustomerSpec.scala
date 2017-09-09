package example

import com.folio_sec.example.domain.simplebank.scala_api._
import com.folio_sec.reladomo.scala_api._
import com.folio_sec.reladomo.scala_api.configuration.DatabaseManager
import org.scalatest._
import unit.DatabasePreparation
import com.twitter.util._

class CustomerSpec extends FlatSpec with Matchers with DatabasePreparation {

  initializeSimpleBankDatabase()
  DatabaseManager.loadRuntimeConfig("ReladomoRuntimeConfig.xml")

  it should "have TxObject, Finder" in {
    TransactionProvider.withTransaction { implicit tx =>
      val customer: Customer = NewCustomer(firstName = "Alice", lastName = "Cooper", country = None).insert()
      NewCustomer(firstName = "Bob", lastName = "Marley", country = None).insert()
      NewCustomer(firstName = "Chris", lastName = "Brown", country = None).insert()

      CustomerFinder.findOneWith(_.firstName.eq("Bob")) match {
        case Some(bob) =>
          NewCustomerAccount(customerId = bob.customerId,
                             accountName = "Bob Marley",
                             accountType = "NORMAL",
                             areaId = None,
                             balance = 10.3).insert()
        case _ => fail("Bob is absent!")
      }
    }
    val customers = CustomerFinder.findManyWith(_.all).limit(10)
    customers.size should equal(3)
    customers.headOption.map(_.customerId) should equal(Some(1))

    // deepFetch to avoid N+1 queries
    // select t0.ACCOUNT_ID,t0.CUSTOMER_ID,t0.ACCOUNT_NAME,t0.ACCOUNT_TYPE,t0.AREA_ID,t0.BALANCE from CUSTOMER_ACCOUNT t0 where  t0.CUSTOMER_ID in ( ?,?,?) {1: 1, 2: 2, 3: 3};
    customers.deepFetch(CustomerFinder.accounts)

    CustomerFinder.findOneWith(_.firstName.eq("Bob")) match {
      case Some(bob) =>
        bob.accounts.size should equal(1)

        TransactionProvider.withTransaction { implicit tx =>
          val newAccount = NewCustomerAccount(customerId = bob.customerId,
                                              accountName = "Bob Sapp",
                                              accountType = "NORMAL",
                                              areaId = None,
                                              balance = 23.44)
          // insert into CUSTOMER_ACCOUNT(ACCOUNT_ID,CUSTOMER_ID,ACCOUNT_NAME,ACCOUNT_TYPE,AREA_ID,BALANCE) values (?,?,?,?,?,?) {1: 2, 2: 2, 3: 'Bob Sapp', 4: 'NORMAL', 5: NULL, 6: 23.44};
          newAccount.insert()
          bob.accounts.size should equal(2)
          bob.accounts.map(_.accountType).distinct should equal(Seq("NORMAL"))
        }

        TransactionProvider.withTransaction { implicit tx =>
          bob.accounts.withAccountType("Normal") // no side-effect wit this
          bob.accounts.map(_.accountType).distinct should equal(Seq("NORMAL"))
        }

        TransactionProvider.withTransaction { implicit tx =>
          // update CUSTOMER_ACCOUNT set ACCOUNT_TYPE = ?  where ACCOUNT_ID in (?,?) {1: 'Normal', 2: 1, 3: 2};
          bob.accounts.withAccountType("Normal").updateAll()
          bob.accounts.map(_.accountType).distinct should equal(Seq("Normal"))
        }

        TransactionProvider.withTransaction { implicit tx =>
          // update CUSTOMER_ACCOUNT set ACCOUNT_TYPE = ? , AREA_ID = ?  where ACCOUNT_ID in (?,?) {1: 'NORMAL', 2: 999, 3: 1, 4: 2};
          bob.accounts.withAccountType("NORMAL").withAreaId(Some(999)).updateAll()
          bob.accounts.map(_.accountType).distinct should equal(Seq("NORMAL"))
          bob.accounts.flatMap(_.areaId).distinct should equal(Seq(999))
        }

        TransactionProvider.withTransaction { implicit tx =>
          // update CUSTOMER_ACCOUNT set AREA_ID = ?  where ACCOUNT_ID in (?,?) {1: NULL, 2: 1, 3: 2};
          bob.accounts.withAreaId(None).updateAll()
          bob.accounts.flatMap(_.areaId).distinct should equal(Seq.empty)
        }

        try {
          TransactionProvider.withTransaction { implicit tx =>
            // delete  from CUSTOMER_ACCOUNT where  CUSTOMER_ID = ? {1: 2}
            bob.accounts.deleteAll()
            bob.accounts.size should equal(0)
            throw new RuntimeException
          }
        } catch {
          case scala.util.control.NonFatal(_) =>
        }
        // ensuring if the previous transaction has been rolled back
        bob.accounts.size should equal(2)

      case _ => fail("Bob is absent!")
    }
  }

  it should "have Service" in {
    val future: Future[CustomerService.TxObjectListFinder] = {
      CustomerService.findSortedManyWith(
        operation = _.all,
        orderBy = _.customerId.descendingOrderBy,
        limit = 10
      )
    }
    future.onSuccess { customers =>
      println(s"customers: ${customers}")
    }
    Await.result(future, Duration.fromSeconds(5))
  }

}
