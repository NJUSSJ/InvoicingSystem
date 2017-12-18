package businesslogic.tablebl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import businesslogic.billbl.CommodityLineItem;
import businesslogic.billbl.CommodityList;
import businesslogic.billbl.GiftBillController;
import businesslogic.billbl.ImportBillController;
import businesslogic.billbl.ImportReturnBillController;
import businesslogic.billbl.LossBillController;
import businesslogic.billbl.OverBillController;
import businesslogic.billbl.SaleBillController;
import businesslogic.billbl.SaleReturnBillController;
import businesslogic.commoditybl.CommodityController;
import businesslogicservice.tableblservice.OperateConditionTableBLService;
import vo.CommodityVO;
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
	public boolean exportAsExcel(OperateConditionTableVO vo,String path){
		HSSFWorkbook wb=new HSSFWorkbook();
		HSSFSheet sheet=wb.createSheet("经营情况表:"+vo.getBegin()+"~"+vo.getEnd());
		HSSFRow row=sheet.createRow(0);
		
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		
		HSSFCell cell=row.createCell(0);
		cell.setCellValue("原销售收入");
		cell.setCellStyle(style);
		cell=row.createCell(1);
		cell.setCellValue("销售折后收入");
		cell.setCellStyle(style);
		cell=row.createCell(2);
		cell.setCellValue("折让");
		cell.setCellStyle(style);
		cell=row.createCell(3);
		cell.setCellValue("报溢收入");
		cell.setCellStyle(style);
		cell=row.createCell(4);
		cell.setCellValue("退货");
		cell.setCellStyle(style);
		cell=row.createCell(5);
		cell.setCellValue("代金券差额收入");
		cell.setCellStyle(style);
		cell=row.createCell(6);
		cell.setCellValue("进货支出");
		cell.setCellStyle(style);
		cell=row.createCell(7);
		cell.setCellValue("报损支出");
		cell.setCellStyle(style);
		cell=row.createCell(8);
		cell.setCellValue("赠品支出");
		cell.setCellStyle(style);
		cell=row.createCell(9);
		cell.setCellValue("销售退货");
		cell.setCellStyle(style);
		cell=row.createCell(10);
		cell.setCellValue("总收入");
		cell.setCellStyle(style);
		cell=row.createCell(11);
		cell.setCellValue("总支出");
		cell.setCellStyle(style);
		cell=row.createCell(12);
		cell.setCellValue("利润");
		
		row=sheet.createRow(1);
		row.createCell(0).setCellValue(vo.getSaleOriginIncome());
		row.createCell(1).setCellValue(vo.getSaleIncome());
		row.createCell(2).setCellValue(vo.getDiscount());
		row.createCell(3).setCellValue(vo.getOverIncome());
		row.createCell(4).setCellValue(vo.getImportReturnIncome());
		row.createCell(5).setCellValue(vo.getCouponIncome());
		row.createCell(6).setCellValue(vo.getImportExpense());
		row.createCell(7).setCellValue(vo.getLossExpense());
		row.createCell(8).setCellValue(vo.getGiftExpense());
		row.createCell(9).setCellValue(vo.getSaleReturnExpense());
		row.createCell(10).setCellValue(vo.getIncome());
		row.createCell(11).setCellValue(vo.getExpense());
		row.createCell(12).setCellValue(vo.getProfit());
		
		try {
			FileOutputStream fout = new FileOutputStream(path+".xls");
			wb.write(fout);
			fout.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
