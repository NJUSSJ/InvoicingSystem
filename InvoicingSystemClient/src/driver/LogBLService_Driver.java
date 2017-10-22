package driver;

import java.sql.Time;

import stubs.LogBLService_Stub;
import vo.UserVO;

public class LogBLService_Driver {
public void drive(LogBLService_Stub stub){
	stub.addNewLog(new Time(0), "**", new UserVO());
	if(stub.getLogInformation()!=null){
		System.out.println("get pass");
	}
}
}
