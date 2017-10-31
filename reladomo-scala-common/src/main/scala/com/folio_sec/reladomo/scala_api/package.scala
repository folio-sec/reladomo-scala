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

package com.folio_sec.reladomo

import com.folio_sec.reladomo.scala_api.implicits.{ AggregateDataImplicits, OperationImplicits }

package object scala_api extends OperationImplicits with AggregateDataImplicits {

  type FinderOperation = com.gs.fw.finder.Operation[_]

  type Transaction = com.gs.fw.common.mithra.MithraTransaction

  type Timestamp = java.sql.Timestamp

  type BigDecimal = java.math.BigDecimal

}
