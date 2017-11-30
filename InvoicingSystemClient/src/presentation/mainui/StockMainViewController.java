package presentation.mainui;

import java.net.URL;
import java.util.ResourceBundle;

import MainApp.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StockMainViewController implements Initializable {
	@FXML
	private Label id;
	@FXML
	private Label logout;
	@FXML
	private ImageView category;
	@FXML
	private ImageView commodity;
	@FXML
	private ImageView stockCheck;
	@FXML
	private ImageView stockInventory;
	@FXML
	private ImageView email;
	@FXML
	private ImageView warn;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void showLoginUI(){
		MainApp.showLoginUI();
	}
	
	public void showEmailUI(){
		MainApp.showEmailUI();
	}
	
	public void showCategoryUI(){
		MainApp.showCategoryUI();
	}

	public void showCommodityUI(){
		MainApp.showCommodityUI();
	}

	public void showStockCheckUI(){
		MainApp.showStockCheckUI();
	}

	public void showStockInventoryUI(){
		MainApp.showStockInventoryUI();
	}
	
    public void showWarningUI(){//未写完
	 Label warnningNum=new Label("设定警戒值：");
	 TextField num=new TextField();
	 Button righB=new Button("确认");
	 righB.setOnAction(e ->{String nuM=num.getText();});
	 VBox root =new VBox();
	 root.setSpacing(3);
	 root.getChildren().addAll(warnningNum,num,righB);
	 Scene scene=new Scene(root,350,150);
	 Stage smallStage=new Stage();
	 smallStage.setTitle("Set Warning Num");
	 smallStage.setScene(scene);
	 smallStage.show();
	
    }
	 
}
