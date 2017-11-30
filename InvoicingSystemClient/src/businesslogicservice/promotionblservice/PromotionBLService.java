package businesslogicservice.promotionblservice;

import java.util.ArrayList;

import po.MemberPromotionPO;
import po.PackagePromotionPO;
import po.PricePromotionPO;
import vo.MemberPromotionVO;
import vo.PackagePromotionVO;
import vo.PricePromotionVO;
import vo.PromotionVO;

public interface PromotionBLService {
	public boolean addMemberPromotionVO(MemberPromotionVO memberPromotionVO);
	public boolean addPackagePromotionVO(PackagePromotionVO packagePromotionVO);
	public boolean addPricePromotionVO(PricePromotionVO pricePromoionVO);
	public boolean deleteMemberPromotionVO(MemberPromotionVO memberPromotionVO);
	public boolean deletePackagePromotionVO(PackagePromotionVO packagePromotionVO);
	public boolean deletePricePromotionVO(PricePromotionVO pricePromoionVO);
	public ArrayList<MemberPromotionVO> findMemberPromotionVO();
	public ArrayList<PackagePromotionVO> findPackagePromotionVO();
	public ArrayList<PricePromotionVO> findPricePromotionVO();
	public MemberPromotionVO toMemberPromotionVO(MemberPromotionPO memberPromotionPO);
	public PackagePromotionVO toPackagePromotionVO(PackagePromotionPO packagePromotionPO);
	public PricePromotionVO toPricePromotionVO(PricePromotionPO pricePromotionPO);
	
}
