package stubs;

import java.sql.Time;

import businesslogicservice.logblservice.LogBLService;
import vo.LogVO;
import vo.UserVO;

public class LogBLService_Stub implements LogBLService{
	Time operate_time;
	String operate_type;
	UserVO operator;
	
	public LogBLService_Stub(Time operate_time,String operate_type,UserVO operator){
		this.operate_time=operate_time;
		this.operate_type=operate_type;
		this.operator=operator;
	}
	
	public void checkRecord(){
		
		System.out.print("check log");
	}
	

	@Override
	public void addRecord(LogVO vo) {
		// TODO 自动生成的方法存根
		
	}
}
