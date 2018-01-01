package businesslogic.logbl;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import Utility.DateUtil;
import runner.ClientRunner;
import vo.LogVO;

public class LogControllerTest {

	LogController controller=new LogController();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		new ClientRunner();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddLog() {
		Date date=DateUtil.toSQL("2018", "1", "1");
		LogVO test=new LogVO(19, date, "addAccount:89763627181346", 1);
		assertEquals(true, controller.addLog(test));
	}

	@Test
	public void testFindLogs() {
		ArrayList<LogVO> test=controller.findLogs();
		assertEquals(false, test.isEmpty());
	}

	@Test
	public void testFindLogByUserID() {
		ArrayList<LogVO> test=controller.findLogByUserID(1);
		assertEquals(false, test.isEmpty());
	}


}
