package businesslogic.billbl;

import java.util.ArrayList;

import businesslogicservice.billblservice.ImportBillBLService;
import vo.ImportBillVO;

public class ImportBill implements ImportBillBLService {

	CommodityList list;
	ImportBillVO importbill;
	long id;
	String User;
	String Member;
	
	
	
	public ImportBill(long id,String user,String member) {
		// TODO Auto-generated constructor stub
		this.id=id;this.User=user;this.Member=member;
		list=new CommodityList();
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
	
	public CommodityList getList() {
		return list;
	}
	
	public int getTotal() {
		return list.getTotal();
	}


	@Override
	public ImportBillVO toBillVO(long id, String user, String member, int sum, CommodityList list,int time) {
		// TODO Auto-generated method stub
		importbill=new ImportBillVO(id, user, member, list, sum, time);
		return importbill;
	}

	@Override
	public String conveyBill(ImportBillVO importbill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImportBillVO checkBill(ImportBillVO importbill) {
		// TODO Auto-generated method stub
		return null;
	}
}
