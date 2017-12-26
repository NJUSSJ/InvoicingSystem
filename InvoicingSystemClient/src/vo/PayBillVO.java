package vo;

import java.sql.Date;

import businesslogic.billbl.AccountList;
import po.PayBillPO;

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
	public PayBillPO toPayBillPO(){
		return new PayBillPO(id,userid,memberid,accountList.toString(),sum,time,state);
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
	public AccountList getAccountList(){
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
	public void setUserID(long userid){
		this.userid=userid;
	}
	public void setMemberID(long memberid) {
		this.memberid=memberid;
	}
	public void setSum() {
		this.sum=accountList.getSum();
	}
	public void setTime(Date time){
		this.time=time;
	}
	public void setState(int state) {
		this.state=state;
	}
	
	
}
