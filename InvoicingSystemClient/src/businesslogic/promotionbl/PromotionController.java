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
		// TODO �Զ����ɵķ������
		return memberPromotionImpl.addMemberPromotionVO(memberPromotionVO);
	}

	@Override
	public boolean addPackagePromotionVO(PackagePromotionVO packagePromotionVO) {
		// TODO �Զ����ɵķ������
		return packagePromotionImpl.addPackagePromotionVO(packagePromotionVO);
	}

	@Override
	public boolean addPricePromotionVO(PricePromotionVO pricePromoionVO) {
		// TODO �Զ����ɵķ������
		return pricePromotionImpl.addPricePromotionVO(pricePromoionVO);
	}

	@Override
	public boolean deleteMemberPromotionVO(MemberPromotionVO memberPromotionVO) {
		// TODO �Զ����ɵķ������
		return memberPromotionImpl.deleteMemberPromotionVO(memberPromotionVO);
	}

	@Override
	public boolean deletePackagePromotionVO(PackagePromotionVO packagePromotionVO) {
		// TODO �Զ����ɵķ������
		return packagePromotionImpl.deletePackagePromotionVO(packagePromotionVO);
	}

	@Override
	public boolean deletePricePromotionVO(PricePromotionVO pricePromoionVO) {
		// TODO �Զ����ɵķ������
		return pricePromotionImpl.deletePricePromotionVO(pricePromoionVO);
	}

	@Override
	public ArrayList<MemberPromotionVO> findMemberPromotionVO() {
		// TODO �Զ����ɵķ������
		return memberPromotionImpl.findMemberPromotionVO();
	}

	@Override
	public ArrayList<PackagePromotionVO> findPackagePromotionVO() {
		// TODO �Զ����ɵķ������
		return packagePromotionImpl.findPackagePromotionVO();
	}

	@Override
	public ArrayList<PricePromotionVO> findPricePromotionVO() {
		// TODO �Զ����ɵķ������
		return pricePromotionImpl.findPricePromotionVO();
	}

	@Override
	public MemberPromotionVO toMemberPromotionVO(MemberPromotionPO memberPromotionPO) {
		// TODO �Զ����ɵķ������
		return memberPromotionImpl.toMemberPromotionVO(memberPromotionPO);
	}

	@Override
	public PackagePromotionVO toPackagePromotionVO(PackagePromotionPO packagePromotionPO) {
		// TODO �Զ����ɵķ������
		return packagePromotionImpl.toPackagePromotionVO(packagePromotionPO);
	}

	@Override
	public PricePromotionVO toPricePromotionVO(PricePromotionPO pricePromotionPO) {
		// TODO �Զ����ɵķ������
		return pricePromotionImpl.toPricePromotionVO(pricePromotionPO);
	}

	
}
