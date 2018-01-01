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

public class LossBillControllerTest {

	LossBillController controller=new LossBillController();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		new ClientRunner();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSubmitLossBill() {
		LossBillVO testVO=controller.findLossBillByID(Long.parseLong("20180101101206"));
		controller.deleteLossBill(testVO);
		assertEquals(true, controller.submitLossBill(testVO));
	}

	@Test
	public void testCheckLossBill() {
		assertEquals(true, controller.checkLossBill(false, Long.parseLong("20180101101206")));
		controller.checkLossBill(true, Long.parseLong("20180101101206"));
	}

	@Test
	public void testDeleteLossBill() {
		LossBillVO testVO=controller.findLossBillByID(Long.parseLong("20180101101206"));
		assertEquals(true, controller.deleteLossBill(testVO));
		controller.submitLossBill(testVO);
	}

	@Test
	public void testFindLossBillByID() {
		LossBillVO testVO=controller.findLossBillByID(Long.parseLong("20180101101206"));
		assertEquals(450,testVO.getSum(),0.1);
	}

	@Test
	public void testFindLossBillByTime() {
		Date date=DateUtil.toSQL("2018", "1", "1");
		ArrayList<LossBillVO> test=controller.findLossBillByTime(date);
		assertEquals(Long.parseLong("20180101101206"), test.get(0).getID());
	}

	@Test
	public void testFindLossBills() {
		ArrayList<LossBillVO> test=controller.findLossBills();
		assertEquals(Long.parseLong("20180101101206"), test.get(0).getID());
	}

	@Test
	public void testFindLossBillsByInterval() {
		Date date=DateUtil.toSQL("2017", "1", "1");
		Date date2=DateUtil.toSQL("2018", "12", "31");
		ArrayList<LossBillVO> test=controller.findLossBillsByInterval(date, date2);
		assertEquals(Long.parseLong("20180101101206"), test.get(0).getID());
	}

	@Test
	public void testFindLossBillsByField() {
		Date date=DateUtil.toSQL("2017", "1", "1");
		Date date2=DateUtil.toSQL("2018", "12", "31");
		ArrayList<LossBillVO> test=controller.findLossBillsByField(date, date2, "");
		assertEquals(Long.parseLong("20180101101206"), test.get(0).getID());
	}

	@Test
	public void testFindLossBillsByState() {
		ArrayList<LossBillVO> test=controller.findLossBillsByState(1);
		assertEquals(Long.parseLong("20180101101206"), test.get(0).getID());
	}

	@Test
	public void testFindLossBillsByUser() {
		ArrayList<LossBillVO> test=controller.findLossBillsByUser(4);
		assertEquals(Long.parseLong("20180101101206"), test.get(0).getID());
	}

	@Test
	public void testFakeDelete() {
		assertEquals(true, controller.fakeDelete(Long.parseLong("20180101101206")));
		controller.checkLossBill(true, Long.parseLong("20180101101206"));
	}

}
