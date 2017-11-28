package businesslogicservice.billblservice;

import java.sql.Date;
import java.util.ArrayList;

import businesslogic.billbl.CommodityLineItem;
import businesslogic.billbl.CommodityList;
import vo.MemberPromotionVO;
import vo.PackagePromotionVO;
import vo.PricePromotionVO;
import vo.SaleBillVO;

public interface SaleBillBLService {
	public ArrayList<CommodityLineItem> getCommoditys(String field);
	public void addCommodityItem(CommodityLineItem item);
	public void deleteCommodityItem(CommodityLineItem item);
	public void setPricePromotion(PricePromotionVO pricepromotion);
	public void setMemberPromotion(MemberPromotionVO memberpromotion);
	public void setPackagePromotion(PackagePromotionVO packagepromotion);
	public PricePromotionVO getPricePromotoin(int sum);
	public MemberPromotionVO getMemberPromotion(String member);
	public PackagePromotionVO getPackagePromotion(CommodityList list);
	public double getTotal();
	public SaleBillVO toBillVO(String id,long userid,long memberid,int sum,CommodityList list,Date time);
	public String conveyBill(SaleBillVO salebill);
	public SaleBillVO checkBill(SaleBillVO salebill);
}
