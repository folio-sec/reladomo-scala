/*
 * This file was automatically generated using folio-sec/sbt-reladomo-plugin. Please do not modify it.
 */
package kata.domain.scala_api

import com.folio_sec.reladomo.scala_api._
import com.folio_sec.reladomo.scala_api.util.TimestampUtil
import com.folio_sec.reladomo.scala_api.exception.ReladomoException
import com.gs.fw.common.mithra.MithraBusinessException
import kata.domain.{ Task => JavaTask }
import kata.domain.{ TaskList => JavaTaskList }
import scala.collection.JavaConverters._

case class NewTask(name: String, status: String) extends TemporalTransactionalObject {
  override lazy val underlying: JavaTask = {
    val underlyingObj = new JavaTask(TimestampUtil.now())
    underlyingObj.setName(name)
    underlyingObj.setStatus(status)
    underlyingObj
  }
  override lazy val savedUnderlying = underlying
  def taskId(): Option[Int]         = if (underlying.isInMemoryAndNotInserted) None else Some(underlying.getTaskId)
}

case class Task private (override val underlying: JavaTask, taskId: Int, name: String, status: String)
    extends TemporalTransactionalObject {
  override lazy val savedUnderlying: JavaTask = {
    underlying.setTaskId(taskId)
    underlying.setName(name)
    underlying.setStatus(status)
    underlying
  }

}
object Task {
  def apply(underlying: JavaTask): Task = {
    new Task(
      underlying = underlying,
      taskId = underlying.getTaskId,
      name = underlying.getName,
      status = underlying.getStatus
    )
  }
}
