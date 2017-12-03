package data.promotiondata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.lang.model.element.PackageElement;

import dataservice.promotiondataservice.PackagePromotionDataService;
import po.PackagePromotionPO;

/**
 * 
 * @author shisj
 *
 */
public class PackagePromotionDataImpl implements PackagePromotionDataService {

	@Override
	public boolean insert(PackagePromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(PackagePromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(PackagePromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<PackagePromotionPO> findPackagePromotions() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
