package vo;

import java.sql.Date;

import po.LossBillPO;

/**
 * 
 * @author yrz
 * ¿â´æ±¨Ëðµ¥
 *
 */
public class LossBillVO {
	long id;
	long userid;
	String commodityname;
	Date time;
	int state;
	int num;
	double sum;
	public LossBillVO(long id,long userid,String commodityname, Date time,int state,int num,double sum) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.commodityname=commodityname;
		this.userid=userid;
		this.time=time;
		this.state=state;
		this.num=num;
		this.sum=sum;
	}
	public LossBillPO toLossBillPO(){
		return new LossBillPO(id,userid,commodityname,time,state,num,sum);
	}
	public long getID(){
		return id;
	}
	public long getUserID(){
		return userid;
	}
	public String getCommodityName(){
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
