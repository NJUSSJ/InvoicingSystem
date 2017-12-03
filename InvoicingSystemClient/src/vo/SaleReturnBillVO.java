package vo;

import java.sql.Date;

import businesslogic.billbl.CommodityList;
import po.SaleReturnBillPO;

/**
 * 
 * @author yrz
 *
 */
public class SaleReturnBillVO {
	String id;
	long userid;
	long memberid;
	CommodityList commodityList;
	double sum;
	int state;
	Date time;
	int num;
	String remark;//±¸×¢
	
	public SaleReturnBillVO(String id,long userid,long memberid,CommodityList list,
			double sum,int state,Date time,String remark) {
		// TODO Auto-generated constructor stub
		this.commodityList=list;
		this.id=id;
		this.memberid=memberid;
		this.userid=userid;
		this.sum=sum;	
		this.time=time;
		num=this.commodityList.getNum();
		this.state=state;
		this.remark=remark;
	}
	public SaleReturnBillPO toSaleReturnBillPO(){
		return new SaleReturnBillPO(id,userid,memberid,commodityList.toString(),sum,state,time,num,remark);
	}
	public String getID() {
		return id;
	}
	
	public long getUserID() {
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
	
	public double getsum() {
		return sum;
	}
	public int getnum(){
		return num;
	}
	public void setState(int state){
		this.state=state;
	}
}
