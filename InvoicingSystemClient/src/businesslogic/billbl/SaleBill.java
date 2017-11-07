package businesslogic.billbl;

import java.util.ArrayList;

import businesslogicservice.billblservice.SaleBillBLService;
import vo.MemberPromotionVO;
import vo.PackagePromotionVO;
import vo.PricePromotionVO;
import vo.SaleBillVO;

public class SaleBill implements SaleBillBLService {
	CommodityList list;
	PricePromotionVO pricePromotion;
	MemberPromotionVO memberPromotipn;
	PackagePromotionVO packagePromotion;
	SaleBillVO salelist;
	@Override
	public ArrayList<CommodityLineItem> getCommoditys(String field) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void addCommodityItem(CommodityLineItem item) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteCommodityItem(CommodityLineItem item) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setPromotion() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public SaleBillVO toBillVO(long id, String user, String member, int sum, CommodityList list, int time) {
		// TODO Auto-generated method stub
		salelist=new SaleBillVO(id, user, member, list, sum, time);
		return salelist;
	}
	@Override
	public String conveyBill(SaleBillVO salebill) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public SaleBillVO checkBill(SaleBillVO salebill) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
