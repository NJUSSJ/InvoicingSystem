package driver;

import java.rmi.RemoteException;

import po.LogPO;
import stubs.LogDatabaseServiceMySqlImpl_Stub;

public class LogDataService_Driver {
	public void drive(LogDatabaseServiceMySqlImpl_Stub stub){
		try {
			stub.insert(new LogPO());
			stub.delete(new LogPO());
			stub.update(new LogPO());
			stub.init();
			stub.finish();
			} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
}
