package vo;

import java.sql.Time;

import po.LogPO;

public class LogVO {
	long id;
	Time time;
	String type;
	long userid;
	
	public LogVO(long id,Time time,String type,long userid) {
		this.id=id;
		this.time=time;
		this.type=type;
		this.userid=userid;
	}
	
	public LogPO toPO(){
		return new LogPO(id,time,type,userid);
	}
}
