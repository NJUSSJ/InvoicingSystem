package Client.dataservice.userdataservice;

import java.rmi.RemoteException;

import Client.po.UserPO;

public interface userdataservice {
	public UserPO find(long id) throws RemoteException;
	public UserPO find(String name) throws RemoteException;
	public void insert(UserPO po) throws RemoteException;
	public void delete(UserPO po) throws RemoteException;
	public void update(UserPO po) throws RemoteException;
	public void init() throws RemoteException;
	public void finish() throws RemoteException;

}
