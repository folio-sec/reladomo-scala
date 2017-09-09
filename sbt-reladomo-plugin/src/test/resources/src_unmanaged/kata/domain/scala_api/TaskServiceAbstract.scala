/*
 * This file was automatically generated using folio-sec/sbt-reladomo-plugin. Please do not modify it.
 */
package kata.domain.scala_api

import com.folio_sec.reladomo.scala_api._
import com.folio_sec.reladomo.scala_api.service.twitter.TemporalTransactionalObjectService
import kata.domain.{Task => JavaTask}

trait TaskServiceAbstract extends TemporalTransactionalObjectService[Task, TaskList, JavaTask] {
  override val finder: TaskFinder = TaskFinder
}
