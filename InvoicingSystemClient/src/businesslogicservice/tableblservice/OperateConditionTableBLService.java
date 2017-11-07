package businesslogicservice.tableblservice;

import java.util.ArrayList;
import businesslogic.tablebl.FinanceBillItem;
import vo.OperateConditionTableVO;

/**
 * 
 * @author yrz:经营情况表 bl接口
 */
public interface OperateConditionTableBLService {
	public void setTime(int begin,int end);
	public void addFinanceBillItem(FinanceBillItem item);
	public void deleteFinanceBillItem(FinanceBillItem item);
	public double getIncome();
	public double getExpense();
	public double getProfit();
	public OperateConditionTableVO toOperateConditionTableVO();
}
