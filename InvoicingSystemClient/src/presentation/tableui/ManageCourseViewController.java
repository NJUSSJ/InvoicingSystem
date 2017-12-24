package presentation.tableui;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.sun.prism.paint.Paint.Type;

import MainApp.MainApp;
import Utility.DateUtil;
import businesslogic.billbl.CashBillController;
import businesslogic.billbl.CommodityList;
import businesslogic.billbl.GiftBillController;
import businesslogic.billbl.ImportBillController;
import businesslogic.billbl.ImportReturnBillController;
import businesslogic.billbl.LossBillController;
import businesslogic.billbl.OverBillController;
import businesslogic.billbl.PayBillController;
import businesslogic.billbl.ReceiveBillController;
import businesslogic.billbl.SaleBill;
import businesslogic.billbl.SaleBillController;
import businesslogic.billbl.SaleReturnBillController;
import businesslogic.billbl.WarningBillController;
import businesslogic.tablebl.OperateCourseTable;
import businesslogic.tablebl.OperateCourseTableController;
import businesslogicservice.billblservice.CashBillBLService;
import businesslogicservice.billblservice.GiftBillBLService;
import businesslogicservice.billblservice.ImportBillBLService;
import businesslogicservice.billblservice.ImportReturnBillBLService;
import businesslogicservice.billblservice.LossBillBLService;
import businesslogicservice.billblservice.OverBillBLService;
import businesslogicservice.billblservice.PayBillBLService;
import businesslogicservice.billblservice.ReceiveBillBLService;
import businesslogicservice.billblservice.SaleBillBLService;
import businesslogicservice.billblservice.SaleReturnBillBLService;
import businesslogicservice.billblservice.WarningBillBLService;
import businesslogicservice.tableblservice.ManageCourseTableBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import presentation.accountui.AccountData;
import presentation.billui.BillData;
import vo.AccountVO;
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
import vo.WarningBillVO;

public class ManageCourseViewController implements Initializable {

	@FXML
	private Label id;
	
	@FXML
	private Label logout;
	
	@FXML
	private ChoiceBox<String> startYear;
	
	@FXML
	private ChoiceBox<String> startMonth;
	
	@FXML
	private ChoiceBox<String> startDay;
	
	@FXML
	private ChoiceBox<String> endYear;
	
	@FXML
	private ChoiceBox<String> endMonth;
	
	@FXML
	private ChoiceBox<String> endDay;
	
	@FXML
	private ChoiceBox<String> billType;
	
	@FXML
	private TextField member;
	
	@FXML
	private TextField user;
	
	@FXML
	private Button search;
	
	@FXML
	private Button reverse;
	
	@FXML
	private Button reverseAndCopy;
	
	@FXML
	private Button returnA;
	
	public  ObservableList<BillData> billData =FXCollections.observableArrayList();
	
	@FXML
	private TableView<BillData> billTable;
	
	@FXML 
	private TableColumn<BillData,String> timeColoumn;
	
	@FXML
	private TableColumn<BillData,String> typeColoumn;
	
	@FXML
	private TableColumn<BillData,String> memberColoumn;
	
	@FXML
	private TableColumn<BillData,String> userColoumn;
	
	@FXML
	private TableColumn<BillData,String> commentColoumn;
	
	CashBillBLService cbbs =new CashBillController();
	PayBillBLService pbbs =new PayBillController();
	ReceiveBillBLService rbbs =new ReceiveBillController();
	ImportReturnBillBLService irbbs =new ImportReturnBillController();
	ImportBillBLService ibbs =new ImportBillController();
	SaleBillBLService sbbs=new SaleBillController();
	SaleReturnBillBLService srbbs=new SaleReturnBillController();
	GiftBillBLService gbbs=new GiftBillController();
	LossBillBLService lbbs=new LossBillController();
	OverBillBLService obbs=new OverBillController();
	
	ArrayList<SaleBillVO> salelist=new ArrayList<SaleBillVO>();
	ArrayList<ImportBillVO> importlist=new ArrayList<ImportBillVO>();
	ArrayList<SaleReturnBillVO> salereturnlist=new ArrayList<SaleReturnBillVO>();
	ArrayList<ImportReturnBillVO> importreturnlist=new ArrayList<ImportReturnBillVO>();
	ArrayList<PayBillVO> paylist=new ArrayList<PayBillVO>();
	ArrayList<ReceiveBillVO> receivelist=new ArrayList<ReceiveBillVO>();
	ArrayList<CashBillVO> cashlist=new ArrayList<CashBillVO>();
	ArrayList<GiftBillVO> giftlist=new ArrayList<GiftBillVO>();
	ArrayList<OverBillVO> overlist=new ArrayList<OverBillVO>();
	ArrayList<LossBillVO> losslist=new ArrayList<LossBillVO>();
	
	BillData data=null;
    BillData billitem;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		long idLong=MainApp.getID();
		String idString=idLong+"";
		while(idString.length()<5) {
			idString="0"+idString;
		}
		id.setText("ID:"+idString);
		

