package dataservice.promotiondataservice;

import po.MemberPromotionPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface MemberPromotionDataService extends Remote{
	public boolean insert(MemberPromotionPO po) throws RemoteException;
	public boolean delete(MemberPromotionPO po) throws RemoteException;
	public boolean update(MemberPromotionPO po) throws RemoteException;
	public ArrayList<MemberPromotionPO> findMemberPromotions() throws RemoteException;
	public ArrayList<MemberPromotionPO> findMemberPromotionsbyRank(int rank) throws RemoteException;
}
