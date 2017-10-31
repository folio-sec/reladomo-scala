/*
 * This file was automatically generated using folio-sec/sbt-reladomo-plugin. Please do not modify it.
 */
package com.folio_sec.example.domain.simplebank.scala_api

import com.folio_sec.reladomo.scala_api._
import com.folio_sec.reladomo.scala_api.exception.ReladomoException
import com.gs.fw.common.mithra.MithraBusinessException
import com.folio_sec.example.domain.simplebank.{Customer => JavaCustomer}
import com.folio_sec.example.domain.simplebank.{CustomerList => JavaCustomerList}
import scala.collection.JavaConverters._

case class CustomerList(underlying: JavaCustomerList,
  override val newValueAppliers: Seq[() => Unit] = Seq.empty)
  extends TransactionalList[Customer, JavaCustomer] {
  override def toScalaObject(jObj: JavaCustomer): Customer = Customer(jObj)

  def withCustomerId(customerId: Int) = {
    CustomerList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () => underlying.setCustomerId(customerId) }
    )
  }
  def withFirstName(firstName: String) = {
    CustomerList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () => underlying.setFirstName(firstName) }
    )
  }
  def withLastName(lastName: String) = {
    CustomerList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () => underlying.setLastName(lastName) }
    )
  }
  def withCountry(country: Option[String]) = {
    CustomerList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () =>
        underlying.setCountry(country.map(_country => _country).orNull[String])
      }
    )
  }
  def withZipCode(zipCode: Option[Int]) = {
    CustomerList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () =>
        zipCode match {
          case Some(_zipCode) => underlying.setZipCode(_zipCode)
          case _ => underlying.setZipCodeNull()
        }
      }
    )
  }

}

case class NewCustomerList(underlying: JavaCustomerList = new JavaCustomerList(),
  override val newValueAppliers: Seq[() => Unit] = Seq.empty)
  extends NewTransactionalList[NewCustomer, JavaCustomer] {
  override def toScalaObject(jObj: JavaCustomer): NewCustomer = NewCustomer(
      firstName = jObj.getFirstName,
      lastName = jObj.getLastName,
      country = if (jObj.isCountryNull) None else Option(jObj.getCountry),
      zipCode = if (jObj.isZipCodeNull) None else Option(jObj.getZipCode).map(_.asInstanceOf[Int])
  )
  def withNewCustomer(newOne: NewCustomer): NewCustomerList = {
    underlying.add(newOne.underlying)
    this
  }
  def withNewCustomer(newOne: Seq[NewCustomer]): NewCustomerList = {
    underlying.addAll(newOne.map(_.underlying).asJava)
    this
  }
}

object NewCustomerList {
  def apply(newOnes: Seq[NewCustomer]): NewCustomerList = {
    NewCustomerList().withNewCustomer(newOnes)
  }
}
