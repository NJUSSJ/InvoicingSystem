package vo;

import businesslogic.billbl.CommodityList;

/**
 * 
 * @author yrz
 */
public class ImportReturnBillVO {
	long id;
	long userid;
	long memberid;
	CommodityList commodityList;
	int sum;
	int time;
	int num;
	public ImportReturnBillVO(long id,long userid,long memberid,CommodityList list,int sum,int time) {
		// TODO Auto-generated constructor stub
		this.id=id;this.userid=userid;
		this.memberid=memberid;
		this.commodityList=list;
		this.sum=sum;
		this.time=time;
		num=this.commodityList.getNum();
	}
	
	public long getID() {
		return id;
	}
	
	public long getUser() {
		return userid;
	}
	
	public long getMember() {
		return memberid;
	}
	
	public int getTime() {
		return time;
	}
	public int getnum(){
		return num;
	}

	public double getsum() {
		return sum;
	}
}
