package vo;

import businesslogic.billbl.CommodityList;

/**
 * 
 * @author yrz
 *	������͵�
 */
public class GiftBillVO {
	long id;
	String user;
	String member;
	CommodityList list;
	int time;
	Boolean state=false;
	public GiftBillVO(long id,String user,String member,CommodityList list,int time) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.user=user;
		this.list=list;
		this.time=time;
		this.member=member;
	}
	public long getID() {
		return id;
	}
}
