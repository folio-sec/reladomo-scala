/*
 * Copyright 2017 FOLIO Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.folio_sec.example.domain.simplebank.scala_api.customer

import com.folio_sec.reladomo.scala_api.{ TransactionalObjectFinder }
import com.folio_sec.reladomo.scala_api.exception.ReladomoException
import com.folio_sec.example.domain.simplebank.{ Customer => JavaCustomer }
import com.gs.fw.common.mithra.MithraBusinessException
import com.gs.fw.finder.Operation

object CustomerFinder extends CustomerFinder

trait CustomerFinder extends TransactionalObjectFinder[Customer, CustomerList, JavaCustomer] {

  import com.folio_sec.example.domain.simplebank.{ CustomerFinder => underlying }

  lazy val all        = underlying.all()
  lazy val customerId = underlying.customerId()
  lazy val firstName  = underlying.firstName()
  lazy val lastName   = underlying.lastName()
  lazy val country    = underlying.country()

  @throws[ReladomoException]("findOne returned more than one result")
  def findByPrimaryKey(pk: Int): Option[Customer] = {
    try {
      Option(underlying.findByPrimaryKey(pk)).map(Customer(_))
    } catch { case mbe: MithraBusinessException => throw new ReladomoException(mbe) }
  }

  @throws[ReladomoException]("findOne returned more than one result")
  override def findOne(operation: Operation[_]): Option[Customer] = {
    try {
      Option(underlying.findOne(operation)).map(Customer(_))
    } catch { case mbe: MithraBusinessException => throw new ReladomoException(mbe) }
  }

  @throws[ReladomoException]("findOne returned more than one result")
  override def findOneBypassCache(operation: Operation[_]): Option[Customer] = {
    try {
      Option(underlying.findOneBypassCache(operation)).map(Customer(_))
    } catch { case mbe: MithraBusinessException => throw new ReladomoException(mbe) }
  }

  override def findMany(operation: Operation[_]): ListFinder[Customer, CustomerList, JavaCustomer] = {
    ListFinder(CustomerList(underlying.findMany(operation)))
  }

  override def findManyBypassCache(operation: Operation[_]): ListFinder[Customer, CustomerList, JavaCustomer] = {
    ListFinder(CustomerList(underlying.findManyBypassCache(operation)))
  }

}
