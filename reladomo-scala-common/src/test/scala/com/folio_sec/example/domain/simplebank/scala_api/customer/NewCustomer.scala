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

import com.folio_sec.example.domain.simplebank.scala_api.customer_account.CustomerAccount
import com.folio_sec.reladomo.scala_api.{ NewTransactionalObject, Transaction }

import scala.collection.JavaConverters._

case class NewCustomer(firstName: String,
                       lastName: String,
                       country: String,
                       accounts: Seq[CustomerAccount] = Seq.empty)
    extends NewTransactionalObject {

  override val underlying: com.folio_sec.example.domain.simplebank.Customer = {
    val underlyingObj = new com.folio_sec.example.domain.simplebank.Customer()
    underlyingObj.setFirstName(firstName)
    underlyingObj.setLastName(lastName)
    underlyingObj.setCountry(country)
    underlyingObj
  }

  def withRelationships(moreAccounts: Seq[CustomerAccount]): NewCustomer = {
    this.copy(accounts = accounts ++ moreAccounts)
  }
  def insert()(implicit tx: Transaction): Customer = {
    underlying.getAccounts.addAll(accounts.map(_.savedUnderlying).asJava)
    underlying.insert()
    Customer(underlying)
  }
}
