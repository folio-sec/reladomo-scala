package generator

import com.folio_sec.reladomo.generator.{ DefaultJavaCodeGenerator, DefaultScalaCodeGenerator }
import org.scalatest._

class ScalaCodeGeneratorSpec extends FlatSpec with Matchers {

  it should "generate" in {
    val javaGeneraror = new DefaultJavaCodeGenerator(
      xmlFilePath = "src/test/resources/reladomo/simplebank/ReladomoClassList.xml",
      modifiableFilesOutputDir = "src/test/resources/generated/",
      unmodifiableFilesOutputDir = "src/test/resources/src_unmanaged/"
    )
    javaGeneraror.generate()
    val generator = new DefaultScalaCodeGenerator(
      mithraObjectXmlPath = "src/test/resources/reladomo/simplebank/Customer.xml",
      scalaApiPackageSuffix = "scala_api",
      scalaApiModifiableFilesOutputDir = "src/test/resources/generated/",
      scalaApiUnmodifiableFilesOutputDir = "src/test/resources/src_unmanaged/",
      futureApi = "twitter"
    )
    generator.generate()
  }

  it should "generateTxObject" in {
    val generator = new DefaultScalaCodeGenerator(
      mithraObjectXmlPath = "src/test/resources/reladomo/simplebank/Customer.xml",
      scalaApiPackageSuffix = "scala_api",
      scalaApiModifiableFilesOutputDir = "src/test/resources/generated/",
      scalaApiUnmodifiableFilesOutputDir = "src/test/resources/src_unmanaged/",
      futureApi = "twitter"
    )
    val sourceCode = generator.generateTxObject(generator.loadMithraObject())
    val expectedSourceCode =
      """/*
        | * This file was automatically generated using folio-sec/sbt-reladomo-plugin. Please do not modify it.
        | */
        |package com.folio_sec.example.domain.simplebank.scala_api
        |
        |import com.folio_sec.reladomo.scala_api._
        |import com.folio_sec.reladomo.scala_api.util.TimestampUtil
        |import com.folio_sec.reladomo.scala_api.exception.ReladomoException
        |import com.gs.fw.common.mithra.MithraBusinessException
        |import com.folio_sec.example.domain.simplebank.{Customer => JavaCustomer}
        |import com.folio_sec.example.domain.simplebank.{CustomerList => JavaCustomerList}
        |import scala.collection.JavaConverters._
        |
        |case class NewCustomer(firstName: String, lastName: String, country: Option[String], zipCode: Option[Int]) extends NewTransactionalObject {
        |  override lazy val underlying: JavaCustomer = {
        |    val underlyingObj = new JavaCustomer()
        |    underlyingObj.setFirstName(firstName)
        |    underlyingObj.setLastName(lastName)
        |    underlyingObj.setCountry(country.map(_country => _country).orNull[String])
        |    zipCode match {
        |      case Some(_zipCode) => underlyingObj.setZipCode(_zipCode)
        |      case _ => underlyingObj.setZipCodeNull()
        |    }
        |    underlyingObj
        |  }
        |  def insert()(implicit tx: Transaction): Customer = {
        |    underlying.insert()
        |    Customer(underlying)
        |  }
        |  def insertForRecovery()(implicit tx: Transaction): Customer = {
        |    underlying.insertForRecovery()
        |    Customer(underlying)
        |  }
        |  def cascadeInsert()(implicit tx: Transaction): Customer = {
        |    underlying.cascadeInsert()
        |    Customer(underlying)
        |  }
        |  def customerId(): Option[Int] = if (underlying.isInMemoryAndNotInserted) None else Some(underlying.getCustomerId)
        |}
        |
        |case class Customer private (override val underlying: JavaCustomer, firstName: String, lastName: String, country: Option[String], zipCode: Option[Int]) extends TransactionalObject {
        |  override lazy val savedUnderlying: JavaCustomer = {
        |    underlying.setFirstName(firstName)
        |    underlying.setLastName(lastName)
        |    underlying.setCountry(country.map(_country => _country).orNull[String])
        |    zipCode match {
        |      case Some(_zipCode) => underlying.setZipCode(_zipCode)
        |      case _ => underlying.setZipCodeNull()
        |    }
        |    underlying
        |  }
        |  lazy val customerId: Int = underlying.getCustomerId
        |  // NOTE: This method always returns the latest relationship without issuing a query
        |  def accounts = CustomerAccountList(underlying.getAccounts())
        |}
        |object Customer {
        |  def apply(underlying: JavaCustomer): Customer = {
        |    new Customer(
        |      underlying = underlying,
        |      firstName = underlying.getFirstName,
        |      lastName = underlying.getLastName,
        |      country = if (underlying.isCountryNull) None else Option(underlying.getCountry),
        |      zipCode = if (underlying.isZipCodeNull) None else Option(underlying.getZipCode).map(_.asInstanceOf[Int])
        |    )
        |  }
        |}
        |""".stripMargin

    sourceCode should equal(expectedSourceCode)
  }

