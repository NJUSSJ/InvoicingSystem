package presentation.promotionui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import vo.PricePromotionVO;

public class PricePromotionData {
	StringProperty pricelinePro;
	StringProperty discountPro;
	StringProperty couponPro;
	PricePromotionVO promotion;
	public PricePromotionData(PricePromotionVO promotion){
		this.promotion=promotion;
		pricelinePro=new SimpleStringProperty(promotion.getPriceline()+"");
		discountPro=new SimpleStringProperty(promotion.getDiscount()+"");
		couponPro=new SimpleStringProperty(promotion.getCoupon()+"");
	}
	public StringProperty getPricelineProperty() {
		// TODO Auto-generated method stub
		return pricelinePro;
	}
	public StringProperty getDiscountProperty() {
		// TODO Auto-generated method stub
		return discountPro;
	}
	public StringProperty getCouponProperty() {
		// TODO Auto-generated method stub
		return couponPro;
	}
	public PricePromotionVO getVO(){
		return promotion;
	}
	
}
