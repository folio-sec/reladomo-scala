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
import com.folio_sec.example.domain.simplebank.{ Customer => JavaCustomer, CustomerList => JavaCustomerList }
import com.folio_sec.reladomo.scala_api.NewTransactionalList

case class NewCustomerList(underlying: JavaCustomerList = new JavaCustomerList(),
                           override val newValueAppliers: Seq[() => Unit] = Seq.empty)
    extends NewTransactionalList[NewCustomer, JavaCustomer] {

  override def toScalaObject(mithraTxObject: JavaCustomer): NewCustomer = NewCustomer(
    firstName = mithraTxObject.getFirstName,
    lastName = mithraTxObject.getLastName,
    country = mithraTxObject.getCountry
  )

  lazy val accounts = CustomerAccountList(underlying.getAccounts)

  def withNewCustomer(newOne: NewCustomer): NewCustomerList = {
    underlying.add(newOne.underlying)
    this
  }

}
