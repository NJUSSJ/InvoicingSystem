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
	public CashBillPO(String id,long userid,long accountid,ArrayList<String> items,int state,Date time,double sum) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.accountid=accountid;
		this.userid=userid;
		this.time=time;
		this.state=state;
		this.sum=sum;
		for(int i=0;i<items.size();i++){
			this.items+=items.get(i);
			if(i!=items.size()-1){
				this.items+=" ";
			}
		}
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
	public String getItems(){
		return items;
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
