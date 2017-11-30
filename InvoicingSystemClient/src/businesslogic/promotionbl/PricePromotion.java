package businesslogic.promotionbl;

import java.util.ArrayList;

import po.PricePromotionPO;
import vo.PricePromotionVO;

public class PricePromotion {
	public boolean addPricePromotionVO(PricePromotionVO pricePromoionVO){
		return false;
		
	}
	public boolean deletePricePromotionVO(PricePromotionVO pricePromoionVO){
		return false;
		
	}
	public ArrayList<PricePromotionVO> findPricePromotionVO(){
		return null;
		
	}
	public PricePromotionVO toPricePromotionVO(PricePromotionPO pricePromotionPO){
		return new PricePromotionVO(pricePromotionPO.getID(),pricePromotionPO.getPriceLine(),
				pricePromotionPO.getDiscount(),pricePromotionPO.getCoupon());
		
	}
}
