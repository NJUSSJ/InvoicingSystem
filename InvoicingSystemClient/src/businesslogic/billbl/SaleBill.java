package businesslogic.billbl;

import businesslogic.promotionbl.PricePromotion;
import businesslogicservice.billblservice.SaleBillBLService;
import po.SaleBillPO;
import vo.MemberPromotionVO;
import vo.PackagePromotionVO;
import vo.PricePromotionVO;
import vo.SaleBillVO;

public class SaleBill extends Bill implements SaleBillBLService {
	CommodityList list;
	PricePromotionVO pricePromotion;
	MemberPromotionVO memberPromotipn;
	PackagePromotionVO packagePromotion;
	
	public SaleBillPO makeSaleBill(SaleBillVO vo){
		return null;
	}
}
