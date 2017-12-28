package po;

import java.io.Serializable;
import java.sql.Date;

public class WarningBillPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long id;
	long userid;
	String commodityList;
	Date time;
	int state;
	
	public WarningBillPO(long id,long userid,String commodityList,Date time,int state) {
		this.id=id;
		this.userid=userid;
		this.commodityList=commodityList;
		this.time=time;
		this.state=state;
	}
	public long getID(){
		return id;
	}
	public long getUserID(){
		return userid;
	}
	public String getCommodityList(){
		return commodityList;
	}
	public Date getTime(){
		return time;
	}
	public int getState(){
		return state;
	}
}
