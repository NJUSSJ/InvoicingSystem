package driver;

import java.rmi.RemoteException;

import po.LogPO;
import stubs.LogDatabaseServiceMySqlImpl_Stub;

public class LogDataService_Driver {
	public void drive(LogDatabaseServiceMySqlImpl_Stub stub){
		try {
			stub.insert(new LogPO(0, null, null, 0));
			stub.delete(new LogPO(0, null, null, 0));
			stub.update(new LogPO(0, null, null, 0));
			stub.init();
			stub.finish();
			} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
}
