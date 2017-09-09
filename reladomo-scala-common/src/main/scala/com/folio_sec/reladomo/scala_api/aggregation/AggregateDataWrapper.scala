package com.folio_sec.reladomo.scala_api.aggregation

import com.gs.fw.common.mithra.AggregateData

case class AggregateDataWrapper(underlying: AggregateData) {

  def attribute[A: AggregateDataTypeBinder](attributeName: String): A = {
    implicitly[AggregateDataTypeBinder[A]].apply(underlying, attributeName)
  }

}
