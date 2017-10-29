/*
 * This file was automatically generated using folio-sec/sbt-reladomo-plugin. Please do not modify it.
 */
package kata.domain.scala_api

import com.folio_sec.reladomo.scala_api._
import com.folio_sec.reladomo.scala_api.util.TimestampUtil
import com.folio_sec.reladomo.scala_api.exception.ReladomoException
import com.gs.fw.common.mithra.MithraBusinessException
import kata.domain.{AllTypes => JavaAllTypes}
import kata.domain.{AllTypesList => JavaAllTypesList}
import scala.collection.JavaConverters._

case class NewAllTypes(id: Int, booleanValue: Boolean, byteValue: Byte, shortValue: Short, charValue: Char, intValue: Int, longValue: Long, floatValue: Float, doubleValue: Double, dateValue: java.util.Date, timestampValue: java.sql.Timestamp, stringValue: String, byteArrayValue: Array[Byte], nullableByteValue: Option[Byte], nullableShortValue: Option[Short], nullableCharValue: Option[Char], nullableIntValue: Option[Int], nullableLongValue: Option[Long], nullableFloatValue: Option[Float], nullableDoubleValue: Option[Double], nullableDateValue: Option[java.util.Date], nullableTimestampValue: Option[java.sql.Timestamp], nullableStringValue: Option[String], nullableByteArrayValue: Option[Array[Byte]]) extends NewTransactionalObject {
  override lazy val underlying: JavaAllTypes = {
    val underlyingObj = new JavaAllTypes()
    underlyingObj.setId(id)
    underlyingObj.setBooleanValue(booleanValue)
    underlyingObj.setByteValue(byteValue)
    underlyingObj.setShortValue(shortValue)
    underlyingObj.setCharValue(charValue)
    underlyingObj.setIntValue(intValue)
    underlyingObj.setLongValue(longValue)
    underlyingObj.setFloatValue(floatValue)
    underlyingObj.setDoubleValue(doubleValue)
    underlyingObj.setDateValue(dateValue)
    underlyingObj.setTimestampValue(timestampValue)
    underlyingObj.setStringValue(stringValue)
    underlyingObj.setByteArrayValue(byteArrayValue)
    nullableByteValue match {
      case Some(_nullableByteValue) => underlyingObj.setNullableByteValue(_nullableByteValue)
      case _ => underlyingObj.setNullableByteValueNull()
    }
    nullableShortValue match {
      case Some(_nullableShortValue) => underlyingObj.setNullableShortValue(_nullableShortValue)
      case _ => underlyingObj.setNullableShortValueNull()
    }
    nullableCharValue match {
      case Some(_nullableCharValue) => underlyingObj.setNullableCharValue(_nullableCharValue)
      case _ => underlyingObj.setNullableCharValueNull()
    }
    nullableIntValue match {
      case Some(_nullableIntValue) => underlyingObj.setNullableIntValue(_nullableIntValue)
      case _ => underlyingObj.setNullableIntValueNull()
    }
    nullableLongValue match {
      case Some(_nullableLongValue) => underlyingObj.setNullableLongValue(_nullableLongValue)
      case _ => underlyingObj.setNullableLongValueNull()
    }
    nullableFloatValue match {
      case Some(_nullableFloatValue) => underlyingObj.setNullableFloatValue(_nullableFloatValue)
      case _ => underlyingObj.setNullableFloatValueNull()
    }
    nullableDoubleValue match {
      case Some(_nullableDoubleValue) => underlyingObj.setNullableDoubleValue(_nullableDoubleValue)
      case _ => underlyingObj.setNullableDoubleValueNull()
    }
    underlyingObj.setNullableDateValue(nullableDateValue.orNull[java.util.Date])
    underlyingObj.setNullableTimestampValue(nullableTimestampValue.orNull[java.sql.Timestamp])
    underlyingObj.setNullableStringValue(nullableStringValue.orNull[String])
    underlyingObj.setNullableByteArrayValue(nullableByteArrayValue.orNull[Array[Byte]])
    underlyingObj
  }
  def insert()(implicit tx: Transaction): AllTypes = {
    underlying.insert()
    AllTypes(underlying)
  }
  def insertForRecovery()(implicit tx: Transaction): AllTypes = {
    underlying.insertForRecovery()
    AllTypes(underlying)
  }
  def cascadeInsert()(implicit tx: Transaction): AllTypes = {
    underlying.cascadeInsert()
    AllTypes(underlying)
  }

}

