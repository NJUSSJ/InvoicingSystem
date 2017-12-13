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
	double discount;
	CommodityList gifts;
	int coupon;
	public MemberPromotionVO(long id,int rank,double discount,CommodityList gifts,int coupon){
		this.id=id;
		this.rank=rank;
		this.discount=discount;
		this.gifts=gifts;
		this.coupon=coupon;
	}
	public MemberPromotionPO toMemberPromotionPO(){
		return new MemberPromotionPO(id,rank,discount,gifts.toString(),coupon);
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
	public CommodityList getGifts(){
		return gifts;
	}
	public int getCoupon(){
		return coupon;
	}
	public void setRank(int rank){
		this.rank=rank;
	}
	public void setDiscount(double discount){
		this.discount=discount;
	}
	public void setCoupon(int coupon){
		this.coupon=coupon;
	}
}

