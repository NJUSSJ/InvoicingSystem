package vo;

import businesslogic.billbl.CommodityList;
import po.PricePromotionPO;

public class PricePromotionVO {
	long id;
	double priceline;
	CommodityList gifts;
	int coupon;
	
	public PricePromotionVO(long id,double priceline,CommodityList gifts,int coupon) {
		this.id=id;
		this.priceline=priceline;
		this.gifts=gifts;
		this.coupon=coupon;
	}
	public PricePromotionPO toPricePromotionPO(){
		return new PricePromotionPO(id,priceline,gifts.toString(),coupon);
	}
	
	public long getID(){
		return id;
	}
	public double getPriceline(){
		return priceline;
	}
	public CommodityList getGifts(){
		return gifts;
	}
	public int getCoupon(){
		return coupon;
	}
	
}
