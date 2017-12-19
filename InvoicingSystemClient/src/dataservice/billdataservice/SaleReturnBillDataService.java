package dataservice.billdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import po.SaleReturnBillPO;

public interface SaleReturnBillDataService extends Remote {
	public boolean insert(SaleReturnBillPO po) throws RemoteException;
	public boolean delete(SaleReturnBillPO po) throws RemoteException;
	public boolean update(SaleReturnBillPO po) throws RemoteException;
	public SaleReturnBillPO findSaleReturnBillbyID(long id) throws RemoteException;
	public ArrayList<SaleReturnBillPO> findSaleReturnBills() throws RemoteException;
	public ArrayList<SaleReturnBillPO> findSaleReturnBillbyTime(Date time) throws RemoteException;
	public ArrayList<SaleReturnBillPO> findSaleReturnBillbyState(int state) throws RemoteException;
	public ArrayList<SaleReturnBillPO> findSaleReturnBillbyField(String usesr,String member) throws RemoteException;
	public ArrayList<SaleReturnBillPO> findSaleReturnBillbyUser(long userid) throws RemoteException;
}
