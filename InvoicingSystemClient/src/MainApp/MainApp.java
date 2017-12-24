 package MainApp;

import java.io.IOException;
import java.util.Optional;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import presentation.commodityui.LossInfoController;
import presentation.commodityui.OverInfoController;
import presentation.commodityui.Sub_StockInventoryController;
import runner.ClientRunner;
import vo.StockInventoryInfoVO;
import vo.UserVO;

/**
 * 
 * @author shisj
 *
 */
public class MainApp extends Application {
	private static Stage primarystage;
	
	private static BorderPane rootlayout;
	
	private static UserVO tempUser;
	
	
	@Override
	public void start(Stage primarystage) throws Exception {
		// TODO Auto-generated method stub
		MainApp.primarystage=primarystage;
		MainApp.primarystage.setTitle("�ƾ߹�˾������ϵͳ");
		MainApp.primarystage.getIcons().add(new Image("file:resources/light_bulb_310px_1204967_easyicon.net.png"));
		initRootLayout();
		showLoginUI();
	}
	/*
	 * initialize the rootlayout
	 */
	public void initRootLayout() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/RootLayout/RootLayout.fxml"));
			rootlayout=(BorderPane)loader.load();
			Scene scene =new Scene(rootlayout);
			
			primarystage.setScene(scene);
			primarystage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ��ʾ��¼����
	 */
	public static  void showLoginUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/mainui/LoginPanel.fxml"));
			
			AnchorPane loginPanel=loader.load();
			MainApp.rootlayout.setCenter(loginPanel);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int getRank(){
		return tempUser.getRank();
	}
	/*
	 * ��ʾ������Ա������
	 */
	public static  void showFianceMainUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/mainui/FianceMainUI.fxml"));
			
			AnchorPane fianceMainUI=loader.load();
			
			MainApp.rootlayout.setCenter(fianceMainUI);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ��ʾ������Ա������
	 */
	public static  void showAdministerMainUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/mainui/AdministMainUI.fxml"));
			
			AnchorPane administMainUI=loader.load();
			
			MainApp.rootlayout.setCenter(administMainUI);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ��ʾ������Ա������
	 */
	public static  void showSaleMainUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/mainui/SaleMainUI.fxml"));
			
			AnchorPane saleMainUI=loader.load();
			
			MainApp.rootlayout.setCenter(saleMainUI);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ��ʾ��������Ա������
	 */
	public static  void showStockMainUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/mainui/StockMainUI.fxml"));
			
			AnchorPane stockMainUI=loader.load();
			
			MainApp.rootlayout.setCenter(stockMainUI);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ��ʾ�ܾ���������
	 */
	public static  void showManagerMainUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/mainui/ManagerMainUI.fxml"));
			
			AnchorPane managerMainUI=loader.load();
			
			MainApp.rootlayout.setCenter(managerMainUI);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ��ʾ�������
	 */
	public static  void showEmailUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/mainui/EmailUI.fxml"));
			
			AnchorPane emailUI=loader.load();
			
			MainApp.rootlayout.setCenter(emailUI);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ��ʾ�ռǽ���
	 */
	public static  void showLogUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/logui/LogUI.fxml"));
			
			AnchorPane logUI=loader.load();
			
			MainApp.rootlayout.setCenter(logUI);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ��ʾ�û��������
	 */
	public static  void showUserChangeUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/userui/UserUI.fxml"));
			AnchorPane userUI=loader.load();
			
			MainApp.rootlayout.setCenter(userUI);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	/*
	 * ��ʾ��Ӫ���̽���
	 */
	public static  void showManageCourseUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/tableui/ManageCourseUI.fxml"));
			
			AnchorPane manageCourseUI=loader.load();
			
			MainApp.rootlayout.setCenter(manageCourseUI);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ��ʾ��Ӫ�������
	 */
	public static  void showManageSituationUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/tableui/ManageSituationUI.fxml"));
			
			AnchorPane manageSituationUI=loader.load();
			
