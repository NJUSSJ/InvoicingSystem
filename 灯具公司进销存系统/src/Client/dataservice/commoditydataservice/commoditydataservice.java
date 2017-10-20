package Client.dataservice.commoditydataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import Client.po.CommodityPO;

public interface commoditydataservice {
	public CommodityPO find(long id) throws RemoteException;
	public ArrayList<CommodityPO> finds(long id,String field) throws RemoteException;
	public void insert(CommodityPO po) throws RemoteException;
	public void delete(CommodityPO po) throws RemoteException;
	public void update(CommodityPO po) throws RemoteException;
	public CommodityPO init() throws RemoteException;
	public void finish() throws RemoteException;

}
