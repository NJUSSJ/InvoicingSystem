package businesslogic.billbl;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import Utility.DateUtil;
import runner.ClientRunner;
import vo.GiftBillVO;

public class GiftBillControllerTest {

	GiftBillController controller=new GiftBillController();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		new ClientRunner();
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testSubmitGiftBill() {
		GiftBillVO test=controller.findGiftBillByID(Long.parseLong("20180101201941"));
		controller.deleteGiftBill(test);
		assertEquals(true, controller.submitGiftBill(test));
	}

	@Test
	public void testCheckGiftBill() {
		assertEquals(true, controller.checkGiftBill(false, Long.parseLong("20180101201941")));
		controller.checkGiftBill(true, Long.parseLong("20180101201941"));
	}

	@Test
	public void testDeleteGiftBill() {
		GiftBillVO test=controller.findGiftBillByID(Long.parseLong("20180101201941"));
		assertEquals(true, controller.deleteGiftBill(test));
		controller.submitGiftBill(test);
	}

	@Test
	public void testFindGiftBillByTime() {
		Date date=DateUtil.toSQL("2018", "1", "1");
		ArrayList<GiftBillVO> test=controller.findGiftBillByTime(date);
		assertEquals(test.get(0).getID(), Long.parseLong("20180101201941"));
	}

	@Test
	public void testFindGiftBills() {
		ArrayList<GiftBillVO> test=controller.findGiftBills();
		assertEquals(test.get(0).getID(), Long.parseLong("20180101201941"));
	}

	@Test
	public void testFindGiftBillsByInterval() {
		Date date=DateUtil.toSQL("2017", "1", "1");
		Date date2=DateUtil.toSQL("2018","12","31");
		ArrayList<GiftBillVO> test=controller.findGiftBillsByInterval(date, date2);
		assertEquals(test.get(0).getID(), Long.parseLong("20180101201941"));
	}

	@Test
	public void testFindGiftBillsByField() {
		Date date=DateUtil.toSQL("2017", "1", "1");
		Date date2=DateUtil.toSQL("2018","12","31");
		ArrayList<GiftBillVO> test=controller.findGiftBillsByField(date, date2, "“∞÷Ì", "4");
		assertEquals(false,test.isEmpty());
	}

	@Test
	public void testFindGiftBillsByState() {
		ArrayList<GiftBillVO> test=controller.findGiftBillsByState(1);
		assertEquals(test.get(0).getID(), Long.parseLong("20180101201941"));
	}

	@Test
	public void testFindGiftBillsByUser() {
		ArrayList<GiftBillVO> test=controller.findGiftBillsByUser(4);
		assertEquals(test.get(0).getID(), Long.parseLong("20180101201941"));
	}

	@Test
	public void testFindGiftBillByID() {
		GiftBillVO test=controller.findGiftBillByID(Long.parseLong("20180101201941"));
		assertEquals(test.getState(), 1);
	}

	@Test
	public void testFakeDelete() {
		boolean ifSuccess=controller.fakeDelete(Long.parseLong("20180101201941"));
		assertEquals(true, ifSuccess);
		controller.checkGiftBill(true, Long.parseLong("20180101201941"));
		
	}

}
