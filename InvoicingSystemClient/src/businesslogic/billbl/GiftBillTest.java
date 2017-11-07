package businesslogic.billbl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import vo.GiftBillVO;

class GiftBillTest {

	GiftBill giftbill=new GiftBill();
	CommodityList list=new CommodityList();
	
	@Test
	void testToBillVO() {
		list.addCommodity(new CommodityLineItem(new MockCommodityVO(20), 20));
		GiftBillVO billvo=new GiftBillVO(0, "1","2", list, 2017);
		GiftBillVO actualvo=giftbill.toBillVO(list, 0, "1","2", 2017);
		assertEquals(billvo.getID(),actualvo.getID());
		//fail("Not yet implemented");
	}

}
