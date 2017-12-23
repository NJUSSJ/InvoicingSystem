package dataservice.commoditydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CommodityPO;

public interface CommodityDataService extends Remote{
	public CommodityPO findCommoditybyID(long id) throws RemoteException;
	public ArrayList<CommodityPO> findCommodities() throws RemoteException;
	public ArrayList<CommodityPO> findCommoditiesbyField(String field) throws RemoteException; 
	public CommodityPO findCommoditybyName(String name) throws RemoteException;
	public ArrayList<CommodityPO> findCommoditiesbyParent(long parentid) throws RemoteException;
	public boolean insert(CommodityPO po) throws RemoteException;
	public boolean delete(CommodityPO po) throws RemoteException;
	public boolean update(CommodityPO po) throws RemoteException;
	public long getLargestIDofCommodity() throws RemoteException;
}
