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
import com.folio_sec.reladomo.scala_api.TransactionProvider
import com.folio_sec.reladomo.scala_api.configuration.DatabaseManager
import com.twitter.util.{ Await, Duration, Future }
import org.scalatest._

class SimpleExampleSpec extends FlatSpec with Matchers {

  def initializePeopleDatabase() = {
    import scalikejdbc._
    Class.forName("org.h2.Driver")
    ConnectionPool.add('people, "jdbc:h2:mem:people;MODE=MySQL", "user", "pass")
    implicit val session = NamedAutoSession('people)
    sql"""
create table PERSON
(
    PERSON_ID int not null,
    FIRST_NAME varchar(64) not null,
    LAST_NAME varchar(64) not null,
    COUNTRY varchar(48) not null
);
alter table PERSON add constraint PERSON_PK primary key (PERSON_ID);
""".execute.apply()
  }

  it should "work" in {
    initializePeopleDatabase()

    DatabaseManager.loadRuntimeConfig("reladomo/ReladomoRuntimeConfig.xml")

    // people database
    TransactionProvider.withTransaction { implicit tx =>
      NewPerson("Taro", "Yamada", "Japan").insert()
    }
    val people = PersonFinder.findManyWith(_.all)
    people.count() should equal(1)

    val f: Future[PersonService.TxObjectListFinder] = PersonService
      .findSortedManyWith(
        operation = _.all,
        orderBy = _.personId.ascendingOrderBy
      )
    Await.result(f, Duration.fromSeconds(1))
  }

}
