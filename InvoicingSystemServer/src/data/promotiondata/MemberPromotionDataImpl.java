package data.promotiondata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.promotiondataservice.MemberPromotionDataService;
import po.MemberPromotionPO;
/**
 * 
 * @author shisj
 *
 */
public class MemberPromotionDataImpl implements MemberPromotionDataService{

	@Override
	public boolean insert(MemberPromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(MemberPromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(MemberPromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<MemberPromotionPO> findMemberPromotions() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MemberPromotionPO> findMemberPromotionsbyRank() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
