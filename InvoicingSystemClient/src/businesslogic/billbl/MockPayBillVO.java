package businesslogic.billbl;

import vo.PayBillVO;

public class MockPayBillVO extends PayBillVO {
	
	long id;
	String  user;
	String member;
	double  sum;
	int time;
	Boolean state=false;
	public MockPayBillVO(String member,double sum) {
		// TODO Auto-generated constructor stub
		this.member=member;
		this.sum=sum;
	}
	
	public double getSum() {
		return sum;
	}
	
	public void setSum(double sum) {
		this.sum=sum;
	}
	
	public String getMember() {
		return member;
	}
	
	public void setMember(String member) {
		this.member=member;
	}
	
	public void setState(Boolean state) {
		this.state=state;
	}
}
