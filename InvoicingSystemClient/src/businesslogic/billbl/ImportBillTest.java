package businesslogic.billbl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class ImportBillTest {

	ImportBill importbill=new ImportBill(1, "", "");
	@Test
	void testGetTotal() {
		//fail("Not yet implemented");
		importbill.addCommodityItem(new CommodityLineItem(new MockCommodityVO(10), 20));
		importbill.addCommodityItem(new CommodityLineItem(new MockCommodityVO(20), 20));
		assertEquals(600, importbill.getTotal());
	}

}
