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
	SaleBillVO salebill;
	
	public SaleBill() {
		// TODO Auto-generated constructor stub
		this.list=new CommodityList();
	}
	@Override
	public ArrayList<CommodityLineItem> getCommoditys(String field) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void addCommodityItem(CommodityLineItem item) {
		// TODO Auto-generated method stub
		list.addCommodity(item);
	}
	@Override
	public void deleteCommodityItem(CommodityLineItem item) {
		// TODO Auto-generated method stub
		list.deleteCommodity(item);
		
	}
	@Override
	public void setPricePromotion(PricePromotionVO pricepromotion) {
		// TODO Auto-generated method stub
		this.pricePromotion=pricepromotion;
		
	}
	@Override
	public double getTotal() {
		// TODO Auto-generated method stub
		double total=list.getTotal();
		if(total>=pricePromotion.getPriceline()) {
			total=total*pricePromotion.getDiscount();
		}
		return total;
	}
	@Override
	public SaleBillVO toBillVO(long id, String user, String member, int sum, CommodityList list, int time) {
		// TODO Auto-generated method stub
		salebill=new SaleBillVO(id, user, member, list, sum, time);
		return salebill;
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
