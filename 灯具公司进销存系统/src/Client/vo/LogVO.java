package Client.vo;

import java.sql.Time;

public class LogVO {
	Time oprate_time;
	String operate_type;
	UserVO opeartor;
	
	public LogVO(Time oprate_time,
	String operate_type,
	UserVO opeartor) {
	
		this.opeartor=opeartor;
		this.oprate_time=oprate_time;
		this.operate_type=operate_type;
		
	}
}
