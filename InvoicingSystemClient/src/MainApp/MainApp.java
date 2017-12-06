package MainApp;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import presentation.mainui.AdministerMainViewController;
import presentation.mainui.FianceMainViewController;
import presentation.mainui.LoginPanelController;
import presentation.mainui.ManagerMainViewController;
import presentation.mainui.SaleMainViewController;
import presentation.mainui.StockMainViewController;
import presentation.mainui.WarningViewController;
import runner.ClientRunner;
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
	
	private static long categoryid=0;
	
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
			// TODO: handle exception
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
			// TODO: handle exception
		}
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
			// TODO: handle exception
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
			// TODO: handle exception
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
			// TODO: handle exception
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
			// TODO: handle exception
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
			// TODO: handle exception
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
			// TODO: handle exception
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
			// TODO: handle exception
		}
	}
	
	/*
	 * ��ʾ�û��������
	 */
	public static  void showUserChangeUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/userui/UserChangeUI.fxml"));
			
			AnchorPane userChangeUI=loader.load();
			
			MainApp.rootlayout.setCenter(userChangeUI);
			
		} catch (IOException e) {
			// TODO: handle exception
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
			// TODO: handle exception
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
			// TODO: handle exception
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
			// TODO: handle exception
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
			// TODO: handle exception
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
			// TODO: handle exception
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
			// TODO: handle exception
		}
	}
	
	/*
	 * ��ʾ�������Խ���
	 */
	public static  void showStrategyUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/promotionui/StrategyUI.fxml"));
			
			AnchorPane strategyUI=loader.load();
			
			MainApp.rootlayout.setCenter(strategyUI);
			
		} catch (IOException e) {
			// TODO: handle exception
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
			// TODO: handle exception
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
			// TODO: handle exception
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
			// TODO: handle exception
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
			// TODO: handle exception
		}
	}
	

	/*
	 * ��ʾ�����˻����ݽ���
	 */
	public static  void showImportReturnUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/saleui/Import_ReturnUI.fxml"));
			
			AnchorPane importReturnUI=loader.load();
			
			MainApp.rootlayout.setCenter(importReturnUI);
			
		} catch (IOException e) {
			// TODO: handle exception
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
			// TODO: handle exception
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
			// TODO: handle exception
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
			// TODO: handle exception
		}
	}
	
	/*
	 * ��ʾ��Ʒ�������
	 */
	public static  void showCommodityUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/commodityui/ComodityUI.fxml"));
			
			AnchorPane commodityUI=loader.load();
			
			MainApp.rootlayout.setCenter(commodityUI);
			
		} catch (IOException e) {
			// TODO: handle exception
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
			// TODO: handle exception
		}
	}
	
	/*
	 * ��ʾ����̵����
	 */
	public static  void showStockInventoryUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/commodityui/StockInventoryUI.fxml"));
			
			AnchorPane stockInventoryUI=loader.load();
			
			MainApp.rootlayout.setCenter(stockInventoryUI);
			
		} catch (IOException e) {
			// TODO: handle exception
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
   
   /*
	 * ��ʾ��澯���߽���
	 */
	public static  void showWarningUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/mainui/WarningUI.fxml"));
			AnchorPane warningUI=loader.load();
			Scene scene=new Scene(warningUI);
			Stage warnStage=new Stage();
			warnStage.setTitle("Warning Num");
			warnStage.initModality(Modality.WINDOW_MODAL);
			warnStage.initOwner(MainApp.primarystage);
			warnStage.setScene(scene);
            WarningViewController controller=loader.getController();
            controller.setStage(warnStage);
            warnStage.showAndWait();
            
		} catch (IOException e) {
			// TODO: handle exception
		}
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


}
