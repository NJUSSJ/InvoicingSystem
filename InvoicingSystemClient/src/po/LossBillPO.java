package po;

import java.sql.Date;


public class LossBillPO {
	long id;
	long userid;
	String commodityList;
	Date time;
	int state;
<<<<<<< HEAD

	public LossBillPO(long id,long userid,String commodityList, Date time,int state) {

=======
	public LossBillPO(long id,long userid,String commodityList, Date time,int state) {
>>>>>>> 2c51a054ae2e8c71a0bc16683dd3793bb0469cbb
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
	public int getState(){
		return state;
	}
}
