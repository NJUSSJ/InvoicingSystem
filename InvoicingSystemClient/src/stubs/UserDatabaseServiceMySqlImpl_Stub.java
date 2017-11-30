package stubs;

import java.rmi.RemoteException;

import dataservice.userdataservice.UserDataService;
import po.UserPO;

public class UserDatabaseServiceMySqlImpl_Stub implements UserDataService{

	@Override
	public UserPO find(long id) throws RemoteException {
		// TODO �Զ����ɵķ������
		return new UserPO(id, null, 0, null);
	}

	@Override
	public UserPO find(String name) throws RemoteException {
		// TODO �Զ����ɵķ������
		return new UserPO(0, name, 0, name);
	}

	@Override
	public boolean insert(UserPO po) throws RemoteException {
		// TODO �Զ����ɵķ������
		System.out.println("insert success");
		return true;
	}

	@Override
	public boolean delete(UserPO po) throws RemoteException {
		// TODO �Զ����ɵķ������
		System.out.println("delete success");
		return true;
	}

	@Override
	public boolean update(UserPO po) throws RemoteException {
		// TODO �Զ����ɵķ������
		System.out.println("update success");
		return true;
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
