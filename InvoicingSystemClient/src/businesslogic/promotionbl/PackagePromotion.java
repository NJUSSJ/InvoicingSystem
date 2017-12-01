package businesslogic.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PackagePromotionPO;
import rmi.RemoteHelper;
import vo.PackagePromotionVO;

public class PackagePromotion {
	public boolean addPackagePromotionVO(PackagePromotionVO packagePromotionVO){
		try {
			return RemoteHelper.getInstance().getPackagePromotionDataService().
					insert(packagePromotionVO.toPackagePromotionPO());
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean deletePackagePromotionVO(PackagePromotionVO packagePromotionVO){
		try {
			return RemoteHelper.getInstance().getPackagePromotionDataService().delete(packagePromotionVO.toPackagePromotionPO());
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
		
	}
	public ArrayList<PackagePromotionVO> findPackagePromotionVO(){
		ArrayList<PackagePromotionVO> temp=null;
		try {
			temp=new ArrayList<PackagePromotionVO>();
			ArrayList<PackagePromotionPO> pp=RemoteHelper.getInstance().
					getPackagePromotionDataService().findPackagePromotions();
			for(int i=0;i<pp.size();i++){
				temp.add(toPackagePromotionVO(pp.get(i)));
			}
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return temp;
		
	}
	public PackagePromotionVO toPackagePromotionVO(PackagePromotionPO packagePromotionPO){
		ArrayList<Long> commodityid=new ArrayList<Long>();
		String[] temp=packagePromotionPO.getCommodityID().split(" ");
		for(int i=0;i<temp.length;i++){
			commodityid.add(Long.parseLong(temp[i]));
		}
		return new PackagePromotionVO(packagePromotionPO.getID(),commodityid,packagePromotionPO.getDiscount());
		
	}
}
