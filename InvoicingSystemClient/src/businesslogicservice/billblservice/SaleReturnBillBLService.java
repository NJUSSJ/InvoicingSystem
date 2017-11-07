package businesslogicservice.billblservice;

import java.util.ArrayList;

import businesslogic.billbl.CommodityLineItem;
import businesslogic.billbl.CommodityList;
import vo.SaleReturnBillVO;

public interface SaleReturnBillBLService {
	public ArrayList<CommodityLineItem> getCommoditys(String field);
	public void addCommodityItem(CommodityLineItem item);
	public void deleteCommodityItem(CommodityLineItem item);
	public int getTotal();
	public SaleReturnBillVO toBillVO(long id,String user,String member,int sum,CommodityList list,int time);
	public String conveyBill(SaleReturnBillVO salebill);
	public SaleReturnBillVO checkBill(SaleReturnBillVO salebill);
}
