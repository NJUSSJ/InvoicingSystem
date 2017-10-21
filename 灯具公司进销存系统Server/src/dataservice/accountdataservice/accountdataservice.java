package dataservice.accountdataservice;

import java.rmi.RemoteException;

import po.AccountPO;



public interface accountdataservice {
	public AccountPO find(long id) throws RemoteException;
	public void insert(AccountPO po) throws RemoteException;
	public void delete(AccountPO po) throws RemoteException;
	public void update(AccountPO po) throws RemoteException;
	public void init() throws RemoteException;
	public void finish() throws RemoteException;
	
}
