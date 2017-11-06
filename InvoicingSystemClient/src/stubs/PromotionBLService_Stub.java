package stubs;

import vo.CommodityVO;
import vo.PromotionVO;

import java.util.ArrayList;

import businesslogicservice.promotionblservice.PromotionBLService;
public class PromotionBLService_Stub implements PromotionBLService {
   PromotionVO pt;
   String promotion_type;
   ArrayList<CommodityVO> gifts;
   int memberrank;
   double totalprice;
   double[][] voucher;//�ܼۣ�����ȯ���ܼۣ��û���
   double discount;//�ۿ�(�û���
   ArrayList<CommodityVO> commodity_group;
   double discount_TotalPrice;//��ϰ���ʹ��
   public PromotionBLService_Stub(String promotion_type,ArrayList<CommodityVO>  gifts,int memberrank,double totalprice,double[][] voucher,double discount,ArrayList<CommodityVO> commodity_group,double discount_TotalPrice){
	   this.promotion_type=promotion_type;
	   this.gifts=gifts;
	   this.memberrank=memberrank;
	   this.totalprice=totalprice;
	   this.voucher=voucher;
	   this.discount=discount;
	   this.commodity_group=commodity_group;
	   this.discount_TotalPrice=discount_TotalPrice;
   }
   @Override
   public void addPromotion(PromotionVO vo){
	   System.out.println("create Promotion Strategy successed");
   }
   @Override
   public void deletePromotion(long id){
	   System.out.println("delete Promotion Strategy successed");
   }
   @Override
   public ArrayList<PromotionVO> getPromotinoList(String field,long id){
	   
	   System.out.println("Get PromotionList Succeed");
	   return null;
   }
@Override
public PromotionVO getPromotion(long id) {
	// TODO Auto-generated method stub
	return null;
}


		   }