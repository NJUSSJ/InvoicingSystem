package dataservice.commoditydataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CommodityPO;

public interface CommodityDataService {
	public CommodityPO findCommoditybyID(long id) throws RemoteException;
	public ArrayList<CommodityPO> findCommodities() throws RemoteException;
	public ArrayList<CommodityPO> findCommoditiesbyField(String field) throws RemoteException; 
	public CommodityPO findCommoditybyName(String name) throws RemoteException;
	public boolean insert(CommodityPO po) throws RemoteException;
	public boolean delete(CommodityPO po) throws RemoteException;
	public boolean update(CommodityPO po) throws RemoteException;
}
