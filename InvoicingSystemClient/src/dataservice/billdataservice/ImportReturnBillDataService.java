package dataservice.billdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ImportReturnBillPO;

public interface ImportReturnBillDataService {
	public void insert(ImportReturnBillPO po) throws RemoteException;
	public void delete(ImportReturnBillPO po) throws RemoteException;
	public void update(ImportReturnBillPO po) throws RemoteException;
	public ImportReturnBillPO find(long id) throws RemoteException;
	public ArrayList<ImportReturnBillPO> finds(String field) throws RemoteException;
}
