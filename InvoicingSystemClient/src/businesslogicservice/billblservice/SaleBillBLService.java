package businesslogicservice.billblservice;

import java.util.ArrayList;

import businesslogic.billbl.CommodityLineItem;
import businesslogic.billbl.CommodityList;
import vo.PricePromotionVO;
import vo.SaleBillVO;

public interface SaleBillBLService {
	public ArrayList<CommodityLineItem> getCommoditys(String field);
	public void addCommodityItem(CommodityLineItem item);
	public void deleteCommodityItem(CommodityLineItem item);
	public void setPricePromotion(PricePromotionVO pricepromotion);
	public double getTotal();
	public SaleBillVO toBillVO(long id,String user,String member,int sum,CommodityList list,int time);
	public String conveyBill(SaleBillVO salebill);
	public SaleBillVO checkBill(SaleBillVO salebill);
}
