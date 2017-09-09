/*
 * This file was automatically generated using folio-sec/sbt-reladomo-plugin. Please do not modify it.
 */
package com.folio_sec.example.domain.simplebank.scala_api

import com.folio_sec.reladomo.scala_api._
import com.folio_sec.reladomo.scala_api.exception.ReladomoException
import com.gs.fw.common.mithra.MithraBusinessException
import com.folio_sec.example.domain.simplebank.{Customer => JavaCustomer}
import scala.collection.JavaConverters._

object CustomerFinder extends CustomerFinder

trait CustomerFinder extends TransactionalObjectFinder[Customer, CustomerList, JavaCustomer] {

  import com.folio_sec.example.domain.simplebank.{CustomerFinder => underlying}

  lazy val all = underlying.all()
  lazy val customerId = underlying.customerId()
  lazy val firstName = underlying.firstName()
  lazy val lastName = underlying.lastName()
  lazy val country = underlying.country()
  lazy val zipCode = underlying.zipCode()
  lazy val accounts = underlying.accounts()

  @throws[ReladomoException]("findOne returned more than one result")
  def findByPrimaryKey(customerId: Int): Option[Customer] = {
    try { Option(underlying.findByPrimaryKey(customerId)).map(Customer(_)) }
    catch { case mbe: MithraBusinessException => throw new ReladomoException(mbe) }
  }

  @throws[ReladomoException]("findOne returned more than one result")
  def findOne(operation: FinderOperation): Option[Customer] = {
    try { Option(underlying.findOne(operation)).map(Customer(_)) }
    catch { case mbe: MithraBusinessException => throw new ReladomoException(mbe) }
  }

  @throws[ReladomoException]("findOne returned more than one result")
  def findOneBypassCache(operation: FinderOperation): Option[Customer] = {
    try { Option(underlying.findOneBypassCache(operation)).map(Customer(_)) }
    catch { case mbe: MithraBusinessException => throw new ReladomoException(mbe) }
  }

  // never throws exception because #findMany just returns a DomainList object
  def findMany(operation: FinderOperation): ListFinder[Customer, CustomerList, JavaCustomer] = {
    ListFinder(CustomerList(underlying.findMany(operation)))
  }

  // never throws exception because #findMany just returns a DomainList object
  def findManyBypassCache(operation: FinderOperation): ListFinder[Customer, CustomerList, JavaCustomer] = {
    ListFinder(CustomerList(underlying.findManyBypassCache(operation)))
  }
}
