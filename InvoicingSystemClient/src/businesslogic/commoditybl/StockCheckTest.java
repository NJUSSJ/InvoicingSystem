package businesslogic.commoditybl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StockCheckTest {

	StockCheck s=new StockCheck(1, 2);
	@Test
	void testGetSaleNum() {
		//fail("Not yet implemented");
		assertEquals(100, s.getSaleNum());
	}

}
