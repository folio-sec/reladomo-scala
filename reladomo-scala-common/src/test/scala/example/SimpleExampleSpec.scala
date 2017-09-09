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

import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

import com.folio_sec.example.domain.people.scala_api.{ NewPerson, PersonFinder }
import org.scalatest._
import com.folio_sec.example.domain.simplebank.scala_api.customer._
import com.folio_sec.example.domain.simplebank.scala_api.customer_account.{
  CustomerAccountFinder,
  CustomerAccountList,
  NewCustomerAccount
}
import com.folio_sec.reladomo.scala_api._
import com.folio_sec.reladomo.scala_api.configuration.DatabaseManager
import com.gs.collections.api.set.primitive.IntSet
import com.gs.fw.common.mithra.util.ConstantIntSet

import scala.concurrent.duration.Duration
import scala.concurrent.{ Await, ExecutionContext, Future }
import scala.util.control.NonFatal

class SimpleExampleSpec extends FlatSpec with Matchers {

  def initializeSimpleBankDatabase() = {
    import scalikejdbc._
    Class.forName("org.h2.Driver")
    ConnectionPool.add('simplebank, "jdbc:h2:mem:simplebank;MODE=MySQL", "user", "pass")
    implicit val session = NamedAutoSession('simplebank)
    sql"""
create table CUSTOMER
(
    CUSTOMER_ID int not null,
    FIRST_NAME varchar(64) not null,
    LAST_NAME varchar(64) not null,
    COUNTRY varchar(48) not null
);
alter table CUSTOMER add constraint CUSTOMER_PK primary key (CUSTOMER_ID);
create table CUSTOMER_ACCOUNT
(
    ACCOUNT_ID int not null,
    CUSTOMER_ID int not null,
    ACCOUNT_NAME varchar(48) not null,
    ACCOUNT_TYPE varchar(16) not null,
    BALANCE float8
);
alter table CUSTOMER_ACCOUNT add constraint CUSTOMER_ACCOUNT_fk_0 foreign key (
    CUSTOMER_ID
) references CUSTOMER(
    CUSTOMER_ID
);
alter table CUSTOMER_ACCOUNT add constraint CUSTOMER_ACCOUNT_PK primary key (ACCOUNT_ID);
create index CUSTOMER_ACCOUNT_IDX0 on CUSTOMER_ACCOUNT(CUSTOMER_ID);
""".execute.apply()
  }

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

  it should "load database configurations" in {
    initializeSimpleBankDatabase()
    initializePeopleDatabase()

    DatabaseManager.loadRuntimeConfig("reladomo/ReladomoRuntimeConfig.xml")

    DatabaseManager.connectionManagerMaxSize("SimpleBank") should equal(None)
    DatabaseManager.connectionManagerMaxSize("People") should equal(Some(3))
  }

  it should "create data" in {
    /*
[error] could not find implicit value for parameter tx: com.folio_sec.reladomo.scala_api.Transaction
[error]     NewCustomer("Taro", "Yamada", "Japan").insert()
[error]                                                  ^
[error] one error found
     */
    // NewCustomer("Taro", "Yamada", "Japan").insert()

    TransactionProvider.withTransaction { implicit tx =>
      NewCustomer("Taro", "Yamada", "Japan").insert()
      NewCustomer("Jiro", "Yamada", "Japan").insert()
      NewCustomer("Ichiro", "Tanaka", "Japan").insert()
      NewCustomer("James", "Roper", "Australia").insert()

      val customer: Customer = {
        CustomerFinder
          .findManyWith(_.all)
          .limit(3)
          .orderByWith(_.firstName.descendingOrderBy)
          .head
      }
      val newOne = NewCustomerAccount(
        customerId = customer.customerId,
        accountName = "ty_jp",
        accountType = "NORMAL",
        balance = 1.23D
      )
      // NOTE: this can be a pitfall because Reladomo set default value for this before insertion
      newOne.underlying.getAccountId should equal(0)
      newOne.accountId should equal(None)
      newOne.insert()
      newOne.underlying.getAccountId should equal(1)
      newOne.accountId should equal(Some(1))

      NewCustomerAccount(
        customerId = customer.customerId,
        accountName = "ty_2_jp",
        accountType = "NORMAL",
        balance = 1.23D
      ).insert()
    }
  }

  it should "find rows" in {
    // ----------------------
    // finder

    val taro: Option[Customer] = CustomerFinder.findOneWith(_.firstName.eq("Taro"))
    taro.map(_.customerId) should equal(Some(1))
    taro.map(_.accounts.count()) should equal(Some(2))
    taro.foreach { t =>
      TransactionProvider.withTransaction { implicit tx =>
        t.copy(lastName = "Yamanaka").update()
      }
    }

    CustomerFinder.findOneWith(_.firstName.eq("Taro")).map(_.lastName) should equal(Some("Yamanaka"))

    TransactionProvider.withTransaction { implicit tx =>
      taro match {
        case Some(t) =>
          // update CUSTOMER_ACCOUNT set BALANCE = ?  where ACCOUNT_ID in (?,?) {1: 0.0, 2: 1, 3: 2};
          t.accounts.withBalance(Some(0)).updateAll()
          t.accounts.map(_.balance).distinct should equal(Seq(Some(0.0D)))

          // this operation just returns new method, no side-effect
          t.accounts.withAccountName("dummy")

          // update CUSTOMER_ACCOUNT set BALANCE = ? , ACCOUNT_NAME = ? , ACCOUNT_TYPE = ?  where ACCOUNT_ID in (?,?) {1: 0.0, 2: 'Anonymous', 3: '', 4: 1, 5: 2};
          t.accounts.withAccountName("Anonymous").withAccountType("WITHDRAWN").updateAll()
          t.accounts.map(_.balance).distinct should equal(Seq(Some(0.0D)))
          t.accounts.map(_.accountType).distinct should equal(Seq("WITHDRAWN"))
          t.accounts.map(_.accountName).distinct should equal(Seq("Anonymous"))

          // delete  from CUSTOMER_ACCOUNT where  CUSTOMER_ID = ? {1: 1};
          t.accounts.deleteAll()

          // delete from CUSTOMER where CUSTOMER_ID = ? {1: 1};
          t.delete()
        case _ =>
      }
    }

    val allCustomers = CustomerFinder.findManyWith(_.all)
    allCustomers.count() should equal(3)
    TransactionProvider.withTransaction { implicit tx =>
      allCustomers.currentList.withCountry("JAPAN").updateAll()
    }
    try {
      TransactionProvider.withTransaction { implicit tx =>
        allCustomers.currentList.withCountry("JP").updateAll()
        throw new RuntimeException
      }
    } catch { case NonFatal(_) => }

  }

  it should "support asynchronous operations" in {
    import com.folio_sec.reladomo.scala_api.implicits.OperationImplicits._
    CustomerFinder.findManyWith(q => q.customerId.eq(123) && q.firstName.startsWith("Bob"))

    val customerService = new CustomerService

    implicit val ec = ExecutionContext.global
    val f: Future[customerService.TxObjectListFinder] = customerService
      .findSortedManyWith(
        operation = _.all,
        orderBy = _.customerId.ascendingOrderBy
      )
    Await.result(f, Duration.apply(1, TimeUnit.SECONDS))

    // people database
    TransactionProvider.withTransaction { implicit tx =>
      NewPerson("Taro", "Yamada", "Japan").insert()
    }
    val people = PersonFinder.findManyWith(_.all)
    people.count() should equal(1)
  }

  it should "support forEachWithCursor" in {
    val counter = new AtomicInteger(0)
    CustomerFinder.findManyWith(_.all).foreachWithCursor { entity =>
      val shouldContinue = entity.customerId <= 3
      if (shouldContinue) {
        counter.incrementAndGet()
      }
      shouldContinue
    }
    counter.get() should equal(2)
  }

  it should "support aggregation" in {
    TransactionProvider.withTransaction { implicit tx =>
      val customerId = CustomerFinder.findManyWith(_.all).limit(1).head.customerId
      NewCustomerAccount(
        customerId = customerId,
        accountName = "123",
        accountType = "NORMAL",
        balance = 1.23D
      ).insert()
      NewCustomerAccount(
        customerId = customerId,
        accountName = "234",
        accountType = "PREMIUM",
        balance = 2.02D
      ).insert()
      NewCustomerAccount(
        customerId = customerId,
        accountName = "345",
        accountType = "PREMIUM",
        balance = 3.50D
      ).insert()
    }

    val aggregation = {
      CustomerAccountFinder
        .aggregateWith(_.all)
        .groupBy(_.accountType, "at")
        .count(_.balance, "cnt")
        .max(_.balance, "mx")
        .sum(_.balance, "sm")
    }
    aggregation.foreach { a =>
      a.attribute[Long]("cnt") should be > 0L
      a.attribute[Float]("mx") should be > 0F
      a.attribute[Double]("sm") should be > 0D
    }
  }

  it should "support force methods" in {
    CustomerFinder.findManyWith(_.all).forceResolve()
    CustomerFinder.findManyWith(_.all).forceRefresh()
  }

  it should "support in-clause with gs collections" in {
    val s: IntSet = new ConstantIntSet(Array(1, 2, 3))
    CustomerFinder.findManyWith(_.customerId.in(s))
    CustomerFinder.findManyWith(_.customerId.notIn(s))
  }

  it should "support in-clause" in {
    val s = Set(1, 2, 3)
    CustomerFinder.findManyWith(_.customerId.in(s))
    CustomerFinder.findManyWith(_.customerId.notIn(s))
  }

  it should "support insertAll + cascadeDeleteAll" in {
    TransactionProvider.withTransaction { implicit tx =>
      val before = CustomerFinder.findManyWith(_.all).count()
      val sera   = NewCustomer(firstName = "Kaz", lastName = "Sera", country = "JAPAN")
      val ito    = NewCustomer(firstName = "Hiroshi", lastName = "Ito", country = "JAPAN")
      NewCustomerList().withNewCustomer(sera).withNewCustomer(ito).insertAll()
      val after = CustomerFinder.findManyWith(_.all).count()
      after should equal(before + 2)

      CustomerFinder.findManyWith(_.all).cascadeDeleteAll()
      CustomerFinder.findManyWith(_.all).deleteAll()
    }
  }

  it should "support deleteAll" in {
    TransactionProvider.withTransaction { implicit tx =>
      val before = CustomerFinder.findManyWith(_.all).count()
      val sera   = NewCustomer(firstName = "Kaz", lastName = "Sera", country = "JAPAN")
      val ito    = NewCustomer(firstName = "Hiroshi", lastName = "Ito", country = "JAPAN")
      NewCustomerList().withNewCustomer(sera).withNewCustomer(ito).insertAll()
      val after = CustomerFinder.findManyWith(_.all).count()
      after should equal(before + 2)

      CustomerFinder.findManyWith(_.all).deleteAll()
    }
  }

}
