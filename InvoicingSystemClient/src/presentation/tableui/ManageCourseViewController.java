package presentation.tableui;

import java.net.URL;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import MainApp.MainApp;
import Utility.DateUtil;
import businesslogic.billbl.AccountLineItem;
import businesslogic.billbl.AccountList;
import businesslogic.billbl.CashBillController;
import businesslogic.billbl.CommodityLineItem;
import businesslogic.billbl.CommodityList;
import businesslogic.billbl.GiftBillController;
import businesslogic.billbl.ImportBillController;
import businesslogic.billbl.ImportReturnBillController;
import businesslogic.billbl.LossBillController;
import businesslogic.billbl.OverBillController;
import businesslogic.billbl.PayBillController;
import businesslogic.billbl.ReceiveBillController;
import businesslogic.billbl.SaleBillController;
import businesslogic.billbl.SaleReturnBillController;
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
import businesslogicservice.tableblservice.ManageCourseTableBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import presentation.billui.BillData;
import presentation.billui.CashBillViewController;
import presentation.billui.PayBillViewController;
import presentation.billui.ReceiveBillViewController;
import presentation.saleui.ImportViewController;
import presentation.saleui.Import_ReturnViewController;
import presentation.saleui.SaleViewController;
import presentation.saleui.Sale_ReturnViewController;
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

public class ManageCourseViewController implements Initializable {

	@FXML
	private Label id;
	@FXML
	private Button logout;
	
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
		
		int rank=MainApp.getRank();
		if(rank==1) {
			reverse.setVisible(false);
			reverseAndCopy.setVisible(false);
		}
		
		String idString=idLong+"";
		while(idString.length()<5) {
			idString="0"+idString;
		}
		id.setText("ID:"+idString);
		