case class AllTypes private (override val underlying: JavaAllTypes, booleanValue: Boolean, byteValue: Byte, shortValue: Short, charValue: Char, intValue: Int, longValue: Long, floatValue: Float, doubleValue: Double, dateValue: java.util.Date, timestampValue: java.sql.Timestamp, stringValue: String, byteArrayValue: Array[Byte], nullableByteValue: Option[Byte], nullableShortValue: Option[Short], nullableCharValue: Option[Char], nullableIntValue: Option[Int], nullableLongValue: Option[Long], nullableFloatValue: Option[Float], nullableDoubleValue: Option[Double], nullableDateValue: Option[java.util.Date], nullableTimestampValue: Option[java.sql.Timestamp], nullableStringValue: Option[String], nullableByteArrayValue: Option[Array[Byte]]) extends TransactionalObject {
  override lazy val savedUnderlying: JavaAllTypes = {
    underlying.setBooleanValue(booleanValue)
    underlying.setByteValue(byteValue)
    underlying.setShortValue(shortValue)
    underlying.setCharValue(charValue)
    underlying.setIntValue(intValue)
    underlying.setLongValue(longValue)
    underlying.setFloatValue(floatValue)
    underlying.setDoubleValue(doubleValue)
    underlying.setDateValue(dateValue)
    underlying.setTimestampValue(timestampValue)
    underlying.setStringValue(stringValue)
    underlying.setByteArrayValue(byteArrayValue)
    nullableByteValue match {
      case Some(_nullableByteValue) => underlying.setNullableByteValue(_nullableByteValue)
      case _ => underlying.setNullableByteValueNull()
    }
    nullableShortValue match {
      case Some(_nullableShortValue) => underlying.setNullableShortValue(_nullableShortValue)
      case _ => underlying.setNullableShortValueNull()
    }
    nullableCharValue match {
      case Some(_nullableCharValue) => underlying.setNullableCharValue(_nullableCharValue)
      case _ => underlying.setNullableCharValueNull()
    }
    nullableIntValue match {
      case Some(_nullableIntValue) => underlying.setNullableIntValue(_nullableIntValue)
      case _ => underlying.setNullableIntValueNull()
    }
    nullableLongValue match {
      case Some(_nullableLongValue) => underlying.setNullableLongValue(_nullableLongValue)
      case _ => underlying.setNullableLongValueNull()
    }
    nullableFloatValue match {
      case Some(_nullableFloatValue) => underlying.setNullableFloatValue(_nullableFloatValue)
      case _ => underlying.setNullableFloatValueNull()
    }
    nullableDoubleValue match {
      case Some(_nullableDoubleValue) => underlying.setNullableDoubleValue(_nullableDoubleValue)
      case _ => underlying.setNullableDoubleValueNull()
    }
    underlying.setNullableDateValue(nullableDateValue.orNull[java.util.Date])
    underlying.setNullableTimestampValue(nullableTimestampValue.orNull[java.sql.Timestamp])
    underlying.setNullableStringValue(nullableStringValue.orNull[String])
    underlying.setNullableByteArrayValue(nullableByteArrayValue.orNull[Array[Byte]])
    underlying
  }
  lazy val id: Int = underlying.getId

}
object AllTypes {
  def apply(underlying: JavaAllTypes): AllTypes = {
    new AllTypes(
      underlying = underlying,
      booleanValue = underlying.isBooleanValue,
      byteValue = underlying.getByteValue,
      shortValue = underlying.getShortValue,
      charValue = underlying.getCharValue,
      intValue = underlying.getIntValue,
      longValue = underlying.getLongValue,
      floatValue = underlying.getFloatValue,
      doubleValue = underlying.getDoubleValue,
      dateValue = underlying.getDateValue,
      timestampValue = underlying.getTimestampValue,
      stringValue = underlying.getStringValue,
      byteArrayValue = underlying.getByteArrayValue,
      nullableByteValue = if (underlying.isNullableByteValueNull) None else Option(underlying.getNullableByteValue).map(_.asInstanceOf[Byte]),
      nullableShortValue = if (underlying.isNullableShortValueNull) None else Option(underlying.getNullableShortValue).map(_.asInstanceOf[Short]),
      nullableCharValue = if (underlying.isNullableCharValueNull) None else Option(underlying.getNullableCharValue),
      nullableIntValue = if (underlying.isNullableIntValueNull) None else Option(underlying.getNullableIntValue).map(_.asInstanceOf[Int]),
      nullableLongValue = if (underlying.isNullableLongValueNull) None else Option(underlying.getNullableLongValue).map(_.asInstanceOf[Long]),
      nullableFloatValue = if (underlying.isNullableFloatValueNull) None else Option(underlying.getNullableFloatValue).map(_.asInstanceOf[Float]),
      nullableDoubleValue = if (underlying.isNullableDoubleValueNull) None else Option(underlying.getNullableDoubleValue).map(_.asInstanceOf[Double]),
      nullableDateValue = if (underlying.isNullableDateValueNull) None else Option(underlying.getNullableDateValue).map(_.asInstanceOf[java.util.Date]),
      nullableTimestampValue = if (underlying.isNullableTimestampValueNull) None else Option(underlying.getNullableTimestampValue).map(_.asInstanceOf[java.sql.Timestamp]),
      nullableStringValue = if (underlying.isNullableStringValueNull) None else Option(underlying.getNullableStringValue),
      nullableByteArrayValue = if (underlying.isNullableByteArrayValueNull) None else Option(underlying.getNullableByteArrayValue).map(_.asInstanceOf[Array[Byte]])
    )
  }
}
