package presentation.mainui;

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
import presentation.billui.BillData;
import presentation.billui.CashBillViewController;
import presentation.billui.GiftBillViewController;
import presentation.billui.PayBillViewController;
import presentation.billui.ReceiveBillViewController;
import presentation.billui.WarningBillViewController;
import presentation.commodityui.LossInfoController;
import presentation.commodityui.OverInfoController;
import presentation.saleui.ImportViewController;
import presentation.saleui.Import_ReturnViewController;
import presentation.saleui.SaleViewController;
import presentation.saleui.Sale_ReturnViewController;
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

public class EmailViewController implements Initializable {
	@FXML
	private Label id;
	@FXML
	private Button returnB;
	@FXML
	private Button deleteB;
	@FXML
	private Button logoutB;
	@FXML
	private Button showDetail;

	public  ObservableList<BillData> billData =FXCollections.observableArrayList();
	
	@FXML
	private TableView<BillData> billTable;
	
	@FXML
	private TableColumn<BillData,String> styleColoumn;
	
	@FXML
	private TableColumn<BillData,String> idColoumn;
	@FXML
	private TableColumn<BillData,String> stateColoumn;
	@FXML
	private TableColumn<BillData,String> operatorColoumn;
	
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
	ArrayList<WarningBillVO> warninglist=new ArrayList<WarningBillVO>();
	
