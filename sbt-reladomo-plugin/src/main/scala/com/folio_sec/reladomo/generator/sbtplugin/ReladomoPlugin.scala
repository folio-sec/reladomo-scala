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

package com.folio_sec.reladomo.generator.sbtplugin

import java.nio.file._
import java.util.stream.Collectors

import com.folio_sec.reladomo.generator._
import sbt._
import Keys._

object ReladomoPlugin extends AutoPlugin {

  object autoImport {

    val reladomoGen                          = taskKey[Seq[File]]("The task which generates source code from Reladomo configuration")
    val reladomoXmlFilesDir                  = settingKey[File]("The root directory to scan ReladomoClassList.xml files")
    val reladomoDbDefinitionFilesDir         = settingKey[File]("The directory to output DB definition files")
    val reladomoDbDefinitionDatabaseType     = settingKey[String]("The database type used for DB definition generation")
    val reladomoClassListXmlFileName         = settingKey[String]("The Reladomo file name")
    val reladomoScalaApiPackageSuffix        = settingKey[String]("The Scala wrapper API package suffix")
    val reladomoModifiableJavaCodeOutputDir  = settingKey[File]("The directory to output managed Java source code")
    val reladomoModifiableScalaCodeOutputDir = settingKey[File]("The directory to output managed Scala source code")
    val reladomoUnmodifiableFilesOutputDir   = settingKey[File]("The directory to output unmanaged source code")
    val reladomoDbDefinitionGenerationEnabled =
      settingKey[Boolean]("If true, the command generates corresponding DDLs as well")
    val reladomoScalaApiFutureType =
      settingKey[String]("Configure Future type to use for Reladomo Scala API code generation (scala-lang/twitter)")
    val reladomoDbDefinitionGeneratorFactoryClassName =
      settingKey[String]("The class name of the factory which implements DbDefinitionGeneratorFactory")
    val reladomoJavaCodeGeneratorFactoryClassName =
      settingKey[String]("The class name of the factory which implements JavaCodeGeneratorFactory")
    val reladomoScalaCodeGeneratorFactoryClassName =
      settingKey[String]("The class name of the factory which implements ScalaCodeGeneratorFactory")

    lazy val baseSettings: Seq[Def.Setting[_]] = Seq(
      reladomoGen := reladomoGenTask.value,
      reladomoXmlFilesDir := resourceDirectory.value / "reladomo",
      reladomoClassListXmlFileName := "ReladomoClassList.xml",
      reladomoDbDefinitionFilesDir := resourceDirectory.value / "reladomo" / "db_definition",
      reladomoDbDefinitionDatabaseType := "mysql",
      reladomoScalaApiPackageSuffix := "scala_api",
      reladomoModifiableJavaCodeOutputDir := (javaSource in Compile).value,
      reladomoModifiableScalaCodeOutputDir := (scalaSource in Compile).value,
      reladomoUnmodifiableFilesOutputDir := (sourceManaged in Compile).value,
      reladomoDbDefinitionGenerationEnabled := true,
      reladomoDbDefinitionGeneratorFactoryClassName := "com.folio_sec.reladomo.generator.DefaultDbDefinitionGeneratorFactory",
      reladomoJavaCodeGeneratorFactoryClassName := "com.folio_sec.reladomo.generator.DefaultJavaCodeGeneratorFactory",
      reladomoScalaCodeGeneratorFactoryClassName := "com.folio_sec.reladomo.generator.DefaultScalaCodeGeneratorFactory",
      reladomoScalaApiFutureType := "scala-lang" // or "twitter"
    )
  }

  import autoImport._

  override def trigger  = noTrigger
  override def requires = sbt.plugins.JvmPlugin

  override val projectSettings: Seq[Def.Setting[_]] = {
    inConfig(Compile)(baseSettings) ++ Seq(
      compileOrder := CompileOrder.JavaThenScala,
      sourceGenerators in Compile += reladomoGen in Compile,
      // Since we have an issue with the compile:doc task which causes XXX is already defined as object XXX errors,
      // this sbt plugin reluctantly disables the phase.
      sources in (Compile, doc) := Seq.empty,
      publishArtifact in (Compile, packageDoc) := false
    )
  }

