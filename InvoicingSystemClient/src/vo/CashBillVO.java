package vo;

import java.sql.Date;
import java.util.ArrayList;

import po.CashBillPO;

/**
 * 
 * @author yrz
 * 现金费用单
 *
 */
public class CashBillVO {
	String id;
	long userid;
	long accountid;
	ArrayList<String> items;//条目：条目名+备注
	Date time;
	double sum;
	int state;
	public CashBillVO(String id,long userid,long accountid,ArrayList<String> items,Date time,int state) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.accountid=accountid;
		this.userid=userid;
		this.time=time;
		this.state=state;
	}
	
	public CashBillPO toCashBillPO(){
		return new CashBillPO(id,accountid,userid,items,state,time,sum);
	}
	
	public String getID(){
		return id;
	}
	public long getUserID(){
		return userid;
	}
	public long getAccountID(){
		return accountid;
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
	public void setAccountID(long accountid){
		this.accountid=accountid;
	}
	public void setState(int state){
		this.state=state;
	}
	public void setTime(Date time){
		this.time=time;
	}
}
