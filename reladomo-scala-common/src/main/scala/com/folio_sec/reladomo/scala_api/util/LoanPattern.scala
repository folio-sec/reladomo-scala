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

package com.folio_sec.reladomo.scala_api.util

import org.slf4j.LoggerFactory

import scala.util.control.NonFatal

object LoanPattern extends LoanPattern

/**
  * The idiom
  */
trait LoanPattern {

  private[this] val logger = LoggerFactory.getLogger(getClass)

  def using[Resource <: AutoCloseable, Result](resource: Resource)(f: Resource => Result): Result = {
    try {
      f(resource)
    } finally {
      try {
        if (resource != null) {
          resource.close()
        }
      } catch {
        case NonFatal(e) =>
          logger.debug(s"Failed to close a resource because ${e.getMessage}", e)
      }
    }
  }

}