  import scala.collection.JavaConverters._

  lazy val reladomoGenTask: Def.Initialize[Task[Seq[File]]] = {
    Def.task {
      val dbDefinitionGeneratorFactory: DbDefinitionGeneratorFactory = {
        val clazz = Class.forName(reladomoDbDefinitionGeneratorFactoryClassName.value)
        clazz.newInstance().asInstanceOf[DbDefinitionGeneratorFactory]
      }
      val javaCodeGeneratorFactory: JavaCodeGeneratorFactory = {
        val clazz = Class.forName(reladomoJavaCodeGeneratorFactoryClassName.value)
        clazz.newInstance().asInstanceOf[JavaCodeGeneratorFactory]
      }
      val scalaCodeGeneratorFactory: ScalaCodeGeneratorFactory = {
        val clazz = Class.forName(reladomoScalaCodeGeneratorFactoryClassName.value)
        clazz.newInstance().asInstanceOf[ScalaCodeGeneratorFactory]
      }

      val classListXmlFiles: Seq[File] = {
        Files
          .walk(Paths.get(reladomoXmlFilesDir.value.getAbsolutePath))
          .collect(Collectors.toList[Path])
          .asScala
          .filter(_.toString.endsWith(reladomoClassListXmlFileName.value))
          .map(_.toFile)
      }
      val generatedJavaFiles: Seq[File] = classListXmlFiles.flatMap {
        case xml =>
          println(s"Generating Reladomo classes from ${xml}...")

          // explicit evaluate not inside if-expressions
          val dbDefinitionFilesDir = reladomoDbDefinitionFilesDir.value.getAbsolutePath
          val databaseType         = reladomoDbDefinitionDatabaseType.value
          if (reladomoDbDefinitionGenerationEnabled.value) {
            println(s"Generating DDL samples from ${xml}...")
            val dbDefGenerator = dbDefinitionGeneratorFactory.getInstance(
              xmlFilePath = xml.getAbsolutePath,
              dbDefinitionFilesDir = dbDefinitionFilesDir,
              databaseType = databaseType
            )
            dbDefGenerator.generate()
          }

          val javaCodeGenerator = javaCodeGeneratorFactory.getInstance(
            xmlFilePath = xml.getAbsolutePath,
            modifiableFilesOutputDir = reladomoModifiableJavaCodeOutputDir.value.getAbsolutePath,
            unmodifiableFilesOutputDir = reladomoUnmodifiableFilesOutputDir.value.getAbsolutePath
          )
          javaCodeGenerator.generate()
      }

      val classXmlFiles: Seq[File] = {
        Files
          .walk(Paths.get(reladomoXmlFilesDir.value.getAbsolutePath))
          .collect(Collectors.toList[Path])
          .asScala
          .filterNot(_.toString.endsWith(reladomoClassListXmlFileName.value))
          .filter(_.toString.endsWith(".xml"))
          .map(_.toFile)
      }
      val generateScalaFiles: Seq[File] = classXmlFiles.flatMap {
        case xml =>
          val scalaCodeGenerator = scalaCodeGeneratorFactory.getInstance(
            mithraObjectXmlPath = xml.getAbsolutePath,
            scalaApiPackageSuffix = reladomoScalaApiPackageSuffix.value,
            scalaApiModifiableFilesOutputDir = reladomoModifiableScalaCodeOutputDir.value.getAbsolutePath,
            scalaApiUnmodifiableFilesOutputDir = reladomoUnmodifiableFilesOutputDir.value.getAbsolutePath,
            futureApi = reladomoScalaApiFutureType.value
          )
          scalaCodeGenerator.generate()
      }

      val generatedFiles = generatedJavaFiles ++ generateScalaFiles
      generatedFiles
    }
  }
}
