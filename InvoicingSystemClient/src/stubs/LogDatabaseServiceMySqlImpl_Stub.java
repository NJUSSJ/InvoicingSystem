package stubs;

import java.rmi.RemoteException;

import dataservice.logdataservice.LogDataService;
import po.LogPO;

public class LogDatabaseServiceMySqlImpl_Stub implements LogDataService {

	public void insert(LogPO po) throws RemoteException{
		System.out.println("Insert successfully!");
	}
	public void delete(LogPO po) throws RemoteException{
		System.out.println("Delete successfully!");
	}
	public void update(LogPO po) throws RemoteException{
		System.out.println("Update successfully!");
	}
	public void init() throws RemoteException{
		System.out.println("Init successfully!");
	}
	public void finish() throws RemoteException{
		System.out.println("Finish successfully!");
	}
}