  it should "generateTxList" in {
    val generator = new DefaultScalaCodeGenerator(
      mithraObjectXmlPath = "src/test/resources/reladomo/simplebank/Customer.xml",
      scalaApiPackageSuffix = "scala_api",
      scalaApiModifiableFilesOutputDir = "src/test/resources/generated/",
      scalaApiUnmodifiableFilesOutputDir = "src/test/resources/src_unmanaged/",
      futureApi = "twitter"
    )
    val sourceCode = generator.generateTxList(generator.loadMithraObject())
    val expectedSourceCode =
      """/*
        | * This file was automatically generated using folio-sec/sbt-reladomo-plugin. Please do not modify it.
        | */
        |package com.folio_sec.example.domain.simplebank.scala_api
        |
        |import com.folio_sec.reladomo.scala_api._
        |import com.folio_sec.reladomo.scala_api.exception.ReladomoException
        |import com.gs.fw.common.mithra.MithraBusinessException
        |import com.folio_sec.example.domain.simplebank.{Customer => JavaCustomer}
        |import com.folio_sec.example.domain.simplebank.{CustomerList => JavaCustomerList}
        |import scala.collection.JavaConverters._
        |
        |case class CustomerList(underlying: JavaCustomerList,
        |  override val newValueAppliers: Seq[() => Unit] = Seq.empty)
        |  extends TransactionalList[Customer, JavaCustomer] {
        |  override def toScalaObject(jObj: JavaCustomer): Customer = Customer(jObj)
        |
        |  def withCustomerId(customerId: Int) = {
        |    CustomerList(
        |      underlying = underlying,
        |      newValueAppliers = newValueAppliers :+ { () => underlying.setCustomerId(customerId) }
        |    )
        |  }
        |  def withFirstName(firstName: String) = {
        |    CustomerList(
        |      underlying = underlying,
        |      newValueAppliers = newValueAppliers :+ { () => underlying.setFirstName(firstName) }
        |    )
        |  }
        |  def withLastName(lastName: String) = {
        |    CustomerList(
        |      underlying = underlying,
        |      newValueAppliers = newValueAppliers :+ { () => underlying.setLastName(lastName) }
        |    )
        |  }
        |  def withCountry(country: Option[String]) = {
        |    CustomerList(
        |      underlying = underlying,
        |      newValueAppliers = newValueAppliers :+ { () =>
        |        underlying.setCountry(country.orNull[String])
        |      }
        |    )
        |  }
        |  def withZipCode(zipCode: Option[Int]) = {
        |    CustomerList(
        |      underlying = underlying,
        |      newValueAppliers = newValueAppliers :+ { () =>
        |        zipCode match {
        |          case Some(_zipCode) => underlying.setZipCode(_zipCode)
        |          case _ => underlying.setZipCodeNull()
        |        }
        |      }
        |    )
        |  }
        |
        |}
        |
        |case class NewCustomerList(underlying: JavaCustomerList = new JavaCustomerList(),
        |  override val newValueAppliers: Seq[() => Unit] = Seq.empty)
        |  extends NewTransactionalList[NewCustomer, JavaCustomer] {
        |  override def toScalaObject(jObj: JavaCustomer): NewCustomer = NewCustomer(
        |      firstName = jObj.getFirstName,
        |      lastName = jObj.getLastName,
        |      country = if (jObj.isCountryNull) None else Option(jObj.getCountry),
        |      zipCode = if (jObj.isZipCodeNull) None else Option(jObj.getZipCode).map(_.asInstanceOf[Int])
        |  )
        |  def withNewCustomer(newOne: NewCustomer): NewCustomerList = {
        |    underlying.add(newOne.underlying)
        |    this
        |  }
        |  def withNewCustomer(newOne: Seq[NewCustomer]): NewCustomerList = {
        |    underlying.addAll(newOne.map(_.underlying).asJava)
        |    this
        |  }
        |}
        |
        |object NewCustomerList {
        |  def apply(newOnes: Seq[NewCustomer]): NewCustomerList = {
        |    NewCustomerList().withNewCustomer(newOnes)
        |  }
        |}
        |""".stripMargin

    sourceCode should equal(expectedSourceCode)
  }

