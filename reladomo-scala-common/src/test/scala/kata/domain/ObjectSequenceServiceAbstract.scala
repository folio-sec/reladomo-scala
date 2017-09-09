/*
 * This file was automatically generated using folio-sec/sbt-reladomo-plugin. Please do not modify it.
 */
package kata.domain.scala_api

import com.folio_sec.reladomo.scala_api._
import com.folio_sec.reladomo.scala_api.service.scala_lang.TransactionalObjectService
import kata.domain.{ ObjectSequence => JavaObjectSequence }

trait ObjectSequenceServiceAbstract
    extends TransactionalObjectService[ObjectSequence, ObjectSequenceList, JavaObjectSequence] {
  override val finder: ObjectSequenceFinder = ObjectSequenceFinder
}
