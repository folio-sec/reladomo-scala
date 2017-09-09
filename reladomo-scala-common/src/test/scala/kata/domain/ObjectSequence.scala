/*
 * This file was automatically generated using folio-sec/sbt-reladomo-plugin. Please do not modify it.
 */
package kata.domain.scala_api

import com.folio_sec.reladomo.scala_api._
import com.folio_sec.reladomo.scala_api.util.TimestampUtil
import com.folio_sec.reladomo.scala_api.exception.ReladomoException
import com.gs.fw.common.mithra.MithraBusinessException
import kata.domain.{ ObjectSequence => JavaObjectSequence }
import kata.domain.{ ObjectSequenceList => JavaObjectSequenceList }
import scala.collection.JavaConverters._

case class NewObjectSequence(simulatedSequenceName: String, nextValue: Long) extends TransactionalObject {
  override lazy val underlying: JavaObjectSequence = {
    val underlyingObj = new JavaObjectSequence()
    underlyingObj.setSimulatedSequenceName(simulatedSequenceName)
    underlyingObj.setNextValue(nextValue)
    underlyingObj
  }
  override lazy val savedUnderlying = underlying

}

case class ObjectSequence private (override val underlying: JavaObjectSequence,
                                   simulatedSequenceName: String,
                                   nextValue: Long)
    extends TransactionalObject {
  override lazy val savedUnderlying: JavaObjectSequence = {
    underlying.setSimulatedSequenceName(simulatedSequenceName)
    underlying.setNextValue(nextValue)
    underlying
  }

}
object ObjectSequence {
  def apply(underlying: JavaObjectSequence): ObjectSequence = {
    new ObjectSequence(
      underlying = underlying,
      simulatedSequenceName = underlying.getSimulatedSequenceName,
      nextValue = underlying.getNextValue
    )
  }
}
