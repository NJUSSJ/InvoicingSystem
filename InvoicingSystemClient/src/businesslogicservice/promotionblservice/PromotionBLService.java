package businesslogicservice.promotionblservice;

import java.util.ArrayList;

import po.MemberPromotionPO;
import po.PackagePromotionPO;
import po.PricePromotionPO;
import vo.MemberPromotionVO;
import vo.PackagePromotionVO;
import vo.PricePromotionVO;

public interface PromotionBLService {
	public boolean addMemberPromotion(MemberPromotionVO memberPromotionVO);
	public boolean addPackagePromotion(PackagePromotionVO packagePromotionVO);
	public boolean addPricePromotion(PricePromotionVO pricePromoionVO);
	public boolean deleteMemberPromotion(MemberPromotionVO memberPromotionVO);
	public boolean deletePackagePromotion(PackagePromotionVO packagePromotionVO);
	public boolean deletePricePromotion(PricePromotionVO pricePromoionVO);
	public ArrayList<MemberPromotionVO> findMemberPromotions();
	public ArrayList<PackagePromotionVO> findPackagePromotions();
	public ArrayList<PricePromotionVO> findPricePromotions();
	public MemberPromotionVO toMemberPromotion(MemberPromotionPO memberPromotionPO);
	public PackagePromotionVO toPackagePromotion(PackagePromotionPO packagePromotionPO);
	public PricePromotionVO toPricePromotion(PricePromotionPO pricePromotionPO);
	public ArrayList<MemberPromotionVO> findMemberPromotionByRank(int rank);

}
