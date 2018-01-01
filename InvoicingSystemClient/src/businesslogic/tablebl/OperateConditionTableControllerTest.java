package businesslogic.tablebl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

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
		fail("Not yet implemented");
	}

	@Test
	public void testExportAsExcel() {
		fail("Not yet implemented");
	}

}
