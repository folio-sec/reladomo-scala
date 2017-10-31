/*
 * This file was automatically generated using folio-sec/sbt-reladomo-plugin. Please do not modify it.
 */
package kata.domain.scala_api

import com.folio_sec.reladomo.scala_api._
import com.folio_sec.reladomo.scala_api.exception.ReladomoException
import com.gs.fw.common.mithra.MithraBusinessException
import kata.domain.{AllTypes => JavaAllTypes}
import kata.domain.{AllTypesList => JavaAllTypesList}
import scala.collection.JavaConverters._

case class AllTypesList(underlying: JavaAllTypesList,
  override val newValueAppliers: Seq[() => Unit] = Seq.empty)
  extends TransactionalList[AllTypes, JavaAllTypes] {
  override def toScalaObject(jObj: JavaAllTypes): AllTypes = AllTypes(jObj)

  def withId(id: Int) = {
    AllTypesList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () => underlying.setId(id) }
    )
  }
  def withBooleanValue(booleanValue: Boolean) = {
    AllTypesList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () => underlying.setBooleanValue(booleanValue) }
    )
  }
  def withByteValue(byteValue: Byte) = {
    AllTypesList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () => underlying.setByteValue(byteValue) }
    )
  }
  def withShortValue(shortValue: Short) = {
    AllTypesList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () => underlying.setShortValue(shortValue) }
    )
  }
  def withCharValue(charValue: Char) = {
    AllTypesList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () => underlying.setCharValue(charValue) }
    )
  }
  def withIntValue(intValue: Int) = {
    AllTypesList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () => underlying.setIntValue(intValue) }
    )
  }
  def withLongValue(longValue: Long) = {
    AllTypesList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () => underlying.setLongValue(longValue) }
    )
  }
  def withFloatValue(floatValue: Float) = {
    AllTypesList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () => underlying.setFloatValue(floatValue) }
    )
  }
  def withDoubleValue(doubleValue: Double) = {
    AllTypesList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () => underlying.setDoubleValue(doubleValue) }
    )
  }
  def withDateValue(dateValue: java.util.Date) = {
    AllTypesList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () => underlying.setDateValue(dateValue) }
    )
  }
  def withTimestampValue(timestampValue: java.sql.Timestamp) = {
    AllTypesList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () => underlying.setTimestampValue(timestampValue) }
    )
  }
  def withStringValue(stringValue: String) = {
    AllTypesList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () => underlying.setStringValue(stringValue) }
    )
  }
  def withByteArrayValue(byteArrayValue: Array[Byte]) = {
    AllTypesList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () => underlying.setByteArrayValue(byteArrayValue) }
    )
  }
  def withNullableByteValue(nullableByteValue: Option[Byte]) = {
    AllTypesList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () =>
        nullableByteValue match {
          case Some(_nullableByteValue) => underlying.setNullableByteValue(_nullableByteValue)
          case _ => underlying.setNullableByteValueNull()
        }
      }
    )
  }
  def withNullableShortValue(nullableShortValue: Option[Short]) = {
    AllTypesList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () =>
        nullableShortValue match {
          case Some(_nullableShortValue) => underlying.setNullableShortValue(_nullableShortValue)
          case _ => underlying.setNullableShortValueNull()
        }
      }
    )
  }
  def withNullableCharValue(nullableCharValue: Option[Char]) = {
    AllTypesList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () =>
        nullableCharValue match {
          case Some(_nullableCharValue) => underlying.setNullableCharValue(_nullableCharValue)
          case _ => underlying.setNullableCharValueNull()
        }
      }
    )
  }
  def withNullableIntValue(nullableIntValue: Option[Int]) = {
    AllTypesList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () =>
        nullableIntValue match {
          case Some(_nullableIntValue) => underlying.setNullableIntValue(_nullableIntValue)
          case _ => underlying.setNullableIntValueNull()
        }
      }
    )
  }
  def withNullableLongValue(nullableLongValue: Option[Long]) = {
    AllTypesList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () =>
        nullableLongValue match {
          case Some(_nullableLongValue) => underlying.setNullableLongValue(_nullableLongValue)
          case _ => underlying.setNullableLongValueNull()
        }
      }
    )
  }
  def withNullableFloatValue(nullableFloatValue: Option[Float]) = {
    AllTypesList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () =>
        nullableFloatValue match {
          case Some(_nullableFloatValue) => underlying.setNullableFloatValue(_nullableFloatValue)
          case _ => underlying.setNullableFloatValueNull()
        }
      }
    )
  }
  def withNullableDoubleValue(nullableDoubleValue: Option[Double]) = {
    AllTypesList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () =>
        nullableDoubleValue match {
          case Some(_nullableDoubleValue) => underlying.setNullableDoubleValue(_nullableDoubleValue)
          case _ => underlying.setNullableDoubleValueNull()
        }
      }
    )
  }
  def withNullableDateValue(nullableDateValue: Option[java.util.Date]) = {
    AllTypesList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () =>
        underlying.setNullableDateValue(nullableDateValue.map(_nullableDateValue => _nullableDateValue).orNull[Date])
      }
    )
  }
  def withNullableTimestampValue(nullableTimestampValue: Option[java.sql.Timestamp]) = {
    AllTypesList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () =>
        underlying.setNullableTimestampValue(nullableTimestampValue.map(_nullableTimestampValue => _nullableTimestampValue).orNull[Timestamp])
      }
    )
  }
  def withNullableStringValue(nullableStringValue: Option[String]) = {
    AllTypesList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () =>
        underlying.setNullableStringValue(nullableStringValue.map(_nullableStringValue => _nullableStringValue).orNull[String])
      }
    )
  }
  def withNullableByteArrayValue(nullableByteArrayValue: Option[Array[Byte]]) = {
    AllTypesList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () =>
        underlying.setNullableByteArrayValue(nullableByteArrayValue.map(_nullableByteArrayValue => _nullableByteArrayValue).orNull[byte[]])
      }
    )
  }

}

