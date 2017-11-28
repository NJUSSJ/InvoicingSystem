package businesslogic.billbl;

import vo.PayBillVO;

public class MockPayBillVO extends PayBillVO {
	
	String id;
	long  user;
	long member;
	double  sum;
	int time;
	Boolean state=false;
	public MockPayBillVO(long member,double sum) {
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
	
	public long getMember() {
		return member;
	}
	
	public void setMember(long member) {
		this.member=member;
	}
	
	public void setState(Boolean state) {
		this.state=state;
	}
}
