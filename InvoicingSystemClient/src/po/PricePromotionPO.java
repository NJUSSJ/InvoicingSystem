package po;

public class PricePromotionPO {
	long id;
	double priceline;
	double discount;
	int coupon;
	
	public PricePromotionPO(long id,double priceline,double discount,int coupon) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.discount=discount;
		this.priceline=priceline;
		this.coupon=coupon;
	}
}
