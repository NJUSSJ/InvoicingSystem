package businesslogic.billbl;

import vo.MemberVO;

public class MockMemberVO extends MemberVO{
	public MockMemberVO(long id, int rank, int postCode, int category, String name, String phoneNum, String address,
			String eMail, double shouldPay, double shouldGet, double quota, long defaultOperatorID) {
		super(id, rank, postCode, category, name, phoneNum, address, eMail, shouldPay, shouldGet, quota, defaultOperatorID);
		// TODO 自动生成的构造函数存根
	}

	String name;
	double should_pay;
	long id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	public double getShouldPay() {
		return should_pay;
	}
	
	public void setShouldPay(double shouldPay) {
		this.should_pay=shouldPay;
	}
}
