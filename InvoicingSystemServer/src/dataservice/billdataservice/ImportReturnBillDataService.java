package dataservice.billdataservice;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import po.ImportReturnBillPO;

public interface ImportReturnBillDataService {
	public boolean insert(ImportReturnBillPO po) throws RemoteException;
	public boolean delete(ImportReturnBillPO po) throws RemoteException;
	public boolean update(ImportReturnBillPO po) throws RemoteException;
	public ImportReturnBillPO findImportBillbyID(long id) throws RemoteException;
	public ArrayList<ImportReturnBillPO> findImportReturnBillbyState(int state) throws RemoteException;
	public ArrayList<ImportReturnBillPO> findImportReturnBills() throws RemoteException;
	public ArrayList<ImportReturnBillPO> findImportReturnBillbyTime(Date time) throws RemoteException;
}