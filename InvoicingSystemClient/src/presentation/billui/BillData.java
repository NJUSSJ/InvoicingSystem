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
	UserBLService ubs=new UserController();
	public BillData(CashBillVO cashbill){
		id.set(cashbill.getID());
		operator.set(ubs.findUserByID(cashbill.getUserID()).getUsername());
		style.set("�ֽ���õ�");
		choose.set("��");
	}
   public BillData(PayBillVO paybill){
	   id.set(paybill.getID());
		operator.set(ubs.findUserByID(paybill.getUserID()).getUsername());
		style.set("���");
		choose.set("��");
	}
    public BillData(ReceiveBillVO receivebill){
    	id.set(receivebill.getID());
		operator.set(ubs.findUserByID(receivebill.getUserID()).getUsername());
		style.set("�տ");
		choose.set("��");
    }
    public BillData(SaleBillVO salebill){
    	id.set(salebill.getID());
		operator.set(ubs.findUserByID(salebill.getUserID()).getUsername());
		style.set("���۵�");
		choose.set("��");
    }
    public BillData(ImportBillVO importbill){
    	id.set(importbill.getID());
		operator.set(ubs.findUserByID(importbill.getUserID()).getUsername());
		style.set("������");
		choose.set("��");
    }
    public BillData(SaleReturnBillVO salereturnbill){
    	id.set(salereturnbill.getID());
		operator.set(ubs.findUserByID(salereturnbill.getUserID()).getUsername());
		style.set("�����˻���");
		choose.set("��");
    }
    public BillData(ImportReturnBillVO importreturnbill){
    	id.set(importreturnbill.getID());
		operator.set(ubs.findUserByID(importreturnbill.getUserID()).getUsername());
		style.set("�����˻���");
		choose.set("��");
    }
    public BillData(LossBillVO lossbill){
    	id.set(Long.toString(lossbill.getID()));
		operator.set(ubs.findUserByID(lossbill.getUserID()).getUsername());
		style.set("����");
		choose.set("��");
    }
    public BillData(GiftBillVO giftbill){
    	id.set( Long.toString(giftbill.getID()));
		operator.set(ubs.findUserByID(giftbill.getUserID()).getUsername());
		style.set("���͵�");
		choose.set("��");
    }
    public BillData(OverBillVO overbill){
    	id.set(  Long.toString(overbill.getID()));
		operator.set(ubs.findUserByID( overbill.getUserID()).getUsername());
		style.set("���絥");
		choose.set("��");
    }
    public BillData(WarningBillVO warningbill){
    	id.set( Long.toString(warningbill.getID()));
		operator.set(ubs.findUserByID( warningbill.getUserID()).getUsername());
		style.set("������");
		choose.set("��");
    }
    
	public StringProperty getidProperty() {
		// TODO Auto-generated method stub
		return id;
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
	public String getchoose() {
		// TODO Auto-generated method stub
		return choose.get();
	}
	public String getid() {
		// TODO Auto-generated method stub
		return id.get();
	}
	public String getstyle() {
		// TODO Auto-generated method stub
		return style.get();
	}
}
