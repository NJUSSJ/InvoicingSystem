package vo;

import java.util.ArrayList;

public class PromotionVO {
	   String promotion_type;
	   ArrayList<CommodityVO> gifts;
	   int memberrank;
	   double totalprice;
	   double[][] voucher;//�ܼۣ�����ȯ���ܼۣ��û���
	   double discount;//�ۿ�(�û���
	   ArrayList<CommodityVO> commodity_group;
	   double discount_TotalPrice;//��ϰ���ʹ��
	
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