case class NewAllTypesList(underlying: JavaAllTypesList = new JavaAllTypesList(),
  override val newValueAppliers: Seq[() => Unit] = Seq.empty)
  extends NewTransactionalList[NewAllTypes, JavaAllTypes] {
  override def toScalaObject(jObj: JavaAllTypes): NewAllTypes = NewAllTypes(
      id = jObj.getId,
      booleanValue = jObj.isBooleanValue,
      byteValue = jObj.getByteValue,
      shortValue = jObj.getShortValue,
      charValue = jObj.getCharValue,
      intValue = jObj.getIntValue,
      longValue = jObj.getLongValue,
      floatValue = jObj.getFloatValue,
      doubleValue = jObj.getDoubleValue,
      dateValue = jObj.getDateValue,
      timestampValue = jObj.getTimestampValue,
      stringValue = jObj.getStringValue,
      byteArrayValue = jObj.getByteArrayValue,
      nullableByteValue = if (jObj.isNullableByteValueNull) None else Option(jObj.getNullableByteValue).map(_.asInstanceOf[Byte]),
      nullableShortValue = if (jObj.isNullableShortValueNull) None else Option(jObj.getNullableShortValue).map(_.asInstanceOf[Short]),
      nullableCharValue = if (jObj.isNullableCharValueNull) None else Option(jObj.getNullableCharValue),
      nullableIntValue = if (jObj.isNullableIntValueNull) None else Option(jObj.getNullableIntValue).map(_.asInstanceOf[Int]),
      nullableLongValue = if (jObj.isNullableLongValueNull) None else Option(jObj.getNullableLongValue).map(_.asInstanceOf[Long]),
      nullableFloatValue = if (jObj.isNullableFloatValueNull) None else Option(jObj.getNullableFloatValue).map(_.asInstanceOf[Float]),
      nullableDoubleValue = if (jObj.isNullableDoubleValueNull) None else Option(jObj.getNullableDoubleValue).map(_.asInstanceOf[Double]),
      nullableDateValue = if (jObj.isNullableDateValueNull) None else Option(jObj.getNullableDateValue).map(_.asInstanceOf[java.util.Date]),
      nullableTimestampValue = if (jObj.isNullableTimestampValueNull) None else Option(jObj.getNullableTimestampValue).map(_.asInstanceOf[java.sql.Timestamp]),
      nullableStringValue = if (jObj.isNullableStringValueNull) None else Option(jObj.getNullableStringValue),
      nullableByteArrayValue = if (jObj.isNullableByteArrayValueNull) None else Option(jObj.getNullableByteArrayValue).map(_.asInstanceOf[Array[Byte]])
  )
  def withNewAllTypes(newOne: NewAllTypes): NewAllTypesList = {
    underlying.add(newOne.underlying)
    this
  }
  def withNewAllTypes(newOne: Seq[NewAllTypes]): NewAllTypesList = {
    underlying.addAll(newOne.map(_.underlying).asJava)
    this
  }
}

object NewAllTypesList {
  def apply(newOnes: Seq[NewAllTypes]): NewAllTypesList = {
    NewAllTypesList().withNewAllTypes(newOnes)
  }
}
