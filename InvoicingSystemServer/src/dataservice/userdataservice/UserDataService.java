package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.UserPO;

public interface UserDataService extends Remote {
	public UserPO findUserbyID(long id) throws RemoteException;
	public UserPO findUserbyName(String name) throws RemoteException;
	public boolean insert(UserPO po) throws RemoteException;
	public boolean delete(UserPO po) throws RemoteException;
	public boolean update(UserPO po) throws RemoteException;
	public ArrayList<UserPO> findUsers() throws RemoteException;
	public ArrayList<UserPO> findUserbyField(String field) throws RemoteException;

}
