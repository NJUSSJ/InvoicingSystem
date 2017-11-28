package vo;

import java.sql.Date;

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
	Date time;
	
	public OverBillVO(long id,long userid,CommodityList list,Date time) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.commoditys=list;
		this.userid=userid;
		this.time=time;
	}
}
