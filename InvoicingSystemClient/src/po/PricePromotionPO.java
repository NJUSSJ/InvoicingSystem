package po;

import java.io.Serializable;

public class PricePromotionPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long id;
	double priceline;
	String gifts;
	int coupon;
	
	public PricePromotionPO(long id,double priceline,String gifts,int coupon) {
		this.id=id;
		this.priceline=priceline;
		this.gifts=gifts;
		this.coupon=coupon;
	}
	public long getID(){
		return id;
	}
	public double getPriceline(){
		return priceline;
	}
	public String getGifts(){
		return gifts;
	}
	public int getCoupon(){
		return coupon;
	}
}
