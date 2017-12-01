package vo;

import po.PricePromotionPO;

public class PricePromotionVO {
	long id;
	double priceline;
	double discount;
	int coupon;
	
	public PricePromotionVO(long id,double priceline,double discount,int coupon) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.discount=discount;
		this.priceline=priceline;
		this.coupon=coupon;
	}
	public PricePromotionPO toPricePromotionPO(){
		return new PricePromotionPO(id,discount,priceline,coupon);
	}
	
	public long getID(){
		return id;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	public double getPriceline() {
		return priceline;
	}
}
