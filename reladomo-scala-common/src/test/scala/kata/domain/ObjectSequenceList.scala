/*
 * This file was automatically generated using folio-sec/sbt-reladomo-plugin. Please do not modify it.
 */
package kata.domain.scala_api

import com.folio_sec.reladomo.scala_api._
import com.folio_sec.reladomo.scala_api.exception.ReladomoException
import com.gs.fw.common.mithra.MithraBusinessException
import kata.domain.{ ObjectSequence => JavaObjectSequence }
import kata.domain.{ ObjectSequenceList => JavaObjectSequenceList }
import scala.collection.JavaConverters._

case class ObjectSequenceList(underlying: JavaObjectSequenceList,
                              override val newValueAppliers: Seq[() => Unit] = Seq.empty)
    extends TransactionalList[ObjectSequence, JavaObjectSequence] {
  override def toScalaObject(jObj: JavaObjectSequence): ObjectSequence = ObjectSequence(jObj)

  def withSimulatedSequenceName(simulatedSequenceName: String) = {
    ObjectSequenceList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () =>
        underlying.setSimulatedSequenceName(simulatedSequenceName)
      }
    )
  }
  def withNextValue(nextValue: Long) = {
    ObjectSequenceList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () =>
        underlying.setNextValue(nextValue)
      }
    )
  }

}
