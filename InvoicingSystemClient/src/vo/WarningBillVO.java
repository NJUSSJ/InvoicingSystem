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
		this.id=id;
		this.userid=userid;
		this.list=list;
		this.time=time;
		this.state=state;
	}
	public WarningBillPO toWarningBillPO(){
		return new WarningBillPO(id,userid,list.toString(),time,state);
	}
	public long getID(){
		return id;
	}
	public long getUserID(){
		return userid;
	}
	public CommodityList getList(){
		return list;
	}
	public Date getTime(){
		return time;
	}
	public int getState(){
		return state;
	}
	public void setUserID(long userid){
		this.userid=userid;
	}
	public void setTime(Date time){
		this.time=time;
	}
	public void setState(int state){
		this.state=state;
	}
}
