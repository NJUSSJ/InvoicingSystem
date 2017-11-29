package driver;

import stubs.LogBLService_Stub;
import vo.LogVO;

public class LogBLService_Driver {
public void drive(LogBLService_Stub stub){
	stub.addRecord(new LogVO(0, null, null, 0));
}
}
