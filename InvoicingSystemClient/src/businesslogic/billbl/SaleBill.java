 package businesslogic.billbl;

import java.sql.Date;
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
	public SaleBillVO toBillVO(long id, long userid, long memberid, int sum, CommodityList list, Date time) {
		// TODO Auto-generated method stub
		this.salebill=new SaleBillVO(id, userid, memberid, list, sum, time);
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
	@Override
	public void setMemberPromotion(MemberPromotionVO memberpromotion) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setPackagePromotion(PackagePromotionVO packagepromotion) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public PricePromotionVO getPricePromotoin(int sum) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public MemberPromotionVO getMemberPromotion(String member) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public PackagePromotionVO getPackagePromotion(CommodityList list) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
