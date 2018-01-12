package businesslogic.tablebl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import Utility.DateUtil;
import runner.ClientRunner;

public class OperateConditionTableControllerTest {
	OperateConditionTableController controller=new OperateConditionTableController();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		new ClientRunner();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindByInterval() {
		java.sql.Date begin=DateUtil.toSQL("2017", "2", "1");
		java.sql.Date end=DateUtil.toSQL("2018", "1", "2");
        assertEquals(-6923,controller.findByInterval(begin, end).getProfit(),0.1);
	}
}
