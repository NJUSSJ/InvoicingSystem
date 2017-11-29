package po;

import java.sql.Date;

public class WarningBillPO {
	long id;
	long userid;
	String commodityList;
	Date time;
	
	public WarningBillPO(long id,long userid,String commodityList,Date time) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.userid=userid;
		this.commodityList=commodityList;
		this.time=time;
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
}
