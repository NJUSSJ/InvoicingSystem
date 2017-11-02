package dataservice.billdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.SaleReturnBillPO;

public interface SaleReturnBillDataService {
	public void insert(SaleReturnBillPO po) throws RemoteException;
	public void delete(SaleReturnBillPO po) throws RemoteException;
	public void update(SaleReturnBillPO po) throws RemoteException;
	public SaleReturnBillPO find(long id) throws RemoteException;
	public ArrayList<SaleReturnBillPO> finds(String field) throws RemoteException;
}
