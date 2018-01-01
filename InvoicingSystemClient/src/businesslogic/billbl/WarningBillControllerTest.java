package businesslogic.billbl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import runner.ClientRunner;
import vo.WarningBillVO;

public class WarningBillControllerTest {

	WarningBillController controller=new WarningBillController();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		new ClientRunner();
	}

	@After
	public void tearDown() throws Exception {
	}

	

	@Test
	public void testSubmitWarningBill() {
		WarningBillVO testVO=controller.findWarningBillByID(Long.parseLong("20171229134402"));
		controller.deleteWarningBill(testVO);
		assertEquals(true, controller.submitWarningBill(testVO));
	}

	@Test
	public void testCheckWarningBill() {
		assertEquals(true, controller.checkWarningBill(true, Long.parseLong("20171229134402")));
	}

	@Test
	public void testDeleteWarningBill() {
		WarningBillVO testVO=controller.findWarningBillByID(Long.parseLong("20171229134402"));
		assertEquals(true, controller.deleteWarningBill(testVO));
		controller.submitWarningBill(testVO);
	}

	@Test
	public void testFindWarningBillByID() {
		WarningBillVO testVO=controller.findWarningBillByID(Long.parseLong("20171229134402"));
		assertEquals(true, testVO!=null);
	}


	@Test
	public void testFindWarningBillsByState() {
		ArrayList<WarningBillVO> test=controller.findWarningBillsByState(1);
		assertEquals(Long.parseLong("20171229134402"), test.get(0).getID());
	}



}
