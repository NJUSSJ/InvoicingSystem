package businesslogic.tablebl;

import java.util.ArrayList;
import java.sql.Date;

import businesslogic.billbl.CashBillController;
import businesslogic.billbl.GiftBillController;
import businesslogic.billbl.ImportBillController;
import businesslogic.billbl.ImportReturnBillController;
import businesslogic.billbl.LossBillController;
import businesslogic.billbl.OverBillController;
import businesslogic.billbl.PayBillController;
import businesslogic.billbl.ReceiveBillController;
import businesslogic.billbl.SaleBillController;
import businesslogic.billbl.SaleReturnBillController;
import vo.CashBillVO;
import vo.GiftBillVO;
import vo.ImportBillVO;
import vo.ImportReturnBillVO;
import vo.LossBillVO;
import vo.OperateCourseTableVO;
import vo.OverBillVO;
import vo.PayBillVO;
import vo.ReceiveBillVO;
import vo.SaleBillVO;
import vo.SaleReturnBillVO;

public class OperateCourseTable{
	SaleBillController saleBL=new SaleBillController();
	SaleReturnBillController saleReturnBL=new SaleReturnBillController();
	ImportBillController importBL=new ImportBillController();
	ImportReturnBillController importReturnBL=new ImportReturnBillController();
	PayBillController payBL=new PayBillController();
	ReceiveBillController receiveBL=new ReceiveBillController();
	CashBillController cashBL=new CashBillController();
	LossBillController lossBL=new LossBillController();
	OverBillController overBL=new OverBillController();
	GiftBillController giftBL=new GiftBillController();
	public OperateCourseTableVO findByInterval(Date begin, Date end) {
		ArrayList<SaleBillVO> saleBills=saleBL.findSaleBillsByInterval(begin, end);
		ArrayList<SaleReturnBillVO> saleReturnBills=saleReturnBL.findSaleReturnBillsByInterval(begin, end);
		ArrayList<ImportBillVO> importBills=importBL.findImportBillsByInterval(begin, end);
		ArrayList<ImportReturnBillVO> importReturnBills=importReturnBL.findImportReturnBillsByInterval(begin, end);
		ArrayList<PayBillVO> payBills=payBL.findPayBillsByInterval(begin, end);
		ArrayList<ReceiveBillVO> receiveBills=receiveBL.findReceiveBillsByInterval(begin, end);
		ArrayList<CashBillVO> cashBills=cashBL.findCashBillsByInterval(begin, end);
		ArrayList<LossBillVO> lossBills=lossBL.findLossBillsByInterval(begin, end);
		ArrayList<OverBillVO> overBills=overBL.findOverBillsByInterval(begin, end);
		ArrayList<GiftBillVO> giftBills=giftBL.findGiftBillsByInterval(begin, end);
		return new OperateCourseTableVO(saleBills,saleReturnBills,importBills,importReturnBills,
				payBills,receiveBills,cashBills,lossBills,overBills,giftBills);
	}

	public OperateCourseTableVO findByField(Date begin, Date end,String type, String memberName,String userName) {
		OperateCourseTableVO result=null;
		if(type==null){
			ArrayList<SaleBillVO> saleBills=saleBL.findSaleBillsByField(
					begin, end, null, memberName, userName);
			ArrayList<SaleReturnBillVO> saleReturnBills=saleReturnBL.findSaleReturnBillsByField(
					begin, end, memberName, userName);
			ArrayList<ImportBillVO> importBills=importBL.findImportBillsByField(
					begin, end, memberName, userName);
			ArrayList<ImportReturnBillVO> importReturnBills=importReturnBL.findImportReturnBillsByField(
					begin, end, memberName, userName);
			ArrayList<PayBillVO> payBills=payBL.findPayBillsByField(
					begin, end, memberName, userName);
			ArrayList<ReceiveBillVO> receiveBills=receiveBL.findReceiveBillSByField(
					begin, end, memberName, userName);
			ArrayList<CashBillVO> cashBills=cashBL.findCashBillsByField(begin, end, userName);
			ArrayList<LossBillVO> lossBills=lossBL.findLossBillsByField(begin, end, userName);
			ArrayList<OverBillVO> overBills=overBL.findOverBillsByField(begin, end, userName);
			ArrayList<GiftBillVO> giftBills=giftBL.findGiftBillsByField(begin, end, memberName, userName);
			result=new OperateCourseTableVO(saleBills,saleReturnBills,importBills,importReturnBills,
					payBills,receiveBills,cashBills,lossBills,overBills,giftBills);
		}else if(type.equals("Sale")){
			result=new OperateCourseTableVO();
			ArrayList<SaleBillVO> saleBills=saleBL.findSaleBillsByField(begin, end, null, memberName, userName);
			result.setSaleBillList(saleBills);
		}else if(type.equals("SaleReturn")){
			result=new OperateCourseTableVO();
			ArrayList<SaleReturnBillVO> saleReturnBills=saleReturnBL.findSaleReturnBillsByField(begin, end, memberName, userName);
			result.setSaleReturnBillList(saleReturnBills);
		}else if(type.equals("Import")){
			result=new OperateCourseTableVO();
			ArrayList<ImportBillVO> importBills=importBL.findImportBillsByField(begin, end,memberName, userName);
			result.setImportBillList(importBills);
		}else if(type.equals("ImportReturn")){
			result=new OperateCourseTableVO();
			ArrayList<ImportReturnBillVO> importReturnBills=importReturnBL.findImportReturnBillsByField(begin, end,memberName, userName);
			result.setImportReturnBillList(importReturnBills);
		}else if(type.equals("Pay")){
			result=new OperateCourseTableVO();
			ArrayList<PayBillVO> payBills=payBL.findPayBillsByField(begin, end,memberName, userName);
			result.setPayBillList(payBills);
		}else if(type.equals("Receive")){
			result=new OperateCourseTableVO();
			ArrayList<ReceiveBillVO> receiveBills=receiveBL.findReceiveBillsByField(begin, end,memberName, userName);
			result.setReceiveBillList(receiveBills);
		}
		return result;
	}

	public boolean exportAsExcel(OperateCourseTableVO vo, String path) {
		return false;
	}
	

}
