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
import java.nio.file.Files
import javax.xml.bind.JAXB

import com.folio_sec.reladomo.generator.MithraObject.{ AsOfAttribute, Attribute, Relationship }

import scala.collection.JavaConverters._

class DefaultScalaCodeGenerator(mithraObjectXmlPath: String,
                                scalaApiPackageSuffix: String,
                                scalaApiUnmodifiableFilesOutputDir: String,
                                scalaApiModifiableFilesOutputDir: String,
                                futureApi: String)
    extends ScalaCodeGenerator(
      mithraObjectXmlPath = mithraObjectXmlPath,
      scalaApiPackageSuffix = scalaApiPackageSuffix,
      scalaApiUnmodifiableFilesOutputDir = scalaApiUnmodifiableFilesOutputDir,
      scalaApiModifiableFilesOutputDir = scalaApiModifiableFilesOutputDir,
      futureApi = futureApi
    )

abstract class ScalaCodeGenerator(mithraObjectXmlPath: String,
                                  scalaApiPackageSuffix: String,
                                  scalaApiUnmodifiableFilesOutputDir: String,
                                  scalaApiModifiableFilesOutputDir: String,
                                  futureApi: String) {

  def loadMithraObject(): MithraObject = {
    JAXB.unmarshal(new File(mithraObjectXmlPath), classOf[MithraObject])
  }

  def generateTxObject(obj: MithraObject): String = {
    if (obj != null && obj.getClassName != null) {
      val newAttributesForInsertion = obj.getAttributes.asScala.filter(_.getPrimaryKeyGeneratorStrategy == null)
      val nonPrimaryKeyAttributes   = obj.getAttributes.asScala.filterNot(_.isPrimaryKey)

      val primaryKeyAccessorsInNewObject = {
        val allAttributes                   = obj.getAttributes.asScala
        val primaryKeyGenStrategyAttributes = allAttributes.filter(_.getPrimaryKeyGeneratorStrategy != null)
        primaryKeyGenStrategyAttributes.map { attr =>
          val (name, scalaType, getterName) =
            (attr.getName, toScalaType(attr.getJavaType), toGetterName(attr.getJavaType, attr.getName))
          s"  def ${name}(): Option[${scalaType}] = if (underlying.isInMemoryAndNotInserted) None else Some(underlying.${getterName})"
        }
      }.mkString("\n")

      val primaryKeyAccessorsInExistingObject = {
        val allAttributes        = obj.getAttributes.asScala
        val primaryKeyAttributes = allAttributes.filter(_.isPrimaryKey)
        primaryKeyAttributes.map { attr =>
          val (name, scalaType, getterName) =
            (attr.getName, toScalaType(attr.getJavaType), toGetterName(attr.getJavaType, attr.getName))
          s"  lazy val ${name}: ${scalaType} = underlying.${getterName}"
        }
      }.mkString("\n")

      s"""/*
         | * This file was automatically generated using folio-sec/sbt-reladomo-plugin. Please do not modify it.
         | */
         |package ${obj.getPackageName}.${scalaApiPackageSuffix}
         |
         |import com.folio_sec.reladomo.scala_api._
         |import com.folio_sec.reladomo.scala_api.util.TimestampUtil
         |import com.folio_sec.reladomo.scala_api.exception.ReladomoException
         |import com.gs.fw.common.mithra.MithraBusinessException
         |import ${obj.getPackageName}.{${obj.getClassName} => Java${obj.getClassName}}
         |import ${obj.getPackageName}.{${obj.getClassName}List => Java${obj.getClassName}List}
         |import scala.collection.JavaConverters._
         |
         |case class New${obj.getClassName}(${toScalaConstructorDefinitionCode(newAttributesForInsertion)}) extends New${getBaseTraitNamePrefix(
           obj
         )}TransactionalObject {
         |  override lazy val underlying: Java${obj.getClassName} = {
         |    val underlyingObj = new Java${obj.getClassName}(${if (obj.getAsOfAttributes.size == 1)
           "TimestampUtil.infinityDate()"
         else if (obj.getAsOfAttributes.size == 2)
           "TimestampUtil.now()"
         else ""})
         |${toSetterCalls("underlyingObj", newAttributesForInsertion)}
         |    underlyingObj
         |  }
         |  def insert()(implicit tx: Transaction): ${obj.getClassName} = {
         |    underlying.insert()
         |    ${obj.getClassName}(underlying)
         |  }
         |  def insertForRecovery()(implicit tx: Transaction): ${obj.getClassName} = {
         |    underlying.insertForRecovery()
         |    ${obj.getClassName}(underlying)
         |  }
         |  def cascadeInsert()(implicit tx: Transaction): ${obj.getClassName} = {
         |    underlying.cascadeInsert()
         |    ${obj.getClassName}(underlying)
         |  }
         |${primaryKeyAccessorsInNewObject}
         |}
         |
         |case class ${obj.getClassName} private (override val underlying: Java${obj.getClassName}${if (nonPrimaryKeyAttributes.isEmpty)
           ""
         else ","} ${toScalaConstructorDefinitionCode(
           nonPrimaryKeyAttributes
         )}) extends ${getBaseTraitNamePrefix(obj)}TransactionalObject {
         |  override lazy val savedUnderlying: Java${obj.getClassName} = {
         |${toSetterCalls("underlying", nonPrimaryKeyAttributes)}
         |    underlying
         |  }
         |${primaryKeyAccessorsInExistingObject}
         |${toRelationships(obj.getRelationships.asScala)}
         |}
         |object ${obj.getClassName} {
         |  def apply(underlying: Java${obj.getClassName}): ${obj.getClassName} = {
         |    new ${obj.getClassName}(
         |      underlying = underlying,
         |${toScalaConstructorCode(nonPrimaryKeyAttributes)}
         |    )
         |  }
         |}
         |""".stripMargin
    } else {
      ""
    }
  }

  def generateTxList(obj: MithraObject): String = {
    if (obj != null && obj.getClassName != null) {
      val newAttributes = obj.getAttributes.asScala.filter(_.getPrimaryKeyGeneratorStrategy == null)

      s"""/*
         | * This file was automatically generated using folio-sec/sbt-reladomo-plugin. Please do not modify it.
         | */
         |package ${obj.getPackageName}.${scalaApiPackageSuffix}
         |
         |import com.folio_sec.reladomo.scala_api._
         |import com.folio_sec.reladomo.scala_api.exception.ReladomoException
         |import com.gs.fw.common.mithra.MithraBusinessException
         |import ${obj.getPackageName}.{${obj.getClassName} => Java${obj.getClassName}}
         |import ${obj.getPackageName}.{${obj.getClassName}List => Java${obj.getClassName}List}
         |import scala.collection.JavaConverters._
         |
         |case class ${obj.getClassName}List(underlying: Java${obj.getClassName}List,
         |  override val newValueAppliers: Seq[() => Unit] = Seq.empty)
         |  extends ${getBaseTraitNamePrefix(obj)}TransactionalList[${obj.getClassName}, Java${obj.getClassName}] {
         |  override def toScalaObject(jObj: Java${obj.getClassName}): ${obj.getClassName} = ${obj.getClassName}(jObj)
         |
         |${toWithCode(obj, obj.getAttributes.asScala)}
         |}
         |
         |case class New${obj.getClassName}List(underlying: Java${obj.getClassName}List = new Java${obj.getClassName}List(),
         |  override val newValueAppliers: Seq[() => Unit] = Seq.empty)
         |  extends New${getBaseTraitNamePrefix(obj)}TransactionalList[New${obj.getClassName}, Java${obj.getClassName}] {
         |  override def toScalaObject(jObj: Java${obj.getClassName}): New${obj.getClassName} = New${obj.getClassName}(
         |${toScalaConstructorCode(newAttributes, "jObj")}
         |  )
         |  def withNew${obj.getClassName}(newOne: New${obj.getClassName}): New${obj.getClassName}List = {
         |    underlying.add(newOne.underlying)
         |    this
         |  }
         |  def withNew${obj.getClassName}(newOne: Seq[New${obj.getClassName}]): New${obj.getClassName}List = {
         |    underlying.addAll(newOne.map(_.underlying).asJava)
         |    this
         |  }
         |}
         |
         |object New${obj.getClassName}List {
         |  def apply(newOnes: Seq[New${obj.getClassName}]): New${obj.getClassName}List = {
         |    New${obj.getClassName}List().withNew${obj.getClassName}(newOnes)
         |  }
         |}
         |""".stripMargin
    } else {
      ""
    }
  }

  def generateFinder(obj: MithraObject): String = {
    if (obj != null && obj.getClassName != null) {
      val allAttributes     = obj.getAttributes.asScala
      val allAsOfAttributes = obj.getAsOfAttributes.asScala
      val allRelationships  = obj.getRelationships.asScala
      val extraParamsWithTypePart = obj.getAsOfAttributes.size match {
        case 2 => ", businessDate: Timestamp, processingDate: Timestamp"
        case 1 => ", processingDate: Timestamp"
        case _ => ""
      }
      val extraParamsPart = obj.getAsOfAttributes.size match {
        case 2 => ", businessDate: Timestamp, processingDate: Timestamp"
        case 1 => ", processingDate: Timestamp"
        case _ => ""
      }
      val primaryKeyDefs =
        obj.getAttributes.asScala.filter(_.isPrimaryKey).map(pk => s"${pk.getName}: ${toScalaType(pk)}").mkString(", ")
      val primaryKeyNames = obj.getAttributes.asScala.filter(_.isPrimaryKey).map(_.getName).mkString(", ")
      val sourceAttrDef =
        Option(obj.getSourceAttribute).map(v => s", ${v.getName}: ${toScalaType(v.getJavaType)}").getOrElse("")
      val sourceAttrName = Option(obj.getSourceAttribute).map(a => ", " + a.getName).getOrElse("")
      s"""/*
         | * This file was automatically generated using folio-sec/sbt-reladomo-plugin. Please do not modify it.
         | */
         |package ${obj.getPackageName}.${scalaApiPackageSuffix}
         |
         |import com.folio_sec.reladomo.scala_api._
         |import com.folio_sec.reladomo.scala_api.exception.ReladomoException
         |import com.gs.fw.common.mithra.MithraBusinessException
         |import ${obj.getPackageName}.{${obj.getClassName} => Java${obj.getClassName}}
         |import scala.collection.JavaConverters._
         |
         |object ${obj.getClassName}Finder extends ${obj.getClassName}Finder
         |
         |trait ${obj.getClassName}Finder extends ${getBaseTraitNamePrefix(obj)}TransactionalObjectFinder[${obj.getClassName}, ${obj.getClassName}List, Java${obj.getClassName}] {
         |
         |  import ${obj.getPackageName}.{${obj.getClassName}Finder => underlying}
         |
         |  lazy val all = underlying.all()
         |${toDslDefinitions(allAttributes, allAsOfAttributes, allRelationships)}
         |
         |  @throws[ReladomoException]("findOne returned more than one result")
         |  def findByPrimaryKey(${primaryKeyDefs}${sourceAttrDef}${extraParamsWithTypePart}): Option[${obj.getClassName}] = {
         |    try { Option(underlying.findByPrimaryKey(${primaryKeyNames}${sourceAttrName}${extraParamsPart})).map(${obj.getClassName}(_)) }
         |    catch { case mbe: MithraBusinessException => throw new ReladomoException(mbe) }
         |  }
         |
         |  @throws[ReladomoException]("findOne returned more than one result")
         |  def findOne(operation: FinderOperation): Option[${obj.getClassName}] = {
         |    try { Option(underlying.findOne(operation)).map(${obj.getClassName}(_)) }
         |    catch { case mbe: MithraBusinessException => throw new ReladomoException(mbe) }
         |  }
         |
         |  @throws[ReladomoException]("findOne returned more than one result")
         |  def findOneBypassCache(operation: FinderOperation): Option[${obj.getClassName}] = {
         |    try { Option(underlying.findOneBypassCache(operation)).map(${obj.getClassName}(_)) }
         |    catch { case mbe: MithraBusinessException => throw new ReladomoException(mbe) }
         |  }
         |
         |  // never throws exception because #findMany just returns a DomainList object
         |  def findMany(operation: FinderOperation): ListFinder[${obj.getClassName}, ${obj.getClassName}List, Java${obj.getClassName}] = {
         |    ListFinder(${obj.getClassName}List(underlying.findMany(operation)))
         |  }
         |
         |  // never throws exception because #findMany just returns a DomainList object
         |  def findManyBypassCache(operation: FinderOperation): ListFinder[${obj.getClassName}, ${obj.getClassName}List, Java${obj.getClassName}] = {
         |    ListFinder(${obj.getClassName}List(underlying.findManyBypassCache(operation)))
         |  }
         |}
         |""".stripMargin
    } else {
      ""
    }
  }

  def generateServiceAbstract(obj: MithraObject): String = {
    if (obj != null && obj.getClassName != null) {
      if (futureApi == "twitter") {
        s"""/*
           | * This file was automatically generated using folio-sec/sbt-reladomo-plugin. Please do not modify it.
           | */
           |package ${obj.getPackageName}.${scalaApiPackageSuffix}
           |
           |import com.folio_sec.reladomo.scala_api._
           |import com.folio_sec.reladomo.scala_api.service.twitter.${getBaseTraitNamePrefix(obj)}TransactionalObjectService
           |import ${obj.getPackageName}.{${obj.getClassName} => Java${obj.getClassName}}
           |
           |trait ${obj.getClassName}ServiceAbstract extends ${getBaseTraitNamePrefix(obj)}TransactionalObjectService[${obj.getClassName}, ${obj.getClassName}List, Java${obj.getClassName}] {
           |  override val finder: ${obj.getClassName}Finder = ${obj.getClassName}Finder
           |}
           |""".stripMargin
      } else {
        s"""/*
           | * This file was automatically generated using folio-sec/sbt-reladomo-plugin. Please do not modify it.
           | */
           |package ${obj.getPackageName}.${scalaApiPackageSuffix}
           |
           |import com.folio_sec.reladomo.scala_api._
           |import com.folio_sec.reladomo.scala_api.service.scala_lang.${getBaseTraitNamePrefix(obj)}TransactionalObjectService
           |import ${obj.getPackageName}.{${obj.getClassName} => Java${obj.getClassName}}
           |
           |trait ${obj.getClassName}ServiceAbstract extends ${getBaseTraitNamePrefix(obj)}TransactionalObjectService[${obj.getClassName}, ${obj.getClassName}List, Java${obj.getClassName}] {
           |  override val finder: ${obj.getClassName}Finder = ${obj.getClassName}Finder
           |}
           |""".stripMargin
      }
    } else {
      ""
    }
  }
  def generateService(obj: MithraObject): String = {
    if (obj != null && obj.getClassName != null) {
      if (futureApi == "twitter") {
        s"""package ${obj.getPackageName}.${scalaApiPackageSuffix}
           |
           |object ${obj.getClassName}Service extends ${obj.getClassName}Service
           |
           |trait ${obj.getClassName}Service extends ${obj.getClassName}ServiceAbstract {
           |}
           |""".stripMargin
      } else {
        s"""package ${obj.getPackageName}.${scalaApiPackageSuffix}
           |
           |object ${obj.getClassName}Service extends ${obj.getClassName}Service
           |
           |trait ${obj.getClassName}Service extends ${obj.getClassName}ServiceAbstract {
           |}
           |""".stripMargin
      }
    } else {
      ""
    }
  }

  def generate(): Seq[File] = {
    val obj = loadMithraObject()
    if (obj != null && obj.getPackageName != null && scalaApiPackageSuffix != null) {
      val sourceDir =
        s"${scalaApiUnmodifiableFilesOutputDir}/${obj.getPackageName.replaceAll("\\.", "/")}/${scalaApiPackageSuffix
          .replaceAll("\\.", "/")}"
      Files.createDirectories(new File(sourceDir).toPath)

      val txObjectSource     = generateTxObject(obj)
      val txObjectSourceFile = new File(s"${sourceDir}/${obj.getClassName}.scala")
      Files.write(txObjectSourceFile.toPath, txObjectSource.getBytes)

      val txListSource     = generateTxList(obj)
      val txListSourceFile = new File(s"${sourceDir}/${obj.getClassName}List.scala")
      Files.write(txListSourceFile.toPath, txListSource.getBytes)

      val finderSource     = generateFinder(obj)
      val finderSourceFile = new File(s"${sourceDir}/${obj.getClassName}Finder.scala")
      Files.write(finderSourceFile.toPath, finderSource.getBytes)

      val serviceAbstractSource     = generateServiceAbstract(obj)
      val serviceAbstractSourceFile = new File(s"${sourceDir}/${obj.getClassName}ServiceAbstract.scala")
      Files.write(serviceAbstractSourceFile.toPath, serviceAbstractSource.getBytes)

      val scalaSourceDir =
        s"${scalaApiModifiableFilesOutputDir}/${obj.getPackageName.replaceAll("\\.", "/")}/${scalaApiPackageSuffix
          .replaceAll("\\.", "/")}"
      Files.createDirectories(new File(scalaSourceDir).toPath)

      val serviceSource     = generateService(obj)
      val serviceSourceFile = new File(s"${scalaSourceDir}/${obj.getClassName}Service.scala")
      // skip if Service source code already exists
      if (serviceSourceFile.exists() == false) {
        Files.write(serviceSourceFile.toPath, serviceSource.getBytes)
      }
      // managed source must not be included
      val generatedFiles = Seq(
        txObjectSourceFile,
        txListSourceFile,
        finderSourceFile,
        serviceAbstractSourceFile
        // Somehow, compilation errors like 'PersonService is already defined as object PersonService' happen for companion objects
        // when adding service source files to the `managedSources` (managedSources := generate(sourceGenerators).value)
        //,serviceSourceFile
      )
      generatedFiles
    } else {
      Seq.empty
    }
  }

  // ---------------------------------------
  // private methods
  // ---------------------------------------

  private def toScalaConstructorDefinitionCode(attributes: Seq[Attribute]): String = {
    attributes
      .map { attr =>
        s"${attr.getName}: ${toScalaType(attr)}"
      }
      .mkString(", ")
  }

  private def toScalaConstructorCode(attributes: Seq[Attribute], objectName: String = "underlying"): String = {
    attributes
      .map { attribute =>
        val getterCode = {
          if (attribute.isNullable) {
            val optionCode =
              s"Option(${objectName}.${toGetterName(attribute.getJavaType, attribute.getName)})"
            val mapCode = attribute.getJavaType match {
              case "String"     => ""
              case "int"        => ".map(_.asInstanceOf[Int])"
              case "long"       => ".map(_.asInstanceOf[Long])"
              case "short"      => ".map(_.asInstanceOf[Short])"
              case "double"     => ".map(_.asInstanceOf[Double])"
              case "float"      => ".map(_.asInstanceOf[Float])"
              case "Date"       => ".map(_.asInstanceOf[java.util.Date])"
              case "Timestamp"  => ".map(_.asInstanceOf[java.sql.Timestamp])"
              case "byte"       => ".map(_.asInstanceOf[Byte])"
              case "byte[]"     => ".map(_.asInstanceOf[Array[Byte]])"
              case "BigDecimal" => ".map(scala.math.BigDecimal.apply)"
              case _            => ""
            }
            s"if (${objectName}.${toIsNullMethodName(attribute.getName)}) None else ${optionCode + mapCode}"
          } else {
            val getterCall = s"${objectName}.${toGetterName(attribute.getJavaType, attribute.getName)}"
            attribute.getJavaType match {
              case "BigDecimal" => s"scala.math.BigDecimal(${getterCall})"
              case _            => getterCall
            }
          }
        }
        s"      ${attribute.getName} = ${getterCode}"
      }
      .mkString(",\n")
  }

  private def isNonNullJavaTypeName(typeName: String): Boolean = {
    typeName match {
      case null => false
      case _    => Character.isLowerCase(typeName.head) && typeName.contains("[]") == false
    }
  }

  private def getBaseTraitNamePrefix(obj: MithraObject): String = {
    obj.getAsOfAttributes.size match {
      case 2 => "BiTemporal"
      case 1 => "Temporal"
      case _ => ""
    }
  }

  private def toWithCode(obj: MithraObject, attributes: Seq[Attribute]): String = {
    attributes
      .map { attribute =>
        val typeName = attribute.getJavaType match {
          case "String"     => "String"
          case "char"       => "Char"
          case "int"        => "Int"
          case "long"       => "Long"
          case "short"      => "Short"
          case "double"     => "Double"
          case "float"      => "Float"
          case "Date"       => "java.util.Date"
          case "Timestamp"  => "java.sql.Timestamp"
          case "byte"       => "Byte"
          case "byte[]"     => "Array[Byte]"
          case "boolean"    => "Boolean"
          case "BigDecimal" => "scala.math.BigDecimal"
          case _            => "String"
        }
        if (attribute.isNullable) {
          if (isNonNullJavaTypeName(attribute.getJavaType)) {
            s"""  def ${toWithMethodName(attribute.getName)}(${attribute.getName}: Option[${typeName}]) = {
               |    ${obj.getClassName}List(
               |      underlying = underlying,
               |      newValueAppliers = newValueAppliers :+ { () =>
               |        ${attribute.getName} match {
               |          case Some(_${attribute.getName}) => underlying.${toSetterName(attribute.getName)}(_${attribute.getName})
               |          case _ => underlying.${toSetterName(attribute.getName)}Null()
               |        }
               |      }
               |    )
               |  }
               |""".stripMargin
          } else {
            s"""  def ${toWithMethodName(attribute.getName)}(${attribute.getName}: Option[${typeName}]) = {
               |    ${obj.getClassName}List(
               |      underlying = underlying,
               |      newValueAppliers = newValueAppliers :+ { () =>
               |        underlying.${toSetterName(attribute.getName)}(${attribute.getName}${appendOptionConverterIfNeeded(
                 attribute.getJavaType
               )}.orNull[${toJavaCompatibleScalaType(attribute)}])
               |      }
               |    )
               |  }
               |""".stripMargin
          }
        } else {
          s"""  def ${toWithMethodName(attribute.getName)}(${attribute.getName}: ${typeName}) = {
             |    ${obj.getClassName}List(
             |      underlying = underlying,
             |      newValueAppliers = newValueAppliers :+ { () => underlying.${toSetterName(attribute.getName)}(${attribute.getName}${toJavaValueIfNeeded(
               attribute.getJavaType
             )}) }
             |    )
             |  }
             |""".stripMargin
        }
      }
      .mkString("")
  }

  private def toScalaType(attribute: Attribute, javaCompatible: Boolean = false): String = {
    (attribute.getJavaType, javaCompatible == false && attribute.isNullable) match {
      case ("String", nullable)                => if (nullable) "Option[String]" else "String"
      case ("char", nullable)                  => if (nullable) "Option[Char]" else "Char"
      case ("int", nullable)                   => if (nullable) "Option[Int]" else "Int"
      case ("long", nullable)                  => if (nullable) "Option[Long]" else "Long"
      case ("short", nullable)                 => if (nullable) "Option[Short]" else "Short"
      case ("double", nullable)                => if (nullable) "Option[Double]" else "Double"
      case ("float", nullable)                 => if (nullable) "Option[Float]" else "Float"
      case ("Date", nullable)                  => if (nullable) "Option[java.util.Date]" else "java.util.Date"
      case ("Timestamp", nullable)             => if (nullable) "Option[java.sql.Timestamp]" else "java.sql.Timestamp"
      case ("byte", nullable)                  => if (nullable) "Option[Byte]" else "Byte"
      case ("byte[]", nullable)                => if (nullable) "Option[Array[Byte]]" else "Array[Byte]"
      case ("boolean", nullable)               => if (nullable) "Option[Boolean]" else "Boolean"
      case ("BigDecimal", _) if javaCompatible => "java.math.BigDecimal"
      case ("BigDecimal", nullable)            => if (nullable) "Option[scala.math.BigDecimal]" else "scala.math.BigDecimal"
      case (_, nullable)                       => if (nullable) "Option[String]" else "String"
    }
  }
  private def toJavaCompatibleScalaType(attribute: Attribute): String = {
    toScalaType(attribute = attribute, javaCompatible = true)
  }

  private[this] val SetTypeRegexp  = "^Set<(.+)>$".r
  private[this] val ListTypeRegexp = "^List<(.+)>$".r

  private def toScalaType(javaTypeName: String) = {
    javaTypeName.trim match {
      case "String"                    => "String"
      case "char"                      => "Char"
      case "int"                       => "Int"
      case "long"                      => "Long"
      case "short"                     => "Short"
      case "double"                    => "Double"
      case "float"                     => "Float"
      case "Date"                      => "java.util.Date"
      case "Timestamp"                 => "java.sql.Timestamp"
      case "byte"                      => "Byte"
      case "byte[]"                    => "Array[Byte]"
      case "boolean"                   => "Boolean"
      case "BigDecimal"                => "scala.math.BigDecimal"
      case SetTypeRegexp(genericType)  => s"Set[${genericType}]"
      case ListTypeRegexp(genericType) => s"Seq[${genericType}]"
      case _                           => "String"
    }
  }

  private def toMethodArguments(relationship: Relationship): String = {
    if (relationship.getParameters == null) {
      ""
    } else {
      relationship.getParameters
        .split(",")
        .map(_.trim.split("\\s+").toSeq)
        .map {
          case Seq(javaTypeName, name)    => s"${name}: ${toScalaType(javaTypeName)}"
          case Seq(javaTypeName, name, _) => s"${name}: ${toScalaType(javaTypeName)}"
        }
        .mkString(", ")
    }
  }
  private def toParameterNameCSV(relationship: Relationship): String = {
    if (relationship.getParameters == null) {
      ""
    } else {
      relationship.getParameters
        .split(",")
        .map { v =>
          val Array(typeName, name) = v.trim.split("\\s+")
          if (typeName.contains("<")) s"${name}.asJava" else name
        }
        .mkString(", ")
    }
  }

  private def parametersExists(relationship: Relationship): Boolean = {
    Option(relationship.getParameters).filterNot(_.isEmpty).isDefined
  }

  private def toRelationships(relationships: Seq[Relationship]): String = {
    relationships
      .map { relationship =>
        relationship.getCardinality match {
          case "one-to-many" =>
            val (objPt1: String, objPt2: String) = {
              if (relationship.getReturnType != null) {
                (s"underlying.${toGetterName(relationship.getReturnType, relationship.getName)}", "")
              } else {
                (s"${relationship.getRelatedObject}List(underlying.${toGetterName(relationship.getReturnType,
                                                                                  relationship.getName)}", ")")
              }
            }
            if (parametersExists(relationship)) {
              s"""  // NOTE: This method always returns the latest relationship without issuing a query
                 |  def ${relationship.getName}(${toMethodArguments(relationship)}) = ${objPt1}(${toParameterNameCSV(
                   relationship
                 )})${objPt2}""".stripMargin
            } else {
              s"""  // NOTE: This method always returns the latest relationship without issuing a query
                 |  def ${relationship.getName} = ${objPt1}()${objPt2}""".stripMargin
            }
          case "many-to-one" | "one-to-one" =>
            val relationshipName       = relationship.getName
            val relationType           = relationship.getRelatedObject
            val relationshipReturnType = relationship.getReturnType

            val methodArguments = toMethodArguments(relationship)
            val getterName      = toGetterName(relationshipReturnType, relationship.getName)
            val getterArguments = toParameterNameCSV(relationship)

            if (parametersExists(relationship)) {
              if (relationshipReturnType != null) {
                s"""  // NOTE: This method always returns the latest relationship without issuing a query
                   |  def ${relationshipName}(${methodArguments}): Option[${relationType}] = underlying.${getterName}(${getterArguments})""".stripMargin
              } else {
                s"""  // NOTE: This method always returns the latest relationship without issuing a query
                   |  def ${relationshipName}(${methodArguments}): Option[${relationType}] = Option(underlying.${getterName}(${getterArguments})).map(${relationType}(_))""".stripMargin
              }
            } else {
              if (relationshipReturnType != null) {
                s"""  // NOTE: This method always returns the latest relationship without issuing a query
                   |  def ${relationshipName}: Option[${relationType}] = underlying.${getterName}()""".stripMargin
              } else {
                s"""  // NOTE: This method always returns the latest relationship without issuing a query
                   |  def ${relationshipName}: Option[${relationType}] = Option(underlying.${getterName}()).map(${relationType}(_))""".stripMargin
              }
            }
          case _ => ""
        }
      }
      .mkString("\n")
  }

  private def toGetterName(javaTypeName: String, name: String): String = {
    javaTypeName match {
      case "boolean" => toMethodNameWithPrefix(name, "is")
      case _         => toMethodNameWithPrefix(name, "get")
    }
  }
  private def toSetterName(name: String): String       = toMethodNameWithPrefix(name, "set")
  private def toWithMethodName(name: String): String   = toMethodNameWithPrefix(name, "with")
  private def toIsNullMethodName(name: String): String = toMethodNameWithPrefix(name, "is") + "Null"
  private def toMethodNameWithPrefix(name: String, prefix: String): String = {
    s"${prefix}${name.charAt(0).toUpper + name.substring(1)}"
  }

  private def toDslDefinitions(attributes: Seq[Attribute],
                               asOfAttributes: Seq[AsOfAttribute],
                               relationships: Seq[Relationship]): String = {
    val attrs = attributes.map { attribute =>
      s"  lazy val ${attribute.getName} = underlying.${attribute.getName}()"
    }
    val asOfAttrs = asOfAttributes.map { attribute =>
      s"  lazy val ${attribute.getName} = underlying.${attribute.getName}()"
    }
    val rls = relationships.map { rel =>
      rel match {
        case r if parametersExists(r) =>
          s"  def ${rel.getName}(${toMethodArguments(r)}) = underlying.${rel.getName}(${toParameterNameCSV(r)})"
        case r =>
          s"  lazy val ${r.getName} = underlying.${r.getName}()"
      }
    }
    (attrs ++ asOfAttrs ++ rls).mkString("\n")
  }

  private def toSetterCalls(underlying: String, attributes: Seq[Attribute]): String = {
    attributes
      .map { attribute =>
        if (attribute.isNullable) {
          if (isNonNullJavaTypeName(attribute.getJavaType)) {
            s"""    ${attribute.getName} match {
               |      case Some(_${attribute.getName}) => ${underlying}.${toSetterName(attribute.getName)}(_${attribute.getName}${toJavaValueIfNeeded(
                 attribute.getJavaType
               )})
               |      case _ => ${underlying}.${toSetterName(attribute.getName)}Null()
               |    }""".stripMargin
          } else {
            s"    ${underlying}.${toSetterName(attribute.getName)}(${attribute.getName}${appendOptionConverterIfNeeded(attribute.getJavaType)}.orNull[${toJavaCompatibleScalaType(attribute)}])"
          }
        } else {
          s"    ${underlying}.${toSetterName(attribute.getName)}(${attribute.getName}${toJavaValueIfNeeded(attribute.getJavaType)})"
        }
      }
      .mkString("\n")
  }

  private def appendOptionConverterIfNeeded(javaType: String): String = {
    toJavaValueIfNeeded(javaType) match {
      case ""         => ""
      case methodCall => s".map(_${methodCall})"
    }
  }

  private def toJavaValueIfNeeded(javaType: String): String = {
    javaType match {
      case "BigDecimal" => ".bigDecimal"
      case _            => ""
    }
  }

}
