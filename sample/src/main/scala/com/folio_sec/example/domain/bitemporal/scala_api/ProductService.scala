package com.folio_sec.example.domain.bitemporal.scala_api

import com.folio_sec.reladomo.scala_api.TransactionProvider
import com.twitter.util.{ Future, Try }

object ProductService extends ProductService

trait ProductService extends ProductServiceAbstract {

  def insert(product: NewProduct): Future[Unit] = {
    withDedicatedFuturePool {
      Try(
        TransactionProvider.withTransaction { implicit tx =>
          product.insert()
        }
      )
    }
  }

  def findAll(): Future[TxObjectListFinder] = findManyWith(_.all)

}
