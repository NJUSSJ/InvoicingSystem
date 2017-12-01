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
		// TODO 自动生成的方法存根
		return memberPromotionImpl.addMemberPromotionVO(memberPromotionVO);
	}

	@Override
	public boolean addPackagePromotion(PackagePromotionVO packagePromotionVO) {
		// TODO 自动生成的方法存根
		return packagePromotionImpl.addPackagePromotionVO(packagePromotionVO);
	}

	@Override
	public boolean addPricePromotion(PricePromotionVO pricePromoionVO) {
		// TODO 自动生成的方法存根
		return pricePromotionImpl.addPricePromotionVO(pricePromoionVO);
	}

	@Override
	public boolean deleteMemberPromotion(MemberPromotionVO memberPromotionVO) {
		// TODO 自动生成的方法存根
		return memberPromotionImpl.deleteMemberPromotionVO(memberPromotionVO);
	}

	@Override
	public boolean deletePackagePromotion(PackagePromotionVO packagePromotionVO) {
		// TODO 自动生成的方法存根
		return packagePromotionImpl.deletePackagePromotionVO(packagePromotionVO);
	}

	@Override
	public boolean deletePricePromotion(PricePromotionVO pricePromoionVO) {
		// TODO 自动生成的方法存根
		return pricePromotionImpl.deletePricePromotionVO(pricePromoionVO);
	}

	@Override
	public ArrayList<MemberPromotionVO> findMemberPromotion() {
		// TODO 自动生成的方法存根
		return memberPromotionImpl.findMemberPromotionVO();
	}

	@Override
	public ArrayList<PackagePromotionVO> findPackagePromotion() {
		// TODO 自动生成的方法存根
		return packagePromotionImpl.findPackagePromotionVO();
	}

	@Override
	public ArrayList<PricePromotionVO> findPricePromotion() {
		// TODO 自动生成的方法存根
		return pricePromotionImpl.findPricePromotionVO();
	}

	@Override
	public MemberPromotionVO toMemberPromotion(MemberPromotionPO memberPromotionPO) {
		// TODO 自动生成的方法存根
		return memberPromotionImpl.toMemberPromotionVO(memberPromotionPO);
	}

	@Override
	public PackagePromotionVO toPackagePromotion(PackagePromotionPO packagePromotionPO) {
		// TODO 自动生成的方法存根
		return packagePromotionImpl.toPackagePromotionVO(packagePromotionPO);
	}

	@Override
	public PricePromotionVO toPricePromotion(PricePromotionPO pricePromotionPO) {
		// TODO 自动生成的方法存根
		return pricePromotionImpl.toPricePromotionVO(pricePromotionPO);
	}

	@Override
	public ArrayList<MemberPromotionVO> findMemberPromotionByRank() {
		// TODO 自动生成的方法存根
		return null;
	}

	
}
