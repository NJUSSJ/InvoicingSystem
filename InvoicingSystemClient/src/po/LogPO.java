package po;

import java.sql.Time;

public class LogPO {
	long id;
	Time time;
	String type;
	long userid;
	
	public LogPO(long id,Time time,String type,long userid) {
		this.id=id;
		this.time=time;
		this.type=type;
		this.userid=userid;
	}
}
