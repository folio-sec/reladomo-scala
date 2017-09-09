package com.folio_sec.reladomo.scala_api.implicits

import java.sql.Timestamp
import java.util.Date
import com.gs.fw.common.mithra.util.Time

import com.folio_sec.reladomo.scala_api.aggregation.AggregateDataTypeBinder
import com.gs.fw.common.mithra.AggregateData

object AggregateDataImplicits extends AggregateDataImplicits

trait AggregateDataImplicits {

  // ---------------
  // Int
  // ---------------

  implicit val intAggregateDataTypeBinder: AggregateDataTypeBinder[Int] = {
    new AggregateDataTypeBinder[Int] {
      override def apply(ad: AggregateData, name: String): Int = {
        ad.getAttributeAsInteger(name)
      }
    }
  }
  implicit val intOptionAggregateDataTypeBinder: AggregateDataTypeBinder[Option[Int]] = {
    new AggregateDataTypeBinder[Option[Int]] {
      override def apply(ad: AggregateData, name: String): Option[Int] = {
        if (ad.isAttributeNull(name)) None
        else Some(ad.getAttributeAsInteger(name))
      }
    }
  }

  // ---------------
  // Double
  // ---------------

  implicit val doubleAggregateDataTypeBinder: AggregateDataTypeBinder[Double] = {
    new AggregateDataTypeBinder[Double] {
      override def apply(ad: AggregateData, name: String): Double = {
        ad.getAttributeAsLong(name)
      }
    }
  }
  implicit val doubleOptionAggregateDataTypeBinder: AggregateDataTypeBinder[Option[Double]] = {
    new AggregateDataTypeBinder[Option[Double]] {
      override def apply(ad: AggregateData, name: String): Option[Double] = {
        if (ad.isAttributeNull(name)) None
        else Some(ad.getAttributeAsDouble(name))
      }
    }
  }

  // ---------------
  // Float
  // ---------------

  implicit val floatAggregateDataTypeBinder: AggregateDataTypeBinder[Float] = {
    new AggregateDataTypeBinder[Float] {
      override def apply(ad: AggregateData, name: String): Float = {
        ad.getAttributeAsFloat(name)
      }
    }
  }
  implicit val floatOptionAggregateDataTypeBinder: AggregateDataTypeBinder[Option[Float]] = {
    new AggregateDataTypeBinder[Option[Float]] {
      override def apply(ad: AggregateData, name: String): Option[Float] = {
        if (ad.isAttributeNull(name)) None
        else Some(ad.getAttributeAsFloat(name))
      }
    }
  }

  // ---------------
  // Byte
  // ---------------

  implicit val byteAggregateDataTypeBinder: AggregateDataTypeBinder[Byte] = {
    new AggregateDataTypeBinder[Byte] {
      override def apply(ad: AggregateData, name: String): Byte = {
        ad.getAttributeAsByte(name)
      }
    }
  }
  implicit val byteOptionAggregateDataTypeBinder: AggregateDataTypeBinder[Option[Byte]] = {
    new AggregateDataTypeBinder[Option[Byte]] {
      override def apply(ad: AggregateData, name: String): Option[Byte] = {
        if (ad.isAttributeNull(name)) None
        else Some(ad.getAttributeAsByte(name))
      }
    }
  }

  // ---------------
  // Long
  // ---------------

  implicit val longAggregateDataTypeBinder: AggregateDataTypeBinder[Long] = {
    new AggregateDataTypeBinder[Long] {
      override def apply(ad: AggregateData, name: String): Long = {
        ad.getAttributeAsLong(name)
      }
    }
  }
  implicit val longOptionAggregateDataTypeBinder: AggregateDataTypeBinder[Option[Long]] = {
    new AggregateDataTypeBinder[Option[Long]] {
      override def apply(ad: AggregateData, name: String): Option[Long] = {
        if (ad.isAttributeNull(name)) None
        else Some(ad.getAttributeAsLong(name))
      }
    }
  }

  // ---------------
  // Short
  // ---------------

  implicit val shortAggregateDataTypeBinder: AggregateDataTypeBinder[Short] = {
    new AggregateDataTypeBinder[Short] {
      override def apply(ad: AggregateData, name: String): Short = {
        ad.getAttributeAsShort(name)
      }
    }
  }
  implicit val shortOptionAggregateDataTypeBinder: AggregateDataTypeBinder[Option[Short]] = {
    new AggregateDataTypeBinder[Option[Short]] {
      override def apply(ad: AggregateData, name: String): Option[Short] = {
        if (ad.isAttributeNull(name)) None
        else Some(ad.getAttributeAsShort(name))
      }
    }
  }

  // ---------------
  // Boolean
  // ---------------

