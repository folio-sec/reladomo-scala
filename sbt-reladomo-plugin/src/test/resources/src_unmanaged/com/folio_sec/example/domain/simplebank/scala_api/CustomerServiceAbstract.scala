/*
 * This file was automatically generated using folio-sec/sbt-reladomo-plugin. Please do not modify it.
 */
package com.folio_sec.example.domain.simplebank.scala_api

import com.folio_sec.reladomo.scala_api._
import com.folio_sec.reladomo.scala_api.service.twitter.TransactionalObjectService
import com.folio_sec.example.domain.simplebank.{Customer => JavaCustomer}

trait CustomerServiceAbstract extends TransactionalObjectService[Customer, CustomerList, JavaCustomer] {
  override val finder: CustomerFinder = CustomerFinder
}
