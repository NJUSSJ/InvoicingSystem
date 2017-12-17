package vo;

import java.util.ArrayList;

public class OperateCourseTableVO {
	ArrayList<SaleBillVO> saleBillList;
	ArrayList<SaleReturnBillVO> saleReturnBillList;
	ArrayList<ImportBillVO> importBillList;
	ArrayList<ImportReturnBillVO> importReturnBillList;
	ArrayList<PayBillVO> payBillList;
	ArrayList<ReceiveBillVO> receiveBillList;
	ArrayList<CashBillVO> cashBillList;
	ArrayList<LossBillVO> lossBillList;
	ArrayList<OverBillVO> overBillList;
	ArrayList<GiftBillVO> giftBillList;
	public OperateCourseTableVO(ArrayList<SaleBillVO> saleBillList,
	ArrayList<SaleReturnBillVO> saleReturnBillList,
	ArrayList<ImportBillVO> importBillList,
	ArrayList<ImportReturnBillVO> importReturnBillList,
	ArrayList<PayBillVO> payBillList,
	ArrayList<ReceiveBillVO> receiveBillList,
	ArrayList<CashBillVO> cashBillList,
	ArrayList<LossBillVO> lossBillList,
	ArrayList<OverBillVO> overBillList,
	ArrayList<GiftBillVO> giftBillList){
		this.saleBillList=saleBillList;
		this.saleReturnBillList=saleReturnBillList;
		this.importBillList=importBillList;
		this.importReturnBillList=importReturnBillList;
		this.payBillList=payBillList;
		this.receiveBillList=receiveBillList;
		this.cashBillList=cashBillList;
		this.lossBillList=lossBillList;
		this.overBillList=overBillList;
		this.giftBillList=giftBillList;
	}
	public ArrayList<SaleBillVO> getSaleBillList(){
		return saleBillList;
	}
	public ArrayList<SaleReturnBillVO> getSaleReturnBillList(){
		return saleReturnBillList;
	}
	public ArrayList<ImportBillVO> getImportBillList(){
		return importBillList;
	}
	public ArrayList<ImportReturnBillVO> getImportReturnBillList(){
		return importReturnBillList;
	}
	public ArrayList<PayBillVO> getPayBillList(){
		return payBillList;
	}
	public ArrayList<ReceiveBillVO> getReceiveBillList(){
		return receiveBillList;
	}
	public ArrayList<CashBillVO> getCashBillList(){
		return cashBillList;
	}
	public ArrayList<LossBillVO> getLossBillList(){
		return lossBillList;
	}
	public ArrayList<OverBillVO> getOverBillList(){
		return overBillList;
	}
	public ArrayList<GiftBillVO> getGiftBillList(){
		return giftBillList;
	}
}
