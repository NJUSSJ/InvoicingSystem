package dataservice.accountdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AccountPO;



public interface AccountDataService {
	public AccountPO findAccountbyID(long id) throws RemoteException;
	public ArrayList<AccountPO> findAccounts() throws RemoteException;
	public boolean insert(AccountPO po) throws RemoteException;
	public boolean delete(AccountPO po) throws RemoteException;
	public boolean update(AccountPO po) throws RemoteException;
	public ArrayList<AccountPO> findAcountbyField(String field) throws RemoteException;
	
}
