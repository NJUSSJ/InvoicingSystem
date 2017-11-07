package vo;

import businesslogic.billbl.CommodityList;

/**
 * 
 * @author yrz
 *	œ˙ €µ•
 */
public class SaleBillVO {
	long id;
	String user;
	String member;
	CommodityList commodityList;
	int sum;
	int time;
	public SaleBillVO(long id,String user,String member,CommodityList list,int sum,int time) {
		// TODO Auto-generated constructor stub
		this.commodityList=list;
		this.id=id;
		this.member=member;
		this.user=user;
		this.sum=sum;	
	}
	
	public long getID() {
		return id;
	}
	
	public String getUser() {
		return user;
	}
	
	public void changeUser(String user) {
		this.user=user;
	}
	
	public String getMember() {
		return member;
	}
	
	public void changeMember(String member) {
		this.member=member;
	}
	
	public CommodityList getList() {
		return commodityList;
	}
	
	public int getsum() {
		return sum;
	}
}
