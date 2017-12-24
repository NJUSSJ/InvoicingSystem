package po;

import java.io.Serializable;
import java.sql.Date;

public class SaleBillPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	long userid;
	long memberid;
	String commodityList;
	double sum;
	int state;
	Date time;
	int num;
	String remark;//±¸×¢
	int coupon;
	double discount;
	double ultimate;
	
	public SaleBillPO(String id,long userid,long memberid,String commodityList,double sum,int state,
			Date time,int num,String remark,int coupon,double discount,double ultimate) {
		this.commodityList=commodityList;
		this.id=id;
		this.memberid=memberid;
		this.userid=userid;
		this.sum=sum;	
		this.time=time;
		this.num=num;
		this.state=state;
		this.remark=remark;
		this.coupon=coupon;
		this.discount=discount;
		this.ultimate=ultimate;
	}
	public String getID(){
		return id;
	}
	public long getUserID(){
		return userid;
	}
	public long getMemberID(){
		return memberid;
	}
	public String getCommodityList(){
		return commodityList;
	}
	public double getSum(){
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
}
