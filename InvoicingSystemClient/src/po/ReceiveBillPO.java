package po;

import java.sql.Date;

public class ReceiveBillPO {
	String id;
	long userid;
	long memberid;
	String accountList;
	double sum;
	Date time;
	int state;
	
	public ReceiveBillPO(String id ,long userid,long memberid,
			String accountList,double sum,Date time,int state) {
		this.id=id;
		this.sum=sum;
		this.memberid=memberid;
		this.userid=userid;
		this.time=time;
		this.state=state;
		this.accountList=accountList.toString();
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
