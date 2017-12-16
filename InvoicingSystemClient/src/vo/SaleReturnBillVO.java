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
	public long getMemberID() {
		return memberid;
	}
	public CommodityList getList() {
		return commodityList;
	}
	public double getSum() {
		return sum;
	}
	public int getState(){
		return state;
	}
	public Date getTime(){
		return time;
	}
	public int getNum(){
		return num;
	}
	public String getRemark(){
		return remark;
	}
	public void setUserID(long userid) {
		this.userid=userid;
	}
	public void setMemberID(long memberid) {
		this.memberid=memberid;
	}
	public void setState(int state){
		this.state=state;
	}
	public void setTime(Date time){
		this.time=time;
	}
	public void setNum(){
		this.num=commodityList.getListSize();
	}
	public void setRemark(String remark){
		this.remark=remark;
	}
}
