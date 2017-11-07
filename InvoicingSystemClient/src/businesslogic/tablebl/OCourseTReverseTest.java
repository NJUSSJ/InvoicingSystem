package businesslogic.tablebl;

import static org.junit.Assert.*;

import org.junit.Test;

public class OCourseTReverseTest {
	OperateCourseTable oct=new OperateCourseTable();
	@Test
	public void test() {
		//fail("ипн╢й╣ож");
		MockFinanceBillItem temp=(MockFinanceBillItem)oct.reverseBillItem(new MockFinanceBillItem(20));
		assertEquals(-20,temp.getMoney(),0);
	}

}
