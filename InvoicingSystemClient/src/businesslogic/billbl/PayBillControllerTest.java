package businesslogic.billbl;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import Utility.DateUtil;
import runner.ClientRunner;
import vo.LossBillVO;
import vo.PayBillVO;

public class PayBillControllerTest {

	PayBillController controller=new PayBillController();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		new ClientRunner();
	}

	@After
	public void tearDown() throws Exception {
	}

	

	@Test
	public void testSubmitPayBill() {
		PayBillVO testVO=controller.findPayBillByID("FKD-20171229-1");
		controller.deletePayBill(testVO);
		assertEquals(true, controller.submitPayBill(testVO));
	}

	@Test
	public void testCheckPayBill() {
		assertEquals(true, controller.checkPayBill(false, "FKD-20171229-1"));
		controller.checkPayBill(true, "FKD-20171229-1");
	}

	@Test
	public void testDeletePayBill() {
		PayBillVO testVO=controller.findPayBillByID("FKD-20171229-1");
		controller.deletePayBill(testVO);
		assertEquals(true, controller.submitPayBill(testVO));
	}

	@Test
	public void testFindPayBillByID() {
		PayBillVO testVO=controller.findPayBillByID("FKD-20171229-1");
		assertEquals(3000, testVO.getSum(),0.1);
	}

	@Test
	public void testFindPayBillByTime() {
		Date date=DateUtil.toSQL("2017", "12", "29");
		
		ArrayList<PayBillVO> test=controller.findPayBillByTime(date);
		assertEquals("FKD-20171229-1", test.get(0).getID());
	}

	@Test
	public void testFindPayBills() {
		ArrayList<PayBillVO> test=controller.findPayBills();
		assertEquals("FKD-20171229-1", test.get(0).getID());
	}

	@Test
	public void testFindPayBillsByInterval() {
		Date date=DateUtil.toSQL("2017", "1", "1");
		Date date2=DateUtil.toSQL("2018", "12", "31");
		ArrayList<PayBillVO> test=controller.findPayBillsByInterval(date, date2);
		assertEquals("FKD-20171229-1", test.get(0).getID());
	}

	@Test
	public void testFindPayBillsByField() {
		Date date=DateUtil.toSQL("2017", "1", "1");
		Date date2=DateUtil.toSQL("2018", "12", "31");
		ArrayList<PayBillVO> test=controller.findPayBillsByField(date, date2, "Ê¯Ê¤½Ü", "2");
		assertEquals("FKD-20171229-1", test.get(0).getID());
	}

	@Test
	public void testFindPayBillsByState() {
		ArrayList<PayBillVO> test=controller.findPayBillsByState(1);
		assertEquals("FKD-20171229-1", test.get(0).getID());
	}

	@Test
	public void testFindPayBillsByUser() {
		ArrayList<PayBillVO> test=controller.findPayBillsByUser(8);
		assertEquals("FKD-20171229-1", test.get(0).getID());
	}

	

}
