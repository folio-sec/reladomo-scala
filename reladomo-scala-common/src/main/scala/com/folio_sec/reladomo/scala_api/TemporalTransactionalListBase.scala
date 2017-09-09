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

import com.gs.fw.finder.Navigation

import scala.collection.JavaConverters._

/**
  * Represents a Scala facade of Reladomo's MithraTransactionalList.
  * The type must provide a MithraTransactionalList which is consistent with the Scala object's state.
  */
trait TemporalTransactionalListBase[TxObject <: TemporalTransactionalObjectBase,
                                    MithraTxObject <: com.gs.fw.common.mithra.MithraDatedTransactionalObject]
    extends Seq[TxObject] { self =>

  /**
    * Returns consistent MithraTransactionalList
    */
  def underlying: com.gs.fw.common.mithra.MithraDatedTransactionalList[MithraTxObject]

  def toScalaObject(mithraTxObject: MithraTxObject): TxObject

  // DomainList[MithraTxObject]

  def count(): Int = underlying.count()

  def deepFetch(navigation: Navigation[MithraTxObject]): self.type = {
    underlying.deepFetch(navigation)
    this
  }

  override def length: Int = count()

  override def apply(idx: Int): TxObject = toScalaObject(underlying.get(idx))

  override def iterator: Iterator[TxObject] = underlying.iterator().asScala.map(toScalaObject)

  def newValueAppliers: Seq[() => Unit]

  def updateAll()(implicit tx: Transaction): Unit = {
    newValueAppliers.foreach(_.apply())
  }

  // TransactionalDomainList[MithraTxObject]

  /**
    * force this list to resolve its operation. Normally, the operation is not resolved until necessary.
    */
  def forceResolve(): Unit = underlying.forceResolve()

  /**
    * force this list to be re-read from the database. Works for both operation based and simple lists.
    * It has no effect on a list of detached objects.
    */
  def forceRefresh(): Unit = underlying.forceRefresh()

}
