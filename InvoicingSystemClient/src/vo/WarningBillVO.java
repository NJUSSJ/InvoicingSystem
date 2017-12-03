package vo;
/**
 * 
 * @author yrz
 * ¿â´æ±¨¾¯µ¥
 *
 */

import java.sql.Date;

import businesslogic.billbl.CommodityList;
import po.WarningBillPO;

public class WarningBillVO {
	long id;
	long userid;
	CommodityList list;
	Date time;
	int state;
	
	public WarningBillVO(long id,long userid,CommodityList list,Date time,int state) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.userid=userid;
		this.list=list;
		this.time=time;
		this.state=state;
	}
	public WarningBillPO toWarningBillPO(){
		return new WarningBillPO(id,userid,list.toString(),time,state);
	}
	public void setState(int state){
		this.state=state;
	}
}
