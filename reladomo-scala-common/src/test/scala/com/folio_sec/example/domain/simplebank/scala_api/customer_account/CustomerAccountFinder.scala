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

package com.folio_sec.example.domain.simplebank.scala_api.customer_account

import com.folio_sec.example.domain.simplebank.{ CustomerAccount => JavaCustomerAccount }
import com.folio_sec.reladomo.scala_api.{ TransactionalObjectFinder }
import com.folio_sec.reladomo.scala_api.exception.ReladomoException
import com.gs.fw.common.mithra.MithraBusinessException
import com.gs.fw.finder.Operation

import scala.collection.JavaConverters._

object CustomerAccountFinder extends CustomerAccountFinder

trait CustomerAccountFinder
    extends TransactionalObjectFinder[CustomerAccount, CustomerAccountList, JavaCustomerAccount] {

  import com.folio_sec.example.domain.simplebank.{ CustomerAccountFinder => underlying }

  lazy val all         = underlying.all()
  lazy val customerId  = underlying.customerId()
  lazy val accountId   = underlying.accountId()
  lazy val accountName = underlying.accountName()
  lazy val accountType = underlying.accountType()
  lazy val balance     = underlying.balance()

  def clearQueryCache() = underlying.clearQueryCache()

  @throws[MithraBusinessException]("findOne returned more than one result")
  def findByPrimaryKey(pk: Int): Option[CustomerAccount] = {
    try {
      Option(underlying.findByPrimaryKey(pk)).map(CustomerAccount(_))
    } catch { case mbe: MithraBusinessException => throw new ReladomoException(mbe) }
  }

  @throws[MithraBusinessException]("findOne returned more than one result")
  def findOne(operation: Operation[_]): Option[CustomerAccount] = {
    try {
      Option(underlying.findOne(operation)).map(CustomerAccount(_))
    } catch { case mbe: MithraBusinessException => throw new ReladomoException(mbe) }
  }

  @throws[MithraBusinessException]("findOne returned more than one result")
  def findOneBypassCache(operation: Operation[_]): Option[CustomerAccount] = {
    try {
      Option(underlying.findOneBypassCache(operation)).map(CustomerAccount(_))
    } catch { case mbe: MithraBusinessException => throw new ReladomoException(mbe) }
  }

  def findMany(operation: Operation[_]): ListFinder[CustomerAccount, CustomerAccountList, JavaCustomerAccount] = {
    ListFinder(CustomerAccountList(underlying.findMany(operation)))
  }

  def findManyBypassCache(
      operation: Operation[_]
  ): ListFinder[CustomerAccount, CustomerAccountList, JavaCustomerAccount] = {
    ListFinder(CustomerAccountList(underlying.findManyBypassCache(operation)))
  }

}
