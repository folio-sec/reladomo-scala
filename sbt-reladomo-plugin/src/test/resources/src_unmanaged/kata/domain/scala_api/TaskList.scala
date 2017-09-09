/*
 * This file was automatically generated using folio-sec/sbt-reladomo-plugin. Please do not modify it.
 */
package kata.domain.scala_api

import com.folio_sec.reladomo.scala_api._
import com.folio_sec.reladomo.scala_api.exception.ReladomoException
import com.gs.fw.common.mithra.MithraBusinessException
import kata.domain.{Task => JavaTask}
import kata.domain.{TaskList => JavaTaskList}
import scala.collection.JavaConverters._

case class TaskList(underlying: JavaTaskList,
  override val newValueAppliers: Seq[() => Unit] = Seq.empty)
  extends TemporalTransactionalList[Task, JavaTask] {
  override def toScalaObject(jObj: JavaTask): Task = Task(jObj)

  def withTaskId(taskId: Int) = {
    TaskList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () => underlying.setTaskId(taskId) }
    )
  }
  def withName(name: String) = {
    TaskList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () => underlying.setName(name) }
    )
  }
  def withStatus(status: String) = {
    TaskList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () => underlying.setStatus(status) }
    )
  }

}

case class NewTaskList(underlying: JavaTaskList = new JavaTaskList(),
  override val newValueAppliers: Seq[() => Unit] = Seq.empty)
  extends NewTemporalTransactionalList[NewTask, JavaTask] {
  override def toScalaObject(jObj: JavaTask): NewTask = NewTask(
      name = jObj.getName,
      status = jObj.getStatus
  )
  def withNewTask(newOne: NewTask): NewTaskList = {
    underlying.add(newOne.underlying)
    this
  }
  def withNewTask(newOne: Seq[NewTask]): NewTaskList = {
    underlying.addAll(newOne.map(_.underlying).asJava)
    this
  }
}

object NewTaskList {
  def apply(newOnes: Seq[NewTask]): NewTaskList = {
    NewTaskList().withNewTask(newOnes)
  }
}
