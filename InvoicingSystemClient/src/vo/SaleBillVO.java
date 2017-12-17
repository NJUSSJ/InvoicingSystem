package vo;

import java.sql.Date;

import businesslogic.billbl.CommodityList;
import po.SaleBillPO;

/**
 * 
 * @author yrz
 *	
 */
public class SaleBillVO {
	String id;
	long userid;
	long memberid;
	CommodityList commodityList;
	double sum;
	int state;
	Date time;
	int num;
	String remark;//备注
	int coupon;
	double discount;
	double ultimate;
	double money;//此单中顾客中实际付的钱
	
	public SaleBillVO(String id,long userid,long memberid,CommodityList list,double sum,int state,
		Date time,String remark,int coupon,double discount,double ultimate,double money) {
		this.commodityList=list;
		this.id=id;
		this.memberid=memberid;
		this.userid=userid;
		this.sum=sum;	
		this.time=time;
		num=this.commodityList.getNum();
		this.state=state;
		this.remark=remark;
		this.coupon=coupon;
		this.ultimate=ultimate;
		this.discount=ultimate/sum;
		this.money=money;
	}
	public SaleBillPO toSaleBillPO(){
		return new SaleBillPO(id,userid,memberid,commodityList.toString(),sum,state,time,num,remark,coupon,discount,ultimate,money);
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
	public int getCoupon(){
		return coupon;
	}
	public double getDiscount(){
		return discount;
	}
	public double getUltimate(){
		return ultimate;
	}
	public double getMoney(){
		return money;
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
		num=commodityList.getListSize();
	}
	public void setRemark(String remark){
		this.remark=remark;
	}
}
