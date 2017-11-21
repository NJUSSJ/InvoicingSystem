package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.UserPO;

public interface UserDataService extends Remote {
	public UserPO find(long id) throws RemoteException;
	public UserPO find(String name) throws RemoteException;
	public void insert(UserPO po) throws RemoteException;
	public void delete(UserPO po) throws RemoteException;
	public void update(UserPO po) throws RemoteException;
	public void init() throws RemoteException;
	public void finish() throws RemoteException;

}
