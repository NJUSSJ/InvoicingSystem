package vo;

import businesslogic.billbl.CommodityList;

/**
 * 
 * @author yrz
 *	�����˻���
 */
public class SaleReturnBillVO {
	long id;
	long userid;
	long memberid;
	CommodityList commodityList;
	int sum;
	int time;
	int num;
	boolean state=false;
	
	public SaleReturnBillVO(long id,long userid,long memberid,CommodityList list,int sum,int time) {
		// TODO Auto-generated constructor stub
		this.commodityList=list;
		this.id=id;
		this.memberid=memberid;
		this.userid=userid;
		this.sum=sum;	
		num=this.commodityList.getNum();
	}
	
	public long getID() {
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
