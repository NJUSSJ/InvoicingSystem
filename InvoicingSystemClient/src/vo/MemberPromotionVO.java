package vo;

import java.util.ArrayList;

/**
 * 
 * 
 * @author yrz:����û��Ĵ�������
 *
 */
public class MemberPromotionVO {
	long id;
	int rank;
	ArrayList<Long> giftsid;//��Ʒ
	int coupon;
	public MemberPromotionVO(long id,int rank,ArrayList<Long> giftsid,int coupon){
		this.id=id;
		this.rank=rank;
		this.giftsid=giftsid;
		this.coupon=coupon;
	}
}
