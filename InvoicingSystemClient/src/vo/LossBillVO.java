package vo;

import java.sql.Date;

import businesslogic.billbl.CommodityList;
import po.LossBillPO;

/**
 * 
 * @author yrz
 * ¿â´æ±¨Ëðµ¥
 *
 */
public class LossBillVO {
	long id;
	long userid;
	CommodityList commodityList;
	Date time;
	int state;
	public LossBillVO(long id,long userid,CommodityList commodityList, Date time,int state) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.commodityList=commodityList;
		this.userid=userid;
		this.time=time;
		this.state=state;
	}
	public LossBillPO toLossBillPO(){
		return new LossBillPO(id,userid,commodityList.toString(),time,state);
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
