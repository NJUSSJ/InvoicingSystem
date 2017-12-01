package vo;

import java.util.ArrayList;

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
	ArrayList<Long> giftsid;//赠品
	int coupon;
	public MemberPromotionVO(long id,int rank,ArrayList<Long> giftsid,int coupon){
		this.id=id;
		this.rank=rank;
		this.giftsid=giftsid;
		this.coupon=coupon;
	}
	public MemberPromotionPO toMemberPromotionPO(){
		return new MemberPromotionPO(id,rank,giftsid,coupon);
	}
}
