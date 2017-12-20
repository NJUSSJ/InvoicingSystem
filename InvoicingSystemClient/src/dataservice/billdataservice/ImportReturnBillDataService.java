package dataservice.billdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import po.ImportReturnBillPO;

public interface ImportReturnBillDataService extends Remote{
	public boolean insert(ImportReturnBillPO po) throws RemoteException;
	public boolean delete(ImportReturnBillPO po) throws RemoteException;
	public boolean update(ImportReturnBillPO po) throws RemoteException;
	public ImportReturnBillPO findImportReturnBillbyID(String id) throws RemoteException;
	public ArrayList<ImportReturnBillPO> findImportReturnBillbyState(int state) throws RemoteException;
	public ArrayList<ImportReturnBillPO> findImportReturnBills() throws RemoteException;
	public ArrayList<ImportReturnBillPO> findImportReturnBillbyTime(Date time) throws RemoteException;
	public ArrayList<ImportReturnBillPO> findImportReturnBillbyField(String user,String member) throws RemoteException;
	public ArrayList<ImportReturnBillPO> findImportReturnBillbyUser(long userid) throws RemoteException;
}
