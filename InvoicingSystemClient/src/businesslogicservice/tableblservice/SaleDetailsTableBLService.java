package businesslogicservice.tableblservice;

import java.util.ArrayList;

import businesslogic.tablebl.BillItem;
import vo.SaleDetailsTableVO;

public interface SaleDetailsTableBLService {
	public void setTime(int begin,int end);
	public void addBillItem(BillItem item);
	public void deleteBillItem(BillItem item);
	public ArrayList<BillItem> checkBillItem(String field);
	public SaleDetailsTableVO toSalesDetailsTableVO();
}