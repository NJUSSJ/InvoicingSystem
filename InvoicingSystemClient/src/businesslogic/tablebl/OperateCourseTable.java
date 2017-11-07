package businesslogic.tablebl;

import java.util.ArrayList;

import businesslogicservice.tableblservice.OperateCourseTableBLService;
import vo.OperateCourseTableVO;

/**
 * 
 * @author yrz:经营历程表
 *
 */
public class OperateCourseTable implements OperateCourseTableBLService{
	int beginTime,endTime;
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

	@Override
	public BillItem reverseBillItem(BillItem item) {
		// TODO 自动生成的方法存根
		if(item.getClass().toString().equals("class businesslogic.tablebl.MockFinanceBillItem")){
			MockFinanceBillItem temp=new MockFinanceBillItem(-((MockFinanceBillItem)item).getMoney());
			return temp;
		}
		return null;
	}

	@Override
	public BillItem reverseBillItemPlus(BillItem item) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public OperateCourseTableVO toOperateCourseTable() {
		// TODO 自动生成的方法存根
		return null;
	}

}
