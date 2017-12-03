package po;

import java.sql.Date;

public class WarningBillPO {
	long id;
	long userid;
	String commodityList;
	Date time;
	int state;
	
	public WarningBillPO(long id,long userid,String commodityList,Date time,int state) {
		// TODO Auto-generated constructor stub
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
