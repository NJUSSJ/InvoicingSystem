package po;

import java.io.Serializable;
import java.sql.Date;

public class LogPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
}
