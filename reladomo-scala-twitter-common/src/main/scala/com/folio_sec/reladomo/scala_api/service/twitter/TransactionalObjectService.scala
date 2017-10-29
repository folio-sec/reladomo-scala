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

package com.folio_sec.reladomo.scala_api.service.twitter

import java.util.concurrent.Executors

import com.folio_sec.reladomo.scala_api.{
  FinderOperation,
  TransactionalList,
  TransactionalObject,
  TransactionalObjectFinder
}
import com.gs.fw.common.mithra.MithraTransactionalObject
import com.gs.fw.finder.OrderBy
import com.twitter.util.{ Future, FuturePool, FuturePools }

/**
  * A TransactionalObjectService which supports Twitter's Future interface.
  *
  * @tparam TxObject the actual transactional object type
  */
trait TransactionalObjectService[TxObject <: TransactionalObject,
                                 TxObjectList <: TransactionalList[TxObject, MithraTxObject],
                                 MithraTxObject <: MithraTransactionalObject] {

  type TxObjectListFinder =
    TransactionalObjectFinder[TxObject, TxObjectList, MithraTxObject]#ListFinder[TxObject, TxObjectList, MithraTxObject]

  val finder: TransactionalObjectFinder[TxObject, TxObjectList, MithraTxObject]

  /**
    * The number of threads in the FuturePool.
    */
  def numberOfThreadsInFuturePool = 1

  private[this] lazy val _defaultDedicatedFuturePool: FuturePool = {
    FuturePools.newFuturePool(Executors.newFixedThreadPool(numberOfThreadsInFuturePool))
  }

  /**
    * The dedicated FuturePool for this service class.
    * If you'd like to share a single FuturePool among several services, overriding the attribute.
    */
  def futurePool: FuturePool = _defaultDedicatedFuturePool

  /**
    * Returns a Future value back-ended by the dedicated FuturePool.
    */
  def withDedicatedFuturePool[T](f: => T): Future[T] = futurePool.apply(f)

  def findOne(operation: FinderOperation): Future[Option[TxObject]] = {
    withDedicatedFuturePool {
      finder.findOne(operation)
    }
  }
  def findOneWith(operation: (finder.type) => FinderOperation): Future[Option[TxObject]] = {
    withDedicatedFuturePool {
      finder.findOneWith(operation)
    }
  }

  def findOneBypassCache(operation: FinderOperation): Future[Option[TxObject]] = {
    withDedicatedFuturePool {
      finder.findOneBypassCache(operation)
    }
  }

  def findOneBypassCacheWith(operation: (finder.type) => FinderOperation): Future[Option[TxObject]] = {
    withDedicatedFuturePool {
      finder.findOneBypassCacheWith(operation)
    }
  }

  def findMany(operation: FinderOperation): Future[TxObjectListFinder] = {
    withDedicatedFuturePool {
      finder.findMany(operation)
    }
  }

  def findManyWith(operation: (finder.type) => FinderOperation): Future[TxObjectListFinder] = {
    withDedicatedFuturePool {
      finder.findManyWith(operation)
    }
  }

  def findSortedManyWith(operation: (finder.type) => FinderOperation,
                         limit: Int = 0,
                         orderBy: (finder.type) => OrderBy[_] = (_) => null): Future[TxObjectListFinder] = {
    withDedicatedFuturePool {
      (limit, orderBy.apply(finder)) match {
        case (size, null) if size <= 0 => finder.findManyWith(operation)
        case (size, null)              => finder.findManyWith(operation).limit(size)
        case (size, _) if size <= 0    => finder.findManyWith(operation).orderByWith(orderBy)
        case (size, _)                 => finder.findManyWith(operation).limit(size).orderByWith(orderBy)
      }
    }
  }

  def findManyBypassCache(operation: FinderOperation): Future[TxObjectListFinder] = {
    withDedicatedFuturePool {
      finder.findManyBypassCache(operation)
    }
  }
  def findManyBypassCacheWith(operation: (finder.type) => FinderOperation): Future[TxObjectListFinder] = {
    withDedicatedFuturePool {
      finder.findManyBypassCacheWith(operation)
    }
  }

  def findSortedManyBypassCacheWith(
      operation: (finder.type) => FinderOperation,
      limit: Int = 0,
      orderBy: (finder.type) => OrderBy[_] = (_) => null
  ): Future[TxObjectListFinder] = {
    withDedicatedFuturePool {
      (limit, orderBy.apply(finder)) match {
        case (size, null) if size <= 0 => finder.findManyBypassCacheWith(operation)
        case (size, null)              => finder.findManyBypassCacheWith(operation).limit(size)
        case (size, _) if size <= 0    => finder.findManyBypassCacheWith(operation).orderByWith(orderBy)
        case (size, _)                 => finder.findManyBypassCacheWith(operation).limit(size).orderByWith(orderBy)
      }
    }
  }

}
