package businesslogic.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.billbl.CommodityList;
import po.PricePromotionPO;
import rmi.RemoteHelper;
import vo.PricePromotionVO;

public class PricePromotion {
	public boolean addPricePromotionVO(PricePromotionVO pricePromotionVO){
		try {
			return RemoteHelper.getInstance().getPricePromotionDataService().
					insert(pricePromotionVO.toPricePromotionPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean deletePricePromotionVO(PricePromotionVO pricePromotionVO){
		try {
			return RemoteHelper.getInstance().getPricePromotionDataService().
					delete(pricePromotionVO.toPricePromotionPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	public ArrayList<PricePromotionVO> findPricePromotions(){
		ArrayList<PricePromotionVO> temp=null;
		try {
			temp=new ArrayList<PricePromotionVO>();
			ArrayList<PricePromotionPO> pp=RemoteHelper.getInstance().
					getPricePromotionDataService().findPricePromotions();
			for(int i=0;i<pp.size();i++){
				temp.add(toPricePromotionVO(pp.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return temp;
		
	}
	public PricePromotionVO toPricePromotionVO(PricePromotionPO pricePromotionPO){
		if(pricePromotionPO==null){
			return null;
		}
		return new PricePromotionVO(pricePromotionPO.getID(),pricePromotionPO.getPriceline(),
				new CommodityList(pricePromotionPO.getGifts()),pricePromotionPO.getCoupon());
	}
}
