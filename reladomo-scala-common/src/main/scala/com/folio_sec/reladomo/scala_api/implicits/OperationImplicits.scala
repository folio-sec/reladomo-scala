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

package com.folio_sec.reladomo.scala_api.implicits

import scala.language.implicitConversions
import com.folio_sec.reladomo.scala_api.operation.OperationWrapper
import com.gs.collections.impl.factory.primitive.{ IntSets, LongSets }
import com.gs.fw.common.mithra.attribute._
import com.gs.fw.common.mithra.finder.Operation

import scala.collection.JavaConverters._

object OperationImplicits extends OperationImplicits

trait OperationImplicits {

  implicit class FromOperationToScalaWrapper(underlying: Operation) {

    def &&(other: Operation): Operation = OperationWrapper(underlying).and(OperationWrapper(other)).underlying

    def ||(other: Operation): Operation = OperationWrapper(underlying).or(OperationWrapper(other)).underlying

  }

  implicit class NonPrimitiveAttributeWrapper[Owner, V](j: NonPrimitiveAttribute[Owner, V]) {
    def in(set: Set[V]): Operation    = j.in(set.asJava)
    def notIn(set: Set[V]): Operation = j.in(set.asJava)
  }

  implicit class IntegerAttributeWrapper[Owner](j: IntegerAttribute[Owner]) {
    def in(set: Set[Int]): Operation    = j.in(IntSets.immutable.of(set.toList: _*))
    def notIn(set: Set[Int]): Operation = j.notIn(IntSets.immutable.of(set.toList: _*))
  }
  implicit class LongAttributeWrapper[Owner](j: LongAttribute[Owner]) {
    def in(set: Set[Long]): Operation    = j.in(LongSets.immutable.of(set.toList: _*))
    def notIn(set: Set[Long]): Operation = j.notIn(LongSets.immutable.of(set.toList: _*))
  }

}
