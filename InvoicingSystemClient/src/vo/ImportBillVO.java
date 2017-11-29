package vo;

import java.sql.Date;

import businesslogic.billbl.CommodityList;

/**
 * 
 * @author yrz
 *	������
 */
public class ImportBillVO {
	long id;
	long userid;
	long memberid;
	CommodityList commodityList;
	int sum;
	int state;
	Date time;
	int num;
	
	public ImportBillVO(long id,long userid,long memberid,CommodityList list,int sum,int state,Date time) {
		// TODO Auto-generated constructor stub
		this.commodityList=list;
		this.id=id;
		this.memberid=memberid;
		this.userid=userid;
		this.sum=sum;	
		this.time=time;
		num=this.commodityList.getNum();
		this.state=state;
	}
	
	public long getID() {
		return id;
	}
	
	public long getUser() {
		return userid;
	}
	
	public void changeUser(long userid) {
		this.userid=userid;
	}
	
	public long getMember() {
		return memberid;
	}
	
	public void setMember(long memberid) {
		this.memberid=memberid;
	}
	
	public CommodityList getList() {
		return commodityList;
	}
	
	public int getsum() {
		return sum;
	}
	public int getnum(){
		return num;
	}
}
