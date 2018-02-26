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

import com.gs.fw.common.mithra.MithraTransactionalObject

/**
  * Represents a Scala facade of Reladomo's MithraTransactionalObject.
  * The type must provide a MithraTransactionalObject which is consistent with the Scala object's state.
  */
trait TransactionalObjectBase {

  /**
    * Returns the underlying MithraTransactionalObject. The object can be unsaved in database yet.
    */
  protected val underlying: MithraTransactionalObject

  def copyDetachedValuesToOriginalOrInsertIfNew()(implicit tx: Transaction): MithraTransactionalObject = {
    underlying.copyDetachedValuesToOriginalOrInsertIfNew()
  }

  def makeInMemoryNonTransactional()(implicit tx: Transaction): Unit = {
    underlying.makeInMemoryNonTransactional()
  }

}
