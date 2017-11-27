package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.UserPO;

public interface UserDataService extends Remote {
	public UserPO find(long id) throws RemoteException;
	public UserPO find(String name) throws RemoteException;
	public boolean insert(UserPO po) throws RemoteException;
	public boolean delete(UserPO po) throws RemoteException;
	public boolean update(UserPO po) throws RemoteException;
	public void init() throws RemoteException;
	public void finish() throws RemoteException;

}
