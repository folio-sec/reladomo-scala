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
import com.folio_sec.example.domain.simplebank.{ CustomerList => JavaCustomerList }
import com.folio_sec.example.domain.simplebank.{ Customer => JavaCustomer }
import com.folio_sec.reladomo.scala_api.TransactionalList

case class CustomerList(underlying: JavaCustomerList, override val newValueAppliers: Seq[() => Unit] = Seq.empty)
    extends TransactionalList[Customer, JavaCustomer] {
  override def toScalaObject(mithraTxObject: JavaCustomer): Customer = Customer(mithraTxObject)

  lazy val accounts = CustomerAccountList(underlying.getAccounts)

  def withCustomerId(customerId: Int) = {
    CustomerList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () =>
        underlying.setCustomerId(customerId)
      }
    )
  }
  def withFirstName(firstName: String) = {
    CustomerList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () =>
        underlying.setFirstName(firstName)
      }
    )
  }
  def withLastName(lastName: String) = {
    CustomerList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () =>
        underlying.setLastName(lastName)
      }
    )
  }
  def withCountry(country: String) = {
    CustomerList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () =>
        underlying.setCountry(country)
      }
    )
  }
}
