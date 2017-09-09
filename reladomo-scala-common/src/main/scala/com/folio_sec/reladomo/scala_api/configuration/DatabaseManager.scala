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

package com.folio_sec.reladomo.scala_api.configuration

import java.io.InputStream

import com.folio_sec.reladomo.scala_api.exception.ReladomoConfigurationException
import com.folio_sec.reladomo.scala_api.util.LoanPattern
import com.gs.fw.common.mithra.MithraManagerProvider
import com.gs.fw.common.mithra.mithraruntime._
import org.slf4j.LoggerFactory

import scala.collection.JavaConverters._

object DatabaseManager extends DatabaseManager {}

trait DatabaseManager {

  private[this] val logger = LoggerFactory.getLogger(classOf[DatabaseManager])

  private[this] var allowReloadingRuntimeConfig: Boolean = false

  private[this] val loadedConfig = new scala.collection.mutable.ListBuffer[String]()

  private[this] var currentRuntimeType: Option[MithraRuntimeType] = None

  def loadRuntimeConfig(runtimeConfigXmlClasspath: String): Unit = {
    if (loadedConfig.contains(runtimeConfigXmlClasspath)) {
      if (allowReloadingRuntimeConfig) {
        forciblyLoadRuntimeConfig(runtimeConfigXmlClasspath)
      } else {
        logger.info(
          s"The RuntimeConfig.xml (${runtimeConfigXmlClasspath}) is already loaded. If you'd like to reload the configuration runtime, " +
          "set DatabaseManager#allowReloadingRuntimeConfig as true."
        )
      }
    } else {
      forciblyLoadRuntimeConfig(runtimeConfigXmlClasspath)
    }
  }

  def currentMithraRuntime: Option[MithraRuntimeType] = currentRuntimeType

  def connectionManager(name: String): Option[ConnectionManagerType] = {
    currentMithraRuntime match {
      case Some(runtime) =>
        runtime.getConnectionManagers.asScala.find(
          _.getProperties.asScala.exists(
            prop => prop.getName == "connectionManagerName" && prop.getValue == name
          )
        )
      case _ => None
    }
  }

  def connectionManagerMaxSize(name: String): Option[Int] = {
    for {
      connManager <- connectionManager(name)
      maxPoolSize <- connManager.getProperties.asScala.find(_.getName == "maxPoolSize").map(_.getValue.toInt)
    } yield {
      maxPoolSize
    }
  }

  // ----------------------------------------------
  // private methods

  private[this] def forciblyLoadRuntimeConfig(runtimeConfigXmlClasspath: String): Unit = {
    val globalMithraManager = MithraManagerProvider.getMithraManager
    LoanPattern.using(loadClasspathResourceAsInputStream(runtimeConfigXmlClasspath)) { (configStream: InputStream) =>
      currentRuntimeType.synchronized {
        logger.info(s"Loading the runtime config file: ${runtimeConfigXmlClasspath} ...")
        val configManager = globalMithraManager.getConfigManager
        val runtimeType   = configManager.parseConfiguration(configStream)
        currentRuntimeType = Some(runtimeType)
        runtimeType.getConnectionManagers.asScala.foreach { connMgr =>
          connMgr.getProperties.asScala.find(_.getName == RuntimeConfigKeys.PARENT_CONFIG_LOCATION) match {
            case Some(location) =>
              mergeAbsentValuesFromParent(connMgr, location.getValue)
            case _ =>
          }
          configManager.initializeRuntime(runtimeType)
        }
      }
    }
  }

  private[this] def mergeAbsentValuesFromParent(childConnManager: ConnectionManagerType, parentPath: String): Unit = {
    logger.info(s"Loading a parent runtime config file: ${parentPath} ...")

    val CONFIG_MANAGER = MithraManagerProvider.getMithraManager.getConfigManager
    val parent = LoanPattern.using(loadClasspathResourceAsInputStream(parentPath)) { inputStream =>
      CONFIG_MANAGER.parseConfiguration(inputStream)
    }
    parent.getConnectionManagers.size match {
      case 1 =>
        val parentConnManager = parent.getConnectionManagers.get(0)
        parentConnManager.getProperties.asScala
          .find(_.getName == RuntimeConfigKeys.PARENT_CONFIG_LOCATION) match {
          case Some(location) => mergeAbsentValuesFromParent(parentConnManager, location.getValue)
          case _              =>
        }

        if (parentConnManager.getClassName != childConnManager.getClassName) {
          throw new ReladomoConfigurationException(
            s"ConnectionManager#className in ${parentPath} must be consistent with its child config files"
          )
        } else {
          if (childConnManager.getLoadOperationProvider == null) {
            childConnManager.setLoadOperationProvider(parentConnManager.getLoadOperationProvider)
          }
          if (childConnManager.getReplicationSchemaName == null) {
            childConnManager.setReplicationSchemaName(parentConnManager.getReplicationSchemaName)
          }
          val existingPropNames = childConnManager.getProperties.asScala.map(_.getName)
          parentConnManager.getProperties.asScala.foreach { prop =>
            if (existingPropNames.exists(_ == prop.getName) == false) {
              childConnManager.getProperties.add(prop)
            }
          }
          val existingSchemaNames = childConnManager.getSchemas.asScala.map(_.getName)
          parentConnManager.getSchemas.asScala.foreach { schema =>
            if (existingSchemaNames.exists(_ == schema.getName) == false) {
              childConnManager.getSchemas.add(schema)
            }
          }
          val existingObjConfigClassNames = childConnManager.getMithraObjectConfigurations.asScala.map(_.getClassName)
          parentConnManager.getMithraObjectConfigurations.asScala.foreach { parentObjConfig =>
            if (existingObjConfigClassNames.exists(_ == parentObjConfig.getClassName) == false) {
              childConnManager.getMithraObjectConfigurations.add(parentObjConfig)
            }
          }
          val existingTempObjConfigClassNames =
            childConnManager.getMithraTemporaryObjectConfigurations.asScala.map(_.getClassName)
          parentConnManager.getMithraTemporaryObjectConfigurations.asScala.foreach { parentObjConfig =>
            if (existingTempObjConfigClassNames.exists(_ == parentObjConfig.getClassName) == false) {
              childConnManager.getMithraTemporaryObjectConfigurations.add(parentObjConfig)
            }
          }
        }

      case _ => throw new ReladomoConfigurationException(s"${parentPath} must have a single ConnectionManager")
    }
  }

  private[this] def loadClasspathResourceAsInputStream(filePath: String): InputStream = {
    val stream = getClass.getClassLoader.getResourceAsStream(filePath)
    if (stream == null) throw new Exception("Failed to locate " + filePath + " in classpath")
    else stream
  }

}
