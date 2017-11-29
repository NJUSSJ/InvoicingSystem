package po;

import java.sql.Date;

import businesslogic.billbl.CommodityList;

public class LossBillPO {
	long id;
	long userid;
	String commodityList;
	Date time;
	public LossBillPO(long id,long userid,CommodityList commodityList, Date time) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.commodityList=commodityList.toString();
		this.userid=userid;
		this.time=time;
	}
}