  it should "generateFinder" in {
    val generator = new DefaultScalaCodeGenerator(
      mithraObjectXmlPath = "src/test/resources/reladomo/simplebank/Customer.xml",
      scalaApiPackageSuffix = "scala_api",
      scalaApiModifiableFilesOutputDir = "src/test/resources/generated/",
      scalaApiUnmodifiableFilesOutputDir = "src/test/resources/src_unmanaged/",
      futureApi = "twitter"
    )
    val sourceCode = generator.generateFinder(generator.loadMithraObject())
    val expectedSourceCode =
      """/*
        | * This file was automatically generated using folio-sec/sbt-reladomo-plugin. Please do not modify it.
        | */
        |package com.folio_sec.example.domain.simplebank.scala_api
        |
        |import com.folio_sec.reladomo.scala_api._
        |import com.folio_sec.reladomo.scala_api.exception.ReladomoException
        |import com.gs.fw.common.mithra.MithraBusinessException
        |import com.folio_sec.example.domain.simplebank.{Customer => JavaCustomer}
        |import scala.collection.JavaConverters._
        |
        |object CustomerFinder extends CustomerFinder
        |
        |trait CustomerFinder extends TransactionalObjectFinder[Customer, CustomerList, JavaCustomer] {
        |
        |  import com.folio_sec.example.domain.simplebank.{CustomerFinder => underlying}
        |
        |  lazy val all = underlying.all()
        |  lazy val customerId = underlying.customerId()
        |  lazy val firstName = underlying.firstName()
        |  lazy val lastName = underlying.lastName()
        |  lazy val country = underlying.country()
        |  lazy val zipCode = underlying.zipCode()
        |  lazy val accounts = underlying.accounts()
        |
        |  @throws[ReladomoException]("findOne returned more than one result")
        |  def findByPrimaryKey(customerId: Int): Option[Customer] = {
        |    try { Option(underlying.findByPrimaryKey(customerId)).map(Customer(_)) }
        |    catch { case mbe: MithraBusinessException => throw new ReladomoException(mbe) }
        |  }
        |
        |  @throws[ReladomoException]("findOne returned more than one result")
        |  def findOne(operation: FinderOperation): Option[Customer] = {
        |    try { Option(underlying.findOne(operation)).map(Customer(_)) }
        |    catch { case mbe: MithraBusinessException => throw new ReladomoException(mbe) }
        |  }
        |
        |  @throws[ReladomoException]("findOne returned more than one result")
        |  def findOneBypassCache(operation: FinderOperation): Option[Customer] = {
        |    try { Option(underlying.findOneBypassCache(operation)).map(Customer(_)) }
        |    catch { case mbe: MithraBusinessException => throw new ReladomoException(mbe) }
        |  }
        |
        |  // never throws exception because #findMany just returns a DomainList object
        |  def findMany(operation: FinderOperation): ListFinder[Customer, CustomerList, JavaCustomer] = {
        |    ListFinder(CustomerList(underlying.findMany(operation)))
        |  }
        |
        |  // never throws exception because #findMany just returns a DomainList object
        |  def findManyBypassCache(operation: FinderOperation): ListFinder[Customer, CustomerList, JavaCustomer] = {
        |    ListFinder(CustomerList(underlying.findManyBypassCache(operation)))
        |  }
        |}
        |""".stripMargin

    sourceCode should equal(expectedSourceCode)
  }

  it should "generateServiceAbstract" in {
    val generator = new DefaultScalaCodeGenerator(
      mithraObjectXmlPath = "src/test/resources/reladomo/simplebank/Customer.xml",
      scalaApiPackageSuffix = "scala_api",
      scalaApiModifiableFilesOutputDir = "src/test/resources/generated/",
      scalaApiUnmodifiableFilesOutputDir = "src/test/resources/src_unmanaged/",
      futureApi = "twitter"
    )
    val sourceCode = generator.generateServiceAbstract(generator.loadMithraObject())
    val expectedSourceCode =
      """/*
        | * This file was automatically generated using folio-sec/sbt-reladomo-plugin. Please do not modify it.
        | */
        |package com.folio_sec.example.domain.simplebank.scala_api
        |
        |import com.folio_sec.reladomo.scala_api._
        |import com.folio_sec.reladomo.scala_api.service.twitter.TransactionalObjectService
        |import com.folio_sec.example.domain.simplebank.{Customer => JavaCustomer}
        |
        |trait CustomerServiceAbstract extends TransactionalObjectService[Customer, CustomerList, JavaCustomer] {
        |  override val finder: CustomerFinder = CustomerFinder
        |}
        |""".stripMargin

    sourceCode should equal(expectedSourceCode)
  }

