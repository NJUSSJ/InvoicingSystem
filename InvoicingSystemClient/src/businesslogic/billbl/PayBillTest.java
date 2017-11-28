package businesslogic.billbl;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Test;



public class PayBillTest {

	PayBill paybill=new PayBill("SKD", 1, 1, 100, new Date(2017));
	@Test
	public void testCheckBill() {
		//fail("Not yet implemented");
		paybill.checkBill();
		assertEquals(900, paybill.getMember().getShouldPay(),0);
	}

}
