package po;

import java.io.Serializable;
import java.sql.Date;

import businesslogic.billbl.CommodityList;


public class GiftBillPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long id;
	long userid;
	long memberid;
	String giftList;
	Date time;
	int state;
	public GiftBillPO(long id,long userid,long memberid,CommodityList giftList,Date time,int state) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.userid=userid;
		this.giftList=giftList.toString();
		this.time=time;
		this.memberid=memberid;
		this.state=state;
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
	public String getCommodityList(){
		return giftList;
	}
	public Date getTime(){
		return time;
	}
	public int getState(){
		return state;
	}
}
