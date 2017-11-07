package businesslogic.tablebl;

import java.util.ArrayList;

import businesslogicservice.tableblservice.SaleDetailsTableBLService;

/**
 * 
 * @author yrz:销售明细表
 *
 */
public class SaleDetailsTable implements SaleDetailsTableBLService{
	int beginTime;
	int endTime;
	ArrayList<BillItem> list;
	@Override
	public void setTime(int begin, int end) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void addBillItem(BillItem item) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void deleteBillItem(BillItem item) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public ArrayList<BillItem> checkBillItem(String field) {
		// TODO 自动生成的方法存根
		return null;
	}

}
