package vo;

import java.sql.Date;

import businesslogic.billbl.CommodityList;
import po.GiftBillPO;

/**
 * 
 * @author yrz
 *	ø‚¥Ê‘˘ÀÕµ•
 */
public class GiftBillVO {
	long id;
	long userid;
	long memberid;
	CommodityList giftList;
	Date time;
	int state;
	public GiftBillVO(long id,long userid,long memberid,CommodityList giftList,Date time,int state) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.userid=userid;
		this.giftList=giftList;
		this.time=time;
		this.memberid=memberid;
		this.state=state;
	}
	public GiftBillPO toGiftBillPO(){
		return new GiftBillPO(id,userid,memberid,giftList.toString(),time,state);
	}
	public long getID() {
		return id;
	}
	public long getUserID(){
		return userid;
	}
	public long getMemberID(){
		return memberid;
	}
	public CommodityList getCommodityList(){
		return giftList;
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
	public void setMemberID(long memberid){
		this.memberid=memberid;
	}
	public void setTime(Date time){
		this.time=time;
	}
	public void setState(int state){
		this.state=state;
	}
}
