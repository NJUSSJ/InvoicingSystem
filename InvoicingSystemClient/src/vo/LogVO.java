package vo;

import java.sql.Date;
import po.LogPO;

public class LogVO {
	long id;
	Date time;
	String type;
	long userid;
	
	public LogVO(long id,Date time,String type,long userid) {
		this.id=id;
		this.time=time;
		this.type=type;
		this.userid=userid;
	}
	
	public LogPO toLogPO(){
		return new LogPO(id,time,type,userid);
	}
	public long getID(){
		return id;
	}
	public Date getTime(){
		return time;
	}
	public String getType(){
		return type;
	}
	public long getUserID(){
		return userid;
	}
	public void setTime(Date time){
		this.time=time;
	}
	public void setType(String type){
		this.type=type;
	}
	public void setUserID(long userid){
		this.userid=userid;
	}
}
