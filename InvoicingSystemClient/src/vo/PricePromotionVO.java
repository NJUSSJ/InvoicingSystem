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
	public double getPriceline() {
		return priceline;
	}
	public double getDiscount() {
		return discount;
	}
	public int getCoupon(){
		return coupon;
	}
	public void setPriceline(double priceline){
		this.priceline=priceline;
	}
	public void setDiscount(double discount){
		this.discount=discount;
	}
	public void setCoupon(int coupon){
		this.coupon=coupon;
	}
	
}
