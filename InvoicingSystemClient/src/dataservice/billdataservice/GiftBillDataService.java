package dataservice.billdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.GiftBillPO;

public interface GiftBillDataService {
	public boolean insert(GiftBillPO po) throws RemoteException;
	public boolean delete(GiftBillPO po) throws RemoteException;
	public boolean update(GiftBillPO po) throws RemoteException;
	public ArrayList<GiftBillPO> findGiftBillbyState(int state) throws RemoteException;
	public ArrayList<GiftBillPO> finds(String field) throws RemoteException;
}