		startYear.setItems(FXCollections.observableArrayList("2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000","1999","1998","1997"));
		startMonth.setItems(FXCollections.observableArrayList("1","2","3","4","5","6","7","9","10","11","12"));
		startDay.setItems(FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"));
		startYear.setValue("2017");
		startMonth.setValue("9");
		startDay.setValue("1");
		endYear.setItems(FXCollections.observableArrayList("2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000","1999","1998","1997"));
		endMonth.setItems(FXCollections.observableArrayList("1","2","3","4","5","6","7","9","10","11","12"));
		endDay.setItems(FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"));	
		endYear.setValue("2018");
		endMonth.setValue("9");
		endDay.setValue("1");
		billType.setItems(FXCollections.observableArrayList("Sale","SaleReturn","Import","ImportReturn","Pay","Receive","Cash","Gift","Over","Loss"));
	
		timeColoumn.setCellValueFactory(cellData ->cellData.getValue().getTimeProperty());
		typeColoumn.setCellValueFactory(cellData ->cellData.getValue().getstyleProperty());
		memberColoumn.setCellValueFactory(cellData ->cellData.getValue().getMemberProperty());
		userColoumn.setCellValueFactory(cellData ->cellData.getValue().getoperatorProperty());
		commentColoumn.setCellValueFactory(cellData ->cellData.getValue().getidProperty());
		
		billTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> getInf(newValue));
		 billData.clear();
		    
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
				if(e.getCode().equals(KeyCode.ENTER)) {
					searchBill();
				}
			}
		});
	}
	
	@FXML
	public void showtheMain(){
		if(MainApp.getRank()==2){
			MainApp.showFianceMainUI();
		}else{
			MainApp.showManagerMainUI();
		}
	}
	@FXML
	public void logout(){
		MainApp.cancelUser();
		MainApp.showLoginUI();
	}
	
	private void getInf(BillData newValue) {
		
		if(newValue!=null){
			data=newValue;
		}
	}

	@FXML
	public void searchBill() {
		OperateCourseTableVO oct=new OperateCourseTableVO();
		if(billType.getSelectionModel().getSelectedItem()==null&&user.getText().equals("")&&member.getText().equals("")) {
			ManageCourseTableBLService mctbl=new OperateCourseTableController();
			Date start=DateUtil.toSQL(startYear.getSelectionModel().getSelectedItem(),startMonth.getSelectionModel().getSelectedItem(),startDay.getSelectionModel().getSelectedItem());		
			Date end=DateUtil.toSQL(endYear.getSelectionModel().getSelectedItem(), endMonth.getSelectionModel().getSelectedItem(), endDay.getSelectionModel().getSelectedItem());
			oct=mctbl.findByInterval(start, end);
		}else{
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
				String style=data.getstyle();
				String id=data.getid();
				if(style.equals("销售单")){
					SaleBillVO sb=data.getSaleBillVO();
					java.util.Date utiltime=new java.util.Date();
					Date nowTime=new Date(utiltime.getTime());
					SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
					String str=sdf.format(nowTime);
					DecimalFormat df=new DecimalFormat("#####");
					ArrayList<SaleBillVO> tmpList=new SaleBillController().findSaleBillByTime(nowTime);
					int times=tmpList.size()+1;
					String thisid="XSD-"+str+"-"+df.format(times);
				
					int num=sb.getList().getListSize();//商品种类
					CommodityList newlist=new CommodityList();
					for(int i=0;i<num;i++) {
						CommodityLineItem newcli=sb.getList().list.get(i);
						newcli.setNum(-newcli.getNum());//取负
						newlist.addCommodity(newcli);
					}
			    	SaleBillVO newsb=new SaleBillVO(thisid,sb.getUserID(), sb.getMemberID(), newlist, -sb.getSum(), 1, nowTime, "", sb.getCoupon(), sb.getDiscount(), -sb.getUltimate());
			        sbbs.submitSaleBill(newsb);
			        Alert warning=new Alert(AlertType.INFORMATION);
					 warning.setContentText("红冲销售单"+thisid+"成功！");
					 warning.showAndWait();
				}else if(style.equals("付款单")){
					PayBillVO pb=data.getPayBillVO();
					java.util.Date utiltime=new java.util.Date();
					Date nowTime=new Date(utiltime.getTime());
					SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
					String str=sdf.format(nowTime);
					DecimalFormat df=new DecimalFormat("#####");
					ArrayList<PayBillVO> tmpList=new PayBillController().findPayBillByTime(nowTime);
					int times=tmpList.size()+1;
					String thisid="PKD-"+str+"-"+df.format(times);
					int num=pb.getAccountList().getListLength();//商品种类
					AccountList newlist=new AccountList();
					for(int i=0;i<num;i++) {
						AccountLineItem newcli=pb.getAccountList().getItem(i);
						newcli.setMoney(-newcli.getMoney());//取负
						newlist.addAccount(newcli);
					}
					PayBillVO newsb=new PayBillVO(thisid,pb.getUserID(), pb.getMemberID(),newlist, -pb.getSum(), nowTime, 1);
					pbbs.submitPayBill(newsb);
					  Alert warning=new Alert(AlertType.INFORMATION);
					  warning.setContentText("红冲付款单"+thisid+"成功！");
						 warning.showAndWait();
				}else if(style.equals("收款单")){
					ReceiveBillVO rb=data.getReceiveBillVO();
					java.util.Date utiltime=new java.util.Date();
					Date nowTime=new Date(utiltime.getTime());
					SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
					String str=sdf.format(nowTime);
					DecimalFormat df=new DecimalFormat("#####");
					ArrayList<ReceiveBillVO> tmpList=new ReceiveBillController().findReceiveBillByTime(nowTime);
					int times=tmpList.size()+1;
					String thisid="SKD-"+str+"-"+df.format(times);
					int num=rb.getAccountList().getListLength();//商品种类
					AccountList newlist=new AccountList();
					for(int i=0;i<num;i++) {
						AccountLineItem newcli=rb.getAccountList().getItem(i);
						newcli.setMoney(-newcli.getMoney());//取负
						newlist.addAccount(newcli);
					}
					ReceiveBillVO newsb=new ReceiveBillVO(thisid, rb.getUserID(), rb.getMemberID(), newlist, -rb.getSum(), nowTime, 1);
					rbbs.submitReceiveBill(newsb);
					  Alert warning=new Alert(AlertType.INFORMATION);
					  warning.setContentText("红冲收款单"+thisid+"成功！");
						 warning.showAndWait();
				}else if(style.equals("现金费用单")){
					CashBillVO cb=data.getCashBillVO();
					java.util.Date utiltime=new java.util.Date();
					Date nowTime=new Date(utiltime.getTime());
					SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
					String str=sdf.format(nowTime);
					DecimalFormat df=new DecimalFormat("#####");
					ArrayList<CashBillVO> tmpList=new CashBillController().findCashBillByTime(nowTime);
					int times=tmpList.size()+1;
					String thisid="XJFYD-"+str+"-"+df.format(times);
					ArrayList<String> oldlist=cb.getAccountList();
					ArrayList<String> newlist= new ArrayList<String>();
					for(int i=0;i<oldlist.size();i++){
						String[] temp=oldlist.get(i).split(",");
						String enterline=temp[0]+","+"-"+temp[1]+","+temp[2];
						newlist.add(enterline);
					}
					
					CashBillVO newsb=new CashBillVO(thisid,cb.getUserID(),cb.getAccountID(),newlist,nowTime,1);
					cbbs.submitCashBill(newsb);
					  Alert warning=new Alert(AlertType.INFORMATION);
					  warning.setContentText("红冲现金费用单"+thisid+"成功！");
						 warning.showAndWait();
				}else if(style.equals("销售退货单")){
					SaleReturnBillVO srb=data.getSaleReturnBillVO();
					java.util.Date utiltime=new java.util.Date();
					Date nowTime=new Date(utiltime.getTime());
					SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
					String str=sdf.format(nowTime);
					DecimalFormat df=new DecimalFormat("#####");
					ArrayList<SaleReturnBillVO> tmpList=new SaleReturnBillController().findSaleReturnBillByTime(nowTime);
					int times=tmpList.size()+1;
					String thisid="XSTHD-"+str+"-"+df.format(times);
					int num=srb.getList().getListSize();//商品种类
					CommodityList newlist=new CommodityList();
					for(int i=0;i<num;i++) {
						CommodityLineItem newcli=srb.getList().list.get(i);
						newcli.setNum(-newcli.getNum());//取负
						newlist.addCommodity(newcli);
					}
					
					SaleReturnBillVO newsb=new SaleReturnBillVO(thisid,srb.getUserID(), srb.getMemberID(), newlist, -srb.getSum(), 1, nowTime, "");
					srbbs.submitSaleReturnBill(newsb);
					  Alert warning=new Alert(AlertType.INFORMATION);
					  warning.setContentText("销售退货单"+thisid+"成功！");
						 warning.showAndWait();
				}else if(style.equals("进货退货单")){
					ImportReturnBillVO irb=data.getImportReturnBillVO();
					java.util.Date utiltime=new java.util.Date();
					Date nowTime=new Date(utiltime.getTime());
					SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
					String str=sdf.format(nowTime);
					DecimalFormat df=new DecimalFormat("#####");
					ArrayList<ImportReturnBillVO> tmpList=new ImportReturnBillController().findImportReturnBillByTime(nowTime);
					int times=tmpList.size()+1;
					String thisid="JHTHD-"+str+"-"+df.format(times);
					int num=irb.getList().getListSize();//商品种类
					CommodityList newlist=new CommodityList();
					for(int i=0;i<num;i++) {
						CommodityLineItem newcli=irb.getList().list.get(i);
						newcli.setNum(-newcli.getNum());//取负
						newlist.addCommodity(newcli);
					}
					
					ImportReturnBillVO newsb=new ImportReturnBillVO(thisid,irb.getUserID(), irb.getMemberID(), newlist, -irb.getSum(), 1, nowTime, "");
					irbbs.submitImportReturnBill(newsb);
					  Alert warning=new Alert(AlertType.INFORMATION);
					  warning.setContentText("红冲进货退货单"+thisid+"成功！");
						 warning.showAndWait();
				}else if(style.equals("进货单")){
					ImportBillVO ib=data.getImportBillVO();
					java.util.Date utiltime=new java.util.Date();
					Date nowTime=new Date(utiltime.getTime());
					SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
					String str=sdf.format(nowTime);
					DecimalFormat df=new DecimalFormat("#####");
					ArrayList<ImportBillVO> tmpList=new ImportBillController().findImportBillByTime(nowTime);
					int times=tmpList.size()+1;
					String thisid="JHD-"+str+"-"+df.format(times);
					int num=ib.getCommodityList().getListSize();//商品种类
					CommodityList newlist=new CommodityList();
					for(int i=0;i<num;i++) {
						CommodityLineItem newcli=ib.getCommodityList().list.get(i);
						newcli.setNum(-newcli.getNum());//取负
						newlist.addCommodity(newcli);
					}
					
					ImportBillVO newsb=new ImportBillVO(thisid,ib.getUserID(), ib.getMemberID(), newlist, -ib.getSum(), 1, nowTime, "");
					ibbs.submitImportBill(newsb);
					  Alert warning=new Alert(AlertType.INFORMATION);
					  warning.setContentText("红冲进货单"+thisid+"成功！");
						 warning.showAndWait();
				}else if(style.equals("赠送单")) {
					Alert warning=new Alert(AlertType.WARNING);
					 warning.setContentText("Can't reverse the giftbill!");
					 warning.showAndWait();
				}else if(style.equals("报警单")) {
					Alert warning=new Alert(AlertType.WARNING);
					 warning.setContentText("Can't reverse the warningbill!");
					 warning.showAndWait();
				}else if(style.equals("报损单")) {
					Alert warning=new Alert(AlertType.WARNING);
					 warning.setContentText("Can't reverse the lossbill!");
					 warning.showAndWait();
				}else if(style.equals("报溢单")) {
					Alert warning=new Alert(AlertType.WARNING);
					 warning.setContentText("Can't reverse the overbill!");
					 warning.showAndWait();
				}
			
	}

	@FXML
	public void reverseAndCopy() {
		String id=data.getid();
		String style=data.getstyle();
		if(style.equals("销售单")){
			SaleBillVO m=sbbs.findSaleBillByID(id);
			try {
				FXMLLoader loader=new FXMLLoader();
				loader.setLocation(MainApp.class.getResource("/presentation/saleui/SaleUI.fxml"));
				AnchorPane salebillUI=loader.load();
				Scene scene=new Scene(salebillUI);
				Stage stage=new Stage();
				stage.setTitle("SaleUI");
				stage.initModality(Modality.WINDOW_MODAL);
				stage.initOwner(MainApp.getPrimaryStage());
				stage.setScene(scene);
	            SaleViewController controller=loader.getController();
	            controller.setStage(stage);
	            controller.red(m);
	            stage.showAndWait();
	            
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(style.equals("付款单")){
			PayBillVO m=pbbs.findPayBillByID(id);
			try {
				FXMLLoader loader=new FXMLLoader();
				loader.setLocation(MainApp.class.getResource("/presentation/billui/PayBillUI.fxml"));
				AnchorPane paybillUI=loader.load();
				Scene scene=new Scene(paybillUI);
				Stage stage=new Stage();
				stage.setTitle("PayUI");
				stage.initModality(Modality.WINDOW_MODAL);
				stage.initOwner(MainApp.getPrimaryStage());
				stage.setScene(scene);
	            PayBillViewController controller=loader.getController();
	            controller.setStage(stage);
	            controller.red(m);
	            stage.showAndWait();
	            
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(style.equals("收款单")){
			ReceiveBillVO m=rbbs.findReceiveBillByID(id);
			try {
				FXMLLoader loader=new FXMLLoader();
				loader.setLocation(MainApp.class.getResource("/presentation/billui/ReceiveBillUI.fxml"));
				AnchorPane receivebillUI=loader.load();
				Scene scene=new Scene(receivebillUI);
				Stage stage=new Stage();
				stage.setTitle("ReceiveUI");
				stage.initModality(Modality.WINDOW_MODAL);
				stage.initOwner(MainApp.getPrimaryStage());
				stage.setScene(scene);
	            ReceiveBillViewController controller=loader.getController();
	            controller.setStage(stage);
	            controller.red(m);
	            stage.showAndWait();
	            
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(style.equals("现金费用单")){
			try {
				CashBillVO m=cbbs.findCashBillByID(id);
				FXMLLoader loader=new FXMLLoader();
				loader.setLocation(MainApp.class.getResource("/presentation/billui/CashBillUI.fxml"));
				AnchorPane cashbillUI=loader.load();
				Scene scene=new Scene(cashbillUI);
				Stage stage=new Stage();
				stage.setTitle("cashUI");
				stage.initModality(Modality.WINDOW_MODAL);
				stage.initOwner(MainApp.getPrimaryStage());
				stage.setScene(scene);
	            CashBillViewController controller=loader.getController();
	            controller.setStage(stage);
	            controller.red(m);
	            stage.showAndWait();
	            
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(style.equals("销售退货单")){
			try {
				SaleReturnBillVO m=srbbs.findSaleReturnBillByID(id);
				FXMLLoader loader=new FXMLLoader();
				loader.setLocation(MainApp.class.getResource("/presentation/saleui/Sale_ReturnUI.fxml"));
				AnchorPane salebillUI=loader.load();
				Scene scene=new Scene(salebillUI);
				Stage stage=new Stage();
				stage.setTitle("PayUI");
				stage.initModality(Modality.WINDOW_MODAL);
				stage.initOwner(MainApp.getPrimaryStage());
				stage.setScene(scene);
	            Sale_ReturnViewController controller=loader.getController();
	            controller.setStage(stage);
	            controller.red(m);
	            stage.showAndWait();
	            
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(style.equals("进货退货单")){
			try {
				ImportReturnBillVO m=irbbs.findImportReturnBillByID(id);
				FXMLLoader loader=new FXMLLoader();
				loader.setLocation(MainApp.class.getResource("/presentation/saleui/Import_Return.fxml"));
				AnchorPane imbillUI=loader.load();
				Scene scene=new Scene(imbillUI);
				Stage stage=new Stage();
				stage.setTitle("importreturnUI");
				stage.initModality(Modality.WINDOW_MODAL);
				stage.initOwner(MainApp.getPrimaryStage());
				stage.setScene(scene);
	            Import_ReturnViewController controller=loader.getController();
	            controller.setStage(stage);
	            controller.red(m);
	            stage.showAndWait();
	            
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(style.equals("进货单")){
			try {
				ImportBillVO m=ibbs.findImportBillByID(id);
				FXMLLoader loader=new FXMLLoader();
				loader.setLocation(MainApp.class.getResource("/presentation/saleui/ImportUI.fxml"));
				AnchorPane paybillUI=loader.load();
				Scene scene=new Scene(paybillUI);
				Stage stage=new Stage();
				stage.setTitle("ImportUI");
				stage.initModality(Modality.WINDOW_MODAL);
				stage.initOwner(MainApp.getPrimaryStage());
				stage.setScene(scene);
	            ImportViewController controller=loader.getController();
	            controller.setStage(stage);
	            controller.red(m);
	            stage.showAndWait();
	            
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(style.equals("赠送单")) {
			Alert warning=new Alert(AlertType.WARNING);
			 warning.setContentText("Can't reverse the giftbill!");
			 warning.showAndWait();
		}else if(style.equals("报警单")) {
			Alert warning=new Alert(AlertType.WARNING);
			 warning.setContentText("Can't reverse the warningbill!");
			 warning.showAndWait();
		}else if(style.equals("报损单")) {
			Alert warning=new Alert(AlertType.WARNING);
			 warning.setContentText("Can't reverse the lossbill!");
			 warning.showAndWait();
		}else if(style.equals("报溢单")) {
			Alert warning=new Alert(AlertType.WARNING);
			 warning.setContentText("Can't reverse the overbill!");
			 warning.showAndWait();
		}
	}
	
}
