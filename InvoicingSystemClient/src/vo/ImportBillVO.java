package vo;

import java.sql.Date;

import businesslogic.billbl.CommodityList;
import po.ImportBillPO;

/**
 * 
 * @author yrz
 *	进货单
 */
public class ImportBillVO {
	String id;
	long userid;
	long memberid;
	CommodityList commodityList;
	double sum;
	int state;
	Date time;
	int num;
	String remark;//备注
	
	public ImportBillVO(String id,long userid,long memberid,CommodityList commoditylist,
			double sum,int state,Date time,String remark) {
		this.commodityList=commoditylist;
		this.id=id;
		this.memberid=memberid;
		this.userid=userid;
		this.sum=sum;	
		this.time=time;
		num=this.commodityList.getNum();
		this.state=state;
		this.remark=remark;
	}
	
	public ImportBillPO toImportBillPO(){
		return new ImportBillPO(id,userid,memberid,commodityList.toString(),sum,time,state,num,remark);
	}
	public String getID() {
		return id;
	}
	public String getRemark() {
		return remark;
	}
	public long getUserID() {
		return userid;
	}
	public long getMemberID() {
		return memberid;
	}
	public CommodityList getCommodityList() {
		return commodityList;
	}
	public double getSum() {
		return sum;
	}
	public int getNum(){
		return num;
	}
	public int getState(){
		return state;
	}
	public Date getTime(){
		return time;
	}
	public void setUserID(long userid) {
		this.userid=userid;
	}
	
	public void setMemberID(long memberid) {
		this.memberid=memberid;
	}
	public void setTime(Date time){
		this.time=time;
	}
	public void setState(int state){
		this.state=state;
	}
	public void setRemark(String remark){
		this.remark=remark;
	}
	
}
