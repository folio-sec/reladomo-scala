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

import java.sql.Timestamp
import java.util.Calendar

object TimestampUtil {

  trait TimestampProvider {
    def now: Timestamp
  }

  object DefaultTimestampProvider extends TimestampProvider {
    override def now: Timestamp = new Timestamp(System.currentTimeMillis())
  }

  def now()(implicit provider: TimestampProvider = DefaultTimestampProvider): Timestamp = provider.now

  def infinityDate()(implicit provider: TimestampProvider = DefaultTimestampProvider): Timestamp = {
    createTimestamp(9999, 11, 1, Calendar.PM, 23, 59, 0, 0)
  }

  private[this] def createTimestamp(year: Int,
                                    month: Int,
                                    dayOfMonth: Int,
                                    amPm: Int,
                                    hourOfDay: Int,
                                    minute: Int,
                                    second: Int,
                                    millisecond: Int): Timestamp = {
    val cal = Calendar.getInstance
    cal.set(Calendar.YEAR, year)
    cal.set(Calendar.MONTH, month)
    cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
    cal.set(Calendar.AM_PM, amPm)
    cal.set(Calendar.HOUR_OF_DAY, hourOfDay)
    cal.set(Calendar.MINUTE, minute)
    cal.set(Calendar.SECOND, second)
    cal.set(Calendar.MILLISECOND, millisecond)
    new Timestamp(cal.getTimeInMillis)
  }
}
