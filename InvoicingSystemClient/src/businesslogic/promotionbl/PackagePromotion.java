package businesslogic.promotionbl;

import java.util.ArrayList;

import po.PackagePromotionPO;
import vo.PackagePromotionVO;

public class PackagePromotion {
	public boolean addPackagePromotionVO(PackagePromotionVO packagePromotionVO){
		return false;
		
	}
	public boolean deletePackagePromotionVO(PackagePromotionVO packagePromotionVO){
		return false;
		
	}
	public ArrayList<PackagePromotionVO> findPackagePromotionVO(){
		return null;
		
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
