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
	public boolean addMemberPromotionVO(MemberPromotionVO memberPromotionVO) {
		// TODO 自动生成的方法存根
		return memberPromotionImpl.addMemberPromotionVO(memberPromotionVO);
	}

	@Override
	public boolean addPackagePromotionVO(PackagePromotionVO packagePromotionVO) {
		// TODO 自动生成的方法存根
		return packagePromotionImpl.addPackagePromotionVO(packagePromotionVO);
	}

	@Override
	public boolean addPricePromotionVO(PricePromotionVO pricePromoionVO) {
		// TODO 自动生成的方法存根
		return pricePromotionImpl.addPricePromotionVO(pricePromoionVO);
	}

	@Override
	public boolean deleteMemberPromotionVO(MemberPromotionVO memberPromotionVO) {
		// TODO 自动生成的方法存根
		return memberPromotionImpl.deleteMemberPromotionVO(memberPromotionVO);
	}

	@Override
	public boolean deletePackagePromotionVO(PackagePromotionVO packagePromotionVO) {
		// TODO 自动生成的方法存根
		return packagePromotionImpl.deletePackagePromotionVO(packagePromotionVO);
	}

	@Override
	public boolean deletePricePromotionVO(PricePromotionVO pricePromoionVO) {
		// TODO 自动生成的方法存根
		return pricePromotionImpl.deletePricePromotionVO(pricePromoionVO);
	}

	@Override
	public ArrayList<MemberPromotionVO> findMemberPromotionVO() {
		// TODO 自动生成的方法存根
		return memberPromotionImpl.findMemberPromotionVO();
	}

	@Override
	public ArrayList<PackagePromotionVO> findPackagePromotionVO() {
		// TODO 自动生成的方法存根
		return packagePromotionImpl.findPackagePromotionVO();
	}

	@Override
	public ArrayList<PricePromotionVO> findPricePromotionVO() {
		// TODO 自动生成的方法存根
		return pricePromotionImpl.findPricePromotionVO();
	}

	@Override
	public MemberPromotionVO toMemberPromotionVO(MemberPromotionPO memberPromotionPO) {
		// TODO 自动生成的方法存根
		return memberPromotionImpl.toMemberPromotionVO(memberPromotionPO);
	}

	@Override
	public PackagePromotionVO toPackagePromotionVO(PackagePromotionPO packagePromotionPO) {
		// TODO 自动生成的方法存根
		return packagePromotionImpl.toPackagePromotionVO(packagePromotionPO);
	}

	@Override
	public PricePromotionVO toPricePromotionVO(PricePromotionPO pricePromotionPO) {
		// TODO 自动生成的方法存根
		return pricePromotionImpl.toPricePromotionVO(pricePromotionPO);
	}

	
}
