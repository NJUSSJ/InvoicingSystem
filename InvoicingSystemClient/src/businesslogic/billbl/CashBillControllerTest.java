package businesslogic.billbl;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import Utility.DateUtil;
import runner.ClientRunner;
import vo.CashBillVO;

public class CashBillControllerTest {

	CashBillController controller=new CashBillController();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		new ClientRunner();
	}

	@After
	public void tearDown() throws Exception {
	}

	

	@Test
	public void testSubmitCashBill() {
		CashBillVO testVO=controller.findCashBillByID("XJFYD-20171229-4");
		controller.deleteCashBill(testVO);
		assertEquals(true, controller.submitCashBill(testVO));
	}

	@Test
	public void testCheckCashBill() {
		boolean ifSuccess=controller.checkCashBill(false, "XJFYD-20171229-4");
		assertEquals(true, ifSuccess);
		controller.checkCashBill(true, "XJFYD-20171229-4");
	}

	@Test
	public void testDeleteCashBill() {
		CashBillVO testVO=controller.findCashBillByID("XJFYD-20171229-4");
		assertEquals(true,controller.deleteCashBill(testVO));
		controller.submitCashBill(testVO);
	}

	@Test
	public void testFindCashBills() {
		ArrayList<CashBillVO> test=controller.findCashBills();
		assertEquals(test.get(0).getID(), "XJFYD-20171229-4");
	}

	@Test
	public void testFindCashBillByTime() {
		Date date=DateUtil.toSQL("2017", "12", "29");
		
		ArrayList<CashBillVO> test=controller.findCashBillByTime(date);
		
		assertEquals(test.get(0).getID(), "XJFYD-20171229-4");
	}

	@Test
	public void testFindCashBillsByInterval() {
		
		java.sql.Date sqlDate1=DateUtil.toSQL("2017", "1", "1");
		java.sql.Date sqlDate2=DateUtil.toSQL("2017", "12", "31");
		
		ArrayList<CashBillVO> test=controller.findCashBillsByInterval(sqlDate1, sqlDate2);
		
		assertEquals(test.get(0).getID(), "XJFYD-20171229-4");
	}

	@Test
	public void testFindCashBillsByField() {
		java.sql.Date sqlDate1=DateUtil.toSQL("2017", "1", "1");
		java.sql.Date sqlDate2=DateUtil.toSQL("2017", "12", "31");
		ArrayList<CashBillVO> test=controller.findCashBillsByField(sqlDate1, sqlDate2, "2");
		assertEquals(test.get(0).getID(), "XJFYD-20171229-4");
		
	}

	@Test
	public void testFindCashBillsByState() {
		ArrayList<CashBillVO> test=controller.findCashBillsByState(1);
		assertEquals(test.get(0).getID(), "XJFYD-20171229-4");
	}

	@Test
	public void testFindCashBillsByUser() {
		ArrayList<CashBillVO> test=controller.findCashBillsByUser(Long.parseLong("8"));
		assertEquals(test.get(0).getID(), "XJFYD-20171229-4");
	}

	@Test
	public void testFindCashBillByID() {
		fail("Not yet implemented");
	}

	@Test
	public void testFakeDelete() {
		fail("Not yet implemented");
	}

}
