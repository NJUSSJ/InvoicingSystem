package businesslogic.billbl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import vo.PricePromotionVO;

class SaleBillTest {

	SaleBill salebill=new SaleBill();
	PricePromotionVO pricepromotion=new PricePromotionVO(20, 0.8);
	@Test
	void testGetTotal() {
		//fail("Not yet implemented");
		salebill.addCommodityItem(new CommodityLineItem(new MockCommodityVO(20), 10));
		salebill.setPricePromotion(pricepromotion);
		double total=salebill.getTotal();
		assertEquals(160, total);
	}

}
