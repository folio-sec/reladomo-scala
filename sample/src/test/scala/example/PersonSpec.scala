package example

import com.folio_sec.example.domain.people.scala_api._
import com.folio_sec.reladomo.scala_api._
import TransactionProvider.withTransaction
import com.folio_sec.reladomo.scala_api.configuration.DatabaseManager
import org.scalatest._
import unit.DatabasePreparation

class PersonSpec extends FlatSpec with Matchers with DatabasePreparation {

  initializePeopleDatabase()
  DatabaseManager.loadRuntimeConfig("ReladomoRuntimeConfig.xml")

  it should "have operations which support relations" in {
    withTransaction { implicit tx =>
      val taro = NewPerson(firstName = "Taro", lastName = "Yamada", country = "JAPAN").insert()
      val jiro = NewPerson(firstName = "Jiro", lastName = "Shirato", country = "JAPAN").insert()
      val john = NewPerson(firstName = "John", lastName = "Legend", country = "US").insert()

      Set("Pochi", "Shiro").foreach(name => NewPet(name = name, ownerId = taro.personId).insert())
      Set("Ichi", "Nii", "San").foreach(name => NewPet(name = name, ownerId = jiro.personId).insert())
      NewPet(name = "Charley", ownerId = john.personId).insert()
    }

    val taroPets = PetFinder.findManyWith(_.owner.firstName.eq("Taro")).limit(10)
    taroPets.size should equal(2)

    val asianPeople = PersonFinder.findManyWith(_.country.in(Set("JAPAN", "CHINA")))
    asianPeople.map(_.firstName) should equal(Seq("Taro", "Jiro"))

    PersonFinder.findManyWith(_.pets.owner.firstName.in(Set("Taro", "Jiro"))).size should equal(2)
  }

}
