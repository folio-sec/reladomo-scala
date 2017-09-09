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

import java.io.Closeable
import java.sql.Connection
import java.util.{ Properties, TimeZone }

import com.folio_sec.reladomo.scala_api.exception.ReladomoConfigurationException
import com.gs.fw.common.mithra.connectionmanager.{ SourcelessConnectionManager, XAConnectionManager }
import com.gs.fw.common.mithra.databasetype.DatabaseType

import DbConnectionManager._

case class DbConnectionManager(
    databaseTypeClassName: String,
    databaseTypeClassNameEnvVariableName: String,
    jdbcDriverClassName: String,
    jdbcDriverClassNameEnvVariableName: String,
    jdbcUrl: String,
    jdbcUrlEnvVariableName: String,
    jdbcUsername: String,
    jdbcUsernameEnvVariableName: String,
    jdbcPassword: String,
    jdbcPasswordEnvVariableName: String,
    connectionTimeoutMillis: Int = DEFAULT_CONNECTION_TIMEOUT_MILLS, // the maximum amount of time to wait if there are no connections available
    connectionTimeoutMillisEnvVariableName: String,
    initialPoolSize: Int = DEFAULT_INITIAL_POOL_SIZE,
    initialPoolSizeEnvVariableName: String,
    maxPoolSize: Int = DEFAULT_MAX_POOL_SIZE,
    maxPoolSizeEnvVariableName: String,
    databaseTimeZone: TimeZone = DEFAULT_DATABASE_TIME_ZONE,
    databaseTimeZoneEnvVariableName: String
) extends SourcelessConnectionManager
    with Closeable {

  private[this] val xaConnectionManager: XAConnectionManager = new XAConnectionManager()

  private[this] val _databaseType: DatabaseType = {
    // TODO: refactoring
    val clazz       = Class.forName(databaseTypeClassName)
    val constructor = clazz.getDeclaredConstructors.head
    constructor.setAccessible(true)
    constructor.newInstance().asInstanceOf[DatabaseType]
  }

  initialize()

  def initialize(): Unit = {
    if (jdbcDriverClassNameEnvVariableName != null) {
      xaConnectionManager.setDriverClassName(
        sys.env
          .get(jdbcDriverClassNameEnvVariableName)
          .getOrElse(envValueNotFound(jdbcDriverClassNameEnvVariableName))
      )
    } else {
      xaConnectionManager.setDriverClassName(jdbcDriverClassName)
    }

    if (connectionTimeoutMillisEnvVariableName != null) {
      xaConnectionManager.setMaxWait(
        sys.env
          .get(connectionTimeoutMillisEnvVariableName)
          .map(_.toInt)
          .getOrElse(envValueNotFound(connectionTimeoutMillisEnvVariableName))
      )
    } else {
      xaConnectionManager.setMaxWait(connectionTimeoutMillis)
    }

    if (jdbcUrlEnvVariableName != null) {
      xaConnectionManager.setJdbcConnectionString(
        sys.env
          .get(jdbcUrlEnvVariableName)
          .getOrElse(envValueNotFound(jdbcUrlEnvVariableName))
      )
    } else {
      xaConnectionManager.setJdbcConnectionString(jdbcUrl)
    }

    if (jdbcUsernameEnvVariableName != null) {
      xaConnectionManager.setJdbcUser(
        sys.env
          .get(jdbcUsernameEnvVariableName)
          .getOrElse(envValueNotFound(jdbcUsernameEnvVariableName))
      )
    } else {
      xaConnectionManager.setJdbcUser(jdbcUsername)
    }

    if (jdbcPasswordEnvVariableName != null) {
      xaConnectionManager.setJdbcPassword(
        sys.env
          .get(jdbcPasswordEnvVariableName)
          .getOrElse(envValueNotFound(jdbcPasswordEnvVariableName))
      )
    } else {
      xaConnectionManager.setJdbcPassword(jdbcPassword)
    }

    if (initialPoolSizeEnvVariableName != null) {
      xaConnectionManager.setInitialSize(
        sys.env
          .get(initialPoolSizeEnvVariableName)
          .map(_.toInt)
          .getOrElse(envValueNotFound(initialPoolSizeEnvVariableName))
      )
    } else {
      xaConnectionManager.setInitialSize(initialPoolSize)
    }

    if (maxPoolSizeEnvVariableName != null) {
      xaConnectionManager.setPoolSize(
        sys.env
          .get(maxPoolSizeEnvVariableName)
          .map(_.toInt)
          .getOrElse(envValueNotFound(maxPoolSizeEnvVariableName))
      )
    } else {
      xaConnectionManager.setPoolSize(maxPoolSize)
    }

    xaConnectionManager.initialisePool()
  }

  override def close(): Unit = {
    xaConnectionManager.shutdown()
  }

  override def getConnection: Connection = xaConnectionManager.getConnection

  override def getDatabaseType: DatabaseType = _databaseType

  override def getDatabaseTimeZone = databaseTimeZone

  override def createBulkLoader = throw new UnsupportedOperationException("BulkLoader is not supported")

  override def getDatabaseIdentifier: String = {
    val foundDbName: Option[String] = for {
      url    <- jdbcUrl.split("\\?").headOption
      dbName <- url.split("/").lastOption
    } yield dbName

    foundDbName match {
      case Some(dbName) => dbName
      case _ =>
        throw new ReladomoConfigurationException(s"Failed to detect database identifier from jdbcUrl: ${jdbcUrl}")
    }
  }

  private[this] def envValueNotFound(name: String): Nothing = {
    throw new ReladomoConfigurationException(s"Env variable ${name} is not found!")
  }

}

