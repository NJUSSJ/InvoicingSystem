package businesslogic.tablebl;

import java.util.ArrayList;

import businesslogicservice.tableblservice.OperateConditionTableBLService;
import vo.OperateConditionTableVO;
/**
 * 
 * @author yrz:��Ӫ�����
 *
 */
public class OperateConditionTable  implements OperateConditionTableBLService{
	int  beginTime;
	int  endTime;
	ArrayList<TradeBillItem> list;
	double profit;
	double income;
	double expense;
	@Override
	public void setTime(int  begin, int end) {
		// TODO �Զ����ɵķ������
		this.beginTime=begin;
		this.endTime=end;
	}

	@Override
	public void addTradeBillItem(TradeBillItem item) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void deleteTradeBillItem(TradeBillItem item) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public double calculateIncome(ArrayList<TradeBillItem> list) {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public double calculateExpense(ArrayList<TradeBillItem> list) {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public double calculateProfit() {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public OperateConditionTableVO toOperateConditionTableVO() {
		// TODO �Զ����ɵķ������
		return null;
	}

}
