package stubs;

import java.rmi.RemoteException;

import dataservice.userdataservice.UserDataService;
import po.UserPO;

public class UserDatabaseServiceMySqlImpl_Stub implements UserDataService{

	@Override
	public UserPO find(long id) throws RemoteException {
		// TODO �Զ����ɵķ������
		return new UserPO();
	}

	@Override
	public UserPO find(String name) throws RemoteException {
		// TODO �Զ����ɵķ������
		return new UserPO();
	}

	@Override
	public void insert(UserPO po) throws RemoteException {
		// TODO �Զ����ɵķ������
		System.out.println("insert success");
	}

	@Override
	public void delete(UserPO po) throws RemoteException {
		// TODO �Զ����ɵķ������
		System.out.println("delete success");
	}

	@Override
	public void update(UserPO po) throws RemoteException {
		// TODO �Զ����ɵķ������
		System.out.println("update success");
	}

	@Override
	public void init() throws RemoteException {
		// TODO �Զ����ɵķ������
		System.out.println("init success");
	}

	@Override
	public void finish() throws RemoteException {
		// TODO �Զ����ɵķ������
		System.out.println("finish success");
	}

}
