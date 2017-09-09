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

import com.folio_sec.reladomo.scala_api.TransactionalObject

case class CustomerAccount private (protected val underlying: com.folio_sec.example.domain.simplebank.CustomerAccount,
                                    accountId: Int,
                                    customerId: Int,
                                    accountName: String,
                                    accountType: String,
                                    balance: Option[Double])
    extends TransactionalObject {

  lazy val savedUnderlying: com.folio_sec.example.domain.simplebank.CustomerAccount = {
    underlying.setAccountId(accountId)
    underlying.setCustomerId(customerId)
    underlying.setAccountName(accountName)
    underlying.setAccountType(accountType)
    balance match {
      case Some(_balance) => underlying.setBalance(_balance)
      case _              => underlying.setBalanceNull()
    }
    underlying
  }
}

object CustomerAccount {
  def apply(underlying: com.folio_sec.example.domain.simplebank.CustomerAccount): CustomerAccount = {
    new CustomerAccount(
      underlying = underlying,
      accountId = underlying.getAccountId,
      customerId = underlying.getCustomerId,
      accountName = underlying.getAccountName,
      accountType = underlying.getAccountType,
      balance = if (underlying.isBalanceNull) None else Option(underlying.getBalance)
    )
  }
}
