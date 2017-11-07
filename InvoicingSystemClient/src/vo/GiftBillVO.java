package vo;

import businesslogic.billbl.CommodityList;

/**
 * 
 * @author yrz
 *	ø‚¥Ê‘˘ÀÕµ•
 */
public class GiftBillVO {
	long id;
	String user;
	CommodityList list;
	int time;
	Boolean state=false;
	public GiftBillVO(long id,String user,CommodityList list,int time) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.user=user;
		this.list=list;
		this.time=time;
	}
	
}
