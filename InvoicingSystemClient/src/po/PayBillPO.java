package po;

import java.io.Serializable;
import java.sql.Date;

import businesslogic.billbl.AccountList;

public class PayBillPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	long userid;
	long memberid;
	String accountList;
	double sum;
	Date time;
	int state;
	
	public PayBillPO(String id ,long userid,long memberid,
			AccountList accountList,double sum,Date time,int state) {
		this.id=id;
		this.sum=sum;
		this.memberid=memberid;
		this.userid=userid;
		this.time=time;
		this.state=state;
		this.accountList=accountList.toString();
		this.sum=accountList.getSum();
	}
	public int getState(){
		return state;
	}
	public String getID() {
		return id;
	}
	public double getSum() {
		return sum;
	}
	public String getAccountList(){
		return accountList;
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
	
	public void setState(int state) {
		this.state=state;
	}
	
	public long getUserID(){
		return userid;
	}
	public Date getTime(){
		return time;
	}
	
}
