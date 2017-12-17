package businesslogic.promotionbl;

import java.util.ArrayList;

import businesslogicservice.promotionblservice.PromotionBLService;
import po.MemberPromotionPO;
import po.PackagePromotionPO;
import po.PricePromotionPO;
import vo.MemberPromotionVO;
import vo.PackagePromotionVO;
import vo.PricePromotionVO;

public class PromotionController implements PromotionBLService{
	MemberPromotion memberPromotionImpl=new MemberPromotion();
	PackagePromotion packagePromotionImpl=new PackagePromotion();
	PricePromotion pricePromotionImpl=new PricePromotion();
	@Override
	public boolean addMemberPromotion(MemberPromotionVO memberPromotionVO) {
		return memberPromotionImpl.addMemberPromotionVO(memberPromotionVO);
	}

	@Override
	public boolean addPackagePromotion(PackagePromotionVO packagePromotionVO) {
		return packagePromotionImpl.addPackagePromotionVO(packagePromotionVO);
	}

	@Override
	public boolean addPricePromotion(PricePromotionVO pricePromoionVO) {
		return pricePromotionImpl.addPricePromotionVO(pricePromoionVO);
	}

	@Override
	public boolean deleteMemberPromotion(MemberPromotionVO memberPromotionVO) {
		return memberPromotionImpl.deleteMemberPromotionVO(memberPromotionVO);
	}

	@Override
	public boolean deletePackagePromotion(PackagePromotionVO packagePromotionVO) {
		return packagePromotionImpl.deletePackagePromotionVO(packagePromotionVO);
	}

	@Override
	public boolean deletePricePromotion(PricePromotionVO pricePromoionVO) {
		return pricePromotionImpl.deletePricePromotionVO(pricePromoionVO);
	}

	@Override
	public ArrayList<MemberPromotionVO> findMemberPromotions() {
		return memberPromotionImpl.findMemberPromotions();
	}

	@Override
	public ArrayList<PackagePromotionVO> findPackagePromotions() {
		return packagePromotionImpl.findPackagePromotions();
	}

	@Override
	public ArrayList<PricePromotionVO> findPricePromotions() {
		return pricePromotionImpl.findPricePromotions();
	}

	@Override
	public MemberPromotionVO toMemberPromotion(MemberPromotionPO memberPromotionPO) {
		return memberPromotionImpl.toMemberPromotionVO(memberPromotionPO);
	}

	@Override
	public PackagePromotionVO toPackagePromotion(PackagePromotionPO packagePromotionPO) {
		return packagePromotionImpl.toPackagePromotionVO(packagePromotionPO);
	}

	@Override
	public PricePromotionVO toPricePromotion(PricePromotionPO pricePromotionPO) {
		return pricePromotionImpl.toPricePromotionVO(pricePromotionPO);
	}

	@Override
	public ArrayList<MemberPromotionVO> findMemberPromotionByRank(int rank) {
		return memberPromotionImpl.findMemberPromotionByRank(rank);
	}

	
}
