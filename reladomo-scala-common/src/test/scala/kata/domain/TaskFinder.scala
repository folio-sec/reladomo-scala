/*
 * This file was automatically generated using folio-sec/sbt-reladomo-plugin. Please do not modify it.
 */
package kata.domain.scala_api

import com.folio_sec.reladomo.scala_api._
import com.folio_sec.reladomo.scala_api.exception.ReladomoException
import com.gs.fw.common.mithra.MithraBusinessException
import kata.domain.{ Task => JavaTask }
import scala.collection.JavaConverters._

object TaskFinder extends TaskFinder

trait TaskFinder extends TemporalTransactionalObjectFinder[Task, TaskList, JavaTask] {

  import kata.domain.{ TaskFinder => underlying }

  lazy val all            = underlying.all()
  lazy val taskId         = underlying.taskId()
  lazy val name           = underlying.name()
  lazy val status         = underlying.status()
  lazy val processingDate = underlying.processingDate()

  @throws[ReladomoException]("findOne returned more than one result")
  def findByPrimaryKey(taskId: Int, processingDate: Timestamp): Option[Task] = {
    try { Option(underlying.findByPrimaryKey(taskId, processingDate: Timestamp)).map(Task(_)) } catch {
      case mbe: MithraBusinessException => throw new ReladomoException(mbe)
    }
  }

  @throws[ReladomoException]("findOne returned more than one result")
  def findOne(operation: FinderOperation): Option[Task] = {
    try { Option(underlying.findOne(operation)).map(Task(_)) } catch {
      case mbe: MithraBusinessException => throw new ReladomoException(mbe)
    }
  }

  @throws[ReladomoException]("findOne returned more than one result")
  def findOneBypassCache(operation: FinderOperation): Option[Task] = {
    try { Option(underlying.findOneBypassCache(operation)).map(Task(_)) } catch {
      case mbe: MithraBusinessException => throw new ReladomoException(mbe)
    }
  }

  // never throws exception because #findMany just returns a DomainList object
  def findMany(operation: FinderOperation): ListFinder[Task, TaskList, JavaTask] = {
    ListFinder(TaskList(underlying.findMany(operation)))
  }

  // never throws exception because #findMany just returns a DomainList object
  def findManyBypassCache(operation: FinderOperation): ListFinder[Task, TaskList, JavaTask] = {
    ListFinder(TaskList(underlying.findManyBypassCache(operation)))
  }
}
