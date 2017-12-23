package presentation.billui;

import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.UserBLService;
import javafx.beans.property.StringProperty;
import vo.CashBillVO;
import vo.GiftBillVO;
import vo.ImportBillVO;
import vo.ImportReturnBillVO;
import vo.LossBillVO;
import vo.OverBillVO;
import vo.PayBillVO;
import vo.ReceiveBillVO;
import vo.SaleBillVO;
import vo.SaleReturnBillVO;
import vo.WarningBillVO;

public class BillData {
	StringProperty id;
	StringProperty operator;
	StringProperty style;
	StringProperty choose;
	StringProperty state;
	UserBLService ubs=new UserController();
	public BillData(CashBillVO cashbill){
		id.set(cashbill.getID());
		operator.set(ubs.findUserByID(cashbill.getUserID()).getUsername());
		style.set("现金费用单");
		choose.set("否");
		state.set(""+cashbill.getState());
	}
   public BillData(PayBillVO paybill){
	   id.set(paybill.getID());
		operator.set(ubs.findUserByID(paybill.getUserID()).getUsername());
		style.set("付款单");
		choose.set("否");
		state.set(""+paybill.getState());
	}
    public BillData(ReceiveBillVO receivebill){
    	id.set(receivebill.getID());
		operator.set(ubs.findUserByID(receivebill.getUserID()).getUsername());
		style.set("收款单");
		choose.set("否");
		state.set(""+receivebill.getState());
    }
    public BillData(SaleBillVO salebill){
    	id.set(salebill.getID());
		operator.set(ubs.findUserByID(salebill.getUserID()).getUsername());
		style.set("销售单");
		choose.set("否");
		state.set(""+salebill.getState());
    }
    public BillData(ImportBillVO importbill){
    	id.set(importbill.getID());
		operator.set(ubs.findUserByID(importbill.getUserID()).getUsername());
		style.set("进货单");
		choose.set("否");
		state.set(""+importbill.getState());
    }
    public BillData(SaleReturnBillVO salereturnbill){
    	id.set(salereturnbill.getID());
		operator.set(ubs.findUserByID(salereturnbill.getUserID()).getUsername());
		style.set("销售退货单");
		choose.set("否");
		state.set(""+salereturnbill.getState());
    }
    public BillData(ImportReturnBillVO importreturnbill){
    	id.set(importreturnbill.getID());
		operator.set(ubs.findUserByID(importreturnbill.getUserID()).getUsername());
		style.set("进货退货单");
		choose.set("否");
		state.set(""+importreturnbill.getState());
    }
    public BillData(LossBillVO lossbill){
    	id.set(Long.toString(lossbill.getID()));
		operator.set(ubs.findUserByID(lossbill.getUserID()).getUsername());
		style.set("报损单");
		choose.set("否");
		state.set(""+lossbill.getState());
    }
    public BillData(GiftBillVO giftbill){
    	id.set( Long.toString(giftbill.getID()));
		operator.set(ubs.findUserByID(giftbill.getUserID()).getUsername());
		style.set("赠送单");
		choose.set("否");
		state.set(""+giftbill.getState());
    }
    public BillData(OverBillVO overbill){
    	id.set(  Long.toString(overbill.getID()));
		operator.set(ubs.findUserByID( overbill.getUserID()).getUsername());
		style.set("报溢单");
		choose.set("否");
		state.set(""+overbill.getState());
    }
    public BillData(WarningBillVO warningbill){
    	id.set( Long.toString(warningbill.getID()));
		operator.set(ubs.findUserByID( warningbill.getUserID()).getUsername());
		style.set("报警单");
		choose.set("否");
		state.set(""+warningbill.getState());
    }
    
	public StringProperty getidProperty() {
		// TODO Auto-generated method stub
		return id;
	}
	public StringProperty getstateProperty() {
		// TODO Auto-generated method stub
		return state;
	}

	public StringProperty getstyleProperty() {
		// TODO Auto-generated method stub
		return style;
	}
	public StringProperty getoperatorProperty() {
		// TODO Auto-generated method stub
		return operator;
	}
	public StringProperty getchooseProperty() {
		// TODO Auto-generated method stub
		return choose;
	}
	public void setChoose(String string) {
		// TODO Auto-generated method stub
		choose.set(string);
	}
	public String getchoose(){
		return choose.get();
	}
	public String getstyle(){
		return style.get();
	}
	public String getid(){
		return id.get();
	}
	public String getstate(){
		return state.get();
	}
}
