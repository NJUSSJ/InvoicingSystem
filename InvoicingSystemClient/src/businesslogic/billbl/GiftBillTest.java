package businesslogic.billbl;




import static org.junit.Assert.assertEquals;

import org.junit.Test;

import vo.GiftBillVO;

public class GiftBillTest {

	GiftBill giftbill=new GiftBill();
	CommodityList list=new CommodityList();
	
	@Test
	public void testToBillVO() {
		list.addCommodity(new CommodityLineItem(new MockCommodityVO(20), 20));
		GiftBillVO billvo=new GiftBillVO(0, "1","2", list, 2017);
		GiftBillVO actualvo=giftbill.toBillVO(list, 0, "1","2", 2017);
		assertEquals(billvo.getID(),actualvo.getID());
		//fail("Not yet implemented");
	}

}
