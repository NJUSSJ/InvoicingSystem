package businesslogic.billbl;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class PayBillTest {

	PayBill paybill=new PayBill(1, "1", "1", 100, 2017);
	@Test
	void testCheckBill() {
		//fail("Not yet implemented");
		paybill.checkBill();
		assertEquals(900, paybill.getMember().should_pay,0);
	}

}