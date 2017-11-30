package stubs;

import vo.CommodityVO;
import vo.MemberPromotionVO;
import vo.PackagePromotionVO;
import vo.PricePromotionVO;
import vo.PromotionVO;

import java.util.ArrayList;

import businesslogicservice.promotionblservice.PromotionBLService;
import po.MemberPromotionPO;
import po.PackagePromotionPO;
import po.PricePromotionPO;
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
public boolean addMemberPromotionVO(MemberPromotionVO memberPromotionVO) {
	// TODO �Զ����ɵķ������
	return false;
}
@Override
public boolean addPackagePromotionVO(PackagePromotionVO packagePromotionVO) {
	// TODO �Զ����ɵķ������
	return false;
}
@Override
public boolean addPricePromotionVO(PricePromotionVO pricePromoionVO) {
	// TODO �Զ����ɵķ������
	return false;
}
@Override
public boolean deleteMemberPromotionVO(MemberPromotionVO memberPromotionVO) {
	// TODO �Զ����ɵķ������
	return false;
}
@Override
public boolean deletePackagePromotionVO(PackagePromotionVO packagePromotionVO) {
	// TODO �Զ����ɵķ������
	return false;
}
@Override
public boolean deletePricePromotionVO(PricePromotionVO pricePromoionVO) {
	// TODO �Զ����ɵķ������
	return false;
}
@Override
public ArrayList<MemberPromotionVO> findMemberPromotionVO() {
	// TODO �Զ����ɵķ������
	return null;
}
@Override
public ArrayList<PackagePromotionVO> findPackagePromotionVO() {
	// TODO �Զ����ɵķ������
	return null;
}
@Override
public ArrayList<PricePromotionVO> findPricePromotionVO() {
	// TODO �Զ����ɵķ������
	return null;
}
@Override
public MemberPromotionVO toMemberPromotionVO(MemberPromotionPO memberPromotionPO) {
	// TODO �Զ����ɵķ������
	return null;
}
@Override
public PackagePromotionVO toPackagePromotionVO(PackagePromotionPO packagePromotionPO) {
	// TODO �Զ����ɵķ������
	return null;
}
@Override
public PricePromotionVO toPricePromotionVO(PricePromotionPO pricePromotionPO) {
	// TODO �Զ����ɵķ������
	return null;
}


		   }