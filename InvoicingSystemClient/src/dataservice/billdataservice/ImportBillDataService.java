package dataservice.billdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ImportBillPO;

public interface ImportBillDataService {
	public void insert(ImportBillPO po) throws RemoteException;
	public void delete(ImportBillPO po) throws RemoteException;
	public void update(ImportBillPO po) throws RemoteException;
	public ImportBillPO find(long id) throws RemoteException;
	public ArrayList<ImportBillPO> finds(String field) throws RemoteException;
}
