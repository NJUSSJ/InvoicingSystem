package businesslogicservice.billblservice;

import java.sql.Date;
import java.util.ArrayList;

import businesslogic.billbl.CommodityLineItem;
import businesslogic.billbl.CommodityList;
import vo.SaleReturnBillVO;

public interface SaleReturnBillBLService {
	public ArrayList<CommodityLineItem> getCommoditys(String field);
	public void addCommodityItem(CommodityLineItem item);
	public void deleteCommodityItem(CommodityLineItem item);
	public int getTotal();
	public SaleReturnBillVO toBillVO(String id,long user,long member,int sum,CommodityList list,Date time);
	public String conveyBill(SaleReturnBillVO salebill);
	public SaleReturnBillVO checkBill(SaleReturnBillVO salebill);
}
