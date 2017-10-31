/*
 * This file was automatically generated using folio-sec/sbt-reladomo-plugin. Please do not modify it.
 */
package com.folio_sec.example.domain.simplebank.scala_api

import com.folio_sec.reladomo.scala_api._
import com.folio_sec.reladomo.scala_api.util.TimestampUtil
import com.folio_sec.reladomo.scala_api.exception.ReladomoException
import com.gs.fw.common.mithra.MithraBusinessException
import com.folio_sec.example.domain.simplebank.{Customer => JavaCustomer}
import com.folio_sec.example.domain.simplebank.{CustomerList => JavaCustomerList}
import scala.collection.JavaConverters._

case class NewCustomer(firstName: String, lastName: String, country: Option[String], zipCode: Option[Int]) extends NewTransactionalObject {
  override lazy val underlying: JavaCustomer = {
    val underlyingObj = new JavaCustomer()
    underlyingObj.setFirstName(firstName)
    underlyingObj.setLastName(lastName)
    underlyingObj.setCountry(country.map(_country => _country).orNull[String])
    zipCode match {
      case Some(_zipCode) => underlyingObj.setZipCode(_zipCode)
      case _ => underlyingObj.setZipCodeNull()
    }
    underlyingObj
  }
  def insert()(implicit tx: Transaction): Customer = {
    underlying.insert()
    Customer(underlying)
  }
  def insertForRecovery()(implicit tx: Transaction): Customer = {
    underlying.insertForRecovery()
    Customer(underlying)
  }
  def cascadeInsert()(implicit tx: Transaction): Customer = {
    underlying.cascadeInsert()
    Customer(underlying)
  }
  def customerId(): Option[Int] = if (underlying.isInMemoryAndNotInserted) None else Some(underlying.getCustomerId)
}

case class Customer private (override val underlying: JavaCustomer, firstName: String, lastName: String, country: Option[String], zipCode: Option[Int]) extends TransactionalObject {
  override lazy val savedUnderlying: JavaCustomer = {
    underlying.setFirstName(firstName)
    underlying.setLastName(lastName)
    underlying.setCountry(country.map(_country => _country).orNull[String])
    zipCode match {
      case Some(_zipCode) => underlying.setZipCode(_zipCode)
      case _ => underlying.setZipCodeNull()
    }
    underlying
  }
  lazy val customerId: Int = underlying.getCustomerId
  // NOTE: This method always returns the latest relationship without issuing a query
  def accounts = CustomerAccountList(underlying.getAccounts())
}
object Customer {
  def apply(underlying: JavaCustomer): Customer = {
    new Customer(
      underlying = underlying,
      firstName = underlying.getFirstName,
      lastName = underlying.getLastName,
      country = if (underlying.isCountryNull) None else Option(underlying.getCountry),
      zipCode = if (underlying.isZipCodeNull) None else Option(underlying.getZipCode).map(_.asInstanceOf[Int])
    )
  }
}
