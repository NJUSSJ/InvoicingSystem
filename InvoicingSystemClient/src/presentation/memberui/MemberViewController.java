package presentation.memberui;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import MainApp.MainApp;
import businesslogic.logbl.LogController;
import businesslogic.memberbl.MemberController;
import businesslogic.utilitybl.Utility;
import businesslogicservice.memberblservice.MemberBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import vo.LogVO;
import vo.MemberVO;

public class MemberViewController implements Initializable {
	@FXML
	private Label id;
	
	@FXML
	private Button logout;
	
	@FXML
	private TextField search;
	
	@FXML
	private Button rightB;
	
	@FXML
	private Button addB;
	
	@FXML
	private Button deleteB;
	
	@FXML
	private Button updateB;
	
	@FXML
	private Button returnB;
	
	private ObservableList<MemberData> memberData =FXCollections.observableArrayList();
	
	@FXML
	private TableView<MemberData> memberTable;
	
	@FXML
	private TableColumn<MemberData,String> idColoumn;
	@FXML
	private TableColumn<MemberData,String> categoryColoumn;
	@FXML
	private TableColumn<MemberData,String> rankColoumn;
	@FXML
	private TableColumn<MemberData,String> nameColoumn;
	@FXML
	private TableColumn<MemberData,String> telephoneColoumn;
	@FXML
	private TableColumn<MemberData,String> addressColoumn;
	@FXML
	private TableColumn<MemberData,String> emailColoumn;
	@FXML
	private TableColumn<MemberData,String> shouldpayColoumn;
	@FXML
	private TableColumn<MemberData,String> shouldgetColoumn;
	@FXML
	private TableColumn<MemberData,String> postcodeColoumn;
	@FXML
	private TableColumn<MemberData,String> quotaColoumn;//应收额度
	@FXML
	private TableColumn<MemberData,String> operatorColoumn;
	
	ArrayList<MemberVO> memberList;
	
	MemberVO me;
	
