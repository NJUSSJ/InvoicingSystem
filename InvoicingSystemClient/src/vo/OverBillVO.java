package vo;

import java.sql.Date;

import businesslogic.billbl.CommodityList;
import po.OverBillPO;

/**
 * 
 * @author yrz
 *	¿â´æ±¨Òçµ¥
 */
public class OverBillVO {
	long id;
	long userid;
	String commodityname;
	Date time;
	int state;
	int num;
	double sum;
	public OverBillVO(long id,long userid,String commodityname,Date time,int state,int num,double sum) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.commodityname=commodityname;
		this.userid=userid;
		this.time=time;
		this.state=state;
		this.sum=sum;
		this.num=num;
	}
	public OverBillPO toOverBillPO(){
		return new OverBillPO(id,userid,commodityname,time,state,num,sum);
	}
	public long getID(){
		return id;
	}
	public long getUserID(){
		return userid;
	}
	public String getCommodityList(){
		return commodityname;
	}
	public Date getTime(){
		return time;
	}
	public int getState(){
		return state;
	}
	public void setUserID(long userid){
		this.userid=userid;
	}
	public void setTime(Date time){
		this.time=time;
	}
	public void setState(int state){
		this.state=state;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num=num;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum=sum;
	}
}