  it should "generateService" in {
    val generator = new DefaultScalaCodeGenerator(
      mithraObjectXmlPath = "src/test/resources/reladomo/simplebank/Customer.xml",
      scalaApiPackageSuffix = "scala_api",
      scalaApiModifiableFilesOutputDir = "src/test/resources/generated/",
      scalaApiUnmodifiableFilesOutputDir = "src/test/resources/src_unmanaged/",
      futureApi = "twitter"
    )
    val sourceCode = generator.generateService(generator.loadMithraObject())
    val expectedSourceCode =
      """package com.folio_sec.example.domain.simplebank.scala_api
        |
        |object CustomerService extends CustomerService
        |
        |trait CustomerService extends CustomerServiceAbstract {
        |}
        |""".stripMargin

    sourceCode should equal(expectedSourceCode)
  }

  it should "work with AllTypes" in {
    val javaGeneraror = new DefaultJavaCodeGenerator(
      xmlFilePath = "src/test/resources/reladomo/main-kata/ReladomoClassList.xml",
      modifiableFilesOutputDir = "src/test/resources/generated/",
      unmodifiableFilesOutputDir = "src/test/resources/src_unmanaged/"
    )
    javaGeneraror.generate()

    val allTasksGenerator = new DefaultScalaCodeGenerator(
      mithraObjectXmlPath = "src/test/resources/reladomo/main-kata/AllTypes.xml",
      scalaApiPackageSuffix = "scala_api",
      scalaApiModifiableFilesOutputDir = "src/test/resources/generated/",
      scalaApiUnmodifiableFilesOutputDir = "src/test/resources/src_unmanaged/",
      futureApi = "twitter"
    )
    allTasksGenerator.generate()
    val taskGenerator = new DefaultScalaCodeGenerator(
      mithraObjectXmlPath = "src/test/resources/reladomo/main-kata/Task.xml",
      scalaApiPackageSuffix = "scala_api",
      scalaApiModifiableFilesOutputDir = "src/test/resources/generated/",
      scalaApiUnmodifiableFilesOutputDir = "src/test/resources/src_unmanaged/",
      futureApi = "twitter"
    )
    taskGenerator.generate()
  }

  it should "fix issue #3 - ParentObject generation" in {
    val generator = new DefaultScalaCodeGenerator(
      mithraObjectXmlPath = "src/test/resources/reladomo/issue003/ParentObject.xml",
      scalaApiPackageSuffix = "scala_api",
      scalaApiModifiableFilesOutputDir = "src/test/resources/generated/",
      scalaApiUnmodifiableFilesOutputDir = "src/test/resources/src_unmanaged/",
      futureApi = "twitter"
    )
    val sourceCode = generator.generateTxObject(generator.loadMithraObject())
    val expectedSourceCode =
      """/*
        | * This file was automatically generated using folio-sec/sbt-reladomo-plugin. Please do not modify it.
        | */
        |package com.folio_sec.example.domain.issue003.scala_api
        |
        |import com.folio_sec.reladomo.scala_api._
        |import com.folio_sec.reladomo.scala_api.util.TimestampUtil
        |import com.folio_sec.reladomo.scala_api.exception.ReladomoException
        |import com.gs.fw.common.mithra.MithraBusinessException
        |import com.folio_sec.example.domain.issue003.{ParentObject => JavaParentObject}
        |import com.folio_sec.example.domain.issue003.{ParentObjectList => JavaParentObjectList}
        |import scala.collection.JavaConverters._
        |
        |case class NewParentObject(name: String) extends NewTemporalTransactionalObject {
        |  override lazy val underlying: JavaParentObject = {
        |    val underlyingObj = new JavaParentObject(TimestampUtil.infinityDate())
        |    underlyingObj.setName(name)
        |    underlyingObj
        |  }
        |  def insert()(implicit tx: Transaction): ParentObject = {
        |    underlying.insert()
        |    ParentObject(underlying)
        |  }
        |  def insertForRecovery()(implicit tx: Transaction): ParentObject = {
        |    underlying.insertForRecovery()
        |    ParentObject(underlying)
        |  }
        |  def cascadeInsert()(implicit tx: Transaction): ParentObject = {
        |    underlying.cascadeInsert()
        |    ParentObject(underlying)
        |  }
        |  def id(): Option[Int] = if (underlying.isInMemoryAndNotInserted) None else Some(underlying.getId)
        |}
        |
        |case class ParentObject private (override val underlying: JavaParentObject, name: String) extends TemporalTransactionalObject {
        |  override lazy val savedUnderlying: JavaParentObject = {
        |    underlying.setName(name)
        |    underlying
        |  }
        |  lazy val id: Int = underlying.getId
        |  // NOTE: This method always returns the latest relationship without issuing a query
        |  def relatedObject(asOfDate: java.sql.Timestamp): Option[BitemporalChildObject] = Option(underlying.getRelatedObject(asOfDate)).map(BitemporalChildObject(_))
        |}
        |object ParentObject {
        |  def apply(underlying: JavaParentObject): ParentObject = {
        |    new ParentObject(
        |      underlying = underlying,
        |      name = underlying.getName
        |    )
        |  }
        |}
        |""".stripMargin

    sourceCode should equal(expectedSourceCode)
  }

