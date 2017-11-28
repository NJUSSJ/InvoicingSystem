package vo;

import java.sql.Date;

import businesslogic.billbl.CommodityList;

/**
 * 
 * @author yrz
 *
 */
public class SaleReturnBillVO {
	String id;
	long userid;
	long memberid;
	CommodityList commodityList;
	int sum;
	Date time;
	int num;
	boolean state=false;
	
	public SaleReturnBillVO(String id,long userid,long memberid,CommodityList list,int sum,Date time) {
		// TODO Auto-generated constructor stub
		this.commodityList=list;
		this.id=id;
		this.memberid=memberid;
		this.userid=userid;
		this.sum=sum;	
		num=this.commodityList.getNum();
	}
	
	public String getID() {
		return id;
	}
	
	public long getUserID() {
		return userid;
	}
	
	public void setUserID(long userid) {
		this.userid=userid;
	}
	
	public long getMemberID() {
		return memberid;
	}
	
	public void setMemberID(long memberid) {
		this.memberid=memberid;
	}
	
	public CommodityList getList() {
		return commodityList;
	}
	
	public int getsum() {
		return sum;
	}
	public int getnum(){
		return num;
	}
}
