package businesslogic.tablebl;
/**
 * 
 * @author yrz:�����൥��
 *
 */
public class FinanceBillItem extends BillItem{
	double money;
	public FinanceBillItem(double money){
		this.money=money;
	}
	public double getMoney(){
		return money;
	}
}
