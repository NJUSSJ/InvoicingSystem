package businesslogic.billbl;

import java.util.ArrayList;

import businesslogicservice.billblservice.ImportReturnBillBLService;
import vo.ImportReturnBillVO;

public class ImportReturnBill implements ImportReturnBillBLService {
	
	CommodityList list;
	ImportReturnBillVO importreturnbill;
	long id;
	String User;
	String Member;
	
	public ImportReturnBill(long id,String user,String member) {
		// TODO Auto-generated constructor stub
		this.id=id;this.User=user;this.Member=member;
	}
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
	
	public CommodityList getList() {
		return list;
	}
	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return list.getTotal();
	}
	@Override
	public ImportReturnBillVO toBillVO(long id, String user, String member, int sum, CommodityList list) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String conveyBill(ImportReturnBillVO importreturnbill) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ImportReturnBillVO checkBill(ImportReturnBillVO importreturnbill) {
		// TODO Auto-generated method stub
		return null;
	}
}
