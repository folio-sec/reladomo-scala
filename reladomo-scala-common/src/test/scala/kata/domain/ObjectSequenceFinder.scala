/*
 * This file was automatically generated using folio-sec/sbt-reladomo-plugin. Please do not modify it.
 */
package kata.domain.scala_api

import com.folio_sec.reladomo.scala_api._
import com.folio_sec.reladomo.scala_api.exception.ReladomoException
import com.gs.fw.common.mithra.MithraBusinessException
import kata.domain.{ ObjectSequence => JavaObjectSequence }
import scala.collection.JavaConverters._

object ObjectSequenceFinder extends ObjectSequenceFinder

trait ObjectSequenceFinder extends TransactionalObjectFinder[ObjectSequence, ObjectSequenceList, JavaObjectSequence] {

  import kata.domain.{ ObjectSequenceFinder => underlying }

  lazy val all                   = underlying.all()
  lazy val simulatedSequenceName = underlying.simulatedSequenceName()
  lazy val nextValue             = underlying.nextValue()

  @throws[ReladomoException]("findOne returned more than one result")
  def findByPrimaryKey(simulatedSequenceName: String): Option[ObjectSequence] = {
    try { Option(underlying.findByPrimaryKey(simulatedSequenceName)).map(ObjectSequence(_)) } catch {
      case mbe: MithraBusinessException => throw new ReladomoException(mbe)
    }
  }

  @throws[ReladomoException]("findOne returned more than one result")
  def findOne(operation: FinderOperation): Option[ObjectSequence] = {
    try { Option(underlying.findOne(operation)).map(ObjectSequence(_)) } catch {
      case mbe: MithraBusinessException => throw new ReladomoException(mbe)
    }
  }

  @throws[ReladomoException]("findOne returned more than one result")
  def findOneBypassCache(operation: FinderOperation): Option[ObjectSequence] = {
    try { Option(underlying.findOneBypassCache(operation)).map(ObjectSequence(_)) } catch {
      case mbe: MithraBusinessException => throw new ReladomoException(mbe)
    }
  }

  // never throws exception because #findMany just returns a DomainList object
  def findMany(operation: FinderOperation): ListFinder[ObjectSequence, ObjectSequenceList, JavaObjectSequence] = {
    ListFinder(ObjectSequenceList(underlying.findMany(operation)))
  }

  // never throws exception because #findMany just returns a DomainList object
  def findManyBypassCache(
      operation: FinderOperation
  ): ListFinder[ObjectSequence, ObjectSequenceList, JavaObjectSequence] = {
    ListFinder(ObjectSequenceList(underlying.findManyBypassCache(operation)))
  }
}