object DbConnectionManager {

  val DEFAULT_CONNECTION_TIMEOUT_MILLS = 500
  val DEFAULT_INITIAL_POOL_SIZE        = 1
  val DEFAULT_MAX_POOL_SIZE            = 1
  val DEFAULT_DATABASE_TIME_ZONE       = TimeZone.getTimeZone("UTC")

  // The connection manager class com.folio_sec.reladomo.scala_api.configuration.DbConnectionManager
  // must have a public static getInstance(Properties) method.
  // https://github.com/goldmansachs/reladomo/blob/16.4.0/reladomo/src/main/java/com/gs/fw/common/mithra/util/MithraConfigurationManager.java#L106-L118
  def getInstance(props: Properties): DbConnectionManager = {
    new DbConnectionManager(
      databaseTypeClassName = props.getProperty("databaseTypeClassName"),
      databaseTypeClassNameEnvVariableName = props.getProperty("databaseTypeClassNameEnvVariableName"),
      jdbcDriverClassName = props.getProperty("jdbcDriverClassName"),
      jdbcDriverClassNameEnvVariableName = props.getProperty("jdbcDriverClassNameEnvVariableName"),
      jdbcUrl = props.getProperty("jdbcUrl"),
      jdbcUrlEnvVariableName = props.getProperty("jdbcUrlEnvVariableName"),
      jdbcUsername = props.getProperty("jdbcUsername"),
      jdbcUsernameEnvVariableName = props.getProperty("jdbcUsernameEnvVariableName"),
      jdbcPassword = props.getProperty("jdbcPassword"),
      jdbcPasswordEnvVariableName = props.getProperty("jdbcPasswordEnvVariableName"),
      connectionTimeoutMillis = Option(props.getProperty("connectionTimeoutMillis"))
        .map(_.toInt)
        .getOrElse(DEFAULT_CONNECTION_TIMEOUT_MILLS),
      connectionTimeoutMillisEnvVariableName = props.getProperty("connectionTimeoutMillisEnvVariableName"),
      initialPoolSize = Option(props.getProperty("initialPoolSize"))
        .map(_.toInt)
        .getOrElse(DEFAULT_INITIAL_POOL_SIZE),
      initialPoolSizeEnvVariableName = props.getProperty("initialPoolSizeEnvVariableName"),
      maxPoolSize = Option(props.getProperty("maxPoolSize")).map(_.toInt).getOrElse(DEFAULT_MAX_POOL_SIZE),
      maxPoolSizeEnvVariableName = props.getProperty("maxPoolSizeEnvVariableName"),
      databaseTimeZone = Option(props.getProperty("databaseTimeZone"))
        .map(TimeZone.getTimeZone)
        .getOrElse(DEFAULT_DATABASE_TIME_ZONE),
      databaseTimeZoneEnvVariableName = props.getProperty("databaseTimeZoneEnvVariableName")
    )
  }
}
