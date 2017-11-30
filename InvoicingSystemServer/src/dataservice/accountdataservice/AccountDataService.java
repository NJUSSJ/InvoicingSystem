package dataservice.accountdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AccountPO;



public interface AccountDataService {
	public AccountPO find(long id) throws RemoteException;
	public ArrayList<AccountPO> finds() throws RemoteException;
	public boolean insert(AccountPO po) throws RemoteException;
	public boolean delete(AccountPO po) throws RemoteException;
	public boolean update(AccountPO po) throws RemoteException;
	public void init() throws RemoteException;
	public void finish() throws RemoteException;
	
}
