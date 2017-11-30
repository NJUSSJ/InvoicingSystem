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
}
