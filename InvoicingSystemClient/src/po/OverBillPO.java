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
	String commodityList;
	Date time;
	int state;

	public OverBillPO(long id,long userid,String commodityList, Date time,int state) {

		// TODO Auto-generated constructor stub
		this.id=id;
		this.commodityList=commodityList;
		this.userid=userid;
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
	public int getState() {
		return state;
	}
}

