/*
 * This file was automatically generated using folio-sec/sbt-reladomo-plugin. Please do not modify it.
 */
package kata.domain.scala_api

import com.folio_sec.reladomo.scala_api._
import com.folio_sec.reladomo.scala_api.service.twitter.TransactionalObjectService
import kata.domain.{AllTypes => JavaAllTypes}

trait AllTypesServiceAbstract extends TransactionalObjectService[AllTypes, AllTypesList, JavaAllTypes] {
  override val finder: AllTypesFinder = AllTypesFinder
}
