package businesslogic.commoditybl;

import java.util.ArrayList;

import businesslogic.billbl.CommodityLineItem;
import businesslogic.billbl.CommodityList;
import businesslogicservice.commodityblservice.StockCheckBLService;
import vo.CommodityVO;
import vo.ImportBillVO;
import vo.ImportReturnBillVO;
import vo.SaleBillVO;
import vo.SaleReturnBillVO;

public class StockCheck implements StockCheckBLService  {
	
	/**
	 * @author shisj
	 */
	int start_time;
	int end_time;
	
	
	
	public StockCheck(int s,int e) {
		// TODO Auto-generated constructor stub
		this.start_time=s;
		this.end_time=e;
	}
	@Override
	public int getInNum() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getOutNum() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getSaleNum() {
		// TODO Auto-generated method stub
		ArrayList<SaleBillVO> list=new ArrayList<>();
		CommodityList commoditylist=new CommodityList();
		commoditylist.addCommodity(new CommodityLineItem(new CommodityVO(null, end_time, null, end_time, end_time, end_time, end_time, end_time, end_time), 100));
		list.add(new MockSaleBillVO(null, end_time, end_time, commoditylist, end_time, end_time, null, null));
		int num=0;
		for(SaleBillVO s:list) {
			System.out.println(s.getnum());
			num+=s.getnum();
		}
		return num;
	}
	@Override
	public int getImportNum() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getInSum() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getOutSum() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getSaleSum() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getImportSum() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public ArrayList<ImportBillVO> getImportBills() {
		return new ArrayList<>();
	}
	
	public ArrayList<ImportReturnBillVO> getImportReturnBills() {
		return new ArrayList<>();
	}
	
	public ArrayList<SaleBillVO> getSaleBills(){
		return new ArrayList<>();
	}
	
	public ArrayList<SaleReturnBillVO> getSaleReturnBills(){
		return new ArrayList<>();
	}
	
	
}
