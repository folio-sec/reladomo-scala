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

package com.folio_sec.reladomo.scala_api

import com.gs.fw.common.mithra.{ MithraManager, MithraManagerProvider, TransactionalCommand }

object TransactionProvider extends TransactionProvider {

  override def mithraManager: MithraManager = MithraManagerProvider.getMithraManager

}

/**
  * Utility which provides a Reladomo transaction.
  */
trait TransactionProvider {

  def mithraManager: MithraManager

  def withTransaction[A](action: Transaction => A): A = {
    // Keep this as-is for Scala 2.11
    val command = new TransactionalCommand[A] {
      override def executeTransaction(tx: Transaction): A = action.apply(tx)
    }
    // MithraManager internally depends on the ThreadLocal<MithraTransaction> object for the current thread.
    mithraManager.executeTransactionalCommand(command)
  }

}
