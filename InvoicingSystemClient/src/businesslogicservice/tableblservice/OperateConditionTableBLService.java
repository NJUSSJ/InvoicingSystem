package businesslogicservice.tableblservice;

import java.util.ArrayList;
import businesslogic.tablebl.FinanceBillItem;
import vo.OperateConditionTableVO;

/**
 * 
 * @author yrz:��Ӫ����� bl�ӿ�
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
