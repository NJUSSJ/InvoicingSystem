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
	public OperateCourseTableVO(){
	}
	public ArrayList<SaleBillVO> getSaleBillList(){
		return saleBillList;
	}
	public void setSaleBillList(ArrayList<SaleBillVO> list){
		saleBillList=list;
	}
	public ArrayList<SaleReturnBillVO> getSaleReturnBillList(){
		return saleReturnBillList;
	}
	public void setSaleReturnBillList(ArrayList<SaleReturnBillVO> list){
		saleReturnBillList=list;
	}
	public ArrayList<ImportBillVO> getImportBillList(){
		return importBillList;
	}
	public void setImportBillList(ArrayList<ImportBillVO> list){
		importBillList=list;
	}
	public ArrayList<ImportReturnBillVO> getImportReturnBillList(){
		return importReturnBillList;
	}
	public void setImportReturnBillList(ArrayList<ImportReturnBillVO> list){
		importReturnBillList=list;
	}
	public ArrayList<PayBillVO> getPayBillList(){
		return payBillList;
	}
	public void setPayBillList(ArrayList<PayBillVO> list){
		payBillList=list;
	}
	public ArrayList<ReceiveBillVO> getReceiveBillList(){
		return receiveBillList;
	}
	public void setReceiveBillList(ArrayList<ReceiveBillVO> list){
		receiveBillList=list;
	}
	public ArrayList<CashBillVO> getCashBillList(){
		return cashBillList;
	}
	public void setCashBillList(ArrayList<CashBillVO> list){
		cashBillList=list;
	}
	public ArrayList<LossBillVO> getLossBillList(){
		return lossBillList;
	}
	public void setLossBillList(ArrayList<LossBillVO> list){
		lossBillList=list;
	}
	public ArrayList<OverBillVO> getOverBillList(){
		return overBillList;
	}
	public void setOverBillList(ArrayList<OverBillVO> list){
		overBillList=list;
	}
	public ArrayList<GiftBillVO> getGiftBillList(){
		return giftBillList;
	}
	public void setGiftBillList(ArrayList<GiftBillVO> list){
		giftBillList=list;
	}
}
