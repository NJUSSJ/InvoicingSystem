package businesslogic.tablebl;

import java.util.ArrayList;

import businesslogicservice.tableblservice.OperateConditionTableBLService;
import vo.OperateConditionTableVO;
/**
 * 
 * @author yrz:经营情况表
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
		// TODO 自动生成的方法存根
		this.beginTime=begin;
		this.endTime=end;
	}

	@Override
	public void addTradeBillItem(TradeBillItem item) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void deleteTradeBillItem(TradeBillItem item) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public double calculateIncome(ArrayList<TradeBillItem> list) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public double calculateExpense(ArrayList<TradeBillItem> list) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public double calculateProfit() {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public OperateConditionTableVO toOperateConditionTableVO() {
		// TODO 自动生成的方法存根
		return null;
	}

}
