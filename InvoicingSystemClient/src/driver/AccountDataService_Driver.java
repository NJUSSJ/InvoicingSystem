package driver;

import java.rmi.RemoteException;

import po.AccountPO;
import stubs.AccountBLService_Stub;
import stubs.AccountDatabaseServiceMySqlImpl_Stub;
import vo.AccountVO;

public class AccountDataService_Driver {

	public void drive(AccountDatabaseServiceMySqlImpl_Stub stub){
		try {
			if(stub.find(0)!=null){
				System.out.println("find pass");
			}
			stub.insert(new AccountPO());
			stub.delete(new AccountPO());
			stub.update(new AccountPO());
			stub.init();
			stub.finish();
			} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
}
