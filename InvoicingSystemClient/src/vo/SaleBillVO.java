package vo;

import java.sql.Date;

import businesslogic.billbl.CommodityList;

/**
 * 
 * @author yrz
 *	
 */
public class SaleBillVO {
	String id;
	long userid;
	long memberid;
	CommodityList commodityList;
	double sum;
	Date time;
	int num=0;
	boolean state=false;
	
	public SaleBillVO() {
		// TODO Auto-generated constructor stub
	}
	public SaleBillVO(String id,long userid,long memberid,CommodityList list,double sum,Date time) {
		// TODO Auto-generated constructor stub
		this.commodityList=list;
		this.id=id;
		this.memberid=memberid;
		this.userid=userid;
		this.sum=sum;	
	}
	
	public String getID() {
		return id;
	}
	
	public long getUser() {
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
	
	public CommodityList getList() {
		return commodityList;
	}
	
	public double getsum() {
		return sum;
	}
	public int getnum(){
		return commodityList.getNum();
	}
}
