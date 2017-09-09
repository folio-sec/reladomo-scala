package com.folio_sec.reladomo.scala_api.aggregation

import com.gs.fw.common.mithra.AggregateData

trait AggregateDataTypeBinder[+A] {

  def apply(ad: AggregateData, name: String): A

  def map[B](f: A => B): AggregateDataTypeBinder[B] = new AggregateDataTypeBinder[B] {
    def apply(rs: AggregateData, name: String): B = f(AggregateDataTypeBinder.this.apply(rs, name))
  }

}
