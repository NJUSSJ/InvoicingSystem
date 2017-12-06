package dataservice.promotiondataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PricePromotionPO;

public interface PricePromotionDataService extends Remote{
	public boolean insert(PricePromotionPO po) throws RemoteException;
	public boolean delete(PricePromotionPO po) throws RemoteException;
	public boolean update(PricePromotionPO po) throws RemoteException;
	public ArrayList<PricePromotionPO> findPricePromotions() throws RemoteException;
	
}
