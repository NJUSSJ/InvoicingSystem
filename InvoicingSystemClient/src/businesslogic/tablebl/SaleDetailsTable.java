package businesslogic.tablebl;

import java.util.ArrayList;

import businesslogicservice.tableblservice.SaleDetailsTableBLService;

/**
 * 
 * @author yrz:������ϸ��
 *
 */
public class SaleDetailsTable implements SaleDetailsTableBLService{
	int beginTime;
	int endTime;
	ArrayList<BillItem> list;
	@Override
	public void setTime(int begin, int end) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void addBillItem(BillItem item) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void deleteBillItem(BillItem item) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public ArrayList<BillItem> checkBillItem(String field) {
		// TODO �Զ����ɵķ������
		return null;
	}

}
