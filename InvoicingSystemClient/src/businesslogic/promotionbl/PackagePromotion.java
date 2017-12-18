package businesslogic.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.billbl.CommodityList;
import po.PackagePromotionPO;
import rmi.RemoteHelper;
import vo.PackagePromotionVO;

public class PackagePromotion {
	public boolean addPackagePromotionVO(PackagePromotionVO packagePromotionVO){
		try {
			return RemoteHelper.getInstance().getPackagePromotionDataService().
					insert(packagePromotionVO.toPackagePromotionPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean deletePackagePromotionVO(PackagePromotionVO packagePromotionVO){
		try {
			return RemoteHelper.getInstance().getPackagePromotionDataService().delete(packagePromotionVO.toPackagePromotionPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	public ArrayList<PackagePromotionVO> findPackagePromotions(){
		ArrayList<PackagePromotionVO> temp=null;
		try {
			temp=new ArrayList<PackagePromotionVO>();
			ArrayList<PackagePromotionPO> pp=RemoteHelper.getInstance().
					getPackagePromotionDataService().findPackagePromotions();
			for(int i=0;i<pp.size();i++){
				temp.add(toPackagePromotionVO(pp.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return temp;
		
	}
	public PackagePromotionVO toPackagePromotionVO(PackagePromotionPO packagePromotionPO){
		if(packagePromotionPO==null){
			return null;
		}
		return new PackagePromotionVO(packagePromotionPO.getID(),
		new CommodityList(packagePromotionPO.getCommodityID()),packagePromotionPO.getDiscount());	
	}
}
