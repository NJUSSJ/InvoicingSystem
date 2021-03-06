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
public class CashBillVO{
	String id;
	long userid;
	long accountid;
	ArrayList<String> items;//条目：条目名+,金额,+备注
	Date time;
    double sum;
	int state;
	String comment;
	public CashBillVO(String id,long userid,long accountid,ArrayList<String> items,Date time,int state) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.accountid=accountid;
		this.userid=userid;
		this.time=time;
		this.state=state;
		this.items=items;
		sum=0;
		for(int i=0;i<items.size();i++){
			String[] temp=items.get(i).split(",");
			sum+=Double.parseDouble(temp[1]);
		}
	}
	
	public CashBillPO toCashBillPO(){
		String temp="";
		for(int i=0;i<items.size();i++){
			temp+=items.get(i);
			if(i!=items.size()-1){
				temp+=" ";
			}
		}
		return new CashBillPO(id,userid,accountid,temp,state,time,sum);
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
	public double getSum(){
		return sum;
	}
	public int getState(){
		return state;
	}
	
	/**
	 * 
	 * @return 条目名："条目名,金额,备注"
	 */
	public ArrayList<String> getAccountList(){
		return items;
	}
	public void setUserID(long userid){
		this.userid=userid;
	}
	public void setMemberID(long accountid){
		this.accountid=accountid;
	}
	public void setState(int state){
		this.state=state;
	}
	public void setTime(Date time){
		this.time=time;
	}
}
