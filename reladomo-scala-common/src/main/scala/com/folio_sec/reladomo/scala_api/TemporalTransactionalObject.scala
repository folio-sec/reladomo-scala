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
  * Represents a Scala facade of Reladomo's MithraTransactionalObject.
  * The type must provide a MithraTransactionalObject which is consistent with the Scala object's state.
  */
trait TemporalTransactionalObject extends TemporalTransactionalObjectBase {

  /**
    * Returns MithraTransactionalObject which is surely synchronized with the state in database.
    * Calling this method can issue update queries to database because it calls Reladomo setter methods internally.
    */
  protected def savedUnderlying: com.gs.fw.common.mithra.MithraDatedTransactionalObject

  def update()(implicit tx: Transaction): Unit = {
    // Calling setter methods in MithraTransactionalObject issues update queries to the database
    // Just calling this method internally calls setters corresponding to the attributes that this Scala object has.
    savedUnderlying
  }

  def terminate()(implicit tx: Transaction): Unit = {
    underlying.terminate()
  }

  def cascadeTerminate()(implicit tx: Transaction): Unit = {
    underlying.cascadeTerminate()
  }

  def cascadeTerminateUntil(exclusiveUntil: Timestamp)(implicit tx: Transaction): Unit = {
    underlying.cascadeTerminateUntil(exclusiveUntil)
  }

  def purge()(implicit tx: Transaction): Unit = {
    underlying.purge()
  }

  def inactivateForArchiving(processingDateTo: Timestamp, businessDateTo: Timestamp): Unit = {
    underlying.inactivateForArchiving(processingDateTo, businessDateTo)
  }

}
