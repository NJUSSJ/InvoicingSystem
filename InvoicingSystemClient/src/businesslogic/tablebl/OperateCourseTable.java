package businesslogic.tablebl;

import java.util.ArrayList;

import businesslogicservice.tableblservice.OperateCourseTableBLService;
import vo.OperateCourseTableVO;

/**
 * 
 * @author yrz:��Ӫ���̱�
 *
 */
public class OperateCourseTable implements OperateCourseTableBLService{
	int beginTime,endTime;
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

	@Override
	public BillItem reverseBillItem(BillItem item) {
		// TODO �Զ����ɵķ������
		if(item.getClass().toString().equals("class businesslogic.tablebl.MockFinanceBillItem")){
			MockFinanceBillItem temp=new MockFinanceBillItem(-((MockFinanceBillItem)item).getMoney());
			return temp;
		}
		return null;
	}

	@Override
	public BillItem reverseBillItemPlus(BillItem item) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public OperateCourseTableVO toOperateCourseTable() {
		// TODO �Զ����ɵķ������
		return null;
	}

}
