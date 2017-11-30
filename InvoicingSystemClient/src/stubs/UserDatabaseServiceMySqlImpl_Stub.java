package stubs;

import java.rmi.RemoteException;

import dataservice.userdataservice.UserDataService;
import po.UserPO;

public class UserDatabaseServiceMySqlImpl_Stub implements UserDataService{

	@Override
	public UserPO find(long id) throws RemoteException {
		// TODO 自动生成的方法存根
		return new UserPO(id, null, 0, null);
	}

	@Override
	public UserPO find(String name) throws RemoteException {
		// TODO 自动生成的方法存根
		return new UserPO(0, name, 0, name);
	}

	@Override
	public boolean insert(UserPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		System.out.println("insert success");
		return true;
	}

	@Override
	public boolean delete(UserPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		System.out.println("delete success");
		return true;
	}

	@Override
	public boolean update(UserPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		System.out.println("update success");
		return true;
	}

	@Override
	public void init() throws RemoteException {
		// TODO 自动生成的方法存根
		System.out.println("init success");
	}

	@Override
	public void finish() throws RemoteException {
		// TODO 自动生成的方法存根
		System.out.println("finish success");
	}

}
