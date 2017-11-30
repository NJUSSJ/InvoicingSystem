package driver;

import java.rmi.RemoteException;

import po.MemberPO;
import stubs.MemberDatabaseServiceMySqlImpl_Stub;

public class MemberDataService_Driver {
	public void drive(MemberDatabaseServiceMySqlImpl_Stub memberdataservice) throws RemoteException {
		memberdataservice.delete(new MemberPO(0, 0, 0, 0, null, 0, null, null, 0, 0, 0, 0));
		memberdataservice.find("Jack");
		memberdataservice.finish();
		memberdataservice.init();
		memberdataservice.insert(new MemberPO(0, 0, 0, 0, null,0, null, null,  0, 0, 0, 0));
		memberdataservice.update(new MemberPO(0, 0, 0, 0, null, 0,null, null,  0, 0, 0, 0));
	}
}
