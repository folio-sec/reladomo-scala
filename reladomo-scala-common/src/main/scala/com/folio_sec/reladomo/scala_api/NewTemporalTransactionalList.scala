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

/**
  * Represents a Scala facade of Reladomo's MithraTransactionalList.
  * The type must provide a MithraTransactionalList which is consistent with the Scala object's state.
  */
trait NewTemporalTransactionalList[TxObject <: NewTemporalTransactionalObject,
                                   MithraTxObject <: com.gs.fw.common.mithra.MithraDatedTransactionalObject]
    extends TemporalTransactionalListBase[TxObject, MithraTxObject] { self =>

  override def toScalaObject(mithraTxObject: MithraTxObject): TxObject

  /**
    * Performs #cascadeInsertAll with the current Transaction.
    *
    * The reasons to accept the implicit parameter are:
    * - avoiding to unintentionally issue insert/update/delete queries
    * - guaranteeing the existence of thread-local Reladomo transaction on the current thread.
    */
  def cascadeInsertAll()(implicit tx: Transaction): Unit = underlying.cascadeInsertAll()

  /**
    * Performs #bulkInsertAll with the current Transaction.
    *
    * The reasons to accept the implicit parameter are:
    * - avoiding to unintentionally issue insert/update/delete queries
    * - guaranteeing the existence of thread-local Reladomo transaction on the current thread.
    */
  def bulkInsertAll()(implicit tx: Transaction): Unit = underlying.bulkInsertAll()

  /**
    * Performs #insertAll with the current Transaction.
    *
    * The reasons to accept the implicit parameter are:
    * - avoiding to unintentionally issue insert/update/delete queries
    * - guaranteeing the existence of thread-local Reladomo transaction on the current thread.
    */
  def insertAll()(implicit tx: Transaction): Unit = underlying.insertAll()

}
