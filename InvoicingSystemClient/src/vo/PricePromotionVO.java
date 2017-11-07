package vo;

public class PricePromotionVO {
	double priceline;
	double discount;
	
	public PricePromotionVO(double priceline,double discount) {
		// TODO Auto-generated constructor stub
		this.discount=discount;
		this.priceline=priceline;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	public double getPriceline() {
		return priceline;
	}
}
