package dataservice.accountdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import po.AccountPO;
import po.BookPO;



public interface AccountDataService extends Remote {
	public AccountPO findAccountbyID(long id) throws RemoteException;
	public ArrayList<AccountPO> findAccounts() throws RemoteException;
	public boolean insert(AccountPO po) throws RemoteException;
	public boolean delete(AccountPO po) throws RemoteException;
	public boolean update(AccountPO po) throws RemoteException;
	public ArrayList<AccountPO> findAcountbyField(String field) throws RemoteException;
	public boolean backUpDataBase(Date time) throws RemoteException;
	public ArrayList<BookPO> restore() throws RemoteException;
}
