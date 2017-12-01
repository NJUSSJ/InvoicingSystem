package po;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class CashBillPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	long userid;
	long accountid;
	String items;
	int state;
	Date time;
	double sum;
	public CashBillPO(String id,long userid,long accountid,String items,int state,Date time,double sum) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.accountid=accountid;
		this.userid=userid;
		this.time=time;
		this.state=state;
		this.sum=sum;
		
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
	public String getItems(){
		return items;
	}
	public int getState(){
		return state;
	}
	public Date getTime(){
		return time;
	}
	public double getSum(){
		return sum;
	}
}