	BillData billitem=null;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		long idLong=MainApp.getID();
		String idString=idLong+"";
		while(idString.length()<5) {
			idString="0"+idString;
		}
		id.setText("ID:"+idString);
	billTable.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> getInf(newValue));
	styleColoumn.setCellValueFactory(cellData ->cellData.getValue().getstyleProperty());
	idColoumn.setCellValueFactory(cellData ->cellData.getValue().getidProperty());
	operatorColoumn.setCellValueFactory(cellData ->cellData.getValue().getoperatorProperty());
	stateColoumn.setCellValueFactory(cellData ->cellData.getValue().getstateProperty());
    findAll();
    billTable.setItems(billData);
	}
	
	@FXML
	public void returnMain(){
		switch (MainApp.getRank()) {
		case 2:
			MainApp.showFianceMainUI();
			break;
		case 3:
            MainApp.showSaleMainUI();
			break;
		case 4:
            MainApp.showStockMainUI();
			break;
		}
	}
	@FXML
	public void logout(){
		MainApp.cancelUser();
		MainApp.showLoginUI();
	}
	@FXML
	public void delete(){
		String style=billitem.getstyle();
		String id=billitem.getid();
		String state=billitem.getstate();
		if(state.equals("1")){
		if(style.equals("销售单")){
			sbbs.fakeDelete(id);
	}else if(style.equals("付款单")){
	        pbbs.fakeDelete(id);
	}else if(style.equals("收款单")){
		   rbbs.fakeDelete(id);
	}else if(style.equals("报损单")){
		  lbbs.fakeDelete(Long.parseLong(id));
	}else if(style.equals("报溢单")){
		obbs.fakeDelete( Long.parseLong(id));
	}else if(style.equals("报警单")){
		wbbs.fakeDelete(Long.parseLong(id));
	}else if(style.equals("现金费用单")){
		cbbs.fakeDelete(id);
	}else if(style.equals("赠送单")){
		gbbs.fakeDelete(Long.parseLong(id));
	}else if(style.equals("销售退货单")){
		srbbs.fakeDelete(id);
	}else if(style.equals("进货退货单")){
		irbbs.fakeDelete(id);
	}else if(style.equals("进货单")){
		ibbs.fakeDelete( id);
	}
		}else{
			if(style.equals("销售单")){
			SaleBillVO tempbill=sbbs.findSaleBillByID(id);
			sbbs.deleteSaleBill(tempbill);
		}else if(style.equals("付款单")){
		    PayBillVO tempbill=pbbs.findPayBillByID(id);
		    pbbs.deletePayBill(tempbill);
		}else if(style.equals("收款单")){
			ReceiveBillVO tempbill=rbbs.findReceiveBillByID(id);
			rbbs.deleteReceiveBill(tempbill);
		}else if(style.equals("报损单")){
			  LossBillVO tempbill=lbbs.findLossBillByID(Long.parseLong(id));
			  lbbs.deleteLossBill(tempbill);
		}else if(style.equals("报溢单")){
			OverBillVO tempbill=obbs.findOverBillByID( Long.parseLong(id));
			obbs.deleteOverBill(tempbill);
		}else if(style.equals("报警单")){
			WarningBillVO tempbill=wbbs.findWarningBillByID(Long.parseLong(id));
			wbbs.deleteWarningBill(tempbill);
		}else if(style.equals("现金费用单")){
		    CashBillVO tempbill=cbbs.findCashBillByID(id);
		    cbbs.deleteCashBill(tempbill);
		}else if(style.equals("赠送单")){
			GiftBillVO tempbill=gbbs.findGiftBillByID(Long.parseLong(id));
			gbbs.deleteGiftBill(tempbill);
		}else if(style.equals("销售退货单")){
			SaleReturnBillVO tempbill=srbbs.findSaleReturnBillByID(id);
			srbbs.deleteSaleReturnBill(tempbill);
		}else if(style.equals("进货退货单")){
			ImportReturnBillVO tempbill=irbbs.findImportReturnBillByID(id);
			irbbs.deleteImportReturnBill(tempbill);
		}else if(style.equals("进货单")){
			ImportBillVO tempbill=ibbs.findImportBillByID(id);
			ibbs.deleteImportBill(tempbill);
		}
		}
		billData.remove(billitem);
	}
	private void findAll() {
		cashlist=cbbs.findCashBillsByUser(MainApp.getID());
	    paylist=pbbs.findPayBillsByUser(MainApp.getID());
	    receivelist=rbbs.findReceiveBillsByUser(MainApp.getID());
	    importlist=ibbs.findImportBillsByUser(MainApp.getID());
	    importreturnlist=irbbs.findImportReturnBillsByUser(MainApp.getID());
	    salelist=sbbs.findSaleBillsByUser(MainApp.getID());
	    salereturnlist=srbbs.findSaleReturnBillsByUser(MainApp.getID());
	    giftlist=gbbs.findGiftBillsByUser(MainApp.getID());
	    losslist=lbbs.findLossBillsByUser(MainApp.getID());
	    overlist=obbs.findOverBillsByUser(MainApp.getID());
	    warninglist=wbbs.findWarningBillsByUser(MainApp.getID());
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
	}
	
	
	private void getInf(BillData newValue) {
		if(newValue!=null){
			billitem=newValue;
		}

	}
	@FXML
	public void showDetail(){
		String id=billitem.getid();
		String style=billitem.getstyle();
		int state=0;
		if(billitem.getstate().equals("通过")) {
			state=1;
		}else if(billitem.getstate().equals("不通过")) {
			state=2;
		}
		
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
	            if(state==1){
	            	controller.setVo(m);
	            }else{
	            	controller.setVO(m);
	            }
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
	            if(state==1){
	            	controller.setVo(m);
	            }else{
	            	controller.setVO(m);
	            }
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
	            if(state==1){
	            	controller.setVo(m);
	            }else{
	            	controller.setVO(m);
	            }
	            stage.showAndWait();
	            
			} catch (Exception e) {
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
	            if(state==1){
	            	controller.setVo(m);
	            }else{
	            	controller.setVO(m);
	            }
	            stage.showAndWait();
	            
			} catch (Exception e) {
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
	            if(state==1){
	            	controller.setVo(m);
	            }else{
	            	controller.setVO(m);
	            }
	            stage.showAndWait();
	            
			} catch (Exception e) {
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
	            if(state==1){
	            	controller.setVo(m);
	            }else{
	            	controller.setVO(m);
	            }
	            stage.showAndWait();
	            
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(style.equals("赠送单")){
			try {
				GiftBillVO m=gbbs.findGiftBillByID(Long.parseLong(id));
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
	            if(state==1){
	            	controller.setVo(m);
	            }else{
	            	controller.setVO(m);
	            }
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
	            if(state==1){
	            	controller.setVo(m);
	            }else{
	            	controller.setVO(m);
	            }
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
	            if(state==1){
	            	controller.setVo(m);
	            }else{
	            	controller.setVO(m);
	            }
	            stage.showAndWait();
	            
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
