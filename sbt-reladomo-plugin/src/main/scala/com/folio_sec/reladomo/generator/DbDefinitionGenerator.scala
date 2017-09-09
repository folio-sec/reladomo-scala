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

package com.folio_sec.reladomo.generator

import com.gs.fw.common.mithra.generator.dbgenerator.MithraDbDefinitionGenerator

class DefaultDbDefinitionGenerator(xmlFilePath: String, dbDefinitionFilesDir: String, databaseType: String)
    extends DbDefinitionGenerator(xmlFilePath = xmlFilePath,
                                  dbDefinitionFilesDir = dbDefinitionFilesDir,
                                  databaseType = databaseType)

abstract class DbDefinitionGenerator(xmlFilePath: String, dbDefinitionFilesDir: String, databaseType: String) {

  protected val generator = new MithraDbDefinitionGenerator()
  initialize()

  protected def initialize(): Unit = {
    generator.setGeneratedDir(dbDefinitionFilesDir)
    generator.setXml(xmlFilePath)
    generator.setDatabaseType(databaseType)
  }

  def generate(): Unit = {
    generator.execute()
  }

}