  implicit val booleanAggregateDataTypeBinder: AggregateDataTypeBinder[Boolean] = {
    new AggregateDataTypeBinder[Boolean] {
      override def apply(ad: AggregateData, name: String): Boolean = {
        ad.getAttributeAsBoolean(name)
      }
    }
  }
  implicit val booleanOptionAggregateDataTypeBinder: AggregateDataTypeBinder[Option[Boolean]] = {
    new AggregateDataTypeBinder[Option[Boolean]] {
      override def apply(ad: AggregateData, name: String): Option[Boolean] = {
        if (ad.isAttributeNull(name)) None
        else Some(ad.getAttributeAsBoolean(name))
      }
    }
  }

  // ---------------
  // String
  // ---------------

  implicit val stringAggregateDataTypeBinder: AggregateDataTypeBinder[String] = {
    new AggregateDataTypeBinder[String] {
      override def apply(ad: AggregateData, name: String): String = {
        ad.getAttributeAsString(name)
      }
    }
  }

  implicit val stringOptionAggregateDataTypeBinder: AggregateDataTypeBinder[Option[String]] = {
    new AggregateDataTypeBinder[Option[String]] {
      override def apply(ad: AggregateData, name: String): Option[String] = {
        if (ad.isAttributeNull(name)) None
        else Some(ad.getAttributeAsString(name))
      }
    }
  }

  // ---------------
  // Character
  // ---------------

  implicit val characterAggregateDataTypeBinder: AggregateDataTypeBinder[Character] = {
    new AggregateDataTypeBinder[Character] {
      override def apply(ad: AggregateData, name: String): Character = {
        ad.getAttributeAsCharacter(name)
      }
    }
  }
  implicit val characterOptionAggregateDataTypeBinder: AggregateDataTypeBinder[Option[Character]] = {
    new AggregateDataTypeBinder[Option[Character]] {
      override def apply(ad: AggregateData, name: String): Option[Character] = {
        if (ad.isAttributeNull(name)) None
        else Some(ad.getAttributeAsCharacter(name))
      }
    }
  }

  // ---------------
  // Timestamp
  // ---------------

  implicit val timstampAggregateDataTypeBinder: AggregateDataTypeBinder[Timestamp] = {
    new AggregateDataTypeBinder[Timestamp] {
      override def apply(ad: AggregateData, name: String): Timestamp = {
        ad.getAttributeAsTimestamp(name)
      }
    }
  }
  implicit val timstampOptionAggregateDataTypeBinder: AggregateDataTypeBinder[Option[Timestamp]] = {
    new AggregateDataTypeBinder[Option[Timestamp]] {
      override def apply(ad: AggregateData, name: String): Option[Timestamp] = {
        if (ad.isAttributeNull(name)) None
        else Some(ad.getAttributeAsTimestamp(name))
      }
    }
  }

  // ---------------
  // Date
  // ---------------

  implicit val dateAggregateDataTypeBinder: AggregateDataTypeBinder[Date] = {
    new AggregateDataTypeBinder[Date] {
      override def apply(ad: AggregateData, name: String): Date = {
        ad.getAttributeAsDate(name)
      }
    }
  }
  implicit val dateOptionAggregateDataTypeBinder: AggregateDataTypeBinder[Option[Date]] = {
    new AggregateDataTypeBinder[Option[Date]] {
      override def apply(ad: AggregateData, name: String): Option[Date] = {
        if (ad.isAttributeNull(name)) None
        else Some(ad.getAttributeAsDate(name))
      }
    }
  }

  // ---------------
  // Time
  // ---------------

  implicit val timeAggregateDataTypeBinder: AggregateDataTypeBinder[Time] = {
    new AggregateDataTypeBinder[Time] {
      override def apply(ad: AggregateData, name: String): Time = {
        ad.getAttributeAsTime(name)
      }
    }
  }
  implicit val timeOptionAggregateDataTypeBinder: AggregateDataTypeBinder[Option[Time]] = {
    new AggregateDataTypeBinder[Option[Time]] {
      override def apply(ad: AggregateData, name: String): Option[Time] = {
        if (ad.isAttributeNull(name)) None
        else Some(ad.getAttributeAsTime(name))
      }
    }
  }

  // ---------------
  // BigDecimal
  // ---------------

  // NOTE: As of Realdomo 16.5.1,
  // com.gs.fw.common.mithra.util.MutableDouble#bigDecimalValue() always returns 0
  // TODO: pull request to fix the issue

//  implicit val bigDecimalAggregateDataTypeBinder: AggregateDataTypeBinder[BigDecimal] = {
//    new AggregateDataTypeBinder[BigDecimal] {
//      override def apply(ad: AggregateData, name: String): BigDecimal = {
//        scala.math.BigDecimal(ad.getAttributeAsBigDecimal(name))
//      }
//    }
//  }
//  implicit val bigDecimalOptionAggregateDataTypeBinder: AggregateDataTypeBinder[Option[BigDecimal]] = {
//    new AggregateDataTypeBinder[Option[BigDecimal]] {
//      override def apply(ad: AggregateData, name: String): Option[BigDecimal] = {
//        if (ad.isAttributeNull(name)) None
//        else Some(ad.getAttributeAsBigDecimal(name)).map(scala.math.BigDecimal(_))
//      }
//    }
//  }

}
