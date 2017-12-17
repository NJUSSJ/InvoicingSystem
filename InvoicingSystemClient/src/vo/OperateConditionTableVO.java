package vo;

import java.sql.Date;

public class OperateConditionTableVO {
	Date begin;
	Date end;
	double saleIncome;//单纯的销售收入
	double overIncome;//报溢收入
	double differenceIncome;//进退货差价收入
	double couponIncome;//代金券差额收入
	double costExpense;
}
