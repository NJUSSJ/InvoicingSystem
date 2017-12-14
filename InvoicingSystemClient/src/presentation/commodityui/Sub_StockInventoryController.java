package presentation.commodityui;

import java.net.URL;
import java.util.ResourceBundle;

import MainApp.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import vo.StockInventoryInfoVO;
/**
 * 
 * @author shisj
 *
 */
public class Sub_StockInventoryController implements Initializable{

	@FXML
	private Label SystemNum;
	@FXML
	private TextField ActualNum;
	@FXML
	private Button Confirm;
	@FXML
	private Button Cancel;
	
	private Stage dialogStage;
	private StockInventoryInfoVO info;
	
	
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage=dialogStage;
	}
	
	public void setInfo(StockInventoryInfoVO info) {
		this.info=info;
		String systemNum=new Integer(info.getStockNum()).toString();
		SystemNum.setText(systemNum);
	}
	
	public void handleConfirm() {
		String tmp=ActualNum.getText();
		
		try {
			int actual=Integer.parseInt(tmp);
			info.setStockNum(actual);
			int systemNum=Integer.parseInt(SystemNum.getText());
			dialogStage.close();
			/*
			 * 判定报损报溢信息
			 *
			 */
			if(systemNum>actual) {
				/*
				 * 报损
				 */
				MainApp.showLossInfo(info.getName(),systemNum-actual, info.getAveragePrice()*(systemNum-actual));
				
			}else if(systemNum<actual) {
				/*
				 * 报溢
				 */
				MainApp.showOverInfo(info.getName(),-systemNum+actual, info.getAveragePrice()*(-systemNum+actual));
			}
			/*
			String name=info.getName();
			
			CommodityController commodityController=new CommodityController();
			
			CommodityVO tmpVO= commodityController.findCommodityByName(name);
			
			tmpVO.setStockNum(actual);
			
			commodityController.updateCommodity(tmpVO);
			
			*/
		} catch (NumberFormatException e) {
			Alert error=new Alert(Alert.AlertType.WARNING);
        	error.setTitle("Format Warning");
        	error.setHeaderText("Invalid Input");
        	error.setContentText("Please enter a NUMBER!");
        	error.showAndWait();
		}
		
		
	}
	
	public void handleCancel() {
		dialogStage.close();
	}
	
	
	
	
}
