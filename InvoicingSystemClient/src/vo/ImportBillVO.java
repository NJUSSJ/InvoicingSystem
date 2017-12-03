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
		// TODO Auto-generated constructor stub
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
	
	public double getSum() {
		return sum;
	}
	public int getNum(){
		return num;
	}
	public void setState(int state){
		this.state=state;
	}
}
