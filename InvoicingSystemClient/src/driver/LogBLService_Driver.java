package driver;

import java.sql.Time;

import stubs.LogBLService_Stub;
import vo.LogVO;
import vo.UserVO;

public class LogBLService_Driver {
public void drive(LogBLService_Stub stub){
	stub.addRecord(new LogVO(null, null, null));
}
}
