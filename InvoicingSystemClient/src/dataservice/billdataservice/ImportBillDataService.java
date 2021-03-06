package dataservice.billdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import po.ImportBillPO;

public interface ImportBillDataService extends Remote {
	public boolean insert(ImportBillPO po) throws RemoteException;
	public boolean delete(ImportBillPO po) throws RemoteException;
	public boolean update(ImportBillPO po) throws RemoteException;
	public ImportBillPO findImportBillbyID(String id) throws RemoteException;
	public ArrayList<ImportBillPO> findImportBillbyState(int state) throws RemoteException;
	public ArrayList<ImportBillPO> findImportBillbyTime(Date time) throws RemoteException;
	public ArrayList<ImportBillPO> findImportBills() throws RemoteException;
	public ArrayList<ImportBillPO> findImportBillsByField(String user,String member) throws RemoteException;
	public ArrayList<ImportBillPO> findImportBillsByUser(long userid) throws RemoteException;
}
