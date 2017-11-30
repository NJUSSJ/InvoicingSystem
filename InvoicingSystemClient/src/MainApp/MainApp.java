package MainApp;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import presentation.mainui.AdministerMainViewController;
import presentation.mainui.FianceMainViewController;
import presentation.mainui.LoginPanelController;
import presentation.mainui.ManagerMainViewController;
import presentation.mainui.SaleMainViewController;
import presentation.mainui.StockMainViewController;
import runner.ClientRunner;

/**
 * 
 * @author shisj
 *
 */
public class MainApp extends Application {
	private static Stage primarystage;
	private static BorderPane rootlayout;
	
	@Override
	public void start(Stage primarystage) throws Exception {
		// TODO Auto-generated method stub
		MainApp.primarystage=primarystage;
		MainApp.primarystage.setTitle("灯具公司进销存系统");
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
	 * 显示登录界面
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
	 * 显示财务人员主界面
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
	 * 显示管理人员主界面
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
	 * 显示销售人员主界面
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
	 * 显示库存管理人员主界面
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
	 * 显示总经理主界面
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
	 * 显示邮箱界面
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
	 * 显示日记界面
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
	 * 显示用户管理界面
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
	/**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return MainApp.primarystage;
    }
 
    
	public static void main(String[] args) {
		new ClientRunner();
		launch(args);
	}

}
