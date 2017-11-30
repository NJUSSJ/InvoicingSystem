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
   double[][] voucher;//总价，代金券（总价，用户）
   double discount;//折扣(用户）
   ArrayList<CommodityVO> commodity_group;
   double discount_TotalPrice;//组合包中使用
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
	// TODO 自动生成的方法存根
	return false;
}
@Override
public boolean addPackagePromotionVO(PackagePromotionVO packagePromotionVO) {
	// TODO 自动生成的方法存根
	return false;
}
@Override
public boolean addPricePromotionVO(PricePromotionVO pricePromoionVO) {
	// TODO 自动生成的方法存根
	return false;
}
@Override
public boolean deleteMemberPromotionVO(MemberPromotionVO memberPromotionVO) {
	// TODO 自动生成的方法存根
	return false;
}
@Override
public boolean deletePackagePromotionVO(PackagePromotionVO packagePromotionVO) {
	// TODO 自动生成的方法存根
	return false;
}
@Override
public boolean deletePricePromotionVO(PricePromotionVO pricePromoionVO) {
	// TODO 自动生成的方法存根
	return false;
}
@Override
public ArrayList<MemberPromotionVO> findMemberPromotionVO() {
	// TODO 自动生成的方法存根
	return null;
}
@Override
public ArrayList<PackagePromotionVO> findPackagePromotionVO() {
	// TODO 自动生成的方法存根
	return null;
}
@Override
public ArrayList<PricePromotionVO> findPricePromotionVO() {
	// TODO 自动生成的方法存根
	return null;
}
@Override
public MemberPromotionVO toMemberPromotionVO(MemberPromotionPO memberPromotionPO) {
	// TODO 自动生成的方法存根
	return null;
}
@Override
public PackagePromotionVO toPackagePromotionVO(PackagePromotionPO packagePromotionPO) {
	// TODO 自动生成的方法存根
	return null;
}
@Override
public PricePromotionVO toPricePromotionVO(PricePromotionPO pricePromotionPO) {
	// TODO 自动生成的方法存根
	return null;
}


		   }