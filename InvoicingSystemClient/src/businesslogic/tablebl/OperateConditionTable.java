package businesslogic.tablebl;

import java.sql.Date;
import java.util.ArrayList;

import businesslogic.billbl.GiftBillController;
import businesslogic.billbl.ImportBillController;
import businesslogic.billbl.ImportReturnBillController;
import businesslogic.billbl.LossBillController;
import businesslogic.billbl.OverBillController;
import businesslogic.billbl.SaleBillController;
import businesslogic.billbl.SaleReturnBillController;
import businesslogicservice.tableblservice.OperateConditionTableBLService;
import vo.GiftBillVO;
import vo.ImportBillVO;
import vo.ImportReturnBillVO;
import vo.LossBillVO;
import vo.OperateConditionTableVO;
import vo.OverBillVO;
import vo.SaleBillVO;
import vo.SaleReturnBillVO;
/**
 * 
 * @author yrz:经营情况表
 *
 */
public class OperateConditionTable{
	SaleBillController saleCon=new SaleBillController();
	SaleReturnBillController saleReturnCon=new SaleReturnBillController();
	ImportBillController importCon=new ImportBillController();
	ImportReturnBillController importReturnCon=new ImportReturnBillController();
	LossBillController lossCon=new LossBillController();
	OverBillController overCon=new OverBillController();
	GiftBillController giftCon=new GiftBillController();
	public OperateConditionTableVO findByInterval(Date begin, Date end) {
		ArrayList<SaleBillVO> saleBills=saleCon.findSaleBillsByInterval(begin, end);
		ArrayList<SaleReturnBillVO> saleReturnBills=saleReturnCon.findSaleReturnBillsByInterval(begin, end);
		ArrayList<ImportBillVO> importBills=importCon.findImportBillsByInterval(begin, end);
		ArrayList<ImportReturnBillVO> importReturnBills=importReturnCon.findImportReturnBillsByInterval(begin, end);
		ArrayList<LossBillVO> lossBills=lossCon.findLossBillsByInterval(begin, end);
		ArrayList<OverBillVO> overBills=overCon.findOverBillsByInterval(begin, end);
		ArrayList<GiftBillVO> giftBills=giftCon.findGiftBillsByInterval(begin, end);
		double saleIncome=0;
		double saleOriginIncome=0;
		double couponIncome=0;
		if(saleBills!=null&&!saleBills.isEmpty()){
			for(SaleBillVO vo:saleBills){
				saleOriginIncome+=vo.getSum();
				saleIncome+=vo.getMoney();
				couponIncome+=vo.getMoney()+vo.getCoupon()-vo.getUltimate();
			}
		}
		double overIncome=0;
		if(overBills!=null&&!overBills.isEmpty()){
			for(OverBillVO vo:overBills){
				overIncome+=vo.getSum();
			}
		}
		double importReturnIncome=0;
		if(importReturnBills!=null&&!importReturnBills.isEmpty()){
			for(ImportReturnBillVO vo:importReturnBills){
				importReturnIncome+=vo.getSum();
			}
		}
		double lossExpense=0;
		if(lossBills!=null&&!lossBills.isEmpty()){
			for(LossBillVO vo:lossBills){
				lossExpense+=vo.getSum();
			}
		}
		double importExpense=0;
		if(importBills!=null&&!importBills.isEmpty()){
			for(ImportBillVO vo:importBills){
				importExpense+=vo.getSum();
			}
		}
		double giftExpense=0;
		if(giftBills!=null&&!giftBills.isEmpty()){
			for(GiftBillVO vo:giftBills){
				giftExpense+=vo.getCommodityList().getSaleTotal();
			}
		}
		double saleReturnExpense=0;
		if(saleReturnBills!=null&&!saleReturnBills.isEmpty()){
			for(SaleReturnBillVO vo:saleReturnBills){
				saleReturnExpense+=vo.getSum();
			}
		}
		double profit=saleIncome+saleOriginIncome+overIncome+importReturnIncome+couponIncome
				-importExpense-lossExpense-giftExpense-saleReturnExpense;
		return new OperateConditionTableVO(begin,end,saleIncome,saleOriginIncome,overIncome,
	importReturnIncome,couponIncome,importExpense,lossExpense,giftExpense,saleReturnExpense,profit);
	}
	
}