  it should "fix issue #3" in {
    val generator = new DefaultScalaCodeGenerator(
      mithraObjectXmlPath = "src/test/resources/reladomo/issue003/BitemporalChildObject.xml",
      scalaApiPackageSuffix = "scala_api",
      scalaApiModifiableFilesOutputDir = "src/test/resources/generated/",
      scalaApiUnmodifiableFilesOutputDir = "src/test/resources/src_unmanaged/",
      futureApi = "twitter"
    )
    val sourceCode = generator.generateTxObject(generator.loadMithraObject())
    val expectedSourceCode =
      """/*
        | * This file was automatically generated using folio-sec/sbt-reladomo-plugin. Please do not modify it.
        | */
        |package com.folio_sec.example.domain.issue003.scala_api
        |
        |import com.folio_sec.reladomo.scala_api._
        |import com.folio_sec.reladomo.scala_api.util.TimestampUtil
        |import com.folio_sec.reladomo.scala_api.exception.ReladomoException
        |import com.gs.fw.common.mithra.MithraBusinessException
        |import com.folio_sec.example.domain.issue003.{BitemporalChildObject => JavaBitemporalChildObject}
        |import com.folio_sec.example.domain.issue003.{BitemporalChildObjectList => JavaBitemporalChildObjectList}
        |import scala.collection.JavaConverters._
        |
        |case class NewBitemporalChildObject(name: String, state: Int, parentObjectId: Int) extends NewBiTemporalTransactionalObject {
        |  override lazy val underlying: JavaBitemporalChildObject = {
        |    val underlyingObj = new JavaBitemporalChildObject(TimestampUtil.now())
        |    underlyingObj.setName(name)
        |    underlyingObj.setState(state)
        |    underlyingObj.setParentObjectId(parentObjectId)
        |    underlyingObj
        |  }
        |  def insert()(implicit tx: Transaction): BitemporalChildObject = {
        |    underlying.insert()
        |    BitemporalChildObject(underlying)
        |  }
        |  def insertForRecovery()(implicit tx: Transaction): BitemporalChildObject = {
        |    underlying.insertForRecovery()
        |    BitemporalChildObject(underlying)
        |  }
        |  def cascadeInsert()(implicit tx: Transaction): BitemporalChildObject = {
        |    underlying.cascadeInsert()
        |    BitemporalChildObject(underlying)
        |  }
        |  def id(): Option[Int] = if (underlying.isInMemoryAndNotInserted) None else Some(underlying.getId)
        |}
        |
        |case class BitemporalChildObject private (override val underlying: JavaBitemporalChildObject, name: String, state: Int, parentObjectId: Int) extends BiTemporalTransactionalObject {
        |  override lazy val savedUnderlying: JavaBitemporalChildObject = {
        |    underlying.setName(name)
        |    underlying.setState(state)
        |    underlying.setParentObjectId(parentObjectId)
        |    underlying
        |  }
        |  lazy val id: Int = underlying.getId
        |  // NOTE: This method always returns the latest relationship without issuing a query
        |  def parentObject: Option[ParentObject] = Option(underlying.getParentObject()).map(ParentObject(_))
        |}
        |object BitemporalChildObject {
        |  def apply(underlying: JavaBitemporalChildObject): BitemporalChildObject = {
        |    new BitemporalChildObject(
        |      underlying = underlying,
        |      name = underlying.getName,
        |      state = underlying.getState,
        |      parentObjectId = underlying.getParentObjectId
        |    )
        |  }
        |}
        |""".stripMargin

    sourceCode should equal(expectedSourceCode)
  }

