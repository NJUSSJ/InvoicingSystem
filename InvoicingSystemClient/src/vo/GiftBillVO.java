package vo;

import java.sql.Date;

import businesslogic.billbl.CommodityList;

/**
 * 
 * @author yrz
 *	ø‚¥Ê‘˘ÀÕµ•
 */
public class GiftBillVO {
	long id;
	long userid;
	long memberid;
	CommodityList list;
	Date time;
	Boolean state=false;
	public GiftBillVO(long id,long userid,long memberid,CommodityList list,Date time) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.userid=userid;
		this.list=list;
		this.time=time;
		this.memberid=memberid;
	}
	public long getID() {
		return id;
	}
}
