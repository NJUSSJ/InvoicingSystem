package po;

import java.io.Serializable;

public class PricePromotionPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long id;
	double priceLine;
	double discount;
	int coupon;
	
	public PricePromotionPO(long id,double priceLine,double discount,int coupon) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.discount=discount;
		this.priceLine=priceLine;
		this.coupon=coupon;
	}
	public long getID(){
		return id;
	}
	public double getPriceLine(){
		return priceLine;
	}
	public double getDiscount(){
		return discount;
	}
	public int getCoupon(){
		return coupon;
	}
}