			MainApp.rootlayout.setCenter(manageSituationUI);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ��ʾ������ϸ����
	 */
	public static  void showSaleDetailsUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/tableui/SaleDetailsUI.fxml"));
			
			AnchorPane saleDetailsUI=loader.load();
			
			MainApp.rootlayout.setCenter(saleDetailsUI);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ��ʾ�˻��������
	 */
	public static  void showAccountUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/accountui/AccountUI.fxml"));
			
			AnchorPane accountUI=loader.load();
			
			MainApp.rootlayout.setCenter(accountUI);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * ��ʾ�տ����
	 */
	public static  void showReceiveBillUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/billui/ReceiveBillUI.fxml"));
			
			AnchorPane receiveBillUI=loader.load();
			
			MainApp.rootlayout.setCenter(receiveBillUI);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ��ʾ�������
	 */
	public static  void showPayBillUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/billui/PayBillUI.fxml"));
			
			AnchorPane payBillUI=loader.load();
			
			MainApp.rootlayout.setCenter(payBillUI);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ��ʾ�������Խ���
	 */
	public static  void showStrategyUI() {
		try {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation the Type of Promotion");
			alert.setHeaderText("Choose Promotion Type");
			alert.setContentText("Choose Promotion Type");

			ButtonType buttonTypeMember = new ButtonType("Member");
			ButtonType buttonTypePrice = new ButtonType("Price");
			ButtonType buttonTypePackage = new ButtonType("Package");
			ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

			alert.getButtonTypes().setAll(buttonTypeMember, buttonTypePrice, buttonTypePackage, buttonTypeCancel);

			Optional<ButtonType> result = alert.showAndWait();
			String type;
			if (result.get() == buttonTypeMember){
			    type="Member";
			} else if (result.get() == buttonTypePackage) {
			    type="Package";
			} else if (result.get() == buttonTypePrice) {
			    type="Price";
			} else {
				type="Package";
			}
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/promotionui/"+type+"PromotionUI.fxml"));
			
			AnchorPane strategyUI=loader.load();
			
			MainApp.rootlayout.setCenter(strategyUI);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * ��ʾ�ڳ����˽���
	 */
	public static  void showAccountBookUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/accountui/AccountBookUI.fxml"));
			
			AnchorPane accountBookUI=loader.load();
			
			MainApp.rootlayout.setCenter(accountBookUI);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ��ʾ�������ݽ���
	 */
	public static  void showExamineUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/billui/ExamineUI.fxml"));
			
			AnchorPane examineUI=loader.load();
			
			MainApp.rootlayout.setCenter(examineUI);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ��ʾ�û��������
	 */
	public static  void showMemberUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/memberui/MemberUI.fxml"));
			
			AnchorPane memberUI=loader.load();
			
			MainApp.rootlayout.setCenter(memberUI);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ��ʾ�������ݽ���
	 */
	public static  void showImportUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/saleui/ImportUI.fxml"));
			
			AnchorPane importUI=loader.load();
			
			MainApp.rootlayout.setCenter(importUI);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	/*
	 * ��ʾ�����˻����ݽ���
	 */
	public static  void showImportReturnUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/saleui/Import_Return.fxml"));
			
			AnchorPane importReturnUI=loader.load();
			
			MainApp.rootlayout.setCenter(importReturnUI);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	/*
	 * ��ʾ���۵��ݽ���
	 */
	public static  void showSaleUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/saleui/SaleUI.fxml"));
			
			AnchorPane saleUI=loader.load();
			
			MainApp.rootlayout.setCenter(saleUI);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ��ʾ�����˻����ݽ���
	 */
	public static  void showSaleReturnUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/saleui/Sale_ReturnUI.fxml"));
			
			AnchorPane saleReturnUI=loader.load();
			
			MainApp.rootlayout.setCenter(saleReturnUI);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ��ʾ��Ʒ�������
	 */
	public static  void showCategoryUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/commodityui/CategoryUI.fxml"));
			
			AnchorPane categoryUI=loader.load();
			
			MainApp.rootlayout.setCenter(categoryUI);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ��ʾ��Ʒ�������
	 */
	public static  void showCommodityUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/commodityui/CommodityUI.fxml"));
			
			AnchorPane commodityUI=loader.load();
			
			MainApp.rootlayout.setCenter(commodityUI);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ��ʾ���鿴����
	 */
	public static  void showStockCheckUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/commodityui/StockCheckUI.fxml"));
			
			AnchorPane stockCheckUI=loader.load();
			
			MainApp.rootlayout.setCenter(stockCheckUI);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ��ʾ����̵����
	 */
	public static  void showStockInventoryUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/commodityui/StockInventory.fxml"));
			
			AnchorPane stockInventoryUI=loader.load();
			
			MainApp.rootlayout.setCenter(stockInventoryUI);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * correct the user
	 */
   public static void setUser(UserVO use){
        MainApp.tempUser=use;
   }
   /*
	 * cancel the user
	 */
   public static void cancelUser(){
	   MainApp.tempUser=null;
	}
   
   /*
  	 * ��ʾ�û���id
  	 */
   public static long getID(){
	   return  MainApp.tempUser.getID();
   }
	
	/**
     * Returns the main stage.
     * @return
     */
    public static Stage getPrimaryStage() {
        return MainApp.primarystage;
    }
 
    
	public static void main(String[] args) {
		new ClientRunner();
		launch(args);
	}
	/*
	 * ��ʾָ���ֽ���õ�
	 */
	public static void showcashBill() {
		// TODO Auto-generated method stub
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/billui/CashBillUI.fxml"));
			AnchorPane cashBillUI;
			cashBillUI = loader.load();
			MainApp.rootlayout.setCenter(cashBillUI);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * ��ʾ����̵��̵����
	 * 
	 */
	
	public static void showStockInventorySub(StockInventoryInfoVO info) {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/commodityui/Sub_StockInventory.fxml"));
			
			AnchorPane pane=(AnchorPane)loader.load();
			
			 Stage dialogStage = new Stage();
		     dialogStage.setTitle("�̵�");
		     dialogStage.getIcons().add(new Image("file:resources/light_bulb_310px_1204967_easyicon.net.png"));
		     dialogStage.initModality(Modality.WINDOW_MODAL);
		     dialogStage.initOwner(primarystage);
		     Scene scene = new Scene(pane);
		     dialogStage.setScene(scene);
		     
		     Sub_StockInventoryController controller=loader.getController();
		     controller.setInfo(info);
		     controller.setDialogStage(dialogStage);
		     
		     dialogStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*

	 * ���ز���Ա������
	 */
	public static String getName() {
		// TODO Auto-generated method stub
		return tempUser.getUsername();
	}
	/*
	 * ��ʾ������Ϣ����
	 * 
	 */
	public static void showLossInfo(String name,int num,double sum) {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/commodityui/LossBillUI.fxml"));
			AnchorPane pane=(AnchorPane)loader.load();
			
			Stage dialogStage=new Stage();
			dialogStage.setTitle("������Ϣ");
			dialogStage.getIcons().add(new Image("file:resources/light_bulb_310px_1204967_easyicon.net.png"));
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primarystage);
			Scene scene=new Scene(pane);
			dialogStage.setScene(scene);
			
			LossInfoController controller=loader.getController();
			controller.setStage(dialogStage);
			controller.setInfo(name, num, sum);
			
			dialogStage.showAndWait();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * ��ʾ������Ϣ����
	 */
	public static void showOverInfo(String name,int num,double sum) {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/commodityui/OverBillUI.fxml"));
			AnchorPane pane=(AnchorPane)loader.load();
			
			Stage dialogStage=new Stage();
			dialogStage.setTitle("������Ϣ");
			dialogStage.getIcons().add(new Image("file:resources/light_bulb_310px_1204967_easyicon.net.png"));
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primarystage);
			Scene scene=new Scene(pane);
			dialogStage.setScene(scene);
			
			OverInfoController controller=loader.getController();
			controller.setStage(dialogStage);
			controller.setInfo(name, num, sum);
			
			dialogStage.showAndWait();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
