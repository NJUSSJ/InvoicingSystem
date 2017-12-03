package stubs;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.accountdataservice.AccountDataService;
import po.AccountPO;

public class AccountDatabaseServiceMySqlImpl_Stub implements AccountDataService {

	@Override
	public AccountPO findAccountbyID(long id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<AccountPO> findAccounts() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean insert(AccountPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean delete(AccountPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean update(AccountPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	
	
	
}
