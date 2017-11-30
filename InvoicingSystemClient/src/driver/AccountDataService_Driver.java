package driver;

import java.rmi.RemoteException;

import po.AccountPO;
import stubs.AccountDatabaseServiceMySqlImpl_Stub;

public class AccountDataService_Driver {

	public void drive(AccountDatabaseServiceMySqlImpl_Stub stub){
		try {
			if(stub.find(0)!=null){
				System.out.println("find pass");
			}
			stub.insert(new AccountPO(0, 0, null));
			stub.delete(new AccountPO(0, 0, null));
			stub.update(new AccountPO(0, 0, null));
			stub.init();
			stub.finish();
			} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
}
