package dataservice.commoditydataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CommodityPO;

public interface CommodityDataService {
	public CommodityPO findCommoditybyID(long id) throws RemoteException;
	public ArrayList<CommodityPO> findCommodities(long id,String field) throws RemoteException;
	public void insert(CommodityPO po) throws RemoteException;
	public void delete(CommodityPO po) throws RemoteException;
	public void update(CommodityPO po) throws RemoteException;
}
