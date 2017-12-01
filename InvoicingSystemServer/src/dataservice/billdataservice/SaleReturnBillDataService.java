package dataservice.billdataservice;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import po.SaleReturnBillPO;

public interface SaleReturnBillDataService {
	public boolean insert(SaleReturnBillPO po) throws RemoteException;
	public boolean delete(SaleReturnBillPO po) throws RemoteException;
	public boolean update(SaleReturnBillPO po) throws RemoteException;
	public SaleReturnBillPO findSaleReturnBillbyID(String id) throws RemoteException;
	public ArrayList<SaleReturnBillPO> findSaleReturnBills() throws RemoteException;
	public ArrayList<SaleReturnBillPO> findSaleReturnBillbyTime(Date time) throws RemoteException;
	public ArrayList<SaleReturnBillPO> findSaleReturnBillbyState(int state) throws RemoteException;
}
