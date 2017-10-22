package driver;

import java.rmi.RemoteException;

import po.MemberPO;
import stubs.MemberDatabaseServiceMySqlImpl_Stub;

public class MemberDataService_Driver {
	public void drive(MemberDatabaseServiceMySqlImpl_Stub memberdataservice) throws RemoteException {
		memberdataservice.delete(new MemberPO());
		memberdataservice.find("Jack");
		memberdataservice.finish();
		memberdataservice.init();
		memberdataservice.insert(new MemberPO());
		memberdataservice.update(new MemberPO());
	}
}
