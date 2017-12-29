package po;

import java.io.Serializable;

public class MemberPromotionPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long id;
	int rank;
	double discount;
	String gifts;//ÔùÆ·
	int coupon;
	public MemberPromotionPO(long id,int rank,double discount,String gifts,int coupon){
		this.id=id;
		this.rank=rank;
		this.discount=discount;
		this.gifts=gifts;
		this.coupon=coupon;
	}
	public long getID(){
		return id;
	}
	public int getRank(){
		return rank;
	}
	public double getDiscount(){
		return discount;
	}
	public String getGifts(){
		return gifts;
	}
	public int getCoupon(){
		return coupon;
	}
}
