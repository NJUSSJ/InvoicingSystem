package businesslogicservice.billblservice;

import java.util.ArrayList;

import businesslogic.billbl.CommodityLineItem;
import businesslogic.billbl.CommodityList;
import vo.ImportReturnBillVO;

public interface ImportReturnBillBLService {
	public ArrayList<CommodityLineItem> getCommoditys(String field);
	public void addCommodityItem(CommodityLineItem item);
	public void deleteCommodityItem(CommodityLineItem item);
	public int getTotal();
	public ImportReturnBillVO toBillVO(long id,String user,String member,int sum,CommodityList list);
	public String conveyBill(ImportReturnBillVO importreturnbill);
	public ImportReturnBillVO checkBill(ImportReturnBillVO importreturnbill);
}
