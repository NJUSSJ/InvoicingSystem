package presentation.promotionui;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import vo.MemberPromotionVO;

public class MemberPromotionData {
	IntegerProperty rankPro;
	IntegerProperty couponPro;
	DoubleProperty discountPro;
	StringProperty giftPro;
	MemberPromotionVO vo;
	public MemberPromotionData(MemberPromotionVO vo){
		this.vo=vo;
		this.rankPro=new SimpleIntegerProperty(vo.getRank());
		this.couponPro=new SimpleIntegerProperty(vo.getCoupon());
		this.discountPro=new SimpleDoubleProperty(vo.getDiscount());
		this.giftPro=new SimpleStringProperty(vo.getGifts().getNumInfo());
	}
	public IntegerProperty getRankProperty(){
		return rankPro;
	}
	public IntegerProperty getCouponProperty(){
		return couponPro;
	}
	public DoubleProperty getDiscountProperty(){
		return discountPro;
	}
	public StringProperty getGiftProperty(){
		return giftPro;
	}
	public MemberPromotionVO getVO(){
		return vo;
	}
}
