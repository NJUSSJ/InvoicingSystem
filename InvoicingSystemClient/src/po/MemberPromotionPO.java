package po;

import java.io.Serializable;
import java.util.ArrayList;

public class MemberPromotionPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long id;
	int rank;
	String gifts;//ÔùÆ·
	int coupon;
	public MemberPromotionPO(long id,int rank,String gifts,int coupon){
		this.id=id;
		this.rank=rank;
		this.gifts=gifts;
		this.coupon=coupon;
	}
	public long getID(){
		return id;
	}
	public int getRank(){
		return rank;
	}
	public String getGifts(){
		return gifts;
	}
	public int getCoupon(){
		return coupon;
	}
}
