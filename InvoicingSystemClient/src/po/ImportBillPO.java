package po;

import java.io.Serializable;
import java.sql.Date;

import businesslogic.billbl.CommodityList;



public class ImportBillPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	long userid;
	long memberid;
	String commodityList;
	double sum;
	int state;
	Date time;
	int num;
	String remark;
	
	public ImportBillPO(String id,long userid,long memberid,CommodityList list,int sum,Date time,int state) {
		// TODO Auto-generated constructor stub
		this.commodityList=list.toString();
		this.id=id;
		this.memberid=memberid;
		this.userid=userid;
		this.sum=sum;	
		this.state=state;
		this.time=time;
	}
	
	public String getID() {
		return id;
	}
	
	public long getUserID() {
		return userid;
	}
	
	public void changeUser(long userid) {
		this.userid=userid;
	}
	
	public long getMember() {
		return memberid;
	}
	
	public void changeMember(long memberid) {
		this.memberid=memberid;
	}
	
	public String getList() {
		return commodityList;
	}
	
	public double getsum() {
		return sum;
	}
	public int getnum(){
		return num;
	}
	public Date getDate() {
		return time;
	}
	public int getState() {
		return state;
	}
	
	public Date getTime() {
		return time;
	}
}
