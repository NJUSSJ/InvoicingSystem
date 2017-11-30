package vo;

import java.sql.Date;

import businesslogic.billbl.AccountList;

/**
 * 
 * @author yrz
 *	¸¶¿îµ¥
 */
public class PayBillVO {
	String id;
	long userid;
	long memberid;
	AccountList accountList;
	double sum;
	Date time;
	int state;
	
	public PayBillVO(String id ,long userid,long memberid,
			AccountList accountList,double sum,Date time,int state) {
		this.id=id;
		this.sum=sum;
		this.memberid=memberid;
		this.userid=userid;
		this.time=time;
		this.state=state;
		this.accountList=accountList;
		this.sum=accountList.getSum();
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
