package vo;

import businesslogic.billbl.CommodityList;

/**
 * 
 * @author yrz
 *	��汨�絥
 */
public class OverBillVO {
	long id;
	String user;
	CommodityList commoditys;
	int time;
	
	public OverBillVO(long id,String user,CommodityList list,int time) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.commoditys=list;
		this.user=user;
	}
}
