package businesslogic.billbl;

import java.sql.Date;

import vo.PayBillVO;

public class MockPayBillVO extends PayBillVO {

	public MockPayBillVO(String id, long userid, long memberid, AccountList accountList, double sum, Date time,
			int state) {
		super(id, userid, memberid, accountList, sum, time, state);
		// TODO �Զ����ɵĹ��캯�����
	}
	
	
}
