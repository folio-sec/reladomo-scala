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

package example

import com.folio_sec.example.domain.people.{ Person => JavaPerson }
import com.folio_sec.example.domain.people
import com.folio_sec.reladomo.scala_api._
import com.gs.fw.common.mithra.MithraBusinessException

case class NewPerson(firstName: String, lastName: String, country: String) extends TransactionalObject {
  lazy val underlying: com.folio_sec.example.domain.people.Person = {
    val underlyingObj = new com.folio_sec.example.domain.people.Person()
    underlyingObj.setFirstName(firstName)
    underlyingObj.setLastName(lastName)
    underlyingObj.setCountry(country)
    underlyingObj
  }
  lazy val savedUnderlying = underlying

  def insert()(implicit tx: Transaction): Person = {
    underlying.insert()
    Person(underlying)
  }
}

case class Person private (val underlying: com.folio_sec.example.domain.people.Person,
                           personId: Int,
                           firstName: String,
                           lastName: String,
                           country: String)
    extends TransactionalObject {
  lazy val savedUnderlying: com.folio_sec.example.domain.people.Person = {
    underlying.setPersonId(personId)
    underlying.setFirstName(firstName)
    underlying.setLastName(lastName)
    underlying.setCountry(country)
    underlying
  }
}
object Person {
  def apply(underlying: com.folio_sec.example.domain.people.Person): Person = {
    new Person(
      underlying = underlying,
      personId = underlying.getPersonId,
      firstName = underlying.getFirstName,
      lastName = underlying.getLastName,
      country = underlying.getCountry
    )
  }
}

case class PersonList(underlying: com.folio_sec.example.domain.people.PersonList,
                      override val newValueAppliers: Seq[() => Unit] = Seq.empty)
    extends TransactionalList[Person, com.folio_sec.example.domain.people.Person] {
  override def toScalaObject(mithraTxObject: people.Person): Person = Person(mithraTxObject)

  def withFirstName(firstName: String) = {
    PersonList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () =>
        underlying.setFirstName(firstName)
      }
    )
  }
  def withLastName(lastName: String) = {
    PersonList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () =>
        underlying.setLastName(lastName)
      }
    )
  }
  def withCountry(country: String) = {
    PersonList(
      underlying = underlying,
      newValueAppliers = newValueAppliers :+ { () =>
        underlying.setCountry(country)
      }
    )
  }
}

object PersonFinder extends PersonFinder

trait PersonFinder extends TransactionalObjectFinder[Person, PersonList, com.folio_sec.example.domain.people.Person] {

  import com.folio_sec.example.domain.people.{ PersonFinder => underlying }

  lazy val all       = underlying.all()
  lazy val personId  = underlying.personId
  lazy val firstName = underlying.firstName
  lazy val lastName  = underlying.lastName
  lazy val country   = underlying.country

  @throws[MithraBusinessException]("findOne returned more than one result")
  def findByPrimaryKey(pk: Int): Option[Person] = {
    Option(underlying.findByPrimaryKey(pk)).map(Person(_))
  }

  @throws[MithraBusinessException]("findOne returned more than one result")
  def findOne(operation: FinderOperation): Option[Person] = {
    Option(underlying.findOne(operation)).map(Person(_))
  }

  @throws[MithraBusinessException]("findOne returned more than one result")
  def findOneBypassCache(operation: FinderOperation): Option[Person] = {
    Option(underlying.findOneBypassCache(operation)).map(Person(_))
  }

  def findMany(operation: FinderOperation): ListFinder[Person, PersonList, JavaPerson] = {
    ListFinder(PersonList(underlying.findMany(operation)))
  }

  def findManyBypassCache(operation: FinderOperation): ListFinder[Person, PersonList, JavaPerson] = {
    ListFinder(PersonList(underlying.findManyBypassCache(operation)))
  }
}

import com.folio_sec.reladomo.scala_api.service.twitter.TransactionalObjectService

object PersonService extends PersonService
trait PersonService extends TransactionalObjectService[Person, PersonList, com.folio_sec.example.domain.people.Person] {
  override val finder: PersonFinder = PersonFinder
}
