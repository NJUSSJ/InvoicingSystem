package vo;

import java.util.ArrayList;

public class PromotionVO {
	   String promotion_type;
	   ArrayList<CommodityVO> gifts;
	   int memberrank;
	   double totalprice;
	   double[][] voucher;//总价，代金券（总价，用户）
	   double discount;//折扣(用户）
	   ArrayList<CommodityVO> commodity_group;
	   double discount_TotalPrice;//组合包中使用
	
	   public PromotionVO(String promotion_type,ArrayList<CommodityVO>  gifts,int memberrank,double totalprice,double[][] voucher,double discount,ArrayList<CommodityVO> commodity_group,double discount_TotalPrice){
		   this.promotion_type=promotion_type;
		   this.gifts=gifts;
		   this.memberrank=memberrank;
		   this.totalprice=totalprice;
		   this.voucher=voucher;
		   this.discount=discount;
		   this.commodity_group=commodity_group;
		   this.discount_TotalPrice=discount_TotalPrice;
	   }
}
