package driver;

import java.rmi.RemoteException;

import po.UserPO;
import stubs.UserDatabaseServiceMySqlImpl_Stub;

public class UserDataService_Driver {
		public void drive(UserDatabaseServiceMySqlImpl_Stub stub){
			try {
				if(stub.find(900)!=null){
					System.out.println("find pass");
				}
				if(stub.find("980")!=null){
					System.out.println("find(str) pass");
				}
				stub.insert(new UserPO());
				stub.delete(new UserPO());
				stub.update(new UserPO());
				stub.init();
				stub.finish();
				} catch (RemoteException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
		}
	}

