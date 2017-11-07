package vo;
/**
 * 
 * @author yrz
 * ¿â´æ±¨¾¯µ¥
 *
 */

import businesslogic.billbl.CommodityList;

public class WarningBillVO {
	long id;
	String user;
	CommodityList list;
	int time;
	
	public WarningBillVO(long id,String user,CommodityList list,int time) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.user=user;
		this.list=list;
		this.time=time;
	}
}
