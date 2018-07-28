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

import java.io.File
import java.nio.file.{ Files, Path, Paths }
import java.util.stream.Collectors

import com.gs.fw.common.mithra.generator.MithraGenerator
import scala.collection.JavaConverters._

class DefaultJavaCodeGenerator(xmlFilePath: String,
                               modifiableFilesOutputDir: String,
                               unmodifiableFilesOutputDir: String)
    extends JavaCodeGenerator(
      xmlFilePath = xmlFilePath,
      modifiableFilesOutputDir = modifiableFilesOutputDir,
      unmodifiableFilesOutputDir = unmodifiableFilesOutputDir
    )

abstract class JavaCodeGenerator(xmlFilePath: String,
                                 modifiableFilesOutputDir: String,
                                 unmodifiableFilesOutputDir: String) {

  protected val generator = new MithraGenerator

  initialize()

  def generate(): Seq[File] = {
    val modifiableDir = new File(modifiableFilesOutputDir)
    if (modifiableDir.exists() == false) {
      Files.createDirectories(modifiableDir.toPath)
    }
    val unmodifiableDir = new File(unmodifiableFilesOutputDir)
    if (unmodifiableDir.exists() == false) {
      Files.createDirectories(unmodifiableDir.toPath)
    }
    generator.setLogLevel(1)

    val existingModifiableFiles = listJavaFiles(modifiableDir.getAbsolutePath)

    generator.execute()

    listJavaFiles(modifiableDir.getAbsolutePath).diff(existingModifiableFiles) ++
    listJavaFiles(unmodifiableDir.getAbsolutePath)
  }

  protected def initialize(): Unit = {
    generator.setNonGeneratedDir(modifiableFilesOutputDir)
    generator.setGeneratedDir(unmodifiableFilesOutputDir)
    generator.setXml(xmlFilePath)
    generator.setGenerateGscListMethod(false)
    generator.setGenerateEcListMethod(true)
  }

  protected def listJavaFiles(dir: String): Seq[File] = {
    Files
      .walk(Paths.get(dir))
      .collect(Collectors.toList[Path])
      .asScala
      .map(_.toFile)
      .filter(_.isFile)
      .filter(_.getPath.endsWith(".java"))
  }

}