		startYear.setItems(FXCollections.observableArrayList("2017","2016","2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000","1999","1998","1997"));
		startMonth.setItems(FXCollections.observableArrayList("1","2","3","4","5","6","7","9","10","11","12"));
		startDay.setItems(FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"));
		
		endYear.setItems(FXCollections.observableArrayList("2017","2016","2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000","1999","1998","1997"));
		endMonth.setItems(FXCollections.observableArrayList("1","2","3","4","5","6","7","9","10","11","12"));
		endDay.setItems(FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"));	
	
		billType.setItems(FXCollections.observableArrayList("销售单","销售退货单","进货单","进货退货单","付款单","收款单","现金费用单","赠送单","报溢单","报损单"));
	
		timeColoumn.setCellValueFactory(cellData ->cellData.getValue().getTimeProperty());
		typeColoumn.setCellValueFactory(cellData ->cellData.getValue().getstyleProperty());
		memberColoumn.setCellValueFactory(cellData ->cellData.getValue().getMemberProperty());
		userColoumn.setCellValueFactory(cellData ->cellData.getValue().getoperatorProperty());
		commentColoumn.setCellValueFactory(cellData ->cellData.getValue().getoperatorProperty());
		
		billTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> getInf(newValue));
		 billData.clear();
		    cashlist=cbbs.findCashBillsByState(0);
		    paylist=pbbs.findPayBillsByState(0);
		    receivelist=rbbs.findReceiveBillsByState(0);
		    importlist=ibbs.findImportBillsByState(0);
		    importreturnlist=irbbs.findImportReturnBillsByState(0);
		    salelist=sbbs.findSaleBillsByState(0);
		    salereturnlist=srbbs.findSaleReturnBillsByState(0);
		    giftlist=gbbs.findGiftBillsByState(0);
		    losslist=lbbs.findLossBillsByState(0);
		    overlist=obbs.findOverBillsByState(0);
		    
		    if(cashlist!=null&&!cashlist.isEmpty()){
		    	for(CashBillVO a:cashlist){
		    		billitem=new BillData(a);
		    		billData.add(billitem);
		    	}
		    }
		    if(paylist!=null&&!paylist.isEmpty()){
		    	for(PayBillVO a:paylist){
		    		billitem=new BillData(a);
		    		billData.add(billitem);
		    	}
		    }
		    if(receivelist!=null&&!receivelist.isEmpty()){
		    	for(ReceiveBillVO a:receivelist){
		    		billitem=new BillData(a);
		    		billData.add(billitem);
		    	}
		    }
		    if(giftlist!=null&&!giftlist.isEmpty()){
		    	for(GiftBillVO a:giftlist){
		    		billitem=new BillData(a);
		    		billData.add(billitem);
		    	}
		    }
		    if(losslist!=null&&!losslist.isEmpty()){
		    	for(LossBillVO a:losslist){
		    		billitem=new BillData(a);
		    		billData.add(billitem);
		    	}
		    }
		    if(overlist!=null&&!overlist.isEmpty()){
		    	for(OverBillVO a:overlist){
		    		billitem=new BillData(a);
		    		billData.add(billitem);
		    	}
		    }
		    if(importlist!=null&&!importlist.isEmpty()){
		    	for(ImportBillVO a:importlist){
		    		billitem=new BillData(a);
		    		billData.add(billitem);
		    	}
		    }
		    if(salelist!=null&&!salelist.isEmpty()){
		    	for(SaleBillVO a:salelist){
		    		billitem=new BillData(a);
		    		billData.add(billitem);
		    	}
		    }
		    if(importreturnlist!=null&&!importreturnlist.isEmpty()){
		    	for(ImportReturnBillVO a:importreturnlist){
		    		billitem=new BillData(a);
		    		billData.add(billitem);
		    	}
		    }
		    if(salereturnlist!=null&&!salereturnlist.isEmpty()){
		    	for(SaleReturnBillVO a:salereturnlist){
		    		billitem=new BillData(a);
		    		billData.add(billitem);
		    	}
		    }
		    billTable.setItems(billData);
		    
	    search.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getCode().equals(KeyCode.ENTER)) {
					searchBill();
				}
			}
		});
	}
	
	private void getInf(BillData newValue) {
		// TODO Auto-generated method stub
		if(newValue.getchooseProperty().get().equals("否")){
			newValue.setChoose("是");
		}else{
			newValue.setChoose("否");
		}
		if(newValue!=null){
			data=newValue;
		}
	}

	@FXML
	public void searchBill() {
		// TODO Auto-generated method stub
		OperateCourseTableVO oct=new OperateCourseTableVO();
		if(billType.getSelectionModel().getSelectedItem()==null&&user.getText().equals("")&&member.getText().equals("")) {
			ManageCourseTableBLService mctbl=new OperateCourseTableController();
			Date start=DateUtil.toSQL(startYear.getSelectionModel().getSelectedItem(),startMonth.getSelectionModel().getSelectedItem(),startDay.getSelectionModel().getSelectedItem());		
			Date end=DateUtil.toSQL(endYear.getSelectionModel().getSelectedItem(), endMonth.getSelectionModel().getSelectedItem(), endDay.getSelectionModel().getSelectedItem());
			oct=mctbl.findByInterval(start, end);
		}
		if(billType.getSelectionModel().getSelectedItem()!=null&&!user.getText().equals("")&&!member.getText().equals("")) {
			ManageCourseTableBLService mctbl=new OperateCourseTableController();
			Date start=DateUtil.toSQL(startYear.getSelectionModel().getSelectedItem(),startMonth.getSelectionModel().getSelectedItem(),startDay.getSelectionModel().getSelectedItem());		
			Date end=DateUtil.toSQL(endYear.getSelectionModel().getSelectedItem(), endMonth.getSelectionModel().getSelectedItem(), endDay.getSelectionModel().getSelectedItem());
			oct=mctbl.findByField(start, end,billType.getSelectionModel().getSelectedItem(),member.getText(),user.getText());
		}
		
		billData.clear();
		cashlist=oct.getCashBillList();
		 if(cashlist!=null&&!cashlist.isEmpty()){
		    	for(CashBillVO a:cashlist){
		    		billitem=new BillData(a);
		    		billData.add(billitem);
		    	}
		    }
		 paylist=oct.getPayBillList();
		    if(paylist!=null&&!paylist.isEmpty()){
		    	for(PayBillVO a:paylist){
		    		billitem=new BillData(a);
		    		billData.add(billitem);
		    	}
		    }
		    receivelist=oct.getReceiveBillList();
		    if(receivelist!=null&&!receivelist.isEmpty()){
		    	for(ReceiveBillVO a:receivelist){
		    		billitem=new BillData(a);
		    		billData.add(billitem);
		    	}
		    }
		    giftlist=oct.getGiftBillList();
		    if(giftlist!=null&&!giftlist.isEmpty()){
		    	for(GiftBillVO a:giftlist){
		    		billitem=new BillData(a);
		    		billData.add(billitem);
		    	}
		    }
		    losslist=oct.getLossBillList();
		    if(losslist!=null&&!losslist.isEmpty()){
		    	for(LossBillVO a:losslist){
		    		billitem=new BillData(a);
		    		billData.add(billitem);
		    	}
		    }
		    overlist=oct.getOverBillList();
		    if(overlist!=null&&!overlist.isEmpty()){
		    	for(OverBillVO a:overlist){
		    		billitem=new BillData(a);
		    		billData.add(billitem);
		    	}
		    }
		    importlist=oct.getImportBillList();
		    if(importlist!=null&&!importlist.isEmpty()){
		    	for(ImportBillVO a:importlist){
		    		billitem=new BillData(a);
		    		billData.add(billitem);
		    	}
		    }
		    salelist=oct.getSaleBillList();
		    if(salelist!=null&&!salelist.isEmpty()){
		    	for(SaleBillVO a:salelist){
		    		billitem=new BillData(a);
		    		billData.add(billitem);
		    	}
		    }
		    importreturnlist=oct.getImportReturnBillList();
		    if(importreturnlist!=null&&!importreturnlist.isEmpty()){
		    	for(ImportReturnBillVO a:importreturnlist){
		    		billitem=new BillData(a);
		    		billData.add(billitem);
		    	}
		    }
		    salereturnlist=oct.getSaleReturnBillList();
		    if(salereturnlist!=null&&!salereturnlist.isEmpty()){
		    	for(SaleReturnBillVO a:salereturnlist){
		    		billitem=new BillData(a);
		    		billData.add(billitem);
		    	}
		    }
	}
	
	@FXML
	public void reverse() {
		for(BillData bill:billData){
			if(bill.getchoose().equals("是")){
				String style=bill.getstyle();
				String id=bill.getid();
				billData.remove(bill);
				if(style.equals("销售单")){
					SaleBillVO sb=bill.getSaleBillVO();
					java.util.Date utiltime=new java.util.Date();
					Date nowTime=new Date(utiltime.getTime());
					
					CommodityList newlist=new CommodityList(sb.getList().toString());
					
					SaleBillVO newsb=new SaleBillVO("-"+sb.getID(), Long.parseLong(id), sb.getMemberID(), newlist, -sb.getSum(), 1, nowTime, "", 0, 0, 0, 0);
					
				}else if(style.equals("付款单")){
				        pbbs.checkPayBill(true, id);
				}else if(style.equals("收款单")){
					rbbs.checkReceiveBill(true, id);
				}else if(style.equals("报损单")){
					  lbbs.checkLossBill(true, Long.parseLong(id));
				}else if(style.equals("报溢单")){
					obbs.checkOverBill(true, Long.parseLong(id));
				}else if(style.equals("现金费用单")){
					cbbs.checkCashBill(true, id);
				}else if(style.equals("销售退货单")){
					srbbs.checkSaleReturnBill(true, id);
				}else if(style.equals("进货退货单")){
					irbbs.checkImportReturnBill(true, id);
				}else if(style.equals("进货单")){
					ibbs.checkImportBill(true, id);
				}
				if(billData.isEmpty()){
					break;
				}
			}
		}
	}

	@FXML
	public void reverseAndCopy() {
		
	}
	
}
