package stubs;

import java.sql.Time;

import vo.LogVO;
import vo.UserVO;

public class LogBLService_Stub {
	Time operate_time;
	String operate_type;
	UserVO operator;
	
	public LogBLService_Stub(Time operate_time,String operate_type,UserVO operator){
		this.operate_time=operate_time;
		this.operate_type=operate_type;
		this.operator=operator;
	}
	
	public LogVO getLogInformation(){
		LogVO lv=new LogVO(operate_time,operate_type,operator);
		return lv;
	}
	
	public void addNewLog(Time operate_time,String operate_type,UserVO operator){
		
		System.out.println("Add successfully!");
	}
}
