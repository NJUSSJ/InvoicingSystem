package vo;

import java.sql.Date;

import businesslogic.billbl.CommodityList;
import po.OverBillPO;

/**
 * 
 * @author yrz
 *	��汨�絥
 */
public class OverBillVO {
	long id;
	long userid;
	CommodityList commodityList;
	Date time;
	int state;
	public OverBillVO(long id,long userid,CommodityList commodityList,Date time,int state) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.commodityList=commodityList;
		this.userid=userid;
		this.time=time;
		this.state=state;
	}
	public OverBillPO toOverBillPO(){
		return new OverBillPO(id,userid,commodityList.toString(),time,state);
	}
}
