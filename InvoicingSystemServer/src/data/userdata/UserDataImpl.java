package data.userdata;

import java.rmi.RemoteException;

import dataservice.userdataservice.UserDataService;
import po.UserPO;

public class UserDataImpl implements UserDataService {

	@Override
	public UserPO find(long id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserPO find(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
