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
	public long getID(){
		return id;
	}
	public long getUserID(){
		return userid;
	}
	public CommodityList getCommodityList(){
		return commodityList;
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
