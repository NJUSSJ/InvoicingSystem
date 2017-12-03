package vo;

import java.util.ArrayList;

import businesslogic.billbl.CommodityList;
import po.MemberPromotionPO;

/**
 * 
 * 
 * @author yrz:针对用户的促销策略
 *
 */
public class MemberPromotionVO {
	long id;
	int rank;
	CommodityList gifts;
	int coupon;
	public MemberPromotionVO(long id,int rank,CommodityList gifts,int coupon){
		this.id=id;
		this.rank=rank;
		this.gifts=gifts;
		this.coupon=coupon;
	}
	public MemberPromotionPO toMemberPromotionPO(){
		return new MemberPromotionPO(id,rank,gifts.toString(),coupon);
	}
	public long getID(){
		return id;
	}
	public int getRank(){
		return rank;
	}
	public CommodityList getGifts(){
		return gifts;
	}
	public int getCoupon(){
		return coupon;
	}
	public void setRank(int rank){
		this.rank=rank;
	}
	public void setCoupon(int coupon){
		this.coupon=coupon;
	}
}

