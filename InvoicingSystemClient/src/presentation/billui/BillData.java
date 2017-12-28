package presentation.billui;

import java.text.SimpleDateFormat;

import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.UserBLService;
import javafx.beans.property.SimpleStringProperty;
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
import vo.UserVO;
import vo.WarningBillVO;

public class BillData {
	StringProperty time=new SimpleStringProperty();
	StringProperty member=new SimpleStringProperty();
	StringProperty id=new SimpleStringProperty();
	StringProperty operator=new SimpleStringProperty();
	StringProperty style=new SimpleStringProperty();
	StringProperty choose=new SimpleStringProperty();
	StringProperty state=new SimpleStringProperty();
	StringProperty comment=new SimpleStringProperty();
	SaleBillVO sb=null;
	SaleReturnBillVO srb=null;
	PayBillVO pb=null;
	ReceiveBillVO rb=null;
	CashBillVO cb=null;
	ImportBillVO ib=null;
	ImportReturnBillVO irb=null;
	UserController ubs=new UserController();
	public BillData(CashBillVO cashbill){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String str=sdf.format(cashbill.getTime());
		time.set(str);
		member.set(""+cashbill.getAccountID());
		id.set(cashbill.getID());
		operator.set(ubs.findUserByID(cashbill.getUserID()).getUsername());
		style.set("现金费用单");
		choose.set("否");
		state.set(""+cashbill.getState());
		cb=cashbill;
	}
   public BillData(PayBillVO paybill){
	   SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	   String str=sdf.format(paybill.getTime());
	   time.set(str);
	   member.set(""+paybill.getMemberID());
	   id.set(paybill.getID());
		operator.set(ubs.findUserByID(paybill.getUserID()).getUsername());
		style.set("付款单");
		choose.set("否");
		state.set(""+paybill.getState());
		pb=paybill;
	}
    public BillData(ReceiveBillVO receivebill){
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String str=sdf.format(receivebill.getTime());
		time.set(str);
		member.set(""+receivebill.getMemberID());
    	id.set(receivebill.getID());
		operator.set(ubs.findUserByID(receivebill.getUserID()).getUsername());
		style.set("收款单");
		choose.set("否");
		state.set(""+receivebill.getState());
		rb=receivebill;
    }
    public BillData(SaleBillVO salebill){
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String str=sdf.format(salebill.getTime());
		time.set(str);
		member.set(""+salebill.getMemberID());
    	id.set(salebill.getID());
		operator.set(ubs.findUserByID(salebill.getUserID()).getUsername());
		style.set("销售单");
		choose.set("否");
		state.set(""+salebill.getState());
		sb=salebill;
    }
    public BillData(ImportBillVO importbill){
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String str=sdf.format(importbill.getTime());
		time.set(str);
		member.set(""+importbill.getMemberID());
    	id.set(importbill.getID());
		operator.set(ubs.findUserByID(importbill.getUserID()).getUsername());
		style.set("进货单");
		choose.set("否");
		state.set(""+importbill.getState());
		ib=importbill;
    }
    public BillData(SaleReturnBillVO salereturnbill){
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String str=sdf.format(salereturnbill.getTime());
		time.set(str);
		member.set(""+salereturnbill.getMemberID());
    	id.set(salereturnbill.getID());
		operator.set(ubs.findUserByID(salereturnbill.getUserID()).getUsername());
		style.set("销售退货单");
		choose.set("否");
		state.set(""+salereturnbill.getState());
		srb=salereturnbill;
    }
    public BillData(ImportReturnBillVO importreturnbill){
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String str=sdf.format(importreturnbill.getTime());
		time.set(str);
		member.set(""+importreturnbill.getMemberID());
    	id.set(importreturnbill.getID());
		operator.set(ubs.findUserByID(importreturnbill.getUserID()).getUsername());
		style.set("进货退货单");
		choose.set("否");
		state.set(""+importreturnbill.getState());
		irb=importreturnbill;
    }
    public BillData(LossBillVO lossbill){
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String str=sdf.format(lossbill.getTime());
		time.set(str);
		member.set("");
    	id.set(Long.toString(lossbill.getID()));
		operator.set(ubs.findUserByID(lossbill.getUserID()).getUsername());
		style.set("报损单");
		choose.set("否");
		state.set(""+lossbill.getState());
    }
    public BillData(GiftBillVO giftbill){
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String str=sdf.format(giftbill.getTime());
		time.set(str);
		member.set(""+giftbill.getMemberID());
    	id.set( Long.toString(giftbill.getID()));
		operator.set(ubs.findUserByID(giftbill.getUserID()).getUsername());
		style.set("赠送单");
		choose.set("否");
		state.set(""+giftbill.getState());
    }
    public BillData(OverBillVO overbill){
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String str=sdf.format(overbill.getTime());
		time.set(str);
		member.set("");
    	id.set(  Long.toString(overbill.getID()));
		operator.set(ubs.findUserByID( overbill.getUserID()).getUsername());
		style.set("报溢单");
		choose.set("否");
		state.set(""+overbill.getState());
    }
    public BillData(WarningBillVO warningbill){
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String str=sdf.format(warningbill.getTime());
		time.set(str);
		member.set("");
    	id.set( Long.toString(warningbill.getID()));
		operator.set(ubs.findUserByID( warningbill.getUserID()).getUsername());
		style.set("报警单");
		choose.set("否");
		state.set(""+warningbill.getState());
    }
    
    public StringProperty getTimeProperty() {
		return time;
	}
    public StringProperty getMemberProperty() {
		return member;
	}
	public StringProperty getidProperty() {
		return id;
	}
	public StringProperty getstateProperty() {
		return state;
	}

	public StringProperty getstyleProperty() {
		return style;
	}
	public StringProperty getoperatorProperty() {
		return operator;
	}
	public StringProperty getchooseProperty() {
		return choose;
	}
	public void setChoose(String string) {
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
	public SaleBillVO getSaleBillVO() {
		return sb;
	}
	public SaleReturnBillVO getSaleReturnBillVO() {
		return srb;
	}
	public PayBillVO getPayBillVO() {
		return pb;
	}
	public ReceiveBillVO getReceiveBillVO() {
		return rb;
	}
	public ImportBillVO getImportBillVO() {
		return ib;
	}
	public ImportReturnBillVO getImportReturnBillVO() {
		return irb;
	}
	public CashBillVO getCashBillVO() {
		return cb;
	}
}
