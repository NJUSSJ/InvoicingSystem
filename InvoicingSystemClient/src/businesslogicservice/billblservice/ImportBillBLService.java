package businesslogicservice.billblservice;

import java.sql.Date;
import java.util.ArrayList;

import businesslogic.billbl.CommodityLineItem;
import businesslogic.billbl.CommodityList;
import vo.ImportBillVO;

public interface ImportBillBLService  {
	public ArrayList<CommodityLineItem> getCommoditys(String field);
	public void addCommodityItem(CommodityLineItem item);
	public void deleteCommodityItem(CommodityLineItem item);
	public int getTotal();
	public ImportBillVO toBillVO(long id,long userid,long memberid,int sum,CommodityList list,Date time);
	public String conveyBill(ImportBillVO importbill);
	public ImportBillVO checkBill(ImportBillVO importbill);
}
