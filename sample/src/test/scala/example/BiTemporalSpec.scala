package example

import com.folio_sec.example.domain.bitemporal.scala_api._
import com.folio_sec.reladomo.scala_api._
import com.folio_sec.reladomo.scala_api.configuration.DatabaseManager
import com.folio_sec.reladomo.scala_api.util.TimestampUtil
import com.twitter.util.{ Await, Future }
import org.scalatest._
import unit.DatabasePreparation

class BiTemporalSpec extends FlatSpec with Matchers with DatabasePreparation {

  initializeBiTemporalDatabase()
  DatabaseManager.loadRuntimeConfig("ReladomoRuntimeConfig.xml")

  it should "have services" in {
    val productId = 1
    val newProduct = new NewProduct(
      productId = productId,
      productCode = s"prod-${productId}",
      productDescription = "This is ...",
      manufacturerId = 1,
      dailyProductionRate = 0.1F
    )
    val productsFuture: Future[ProductService.TxObjectListFinder] = {
      for {
        _        <- ProductService.insert(newProduct)
        products <- ProductService.findAll()
      } yield products
    }
    val products = Await.result(productsFuture)
    products.size should equal(1)
  }

  it should "work" in {
    val productId = 2

    TransactionProvider.withTransaction { implicit tx =>
      // insert into PRODUCT(PROD_ID,CODE,PROD_DESC,MANUFACTURER_ID,DAILY_PRODUCTION_RATE)
      // values (?,?,?,?,?) {1: 1, 2: 'prod-123', 3: 'This is ...', 4: 1, 5: 0.1};
      val product = new NewProduct(
        productId = productId,
        productCode = s"prod-${productId}",
        productDescription = "This is ...",
        manufacturerId = 1,
        dailyProductionRate = 0.1F
      )
      product.insert()

      // insert into PRODUCT_SYN(PROD_ID,SYN_TYPE,SYN_VAL)
      // values (?,?,?) {1: 1, 2: 'type1', 3: 'synonymValue~~~~~'};
      val productSynonym = new NewProductSynonym(
        productId = productId,
        synonymType = "type1",
        synonymValue = "synonymValue~~~~~"
      )
      productSynonym.insert()

      val orderId = 111

      // insert into BITEMPORAL_ORDER(ORDER_ID,ORDER_DATE,USER_ID,DESCRIPTION,STATE,TRACKING_ID,FROM_Z,THRU_Z,IN_Z,OUT_Z)
      // values (?,?,?,?,?,?,?,?,?,?)
      // {1: 111, 2: TIMESTAMP '2017-07-03 22:59:20.666', 3: 123, 4: 'This is blah, blah ...', 5: 'state?', 6: 'tr-123456',
      // 7: TIMESTAMP '2017-07-03 22:59:20.734', 8: TIMESTAMP '9999-12-01 23:59:00.0',
      // 9: TIMESTAMP '2017-07-03 22:59:20.77', 10: TIMESTAMP '9999-12-01 23:59:00.0'};
      val order = new NewBitemporalOrder(
        orderId = orderId,
        orderDate = TimestampUtil.now(),
        userId = 123,
        description = "This is blah, blah ...",
        state = "state?",
        trackingId = "tr-123456"
      )
      order.insert()

      // insert into BITEMPORAL_ORDER_ITEM(ID,ORDER_ID,PRODUCT_ID,QUANTITY,ORIGINAL_PRICE,DISCOUNT_PRICE,STATE,IN_Z,OUT_Z,FROM_Z,THRU_Z)
      // values (?,?,?,?,?,?,?,?,?,?,?) {1: 1, 2: 111, 3: 1, 4: 0.3, 5: 13.3, 6: 10.1, 7: 'state?',
      // 8: TIMESTAMP '2017-07-03 22:59:20.77', 9: TIMESTAMP '9999-12-01 23:59:00.0',
      // 10: TIMESTAMP '2017-07-03 22:59:20.797', 11: TIMESTAMP '9999-12-01 23:59:00.0'};
      val orderItem = NewBitemporalOrderItem(
        id = 1,
        orderId = orderId,
        productId = product.productId,
        quantity = 0.3D,
        originalPrice = 13.3D,
        discountPrice = 10.1D,
        state = "state?"
      )
      orderItem.insert()

      val maybeOrderItem: Option[BitemporalOrderItem] = {
        // select t0.ID,t0.ORDER_ID,t0.PRODUCT_ID,t0.QUANTITY,t0.ORIGINAL_PRICE,t0.DISCOUNT_PRICE,t0.STATE,t0.IN_Z,t0.OUT_Z,t0.FROM_Z,t0.THRU_Z
        // from BITEMPORAL_ORDER_ITEM t0
        // where  t0.ORDER_ID = ? and t0.OUT_Z = ? and t0.FROM_Z <= ? and t0.THRU_Z > ?
        // {1: 111, 2: TIMESTAMP '9999-12-01 23:59:00.0',
        //  3: TIMESTAMP '2017-07-04 22:28:04.784', 4: TIMESTAMP '2017-07-04 22:28:04.784'};
        BitemporalOrderItemFinder.findOneWith { q =>
          q.orderId.eq(orderId) && q.businessDate.eq(TimestampUtil.now())
        }
      }
      maybeOrderItem match {
        case Some(existingOrderItem) =>
          // update BITEMPORAL_ORDER_ITEM set THRU_Z = ?  where ID = ? AND THRU_Z = ? AND OUT_Z = ?
          // {1: TIMESTAMP '2017-07-03 22:59:20.807', 2: 1, 3: TIMESTAMP '9999-12-01 23:59:00.0', 4: TIMESTAMP '9999-12-01 23:59:00.0'};

          // insert into BITEMPORAL_ORDER_ITEM(ID,ORDER_ID,PRODUCT_ID,QUANTITY,ORIGINAL_PRICE,DISCOUNT_PRICE,STATE,IN_Z,OUT_Z,FROM_Z,THRU_Z)
          // values (?,?,?,?,?,?,?,?,?,?,?)
          // {1: 1, 2: 111, 3: 1, 4: 0.3, 5: 13.3, 6: 10.1, 7: 'shipping',
          // 8: TIMESTAMP '2017-07-03 22:59:20.77', 9: TIMESTAMP '9999-12-01 23:59:00.0',
          // 10: TIMESTAMP '2017-07-03 22:59:20.807', 11: TIMESTAMP '9999-12-01 23:59:00.0'};
          existingOrderItem.copy(state = "shipping").update()
        case _ =>
      }
    }
  }

}
