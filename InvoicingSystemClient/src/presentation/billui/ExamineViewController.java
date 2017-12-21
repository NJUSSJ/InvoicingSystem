package presentation.billui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import MainApp.MainApp;
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
import businesslogic.billbl.WarningBillController;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import presentation.accountui.SimpleAccountController;
import presentation.commodityui.LossInfoController;
import presentation.commodityui.OverInfoController;
import presentation.saleui.SaleViewController;
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


public class ExamineViewController implements Initializable {
	@FXML
	private Label id;
	@FXML
	private Label logout;
	@FXML
	private Label detail;
	@FXML
	private Button passB;
	
	@FXML
	private Button returnB;
	
	@FXML
	private Button notpassB;
	
	@FXML
	private Button detailB;
	
    private ObservableList<BillData> billData =FXCollections.observableArrayList();
	@FXML
	private TableView<BillData> billTable;
	@FXML
	private TableColumn<BillData,String> idColumn;
	@FXML
	private TableColumn<BillData,String> styleColumn;
	@FXML
	private TableColumn<BillData,String> chooseColumn;
	@FXML
	private TableColumn<BillData,String> operatorColumn;
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
	WarningBillBLService wbbs=new WarningBillController();
	BillData billitem=null;
	
    ArrayList<CashBillVO> cashlist=new ArrayList<CashBillVO>();
    ArrayList<PayBillVO> paylist=new ArrayList<PayBillVO>();
	ArrayList<ReceiveBillVO> receivelist=new ArrayList<ReceiveBillVO>();
	ArrayList<ImportReturnBillVO> importreturnlist=new ArrayList<ImportReturnBillVO>();
	ArrayList<ImportBillVO> importlist=new ArrayList<ImportBillVO>();
	ArrayList<SaleReturnBillVO> salereturnlist=new ArrayList<SaleReturnBillVO>();
	ArrayList<SaleBillVO> salelist=new ArrayList<SaleBillVO>();
	ArrayList<GiftBillVO> giftlist=new ArrayList<GiftBillVO>();
	ArrayList<LossBillVO> losslist=new ArrayList<LossBillVO>();
	ArrayList<OverBillVO> overlist=new ArrayList<OverBillVO>();
	ArrayList<WarningBillVO> warninglist=new ArrayList<WarningBillVO>();
	 BillData a=null;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		id.setText("ID:"+MainApp.getID());
		billTable.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> getInf(newValue));
		idColumn.setCellValueFactory(cellData ->cellData.getValue().getidProperty());
		styleColumn.setCellValueFactory(cellData ->cellData.getValue().getstyleProperty());
		operatorColumn.setCellValueFactory(cellData ->cellData.getValue().getoperatorProperty());
		chooseColumn.setCellValueFactory(cellData ->cellData.getValue().getchooseProperty());
	    search();
	}
	private void getInf(BillData newValue) {
		// TODO Auto-generated method stub
		billData.remove(newValue);
		if(newValue.getchooseProperty().get().equals("否")){
			newValue.setChoose("是");
		}else{
			newValue.setChoose("否");
		}
		a=newValue;
		billData.add(newValue);
		billTable.setItems(billData);
	}
	@FXML
	public void showManagerMainUI(){
		MainApp.showManagerMainUI();
	}
	@FXML
	public void logout(){
		MainApp.cancelUser();
		MainApp.showLoginUI();
	}
	@FXML
	public void pass(){
		for(BillData bill:billData){
			if(bill.getchoose().equals("是")){
				String style=bill.getstyle();
				String id=bill.getid();
				if(style.equals("销售单")){
						sbbs.checkSaleBill(true, id);
				}else if(style.equals("付款单")){
				        pbbs.checkPayBill(true, id);
				}else if(style.equals("收款单")){
					rbbs.checkReceiveBill(true, id);
				}else if(style.equals("报损单")){
					  lbbs.checkLossBill(true, Long.parseLong(id));
				}else if(style.equals("报溢单")){
					obbs.checkOverBill(true, Long.parseLong(id));
				}else if(style.equals("报警单")){
					wbbs.checkWarningBill(true, Long.parseLong(id));
				}else if(style.equals("现金费用单")){
					cbbs.checkCashBill(true, id);
				}else if(style.equals("赠送单")){
					gbbs.checkGiftBill(true, Long.parseLong(id));
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
		billTable.setItems(billData);
	}
	@FXML
	public void notpass(){
		for(BillData bill:billData){
			if(bill.getchoose().equals("是")){
				String style=bill.getstyle();
				String id=bill.getid();
				if(style.equals("销售单")){
					sbbs.checkSaleBill(false, id);
			}else if(style.equals("付款单")){
			        pbbs.checkPayBill(false, id);
			}else if(style.equals("收款单")){
				rbbs.checkReceiveBill(false, id);
			}else if(style.equals("报损单")){
				  lbbs.checkLossBill(false, Long.parseLong(id));
			}else if(style.equals("报溢单")){
				obbs.checkOverBill(false, Long.parseLong(id));
			}else if(style.equals("报警单")){
				wbbs.checkWarningBill(false, Long.parseLong(id));
			}else if(style.equals("现金费用单")){
				cbbs.checkCashBill(false, id);
			}else if(style.equals("赠送单")){
				gbbs.checkGiftBill(false, Long.parseLong(id));
			}else if(style.equals("销售退货单")){
				srbbs.checkSaleReturnBill(false, id);
			}else if(style.equals("进货退货单")){
				irbbs.checkImportReturnBill(false, id);
			}else if(style.equals("进货单")){
				ibbs.checkImportBill(false, id);
			}
			if(billData.isEmpty()){
				break;
			}
          }
		}
		billTable.setItems(billData);
	}
	@FXML
	public void showDetail(){
		String id=a.getid();
		String style=a.getstyle();
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
	            controller.setVo(m);
	            stage.showAndWait();
	            
			} catch (IOException e) {
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
	            controller.setVo(m);
	            stage.showAndWait();
	            
			} catch (IOException e) {
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
	            controller.setVo(m);
	            stage.showAndWait();
	            
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(style.equals("报损单")){
			try {
				LossBillVO m=lbbs.findLossBillByID(Long.parseLong(id));
				FXMLLoader loader=new FXMLLoader();
				loader.setLocation(MainApp.class.getResource("/presentation/commodityui/LossBillUI.fxml"));
				AnchorPane lossbillUI=loader.load();
				Scene scene=new Scene(lossbillUI);
				Stage stage=new Stage();
				stage.setTitle("LossUI");
				stage.initModality(Modality.WINDOW_MODAL);
				stage.initOwner(MainApp.getPrimaryStage());
				stage.setScene(scene);
	            LossInfoController controller=loader.getController();
	            controller.setStage(stage);
	            controller.setVo(m);
	            stage.showAndWait();
	            
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(style.equals("报溢单")){
			try {
				OverBillVO m=obbs.findOverBillByID(Long.parseLong(id));
				FXMLLoader loader=new FXMLLoader();
				loader.setLocation(MainApp.class.getResource("/presentation/commodityui/OverBillUI.fxml"));
				AnchorPane overbillUI=loader.load();
				Scene scene=new Scene(overbillUI);
				Stage stage=new Stage();
				stage.setTitle("OverUI");
				stage.initModality(Modality.WINDOW_MODAL);
				stage.initOwner(MainApp.getPrimaryStage());
				stage.setScene(scene);
	            OverInfoController controller=loader.getController();
	            controller.setStage(stage);
	            controller.setVo(m);
	            stage.showAndWait();
	            
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(style.equals("报警单")){
			try {
				WarningBillVO m=wbbs.findWarningBillByID(Long.parseLong(id));
				FXMLLoader loader=new FXMLLoader();
				loader.setLocation(MainApp.class.getResource("/presentation/billui/WarningBillUI.fxml"));
				AnchorPane warnbillUI=loader.load();
				Scene scene=new Scene(warnbillUI);
				Stage stage=new Stage();
				stage.setTitle("WarningUI");
				stage.initModality(Modality.WINDOW_MODAL);
				stage.initOwner(MainApp.getPrimaryStage());
				stage.setScene(scene);
	            WarningBillViewController controller=loader.getController();
	            controller.setStage(stage);
	            controller.setVo(m);
	            stage.showAndWait();
	            
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(style.equals("现金费用单")){
			try {
				CashBillVO m=cbbs.findCashBillByID(id);
				FXMLLoader loader=new FXMLLoader();
				loader.setLocation(MainApp.class.getResource("/presentation/billui/CahBillUI.fxml"));
				AnchorPane cashbillUI=loader.load();
				Scene scene=new Scene(cashbillUI);
				Stage stage=new Stage();
				stage.setTitle("cashUI");
				stage.initModality(Modality.WINDOW_MODAL);
				stage.initOwner(MainApp.getPrimaryStage());
				stage.setScene(scene);
	            CashBillViewController controller=loader.getController();
	            controller.setStage(stage);
	            controller.setVo(m);
	            stage.showAndWait();
	            
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(style.equals("赠送单")){
			try {
				GiftBillVO m=gbbs.findGiftBillById(Long.parseLong(id));
				FXMLLoader loader=new FXMLLoader();
				loader.setLocation(MainApp.class.getResource("/presentation/billui/GiftBillUI.fxml"));
				AnchorPane giftbillUI=loader.load();
				Scene scene=new Scene(giftbillUI);
				Stage stage=new Stage();
				stage.setTitle("GiftUI");
				stage.initModality(Modality.WINDOW_MODAL);
				stage.initOwner(MainApp.getPrimaryStage());
				stage.setScene(scene);
	            GiftBillViewController controller=loader.getController();
	            controller.setStage(stage);
	            controller.setVo(m);
	            stage.showAndWait();
	            
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(style.equals("销售退货单")){
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
	            controller.setVo(m);
	            stage.showAndWait();
	            
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(style.equals("进货退货单")){
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
	            controller.setVo(m);
	            stage.showAndWait();
	            
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(style.equals("进货单")){
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
	            controller.setVo(m);
	            stage.showAndWait();
	            
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void search(){
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
		    warninglist=wbbs.findWarningBillsByState(0);
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
		    if(warninglist!=null&&!warninglist.isEmpty()){
		    	for(WarningBillVO a:warninglist){
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
	}
}
