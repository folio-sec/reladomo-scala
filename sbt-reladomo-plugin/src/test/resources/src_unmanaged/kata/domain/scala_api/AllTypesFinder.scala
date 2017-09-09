/*
 * This file was automatically generated using folio-sec/sbt-reladomo-plugin. Please do not modify it.
 */
package kata.domain.scala_api

import com.folio_sec.reladomo.scala_api._
import com.folio_sec.reladomo.scala_api.exception.ReladomoException
import com.gs.fw.common.mithra.MithraBusinessException
import kata.domain.{AllTypes => JavaAllTypes}
import scala.collection.JavaConverters._

object AllTypesFinder extends AllTypesFinder

trait AllTypesFinder extends TransactionalObjectFinder[AllTypes, AllTypesList, JavaAllTypes] {

  import kata.domain.{AllTypesFinder => underlying}

  lazy val all = underlying.all()
  lazy val id = underlying.id()
  lazy val booleanValue = underlying.booleanValue()
  lazy val byteValue = underlying.byteValue()
  lazy val shortValue = underlying.shortValue()
  lazy val charValue = underlying.charValue()
  lazy val intValue = underlying.intValue()
  lazy val longValue = underlying.longValue()
  lazy val floatValue = underlying.floatValue()
  lazy val doubleValue = underlying.doubleValue()
  lazy val dateValue = underlying.dateValue()
  lazy val timestampValue = underlying.timestampValue()
  lazy val stringValue = underlying.stringValue()
  lazy val byteArrayValue = underlying.byteArrayValue()
  lazy val nullableByteValue = underlying.nullableByteValue()
  lazy val nullableShortValue = underlying.nullableShortValue()
  lazy val nullableCharValue = underlying.nullableCharValue()
  lazy val nullableIntValue = underlying.nullableIntValue()
  lazy val nullableLongValue = underlying.nullableLongValue()
  lazy val nullableFloatValue = underlying.nullableFloatValue()
  lazy val nullableDoubleValue = underlying.nullableDoubleValue()
  lazy val nullableDateValue = underlying.nullableDateValue()
  lazy val nullableTimestampValue = underlying.nullableTimestampValue()
  lazy val nullableStringValue = underlying.nullableStringValue()
  lazy val nullableByteArrayValue = underlying.nullableByteArrayValue()

  @throws[ReladomoException]("findOne returned more than one result")
  def findByPrimaryKey(id: Int): Option[AllTypes] = {
    try { Option(underlying.findByPrimaryKey(id)).map(AllTypes(_)) }
    catch { case mbe: MithraBusinessException => throw new ReladomoException(mbe) }
  }

  @throws[ReladomoException]("findOne returned more than one result")
  def findOne(operation: FinderOperation): Option[AllTypes] = {
    try { Option(underlying.findOne(operation)).map(AllTypes(_)) }
    catch { case mbe: MithraBusinessException => throw new ReladomoException(mbe) }
  }

  @throws[ReladomoException]("findOne returned more than one result")
  def findOneBypassCache(operation: FinderOperation): Option[AllTypes] = {
    try { Option(underlying.findOneBypassCache(operation)).map(AllTypes(_)) }
    catch { case mbe: MithraBusinessException => throw new ReladomoException(mbe) }
  }

  // never throws exception because #findMany just returns a DomainList object
  def findMany(operation: FinderOperation): ListFinder[AllTypes, AllTypesList, JavaAllTypes] = {
    ListFinder(AllTypesList(underlying.findMany(operation)))
  }

  // never throws exception because #findMany just returns a DomainList object
  def findManyBypassCache(operation: FinderOperation): ListFinder[AllTypes, AllTypesList, JavaAllTypes] = {
    ListFinder(AllTypesList(underlying.findManyBypassCache(operation)))
  }
}
