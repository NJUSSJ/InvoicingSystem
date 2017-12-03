package data.promotiondata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.promotiondataservice.PricePromotionDataService;
import po.PricePromotionPO;

/**
 * 
 * @author shisj
 *
 */
public class PricePromotionDataImpl implements PricePromotionDataService{

	@Override
	public boolean insert(PricePromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(PricePromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(PricePromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<PricePromotionPO> findPricePromotions() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
