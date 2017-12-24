package presentation.logui;

import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import MainApp.MainApp;
import businesslogic.logbl.LogController;
import businesslogic.userbl.UserController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import vo.LogVO;
import vo.UserVO;

public class LogViewController implements Initializable {
	@FXML
	private Label id;
	@FXML
	private Label logout;
	@FXML
	private Button rightB;
	@FXML
	private Button returnB;
	@FXML
	private TextField operator;
	@FXML
	private TextField beginYear;
	@FXML
	private TextField endYear;
	@FXML
	private TextField beginMonth;
	@FXML
	private TextField endMonth;
	@FXML
	private TextField beginDay;
	@FXML
	private TextField endDay;
	@FXML
	private TextField type;
	@FXML
	private TableView<LogData> logTable;
	@FXML
	private TableColumn<LogData,String> nameColumn;
	@FXML
	private TableColumn<LogData,String> timeColumn;
	@FXML
	private TableColumn<LogData,String> typeColumn;
	
	private ObservableList<LogData> logData =FXCollections.observableArrayList();
	
	private ArrayList<LogVO> volist=new ArrayList<LogVO>();
	
	private LogController lcon=new LogController();
	private UserController ucon=new UserController();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		long idLong=MainApp.getID();
		String idString=idLong+"";
		while(idString.length()<5) {
			idString="0"+idString;
		}
		id.setText("ID:"+idString);
		/*categoryTable.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> getInf(newValue));*/
		timeColumn.setCellValueFactory(cellData ->cellData.getValue().getTime());
		nameColumn.setCellValueFactory(cellData ->cellData.getValue().getName());
		typeColumn.setCellValueFactory(cellData ->cellData.getValue().getType());
	    //volist=lcon.findLogs();
		volist.add(new LogVO(0, new Date(new java.util.Date().getTime()), "faq", 2));
		volist.add(new LogVO(0, new Date(new java.util.Date().getTime()), "leather", 3));
		volist.add(new LogVO(0, new Date(new java.util.Date().getTime()), "faq", 4));
	    for(LogVO log:volist){
			logData.add(new LogData(log));
		}
		logTable.setItems(logData);
	}
	@FXML
	public void back(){
		MainApp.showAdministerMainUI();
	}
	@FXML
	public void logOut(){
		MainApp.cancelUser();
		MainApp.showLoginUI();
	}
	@FXML
	public void search(){
		String beginYText=beginYear.getText();
		String beginMText=beginMonth.getText();
		String beginDText=beginDay.getText();
		String endYText=endYear.getText();
		String endMText=endMonth.getText();
		String endDText=endDay.getText();
		String userName=operator.getText();
		String operateType=type.getText();
		//volist=lcon.findLogs();
		volist=new ArrayList<LogVO>();
		volist.add(new LogVO(0, new Date(new java.util.Date().getTime()), "faq", 2));
		volist.add(new LogVO(0, new Date(new java.util.Date().getTime()), "leather", 3));
		volist.add(new LogVO(0, new Date(new java.util.Date().getTime()), "faq", 4));
		if(userName!=null&&userName.length()>0){
			volist=findByUsername(userName,volist);
		}
		if(operateType!=null&&operateType.length()>0){
			volist=findByType(operateType,volist);
		}
		int inputNum=0;
		if(beginYText!=null&&beginYText.length()>0){
			inputNum++;
		}
		if(beginMText!=null&&beginMText.length()>0){
			inputNum++;
		}
		if(beginDText!=null&&beginDText.length()>0){
			inputNum++;
		}
		if(endYText!=null&&endYText.length()>0){
			inputNum++;
		}
		if(endMText!=null&&endMText.length()>0){
			inputNum++;
		}
		if(endDText!=null&&endDText.length()>0){
			inputNum++;
		}
		if(inputNum==6){
			if(beginMText.length()<2){
				beginMText="0"+beginMText;
			}
			if(beginDText.length()<2){
				beginDText="0"+beginDText;
			}
			if(endMText.length()<2){
				endMText="0"+endMText;
			}
			if(endDText.length()<2){
				endDText="0"+endDText;
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			try {
				java.util.Date d = sdf.parse(beginYText+beginMText+beginDText);
				Date begin=new Date(d.getTime());
				d = sdf.parse(endYText+endMText+endDText);
				Date end=new Date(d.getTime());
				volist=findByInterval(begin,end,volist);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}else if(inputNum>0){
			 Alert alert = new Alert(AlertType.WARNING);
	   	        alert.initOwner(MainApp.getPrimaryStage());
	   	        alert.setTitle("Input error");
	   	        alert.setHeaderText("Input error");
	   	        alert.setContentText("Input error:Date is incomplete");
	            alert.showAndWait();
		}
		if(volist==null||volist.isEmpty()){
			 Alert alert = new Alert(AlertType.WARNING);
	   	        alert.initOwner(MainApp.getPrimaryStage());
	   	        alert.setTitle("Not found");
	   	        alert.setHeaderText("Not found");
	   	        alert.setContentText("No result");
	            alert.showAndWait();
	            return;
		}
		
		logData.clear();
		for(LogVO log:volist){
			logData.add(new LogData(log));
		}
		logTable.setItems(logData);
	}
	public ArrayList<LogVO> findByInterval(Date begin,Date end,ArrayList<LogVO> list){
		ArrayList<LogVO> result=new ArrayList<LogVO>();
		for(LogVO vo:list){
			if(vo.getTime().before(end)&&vo.getTime().after(begin)){
				result.add(vo);
			}
		}
		return result;
	}
	public ArrayList<LogVO> findByUsername(String userName,ArrayList<LogVO> list){
		ArrayList<LogVO> result=new ArrayList<LogVO>();
		UserVO user=ucon.findUserbyName(userName);
		if(user==null){
			return list;
		}
		long id=user.getID();
		for(LogVO vo:list){
			if(id==vo.getUserID()){
				result.add(vo);
			}
		}
		return result;
	}
	public ArrayList<LogVO> findByType(String type,ArrayList<LogVO> list){
		ArrayList<LogVO> result=new ArrayList<LogVO>();
		for(LogVO vo:list){
			//System.out.println(vo.getType()+"=="+type);
			if(vo.getType().equals(type)){
				result.add(vo);
			}
		}
		return result;
	}
}
