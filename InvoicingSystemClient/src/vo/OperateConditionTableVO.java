package vo;

import java.sql.Date;

public class OperateConditionTableVO {
	Date begin;
	Date end;
	double saleIncome;//�����ۺ�����
	double saleOriginIncome;//������ǰ���� (�����ڼ���)
	double overIncome;//��������
	double importReturnIncome;//�˻�����
	double couponIncome;//����ȯ�������
	double importExpense;//����֧��
	double lossExpense;//��Ʒ����֧��
	double giftExpense;//��Ʒ֧��
	double saleReturnExpense;//�����˻�֧��
	double profit;
	public OperateConditionTableVO(Date begin,Date end,double saleIncome,double saleOriginIncome,
	double overIncome,double importReturnIncome,double couponIncome,double importExpense,double lossExpense,double giftExpense,
	double saleReturnExpense,double profit){
		this.begin=begin;
		this.end=end;
		this.saleIncome=saleIncome;
		this.saleOriginIncome=saleOriginIncome;
		this.overIncome=overIncome;
		this.importReturnIncome=importReturnIncome;
		this.couponIncome=couponIncome;
		this.importExpense=importExpense;
		this.lossExpense=lossExpense;
		this.giftExpense=giftExpense;
		this.saleReturnExpense=saleReturnExpense;
		this.profit=profit;
	}
	public Date getBegin(){
		return begin;
	}
	public Date getEnd(){
		return end;
	}
	public double getSaleIncome(){
		return saleIncome;
	}
	public double getSaleOriginIncome(){
		return saleOriginIncome;
	}
	public double getOverIncome(){
		return overIncome;
	}
	public double getImportReturnIncome(){
		return importReturnIncome;
	}
	public double getCouponIncome(){
		return couponIncome;
	}
	public double getImportExpense(){
		return importExpense;
	}
	public double getLossExpense(){
		return lossExpense;
	}
	public double getGiftExpense(){
		return giftExpense;
	}
	public double getSaleReturnExpense(){
		return saleReturnExpense;
	}
}
