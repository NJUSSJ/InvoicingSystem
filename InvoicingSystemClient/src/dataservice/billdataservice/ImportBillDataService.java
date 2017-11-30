package dataservice.billdataservice;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import po.ImportBillPO;

public interface ImportBillDataService {
	public void insert(ImportBillPO po) throws RemoteException;
	public void delete(ImportBillPO po) throws RemoteException;
	public void update(ImportBillPO po) throws RemoteException;
	public ArrayList<ImportBillPO> findImportBillbyState(int state) throws RemoteException;
	public ArrayList<ImportBillPO> findImportBillbyTime(Date time) throws RemoteException;
}
