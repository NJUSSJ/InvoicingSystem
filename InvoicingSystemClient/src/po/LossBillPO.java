package po;

import java.io.Serializable;
import java.sql.Date;


public class LossBillPO implements Serializable {
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
	public LossBillPO(long id,long userid,String commodityname, Date time,int state,int num,double sum) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.commodityname=commodityname;
		this.userid=userid;
		this.time=time;
		this.state=state;
		this.num=num;
		this.sum=sum;
	}
	public long getID(){
		return id;
	}
	public long getUserID(){
		return userid;
	}
	public String getName(){
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
