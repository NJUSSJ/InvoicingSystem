package businesslogicservice.tableblservice;

import java.util.ArrayList;

import businesslogic.tablebl.BillItem;

/**
 * 
 * @author yrz:��Ӫ���̱� bl�ӿ�
 *
 */
public interface OperateCourseTableBLService {
	public void setTime(int begin,int end);
	public void addBillItem(BillItem item);
	public void deleteBillItem(BillItem item);
	public ArrayList<BillItem> checkBillItem(String field);
	public BillItem reverseBillItem(BillItem item);
	public BillItem reverseBillItemPlus(BillItem item);
}
