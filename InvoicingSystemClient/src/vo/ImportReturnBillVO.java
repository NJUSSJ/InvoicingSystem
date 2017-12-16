package vo;

import java.sql.Date;

import businesslogic.billbl.CommodityList;
import po.ImportReturnBillPO;

/**
 * 
 * @author yrz
 */
public class ImportReturnBillVO {
	String id;
	long userid;
	long memberid;
	CommodityList commodityList;
	double sum;
	int state;
	Date time;
	int num;
	String remark;//±¸×¢
	
	public ImportReturnBillVO(String id,long userid,long memberid,CommodityList list,
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
	public ImportReturnBillPO toImportReturnBillPO(){
		return new ImportReturnBillPO(id,userid,memberid,commodityList.toString(),sum,time,state,num,remark);
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
	public int getNum(){
		return num;
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
	public void setRemark(String remark){
		this.remark=remark;
	}
}
