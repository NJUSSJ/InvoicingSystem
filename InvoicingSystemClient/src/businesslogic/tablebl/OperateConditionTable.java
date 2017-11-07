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
	ArrayList<FinanceBillItem> inlist=new ArrayList<FinanceBillItem>();
	ArrayList<FinanceBillItem> outlist=new ArrayList<FinanceBillItem>();
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
	public void addFinanceBillItem(FinanceBillItem item) {
		// TODO 自动生成的方法存根
		if(item.money<0){
			outlist.add(item);
		}else{
			inlist.add(item);
		}
	}

	@Override
	public void deleteFinanceBillItem(FinanceBillItem item) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public double getIncome() {
		// TODO 自动生成的方法存根
		double sum=0;
		for(int i=0;i<inlist.size();i++){
			sum=sum+((MockFinanceBillItem)inlist.get(i)).getMoney();
		}
		return sum;
	}

	@Override
	public double getExpense() {
		// TODO 自动生成的方法存根
		double sum=0;
		for(int i=0;i<outlist.size();i++){
			sum+=((MockFinanceBillItem)outlist.get(i)).getMoney();
		}
		return sum;
	}

	@Override
	public double getProfit() {
		// TODO 自动生成的方法存根
		return getIncome()+getExpense();
	}

	@Override
	public OperateConditionTableVO toOperateConditionTableVO() {
		// TODO 自动生成的方法存根
		return null;
	}


}
