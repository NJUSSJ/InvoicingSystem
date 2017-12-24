package businesslogic.billbl;

import java.sql.Date;

import org.junit.Test;

import vo.PayBillVO;



public class PayBillTest {

	PayBillVO paybill=new PayBillVO( null, 0, 0, null, 0, new Date(2017), 0);
	@Test
	public void testCheckBill() {
		//fail("Not yet implemented");
		//paybill.checkBill();
		//assertEquals(900, paybill.getMember().getShouldPay(),0);
	}

}
