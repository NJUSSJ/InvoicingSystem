package businesslogic.billbl;

import vo.MemberVO;

public class MockMemberVO extends MemberVO{

	public MockMemberVO(long id, int rank, int postCode, int category, String name, int phoneNum, String address,
			String eMail, double shouldPay, double shouldGet, double quota, long defaultOperatorID) {
		super(id, rank, postCode, category, name, phoneNum, address, eMail, shouldPay, shouldGet, quota, defaultOperatorID);
		// TODO �Զ����ɵĹ��캯�����
	}
	
}
