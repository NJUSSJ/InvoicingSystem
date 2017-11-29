package vo;

import java.sql.Date;

import businesslogic.billbl.CommodityList;
import po.OverBillPO;

/**
 * 
 * @author yrz
 *	¿â´æ±¨Òçµ¥
 */
public class OverBillVO {
	long id;
	long userid;
	CommodityList commodityList;
	Date time;
	
	public OverBillVO(long id,long userid,CommodityList commodityList,Date time) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.commodityList=commodityList;
		this.userid=userid;
		this.time=time;
	}
	public OverBillPO toOverBillPO(){
		return new OverBillPO(id,userid,commodityList,time);
	}
}