	MemberBLService mbs=new MemberController();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		long idLong=MainApp.getID();
		String idString=idLong+"";
		while(idString.length()<5) {
			idString="0"+idString;
		}
		id.setText("ID:"+idString);
		memberTable.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> getInf(newValue));
		nameColoumn.setCellValueFactory(cellData ->cellData.getValue().getNameProperty());
		categoryColoumn.setCellValueFactory(cellData ->cellData.getValue().getCategoryProperty());
		idColoumn.setCellValueFactory(cellData ->cellData.getValue().getidProperty());
		rankColoumn.setCellValueFactory(cellData ->cellData.getValue().getRankProperty());
		addressColoumn.setCellValueFactory(cellData ->cellData.getValue().getAddressProperty());
		postcodeColoumn.setCellValueFactory(cellData ->cellData.getValue().getPostCodeProperty());
		emailColoumn.setCellValueFactory(cellData ->cellData.getValue().getEmailProperty());
		quotaColoumn.setCellValueFactory(cellData ->cellData.getValue().getQuotaProperty());
		operatorColoumn.setCellValueFactory(cellData ->cellData.getValue().getOperatorProperty());
		shouldpayColoumn.setCellValueFactory(cellData ->cellData.getValue().getpayProperty());
		shouldgetColoumn.setCellValueFactory(cellData ->cellData.getValue().getgetProperty());
	    telephoneColoumn.setCellValueFactory(cellData ->cellData.getValue().getTelephoneProperty());
	    memberList=mbs.findMembers();
	    for(MemberVO a:memberList){
			memberData.add(new MemberData(a));
		}
	    memberTable.setItems(memberData);
	}

	private void getInf(MemberData newValue) {
		if(newValue==null){
			return;
		}
		me=newValue.getVO();
	}
	
	@FXML
	public void search(){
		String findName=search.getText();
		
		if(findName==null||findName.length()<=0){
			 MainApp.showMemberUI();
	            return;
		}
		if(findName.charAt(0)>='0'&&findName.charAt(0)<='9'){
			me=mbs.findMemberByID(Long.parseLong(findName));
			if(me==null){
				Alert alert = new Alert(AlertType.WARNING);
	   	        alert.initOwner(MainApp.getPrimaryStage());
	   	        alert.setTitle("Not Found");
	   	        alert.setHeaderText("Not Found");
	   	        alert.setContentText("Not Found:"+findName);
	            alert.showAndWait();
	            return;
			}
			memberData.clear();
			memberData.add(new MemberData(me));
			memberTable.setItems(memberData);
		}else{
		memberList=mbs.findMembersByField(findName);
		if(memberList==null||memberList.size()<=0){
			Alert alert = new Alert(AlertType.WARNING);
   	        alert.initOwner(MainApp.getPrimaryStage());
   	        alert.setTitle("Not Found");
   	        alert.setHeaderText("Not Found");
   	        alert.setContentText("Not Found:"+findName);
            alert.showAndWait();
            return;
		}
		memberData.clear();
		for(MemberVO a:memberList){
			memberData.add(new MemberData(a));
		}
		memberTable.setItems(memberData);
		}
	}
	@FXML
	public void add(){
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/memberui/SimpleMember.fxml"));
			AnchorPane memberUI=loader.load();
			Scene scene=new Scene(memberUI);
			Stage memberStage=new Stage();
			memberStage.setTitle("Create/Change Member");
			memberStage.initModality(Modality.WINDOW_MODAL);
			memberStage.initOwner(MainApp.getPrimaryStage());
			memberStage.setScene(scene);
            SimpleMemberController controller=loader.getController();
            controller.setStage(memberStage);
            controller.setList(memberData);
            memberStage.showAndWait();
            
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	public void delete(){
		int selectedIndex = memberTable.getSelectionModel().getSelectedIndex();

   	 	if (selectedIndex >= 0) {
   	 	//记录日志
   	 		if(me.getShouldGet()!=0||me.getShouldPay()!=0) {
   	 			Alert alert = new Alert(AlertType.WARNING);
   	 			alert.initOwner(MainApp.getPrimaryStage());
   	 			alert.setTitle("Member delete error");
   	 			alert.setHeaderText("Member delete error");
   	 			alert.setContentText("Member still has trade on process!");
   	 			alert.showAndWait();
   	 			return;
   	 		}
   	 		
   	 		if(mbs.deleteMember(me)){
   	 		//
			LogController logController=new LogController();
			long logID=logController.findLargestID()+1;
	        LogVO logVO=new LogVO(logID,new Date(Utility.getNow().getTime()),"deleteMember:"+me.getID(),MainApp.getID());
	        logController.addLog(logVO);
	        //
   	 		memberTable.getItems().remove(selectedIndex);
   	 		}else{
   	 			Alert alert = new Alert(AlertType.WARNING);
	 			alert.initOwner(MainApp.getPrimaryStage());
	 			alert.setTitle("Member delete error");
	 			alert.setHeaderText("Member delete error");
	 			alert.setContentText("Member has unchecked bill！");
	 			alert.showAndWait();
	 			return;
   	 		}
   	    } else {
   	        // Nothing selected.
   	        Alert alert = new Alert(AlertType.WARNING);
   	        alert.initOwner(MainApp.getPrimaryStage());
   	        alert.setTitle("No Selection");
   	        alert.setHeaderText("No Member Selected");
   	        alert.setContentText("Please select a mmember in the table.");
            alert.showAndWait();
   	    }
	}
	@FXML
	public void update(){
		if(me==null) {
			Alert alert = new Alert(AlertType.WARNING);
   	        alert.initOwner(MainApp.getPrimaryStage());
   	        alert.setTitle("No Selection");
   	        alert.setHeaderText("No Member Selected");
   	        alert.setContentText("Please select a mmember in the table.");
            alert.showAndWait();
		}
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/memberui/SimpleMember.fxml"));
			AnchorPane memberUI=loader.load();
			Scene scene=new Scene(memberUI);
			Stage memberStage=new Stage();
			memberStage.setTitle("Create/Change Member");
			memberStage.initModality(Modality.WINDOW_MODAL);
			memberStage.initOwner(MainApp.getPrimaryStage());
			memberStage.setScene(scene);
            SimpleMemberController controller=loader.getController();
            controller.setStage(memberStage);
            controller.setMember(me);
            controller.setList(memberData);
            controller.setMemberData(memberData.get(memberTable.getSelectionModel().getSelectedIndex()));
            memberStage.showAndWait();
            
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	public void logout(){
		MainApp.cancelUser();
		MainApp.showLoginUI();
	}
	@FXML
	public void showSaleMainUI(){
		MainApp.showSaleMainUI();
	}
}
