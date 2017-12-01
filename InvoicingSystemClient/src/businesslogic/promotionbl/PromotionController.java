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
		// TODO �Զ����ɵķ������
		return memberPromotionImpl.addMemberPromotionVO(memberPromotionVO);
	}

	@Override
	public boolean addPackagePromotion(PackagePromotionVO packagePromotionVO) {
		// TODO �Զ����ɵķ������
		return packagePromotionImpl.addPackagePromotionVO(packagePromotionVO);
	}

	@Override
	public boolean addPricePromotion(PricePromotionVO pricePromoionVO) {
		// TODO �Զ����ɵķ������
		return pricePromotionImpl.addPricePromotionVO(pricePromoionVO);
	}

	@Override
	public boolean deleteMemberPromotion(MemberPromotionVO memberPromotionVO) {
		// TODO �Զ����ɵķ������
		return memberPromotionImpl.deleteMemberPromotionVO(memberPromotionVO);
	}

	@Override
	public boolean deletePackagePromotion(PackagePromotionVO packagePromotionVO) {
		// TODO �Զ����ɵķ������
		return packagePromotionImpl.deletePackagePromotionVO(packagePromotionVO);
	}

	@Override
	public boolean deletePricePromotion(PricePromotionVO pricePromoionVO) {
		// TODO �Զ����ɵķ������
		return pricePromotionImpl.deletePricePromotionVO(pricePromoionVO);
	}

	@Override
	public ArrayList<MemberPromotionVO> findMemberPromotion() {
		// TODO �Զ����ɵķ������
		return memberPromotionImpl.findMemberPromotionVO();
	}

	@Override
	public ArrayList<PackagePromotionVO> findPackagePromotion() {
		// TODO �Զ����ɵķ������
		return packagePromotionImpl.findPackagePromotionVO();
	}

	@Override
	public ArrayList<PricePromotionVO> findPricePromotion() {
		// TODO �Զ����ɵķ������
		return pricePromotionImpl.findPricePromotionVO();
	}

	@Override
	public MemberPromotionVO toMemberPromotion(MemberPromotionPO memberPromotionPO) {
		// TODO �Զ����ɵķ������
		return memberPromotionImpl.toMemberPromotionVO(memberPromotionPO);
	}

	@Override
	public PackagePromotionVO toPackagePromotion(PackagePromotionPO packagePromotionPO) {
		// TODO �Զ����ɵķ������
		return packagePromotionImpl.toPackagePromotionVO(packagePromotionPO);
	}

	@Override
	public PricePromotionVO toPricePromotion(PricePromotionPO pricePromotionPO) {
		// TODO �Զ����ɵķ������
		return pricePromotionImpl.toPricePromotionVO(pricePromotionPO);
	}

	@Override
	public ArrayList<MemberPromotionVO> findMemberPromotionByRank() {
		// TODO �Զ����ɵķ������
		return null;
	}

	
}
