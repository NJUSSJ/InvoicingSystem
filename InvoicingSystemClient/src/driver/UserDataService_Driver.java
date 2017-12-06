package driver;

import java.rmi.RemoteException;

import po.UserPO;
import stubs.UserDatabaseServiceMySqlImpl_Stub;

public class UserDataService_Driver {
		public void drive(UserDatabaseServiceMySqlImpl_Stub stub){
			try {
				stub.insert(new UserPO(0, null, 0, null));
				stub.delete(new UserPO(0, null, 0, null));
				stub.update(new UserPO(0, null, 0, null));
				} catch (RemoteException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
		}
	}

