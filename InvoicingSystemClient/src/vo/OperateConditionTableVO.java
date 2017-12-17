package vo;

import java.sql.Date;

public class OperateConditionTableVO {
	Date begin;
	Date end;
	double saleIncome;//销售折后收入
	double saleOriginIncome;//销售折前收入 (不用于计算)
	double overIncome;//报溢收入
	double importReturnIncome;//退货收入
	double couponIncome;//代金券差额收入
	double importExpense;//进货支出
	double lossExpense;//商品报损支出
	double giftExpense;//赠品支出
	double saleReturnExpense;//销售退货支出
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
