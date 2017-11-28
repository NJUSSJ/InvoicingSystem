package po;

import java.io.Serializable;

public class PayBillPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	long userid;
	long memberid;
	double sum;
	int time;
	boolean state=false;
	
	
	public PayBillPO() {
		// TODO Auto-generated constructor stub
	}
	public PayBillPO(String id ,long userid,long memberid,int sum,int time) {
		this.id=id;
		this.sum=sum;
		this.memberid=memberid;
		this.userid=userid;
		this.time=time;
	}
	
	public String getID() {
		return id;
	}
	public double getSum() {
		return sum;
	}
	
	public void setSum(double sum) {
		this.sum=sum;
	}
	
	public long getMemberID() {
		return memberid;
	}
	
	public void setMemberID(long memberid) {
		this.memberid=memberid;
	}
	
	public void setState(Boolean state) {
		this.state=state;
	}
	
	
}

