package po;

import java.sql.Date;


public class LossBillPO {
	long id;
	long userid;
	String commodityList;
	Date time;
	int state;
	public LossBillPO(long id,long userid,String commodityList, Date time) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.commodityList=commodityList;
		this.userid=userid;
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
