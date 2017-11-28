package businesslogic.billbl;



import static org.junit.Assert.assertEquals;

import org.junit.Test;

import vo.PricePromotionVO;

public class SaleBillTest {

	SaleBill salebill=new SaleBill();
	PricePromotionVO pricepromotion=new PricePromotionVO(20, 0.8);
	@Test
	public void testGetTotal() {
		//fail("Not yet implemented");
		salebill.addCommodityItem(new CommodityLineItem(new MockCommodityVO(20), 10));
		salebill.setPricePromotion(pricepromotion);
		double total=salebill.getTotal();
		assertEquals(160, total,1.0);
	}

}
