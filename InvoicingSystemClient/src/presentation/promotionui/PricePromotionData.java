package presentation.promotionui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import vo.PricePromotionVO;

public class PricePromotionData {
	StringProperty pricelinePro;
	StringProperty giftPro;
	StringProperty couponPro;
	PricePromotionVO promotion;
	public PricePromotionData(PricePromotionVO promotion){
		this.promotion=promotion;
		pricelinePro=new SimpleStringProperty(promotion.getPriceline()+"");
		giftPro=new SimpleStringProperty(promotion.getGifts().getNumInfo()+"");
		couponPro=new SimpleStringProperty(promotion.getCoupon()+"");
	}
	public StringProperty getPricelineProperty() {
		return pricelinePro;
	}
	public StringProperty getGiftProperty() {
		return giftPro;
	}
	public StringProperty getCouponProperty() {
		return couponPro;
	}
	public PricePromotionVO getVO(){
		return promotion;
	}
	
}
