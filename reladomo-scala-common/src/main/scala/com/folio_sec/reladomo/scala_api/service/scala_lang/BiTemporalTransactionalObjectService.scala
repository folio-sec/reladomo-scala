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

package com.folio_sec.reladomo.scala_api.service.scala_lang

import com.folio_sec.reladomo.scala_api._
import com.gs.fw.common.mithra.{ MithraDatedTransactionalObject, MithraTransactionalObject }
import com.gs.fw.finder.OrderBy

import scala.concurrent.{ ExecutionContext, Future }

/**
  * A TransactionalObjectService which supports scala-lang Future interface.
  *
  * @tparam TxObject the actual transactional object type
  */
trait BiTemporalTransactionalObjectService[TxObject <: BiTemporalTransactionalObject,
                                           TxObjectList <: BiTemporalTransactionalList[TxObject, MithraTxObject],
                                           MithraTxObject <: MithraDatedTransactionalObject] {

  type TxObjectListFinder =
    BiTemporalTransactionalObjectFinder[TxObject, TxObjectList, MithraTxObject]#ListFinder[
      TxObject,
      TxObjectList,
      MithraTxObject
    ]

  val finder: BiTemporalTransactionalObjectFinder[TxObject, TxObjectList, MithraTxObject]

  def findOne(operation: FinderOperation)(implicit ctx: ExecutionContext): Future[Option[TxObject]] = {
    Future(finder.findOne(operation))
  }
  def findOneWith(
      operation: (finder.type) => FinderOperation
  )(implicit ctx: ExecutionContext): Future[Option[TxObject]] = {
    Future(finder.findOne(operation.apply(finder)))
  }

  def findOneBypassCache(operation: FinderOperation)(implicit ctx: ExecutionContext): Future[Option[TxObject]] = {
    Future(finder.findOneBypassCache(operation))
  }
  def findOneBypassCacheWith(
      operation: (finder.type) => FinderOperation
  )(implicit ctx: ExecutionContext): Future[Option[TxObject]] = {
    Future(finder.findOneBypassCache(operation.apply(finder)))
  }

  def findMany(operation: FinderOperation)(implicit ctx: ExecutionContext): Future[TxObjectListFinder] = {
    Future(finder.findMany(operation))
  }
  def findManyWith(
      operation: (finder.type) => FinderOperation
  )(implicit ctx: ExecutionContext): Future[TxObjectListFinder] = {
    Future(finder.findMany(operation.apply(finder)))
  }
  def findSortedManyWith(
      operation: (finder.type) => FinderOperation,
      limit: Int = 0,
      orderBy: (finder.type) => OrderBy[_] = (_) => null
  )(implicit ctx: ExecutionContext): Future[TxObjectListFinder] = {
    Future {
      (limit, orderBy.apply(finder)) match {
        case (size, null) if size <= 0 => finder.findManyWith(operation)
        case (size, null)              => finder.findManyWith(operation).limit(size)
        case (size, _) if size <= 0    => finder.findManyWith(operation).orderByWith(orderBy)
        case (size, _)                 => finder.findManyWith(operation).limit(size).orderByWith(orderBy)
      }
    }
  }

  def findManyBypassCache(
      operation: FinderOperation
  )(implicit ctx: ExecutionContext): Future[TxObjectListFinder] = {
    Future(finder.findManyBypassCache(operation))
  }
  def findManyBypassCacheWith(
      operation: (finder.type) => FinderOperation
  )(implicit ctx: ExecutionContext): Future[TxObjectListFinder] = {
    Future(finder.findManyBypassCache(operation.apply(finder)))
  }

  def findSortedManyBypassCacheWith(
      operation: (finder.type) => FinderOperation,
      limit: Int = 0,
      orderBy: (finder.type) => OrderBy[_] = (_) => null
  )(implicit ctx: ExecutionContext): Future[TxObjectListFinder] = {
    Future {
      (limit, orderBy.apply(finder)) match {
        case (size, null) if size <= 0 => finder.findManyBypassCacheWith(operation)
        case (size, null)              => finder.findManyBypassCacheWith(operation).limit(size)
        case (size, _) if size <= 0    => finder.findManyBypassCacheWith(operation).orderByWith(orderBy)
        case (size, _)                 => finder.findManyBypassCacheWith(operation).limit(size).orderByWith(orderBy)
      }
    }
  }

}
