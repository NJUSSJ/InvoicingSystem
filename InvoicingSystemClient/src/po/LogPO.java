package po;

import java.sql.Date;

public class LogPO {
	long id;
	Date time;
	String type;
	long userid;
	
	public LogPO(long id,Date time,String type,long userid) {
		this.id=id;
		this.time=time;
		this.type=type;
		this.userid=userid;
	}
}
