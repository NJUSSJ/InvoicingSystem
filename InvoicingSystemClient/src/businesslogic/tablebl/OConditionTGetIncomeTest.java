package businesslogic.tablebl;

import static org.junit.Assert.*;

import org.junit.Test;

public class OConditionTGetIncomeTest {
	OperateConditionTable oct=new OperateConditionTable();
	@Test
	public void testCalculateIncome() {
		//fail("��δʵ��");
		oct.addFinanceBillItem(new MockFinanceBillItem(20));
		assertEquals(20,oct.getIncome(),0);
	}

}
