package vo;

import businesslogic.billbl.CommodityList;

/**
 * 
 * @author yrz
 *	¿â´æ±¨Òçµ¥
 */
public class OverBillVO {
	long id;
	long userid;
	CommodityList commoditys;
	int time;
	
	public OverBillVO(long id,String user,CommodityList list,int time) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.commoditys=list;
		this.userid=userid;
		this.time=time;
	}
}
