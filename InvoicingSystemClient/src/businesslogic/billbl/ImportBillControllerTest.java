package businesslogic.billbl;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import Utility.DateUtil;
import runner.ClientRunner;
import vo.ImportBillVO;

public class ImportBillControllerTest {

	ImportBillController controller=new ImportBillController();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		new ClientRunner();
		
	}

	@After
	public void tearDown() throws Exception {
	}



	@Test
	public void testSubmitImportBill() {
		ImportBillVO test=controller.findImportBillByID("JHD-20180101-1");
		controller.deleteImportBill(test);
		assertEquals(true, controller.submitImportBill(test));
	}

	@Test
	public void testCheckImportBill() {
		assertEquals(true, controller.checkImportBill(false, "JHD-20180101-1"));
		controller.checkImportBill(true, "JHD-20180101-1");
	}

	@Test
	public void testDeleteImportBill() {
		ImportBillVO test=controller.findImportBillByID("JHD-20180101-1");
		assertEquals(true, controller.deleteImportBill(test));
		controller.submitImportBill(test);
	}

	@Test
	public void testFindImportBillByID() {
		ImportBillVO test=controller.findImportBillByID("JHD-20180101-1");
		assertEquals(test.getSum(),300,0.1);
	}

	@Test
	public void testFindImportBillByTime() {
		Date date=DateUtil.toSQL("2018","1","1");
		assertEquals("JHD-20180101-1", controller.findImportBillByTime(date).get(0).getID());
	}

	@Test
	public void testFindImportBills() {
		ArrayList<ImportBillVO> test=controller.findImportBills();
		assertEquals("JHD-20180101-1", test.get(0).getID());
	}

	@Test
	public void testFindImportBillsByInterval() {
		Date date1=DateUtil.toSQL("2017","1","1");
		Date date2=DateUtil.toSQL("2018", "1", "10");
		
		ArrayList<ImportBillVO> test=controller.findImportBillsByInterval(date1, date2);
		assertEquals("JHD-20180101-1", test.get(0).getID());
	}

	@Test
	public void testFindImportBillsByField() {
		Date date1=DateUtil.toSQL("2017","1","1");
		Date date2=DateUtil.toSQL("2018", "1", "10");
		ArrayList<ImportBillVO> test=controller.findImportBillsByField(date1, date2, "Ê¯Ê¤½Ü", "3");
		assertEquals(false, test.isEmpty());
	}

	@Test
	public void testFindImportBillsByState() {
		ArrayList<ImportBillVO> test=controller.findImportBillsByState(1);
		assertEquals("JHD-20180101-1", test.get(0).getID());
	}

	@Test
	public void testFindImportBillsByUser() {
		ArrayList<ImportBillVO> test=controller.findImportBillsByUser(3);
		assertEquals("JHD-20180101-1", test.get(0).getID());
	}

	@Test
	public void testFakeDelete() {
		assertEquals(true, controller.fakeDelete("JHD-20180101-1"));
		controller.checkImportBill(true, "JHD-20180101-1");
	}

}
