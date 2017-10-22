package stubs;

import java.rmi.RemoteException;

import dataservice.accountdataservice.AccountDataService;
import po.AccountPO;

public class AccountDatabaseServiceMySqlImpl_Stub implements AccountDataService {

	@Override
	public AccountPO find(long id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find Succeed");
		return new AccountPO();
	}

	@Override
	public void insert(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Insert Succeed");
	}

	@Override
	public void delete(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete Succeed");
	}

	@Override
	public void update(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed");
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Init Succeed");
	}
	

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Finish");
	}
	
}
