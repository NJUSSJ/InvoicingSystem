package businesslogic.tablebl;

import java.sql.Date;
import java.util.ArrayList;

import businesslogic.billbl.ImportBillController;
import businesslogic.billbl.ImportReturnBillController;
import businesslogic.billbl.SaleBillController;
import businesslogic.billbl.SaleReturnBillController;
import businesslogicservice.tableblservice.OperateConditionTableBLService;
import vo.ImportBillVO;
import vo.ImportReturnBillVO;
import vo.OperateConditionTableVO;
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
	public OperateConditionTableVO findByInterval(Date begin, Date end) {
		ArrayList<SaleBillVO> saleBills=saleCon.findSaleBillsByInterval(begin, end);
		ArrayList<SaleReturnBillVO> saleReturnBills=saleReturnCon.findSaleReturnBillsByInterval(begin, end);
		ArrayList<ImportBillVO> importBills=importCon.findImportBillsByInterval(begin, end);
		ArrayList<ImportReturnBillVO> importReturnBills=importReturnCon.findImportReturnBillsByInterval(begin, end);
		
		
		return null;
	}
	
}
