package po;

import java.io.Serializable;
import java.sql.Date;



public class OverBillPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long id;
	long userid;
	String commodityname;
	Date time;
	int state;
	int num;
	double sum;
	public OverBillPO(long id,long userid,String commodityname, Date time,int state,int num,double sum) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.commodityname=commodityname;
		this.userid=userid;
		this.time=time;
		this.state=state;
		this.sum=sum;
		this.num=num;
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
	public int getNum() {
		return num;
	}
	public double getSum() {
		return sum;
	}
}

