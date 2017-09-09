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

import com.folio_sec.example.domain.simplebank.{
  CustomerAccount => JavaCustomerAccount,
  CustomerAccountList => JavaCustomerAccountList
}
import com.folio_sec.reladomo.scala_api.TransactionalList

case class CustomerAccountList(underlying: JavaCustomerAccountList,
                               override val newValueAppliers: Seq[() => Unit] = Seq.empty)
    extends TransactionalList[CustomerAccount, JavaCustomerAccount] {
  override def toScalaObject(mithraTxObject: JavaCustomerAccount): CustomerAccount = {
    CustomerAccount(mithraTxObject)
  }

  def withAccountId(accountId: Int) = {
    CustomerAccountList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () =>
        underlying.setAccountId(accountId)
      }
    )
  }
  def withCustomerId(customerId: Int) = {
    CustomerAccountList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () =>
        underlying.setCustomerId(customerId)
      }
    )
  }
  def withAccountName(accountName: String) = {
    CustomerAccountList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () =>
        underlying.setAccountName(accountName)
      }
    )
  }
  def withAccountType(lastName: String) = {
    CustomerAccountList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () =>
        underlying.setAccountType(lastName)
      }
    )
  }
  def withBalance(balance: Option[Double]) = {
    CustomerAccountList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () =>
        balance match {
          case Some(_balance) => underlying.setBalance(_balance)
          case _              => underlying.setBalanceNull()
        }
      }
    )
  }
}
