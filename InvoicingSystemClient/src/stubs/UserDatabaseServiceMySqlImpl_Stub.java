package stubs;

import java.rmi.RemoteException;

import dataservice.userdataservice.UserDataService;
import po.UserPO;

public class UserDatabaseServiceMySqlImpl_Stub implements UserDataService{

	@Override
	public UserPO findUserbyID(long id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public UserPO findUserbyName(String name) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean insert(UserPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean delete(UserPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean update(UserPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	

}
