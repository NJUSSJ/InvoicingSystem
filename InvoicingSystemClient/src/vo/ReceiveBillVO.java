package vo;

import java.sql.Date;

import businesslogic.billbl.AccountList;
import po.ReceiveBillPO;

/**
 * 
 * @author yrz
 *	�տ
 */
public class ReceiveBillVO {
	String id;
	long userid;
	long memberid;
	AccountList accountList;
	double sum;
	Date time;
	int state;
	
	public ReceiveBillVO(String id ,long userid,long memberid,
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
	public ReceiveBillPO toReceiveBillPO(){
		return new ReceiveBillPO(id,userid,memberid,accountList.toString(),sum,time,state);
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
		return accountList.getSum();
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
	public void setSum() {
		this.sum=accountList.getSum();
	}
	public void setMemberID(long memberid) {
		this.memberid=memberid;
	}
	public void setTime(Date time){
		this.time=time;
	}
	public void setState(int state) {
		this.state=state;
	}
	
	
}
