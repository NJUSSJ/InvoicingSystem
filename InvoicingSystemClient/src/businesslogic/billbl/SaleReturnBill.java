package businesslogic.billbl;

import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.billblservice.SaleReturnBillBLService;
import vo.SaleReturnBillVO;

public class SaleReturnBill  implements SaleReturnBillBLService{
	
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
	public int getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public SaleReturnBillVO toBillVO(String id, long user, long member, int sum, CommodityList list, Date time) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String conveyBill(SaleReturnBillVO salebill) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public SaleReturnBillVO checkBill(SaleReturnBillVO salebill) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
