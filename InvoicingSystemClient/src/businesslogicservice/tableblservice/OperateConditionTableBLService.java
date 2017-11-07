package businesslogicservice.tableblservice;

import java.util.ArrayList;

import businesslogic.tablebl.TradeBillItem;
import vo.OperateConditionTableVO;

/**
 * 
 * @author yrz:经营情况表 bl接口
 */
public interface OperateConditionTableBLService {
	public void setTime(int begin,int end);
	public void addTradeBillItem(TradeBillItem item);
	public void deleteTradeBillItem(TradeBillItem item);
	public double calculateIncome(ArrayList<TradeBillItem> list);
	public double calculateExpense(ArrayList<TradeBillItem> list);
	public double calculateProfit();
	public OperateConditionTableVO toOperateConditionTableVO();
}
