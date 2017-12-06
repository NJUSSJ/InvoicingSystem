package dataservice.promotiondataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PackagePromotionPO;

public interface PackagePromotionDataService extends Remote{
	public boolean insert(PackagePromotionPO po) throws RemoteException;
	public boolean delete(PackagePromotionPO po) throws RemoteException;
	public boolean update(PackagePromotionPO po) throws RemoteException;
	public ArrayList<PackagePromotionPO> findPackagePromotions() throws RemoteException;
}
