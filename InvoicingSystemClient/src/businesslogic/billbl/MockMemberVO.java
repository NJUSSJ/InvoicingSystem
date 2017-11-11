package businesslogic.billbl;

import vo.MemberVO;

public class MockMemberVO extends MemberVO{
	String name;
	double should_pay;
	
	public MockMemberVO(String name,double should_pay) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.should_pay=should_pay;
	}
	
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
