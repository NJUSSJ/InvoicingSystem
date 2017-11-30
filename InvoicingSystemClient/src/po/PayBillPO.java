package po;

import java.io.Serializable;
import java.sql.Date;

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
			String accountList,double sum,Date time,int state) {
		this.id=id;
		this.sum=sum;
		this.memberid=memberid;
		this.userid=userid;
		this.time=time;
		this.state=state;
		this.accountList=accountList;
		this.sum=sum;
	}
	public String getID() {
		return id;
	}
	public long getUserID(){
		return userid;
	}
	public long getMemberID() {
		return memberid;
	}
	public String getAccountList(){
		return accountList;
	}
	public double getSum() {
		return sum;
	}
	public Date getTime(){
		return time;
	}
	public int getState(){
		return state;
	}
	
}
