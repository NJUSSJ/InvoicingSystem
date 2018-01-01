package businesslogic.billbl;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import Utility.DateUtil;
import runner.ClientRunner;
import vo.SaleBillVO;

public class SaleBillControllerTest {

	SaleBillController controller=new SaleBillController();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		new ClientRunner();
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testSubmitSaleBill() {
		SaleBillVO testVO=controller.findSaleBillByID("XSD-20171229-1");
		controller.deleteSaleBill(testVO);
		assertEquals(true, controller.submitSaleBill(testVO));
	}

	@Test
	public void testCheckSaleBill() {
		assertEquals(true, controller.checkSaleBill(false, "XSD-20171229-1"));
		controller.checkSaleBill(true, "XSD-20171229-1");
	}

	@Test
	public void testDeleteSaleBill() {
		SaleBillVO testVO=controller.findSaleBillByID("XSD-20171229-1");
		assertEquals(true, controller.deleteSaleBill(testVO));
		controller.submitSaleBill(testVO);
	}

	@Test
	public void testFindSaleBillByID() {
		SaleBillVO testVO=controller.findSaleBillByID("XSD-20171229-1");
		assertEquals(true, testVO!=null);
	}

	@Test
	public void testFindSaleBillByTime() {
		Date date=DateUtil.toSQL("2017", "12", "29");
		
		ArrayList<SaleBillVO> test=controller.findSaleBillByTime(date);
		
		assertEquals("XSD-20171229-1", test.get(0).getID());
	}

	@Test
	public void testFindSaleBills() {
		ArrayList<SaleBillVO> test=controller.findSaleBills();
		
		assertEquals("XSD-20171229-1", test.get(0).getID());
	}


	@Test
	public void testFindSaleBillsByInterval() {
		Date date=DateUtil.toSQL("2017", "1", "29");
		Date date2=DateUtil.toSQL("2018","12","31");
		
		ArrayList<SaleBillVO> test=controller.findSaleBillsByInterval(date, date2);
		
		assertEquals("XSD-20171229-2", test.get(0).getID());
	}

	@Test
	public void testFindSaleBillsByState() {
		ArrayList<SaleBillVO> test=controller.findSaleBillsByState(1);
		
		assertEquals("XSD-20171229-2", test.get(0).getID());
	}

	@Test
	public void testFindSaleBillsByField() {
		Date date=DateUtil.toSQL("2017", "1", "29");
		Date date2=DateUtil.toSQL("2018","12","31");
		
		ArrayList<SaleBillVO> test=controller.findSaleBillsByField(date, date2, "", "“∞÷Ì", "3");
		
		assertEquals("XSD-20171229-2", test.get(0).getID());
	}

	@Test
	public void testFindSaleBillsByUser() {
		ArrayList<SaleBillVO> test=controller.findSaleBillsByUser(3);
		
		assertEquals("XSD-20171229-1", test.get(0).getID());
	}

	

}
