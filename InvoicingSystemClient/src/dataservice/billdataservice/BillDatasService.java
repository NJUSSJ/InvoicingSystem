package dataservice.billdataservice;

import java.rmi.RemoteException;

import po.BillPO;

public interface BillDatasService {
	public BillPO importBill (BillPO ib) throws RemoteException;
	public BillPO exportBill (BillPO ib) throws RemoteException;
	public BillPO salesBill (BillPO ib) throws RemoteException;
	public BillPO salesExportBill(BillPO ib) throws RemoteException;
	public BillPO payBillPO (BillPO pb) throws RemoteException;
	public BillPO getMoneyBill(BillPO gb) throws RemoteException;
	public BillPO giftBill(BillPO gb) throws RemoteException;
	public BillPO cashBill(BillPO cb) throws RemoteException;
	public BillPO overBill(BillPO ob) throws RemoteException;
	public BillPO damageBill(BillPO db) throws RemoteException;
	public BillPO warnBill(BillPO wb) throws RemoteException;
	public void delete(BillPO b) throws RemoteException;
	public BillPO find(int id) throws RemoteException;
	public void init() throws RemoteException;
	public void finish() throws RemoteException;
}
