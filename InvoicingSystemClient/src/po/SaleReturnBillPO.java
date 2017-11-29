package po;

import java.io.Serializable;
import java.sql.Date;

import businesslogic.billbl.CommodityList;



public class SaleReturnBillPO implements Serializable{
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
	String remark;//±¸×¢
	
	public SaleReturnBillPO(String id,long userid,long memberid,CommodityList commodityList,
			double sum,int state,Date time,String remark) {
		// TODO Auto-generated constructor stub
		this.commodityList=commodityList.toString();
		this.id=id;
		this.memberid=memberid;
		this.userid=userid;
		this.sum=sum;	
		this.time=time;
		num=commodityList.getNum();
		this.state=state;
		this.remark=remark;
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
	
	public void setMember(long memberid) {
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
}
