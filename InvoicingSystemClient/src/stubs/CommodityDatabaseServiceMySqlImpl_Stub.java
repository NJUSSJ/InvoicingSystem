package stubs;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.commoditydataservice.CommodityDataService;
import po.CommodityPO;

public class CommodityDatabaseServiceMySqlImpl_Stub implements CommodityDataService{

	@Override
	public CommodityPO findCommoditybyID(long id) throws RemoteException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ArrayList<CommodityPO> findCommodities() throws RemoteException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ArrayList<CommodityPO> findCommoditiesbyField() throws RemoteException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public CommodityPO findCommoditybyName(String name) throws RemoteException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public boolean insert(CommodityPO po) throws RemoteException {
		// TODO �Զ����ɵķ������
		return false;
	}

	@Override
	public boolean delete(CommodityPO po) throws RemoteException {
		// TODO �Զ����ɵķ������
		return false;
	}

	@Override
	public boolean update(CommodityPO po) throws RemoteException {
		// TODO �Զ����ɵķ������
		return false;
	}
	
	
}
