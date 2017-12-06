package dataservice.billdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import po.GiftBillPO;

public interface GiftBillDataService extends Remote{
	public boolean insert(GiftBillPO po) throws RemoteException;
	public boolean delete(GiftBillPO po) throws RemoteException;
	public boolean update(GiftBillPO po) throws RemoteException;
	public GiftBillPO findGiftBillbyID(long id) throws RemoteException;
	public ArrayList<GiftBillPO> findGiftBillbyState(int state) throws RemoteException;
	public ArrayList<GiftBillPO> findGiftBills() throws RemoteException;
	public ArrayList<GiftBillPO> findGiftBillsbyTime(Date time) throws RemoteException;
}
