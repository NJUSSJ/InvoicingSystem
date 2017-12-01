package businesslogic.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PricePromotionPO;
import rmi.RemoteHelper;
import vo.PricePromotionVO;

public class PricePromotion {
	public boolean addPricePromotionVO(PricePromotionVO pricePromotionVO){
		try {
			return RemoteHelper.getInstance().getPricePromotionDataService().
					insert(pricePromotionVO.toPricePromotionPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean deletePricePromotionVO(PricePromotionVO pricePromotionVO){
		try {
			return RemoteHelper.getInstance().getPricePromotionDataService().
					delete(pricePromotionVO.toPricePromotionPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
		
	}
	public ArrayList<PricePromotionVO> findPricePromotionVO(){
		ArrayList<PricePromotionVO> temp=null;
		try {
			temp=new ArrayList<PricePromotionVO>();
			ArrayList<PricePromotionPO> pp=RemoteHelper.getInstance().
					getPricePromotionDataService().findPricePromotions();
			for(int i=0;i<pp.size();i++){
				temp.add(toPricePromotionVO(pp.get(i)));
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return temp;
		
	}
	public PricePromotionVO toPricePromotionVO(PricePromotionPO pricePromotionPO){
		return new PricePromotionVO(pricePromotionPO.getID(),pricePromotionPO.getPriceLine(),
				pricePromotionPO.getDiscount(),pricePromotionPO.getCoupon());
		
	}
}
