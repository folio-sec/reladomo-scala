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

import com.gs.fw.common.mithra.MithraDatedTransactionalObject

/**
  * Represents a Scala facade of Reladomo's MithraTransactionalObject.
  * The type must provide a MithraTransactionalObject which is consistent with the Scala object's state.
  */
trait TemporalTransactionalObjectBase extends TransactionalObjectBase {

  /**
    * Returns the underlying MithraTransactionalObject. The object can be unsaved in database yet.
    */
  override val underlying: com.gs.fw.common.mithra.MithraDatedTransactionalObject

  def copyDetachedValuesToOriginalOrInsertIfNewUntil(exclusiveUntil: Timestamp): MithraDatedTransactionalObject = {
    underlying.copyDetachedValuesToOriginalOrInsertIfNewUntil(exclusiveUntil)
  }

  def copyNonPrimaryKeyAttributesUntilFrom(from: MithraDatedTransactionalObject, until: Timestamp): Unit = {
    underlying.copyNonPrimaryKeyAttributesUntilFrom(from, until)
  }

}
