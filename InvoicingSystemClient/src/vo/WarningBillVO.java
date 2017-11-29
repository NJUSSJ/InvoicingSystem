package vo;
/**
 * 
 * @author yrz
 * ¿â´æ±¨¾¯µ¥
 *
 */

import java.sql.Date;

import businesslogic.billbl.CommodityList;

public class WarningBillVO {
	long id;
	long userid;
	CommodityList list;
	Date time;
	
	public WarningBillVO(long id,long userid,CommodityList list,Date time) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.userid=userid;
		this.list=list;
		this.time=time;
	}
}
