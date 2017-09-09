package example

import java.io.File
import javax.xml.bind.JAXB

import com.folio_sec.reladomo.generator.MithraObject
import org.scalatest._

class MithraObjectParserSpec extends FlatSpec with Matchers {

  it should "parse Customer.xml" in {
    val mithraObjectXmlPath = "src/test/resources/reladomo/simplebank/Customer.xml"
    val obj                 = JAXB.unmarshal(new File(mithraObjectXmlPath), classOf[MithraObject])
    obj.getPackageName should equal("com.folio_sec.example.domain.simplebank")
    obj.getClassName should equal("Customer")
    obj.getDefaultTable should equal("CUSTOMER")

    obj.getAttributes.size should equal(5)
    obj.getAttributes.get(0).getName should equal("customerId")

    obj.getRelationships.size should equal(1)
  }

}