  it should "fix issue #9 ; Support BigDecimal as javaType" in {
    val generator = new DefaultScalaCodeGenerator(
      mithraObjectXmlPath = "src/test/resources/reladomo/issue009/ObjectWithBigDecimal.xml",
      scalaApiPackageSuffix = "scala_api",
      scalaApiModifiableFilesOutputDir = "src/test/resources/generated/",
      scalaApiUnmodifiableFilesOutputDir = "src/test/resources/src_unmanaged/",
      futureApi = "twitter"
    )
    val sourceCode = generator.generateTxObject(generator.loadMithraObject())
    val expectedSourceCode =
      """/*
        | * This file was automatically generated using folio-sec/sbt-reladomo-plugin. Please do not modify it.
        | */
        |package com.folio_sec.example.domain.issue009.scala_api
        |
        |import com.folio_sec.reladomo.scala_api._
        |import com.folio_sec.reladomo.scala_api.util.TimestampUtil
        |import com.folio_sec.reladomo.scala_api.exception.ReladomoException
        |import com.gs.fw.common.mithra.MithraBusinessException
        |import com.folio_sec.example.domain.issue009.{ObjectWithBigDecimal => JavaObjectWithBigDecimal}
        |import com.folio_sec.example.domain.issue009.{ObjectWithBigDecimalList => JavaObjectWithBigDecimalList}
        |import scala.collection.JavaConverters._
        |
        |case class NewObjectWithBigDecimal(price: scala.math.BigDecimal, nullablePrice: Option[scala.math.BigDecimal]) extends NewTransactionalObject {
        |  override lazy val underlying: JavaObjectWithBigDecimal = {
        |    val underlyingObj = new JavaObjectWithBigDecimal()
        |    underlyingObj.setPrice(price.bigDecimal)
        |    underlyingObj.setNullablePrice(nullablePrice.map(_nullablePrice => _nullablePrice.bigDecimal).orNull[BigDecimal])
        |    underlyingObj
        |  }
        |  def insert()(implicit tx: Transaction): ObjectWithBigDecimal = {
        |    underlying.insert()
        |    ObjectWithBigDecimal(underlying)
        |  }
        |  def insertForRecovery()(implicit tx: Transaction): ObjectWithBigDecimal = {
        |    underlying.insertForRecovery()
        |    ObjectWithBigDecimal(underlying)
        |  }
        |  def cascadeInsert()(implicit tx: Transaction): ObjectWithBigDecimal = {
        |    underlying.cascadeInsert()
        |    ObjectWithBigDecimal(underlying)
        |  }
        |  def id(): Option[Int] = if (underlying.isInMemoryAndNotInserted) None else Some(underlying.getId)
        |}
        |
        |case class ObjectWithBigDecimal private (override val underlying: JavaObjectWithBigDecimal, price: scala.math.BigDecimal, nullablePrice: Option[scala.math.BigDecimal]) extends TransactionalObject {
        |  override lazy val savedUnderlying: JavaObjectWithBigDecimal = {
        |    underlying.setPrice(price.bigDecimal)
        |    underlying.setNullablePrice(nullablePrice.map(_nullablePrice => _nullablePrice.bigDecimal).orNull[BigDecimal])
        |    underlying
        |  }
        |  lazy val id: Int = underlying.getId
        |
        |}
        |object ObjectWithBigDecimal {
        |  def apply(underlying: JavaObjectWithBigDecimal): ObjectWithBigDecimal = {
        |    new ObjectWithBigDecimal(
        |      underlying = underlying,
        |      price = scala.math.BigDecimal(underlying.getPrice),
        |      nullablePrice = scala.math.BigDecimal(if (underlying.isNullablePriceNull) None else Option(underlying.getNullablePrice).map(scala.math.BigDecimal.apply))
        |    )
        |  }
        |}
        |""".stripMargin

    sourceCode should equal(expectedSourceCode)
  }
}
