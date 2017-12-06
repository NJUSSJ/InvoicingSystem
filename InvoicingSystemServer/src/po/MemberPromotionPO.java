package po;

import java.io.Serializable;

public class MemberPromotionPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long id;
	int rank;
	String giftlist;//ÔùÆ·
	int coupon;
	public MemberPromotionPO(long id,int rank,String giftlist,int coupon){
		this.id=id;
		this.rank=rank;
		this.giftlist=giftlist;
		this.coupon=coupon;
	}
	public long getID(){
		return id;
	}
	public int getRank(){
		return rank;
	}
	public String getGiftlist(){
		return giftlist;
	}
	public int getCoupon(){
		return coupon;
	}
}
