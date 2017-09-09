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

import com.folio_sec.example.domain.simplebank.scala_api.customer_account.CustomerAccountList
import com.folio_sec.reladomo.scala_api.TransactionalObject

case class Customer private (protected override val underlying: com.folio_sec.example.domain.simplebank.Customer,
                             customerId: Int,
                             firstName: String,
                             lastName: String,
                             country: String)
    extends TransactionalObject {

  lazy val savedUnderlying: com.folio_sec.example.domain.simplebank.Customer = {
    underlying.setCustomerId(customerId)
    underlying.setFirstName(firstName)
    underlying.setLastName(lastName)
    underlying.setCountry(country)
    underlying
  }

  lazy val accounts = CustomerAccountList(underlying.getAccounts)
}

object Customer {
  def apply(underlying: com.folio_sec.example.domain.simplebank.Customer): Customer = {
    new Customer(
      underlying = underlying,
      customerId = underlying.getCustomerId,
      firstName = underlying.getFirstName,
      lastName = underlying.getLastName,
      country = underlying.getCountry
    )
  }
}
