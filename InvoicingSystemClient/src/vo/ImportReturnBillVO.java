package vo;

import businesslogic.billbl.CommodityList;

/**
 * 
 * @author yrz
 *	�����˻���
 */
public class ImportReturnBillVO {
	long id;
	String user;
	String member;
	CommodityList commodityList;
	int sum;
	int time;
	int num;
	public ImportReturnBillVO(long id,String user,String member,CommodityList list,int sum,int time) {
		// TODO Auto-generated constructor stub
		this.id=id;this.user=user;
		this.member=member;
		this.commodityList=list;
		this.sum=sum;
		this.time=time;
		num=this.commodityList.getNum();
	}
	
	public long getID() {
		return id;
	}
	
	public String getUser() {
		return user;
	}
	
	public String getMember() {
		return member;
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
