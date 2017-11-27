package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import data.userdata.UserDataImpl;
import dataservice.userdataservice.UserDataService;
import po.UserPO;

/**
 * 
 * @author shisj
 *
 */
public class DataRemoteObject extends UnicastRemoteObject implements UserDataService{

	
	
	private static final long serialVersionUID = 1L;

	
	private UserDataService userService;
	
	
	protected DataRemoteObject() throws RemoteException {
		userService=new UserDataImpl();
		// TODO Auto-generated constructor stub
	}

	//UserDataService
	@Override
	public UserPO find(long id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public UserPO find(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return userService.find(name);
	}

	

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean insert(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
