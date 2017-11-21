package MainApp;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import runner.ClientRunner;

/**
 * 
 * @author shisj
 *
 */
public class MainApp extends Application {
	private Stage primarystage;
	private BorderPane rootlayout;
	
	@Override
	public void start(Stage primarystage) throws Exception {
		// TODO Auto-generated method stub
		this.primarystage=primarystage;
		this.primarystage.setTitle("灯具公司进销存系统");
		this.primarystage.getIcons().add(new Image("file:resources/light_bulb_310px_1204967_easyicon.net.png"));
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
	public void showLoginUI() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/mainui/LoginPanel.fxml"));
			
			AnchorPane loginPanel=loader.load();
			
			rootlayout.setCenter(loginPanel);
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		new ClientRunner();
		launch(args);
	}

}
