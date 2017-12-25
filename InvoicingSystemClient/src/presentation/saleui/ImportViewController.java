package presentation.saleui;

import java.net.URL;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import MainApp.MainApp;
import businesslogic.billbl.CommodityLineItem;
import businesslogic.billbl.CommodityList;
import businesslogic.billbl.ImportBillController;
import businesslogic.commoditybl.CommodityController;
import businesslogic.logbl.LogController;
import businesslogic.memberbl.MemberController;
import businesslogic.utilitybl.Utility;
import businesslogicservice.billblservice.ImportBillBLService;
import businesslogicservice.commodityblservice.CommodityBLService;
import businesslogicservice.memberblservice.MemberBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import vo.CommodityVO;
import vo.ImportBillVO;
import vo.LogVO;
import vo.MemberVO;

public class ImportViewController implements Initializable {
	@FXML
	private Label id;
	
	@FXML
	private Button logout;
	@FXML
	private Button reviseB;
	@FXML
	private Button search;
	
	@FXML
	private Label altogether;
	
	@FXML
	private Label billid;
	
	@FXML
	private Label operator;
	
	@FXML
	private TextField name;
	
	@FXML
	private TextField member;
	
	@FXML
	private TextField lastprice;
	
	@FXML
	private TextField note;
	
	@FXML
	private TextField num;
	
	@FXML
	private TextArea notea;
	
	@FXML
	private Button rightB;
	
	@FXML
	private Button addB;
	
	@FXML
	private Button deleteB;
	
	@FXML
	private Button returnB;
	Stage stage;
	private ObservableList<CommodityItemData> commodityData =FXCollections.observableArrayList();
	
	@FXML
	private TableView<CommodityItemData> commodityTable;
	
	@FXML
	private TableColumn<CommodityItemData,String> nameColumn;
	
	@FXML
	private TableColumn<CommodityItemData,String> amountColumn;
	@FXML
	private TableColumn<CommodityItemData,String> idColumn;
	@FXML
	private TableColumn<CommodityItemData,String> modelColumn;
	@FXML
	private TableColumn<CommodityItemData,String> moneyColumn;
	@FXML
	private TableColumn<CommodityItemData,String> totalmoneyColumn;
	@FXML
	private TableColumn<CommodityItemData,String> noteColumn;
	
	static int times=0;
	
	Date time;
	CommodityItemData itemdata=null;
	CommodityLineItem item=null;
	CommodityList comlist=new CommodityList();
	CommodityVO a;
	MemberVO memberl;
	CommodityBLService cbs=new CommodityController();
	MemberBLService mbs=new MemberController();
	ImportBillBLService ibbs=new ImportBillController();
	ImportBillVO unpassbill=null;
	int ishas=0;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		java.util.Date utiltime=new java.util.Date();
		time=new Date(utiltime.getTime());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		String str=sdf.format(time);
		DecimalFormat df=new DecimalFormat("#####");
		
		ArrayList<ImportBillVO> tmpList=new ImportBillController().findImportBillByTime(time);
		times=tmpList.size()+1;
		
		billid.setText("JHD-"+str+"-"+df.format(times));
		/*
		 * set id
		 */
		long idLong=MainApp.getID();
		String idString=idLong+"";
		while(idString.length()<5) {
			idString="0"+idString;
		}
		id.setText("ID:"+idString);
		
		operator.setText(MainApp.getName());
		commodityTable.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> getInf(newValue));
		nameColumn.setCellValueFactory(cellData ->cellData.getValue().getName());
		amountColumn.setCellValueFactory(cellData ->cellData.getValue().getNum());
		idColumn.setCellValueFactory(cellData ->cellData.getValue().getId());
		noteColumn.setCellValueFactory(cellData ->cellData.getValue().getNote());
		totalmoneyColumn.setCellValueFactory(cellData ->cellData.getValue().getTotalPrice());
		modelColumn.setCellValueFactory(cellData ->cellData.getValue().getModel());
		moneyColumn.setCellValueFactory(cellData ->cellData.getValue().getImportPrice());
	    altogether.setText("0");
	    reviseB.setVisible(false);
	    commodityTable.setItems(commodityData);
	}

	
	private void getInf(CommodityItemData newValue) {
		if(newValue!=null) {
			itemdata=newValue;
			item=itemdata.getItem();
			name.setText(newValue.getName().get());
			num.setText(""+item.getNum());
			lastprice.setText(""+item.getImportPrice());
			notea.setText(item.getRemark());
			ishas=1;
		}
	}

	@FXML
	public void delete(){
		int selectedIndex = commodityTable.getSelectionModel().getSelectedIndex();
	   	 if (selectedIndex >= 0) {
	   		   comlist.deleteCommodity(item);
	   		   commodityTable.getItems().remove(selectedIndex); 
	           altogether.setText(""+comlist.getImportTotal());
	   	    } else {
	   	        // Nothing selected.
	   	        Alert alert = new Alert(AlertType.WARNING);
	   	        alert.initOwner(MainApp.getPrimaryStage());
	   	        alert.setTitle("No Selection");
	   	        alert.setHeaderText("No Item Selected");
	   	        alert.setContentText("Please select an item in the table.");
                 alert.showAndWait();
	   	    }
	}
	@FXML
	public void search(){
		String findname=name.getText();
		if(findname.charAt(0)>='0'&&findname.charAt(0)<='9'){
			a=cbs.findCommodityByID(Long.parseLong(findname));
		}else{
			a=cbs.findCommodityByName(findname);
		}
		if(a==null){
			 Alert alert = new Alert(AlertType.WARNING);
	   	        alert.initOwner(MainApp.getPrimaryStage());
	   	        alert.setTitle("No Commodity");
	   	        alert.setHeaderText("No Commodity find");
	   	        alert.setContentText("Please comfirm your spelling ");

	   	        alert.showAndWait();
		}else{
			lastprice.setText(""+a.getImportPrice());
		}
	}
	@FXML
	public void confirm(){
		if(ishas==0){
			itemdata=new CommodityItemData(0,a,Integer.parseInt(num.getText()),Double.parseDouble(lastprice.getText()),notea.getText());
		    item=new CommodityLineItem(Integer.parseInt(num.getText()),a.getID(),Double.parseDouble(lastprice.getText()),a.getImportPrice(),notea.getText());
		    comlist.addCommodity(item);
			commodityData.add(itemdata);
			}else{
				ishas=0;
				itemdata.setNum(num.getText());
				comlist.deleteCommodity(item);
				comlist.addCommodity(itemdata.getItem());
			}
	    altogether.setText(""+comlist.getImportTotal());
	    name.setText("");
	    lastprice.setText("");
	    num.setText("");
	    notea.setText("");
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
	@FXML
	public void revise(){
		memberl=mbs.findMemberByName(member.getText());
		if(memberl==null) {
			Alert warning=new Alert(AlertType.WARNING);
			warning.setContentText("供应商不存在");
			warning.showAndWait();
			return ;
		}
		ImportBillVO importbill=new ImportBillVO(billid.getText(),MainApp.getID(),memberl.getID(),comlist,comlist.getImportTotal(),0,time,note.getText());
		 String isSubmit="fail Submit";
		 ibbs.deleteImportBill(unpassbill);
		 if(ibbs.submitImportBill(importbill)){
			 isSubmit="succeed Submit";
			//记录日志
				LogController logController=new LogController();
				long logID=logController.findLargestID()+1;
	        LogVO logVO=new LogVO(logID,new Date(Utility.getNow().getTime()),"submitImportBill:"+importbill.getID(),MainApp.getID());
	        logController.addLog(logVO);
	        //
		 }
		 		Alert alert = new Alert(AlertType.INFORMATION);
		        alert.initOwner(MainApp.getPrimaryStage());
		        alert.setTitle("Information");
		        alert.setHeaderText("Submit");
		        alert.setContentText(isSubmit);
		        alert.showAndWait();
		 
	}
	@FXML
	public void setBill(){
		memberl=mbs.findMemberByName(member.getText());
		if(memberl==null) {
			Alert warning=new Alert(AlertType.WARNING);
			warning.setContentText("供应商不存在");
			warning.showAndWait();
			return ;
		}
		ImportBillVO importbill=new ImportBillVO(billid.getText(),MainApp.getID(),memberl.getID(),comlist,comlist.getImportTotal(),0,time,note.getText());
		 String isSubmit="fail Submit";
		 if(ibbs.submitImportBill(importbill)){
			 //记录日志
			 LogController logController=new LogController();
			 long logID=logController.findLargestID()+1;
			 LogVO logVO=new LogVO(logID,new Date(Utility.getNow().getTime()),"submitImportBill:"+importbill.getID(),MainApp.getID());
			 logController.addLog(logVO);
			 //
			 SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			 String str=sdf.format(time);
			 DecimalFormat df=new DecimalFormat("#####");
			 
			 ArrayList<ImportBillVO> tmpList=new ImportBillController().findImportBillByTime(time);
			 times=tmpList.size()+1;
				
			 billid.setText("JHD-"+str+"-"+df.format(times));
			 
			 isSubmit="Succeed Submit";
				
			 member.setText("");
			 name.setText("");
			 note.setText("");
			 notea.setText("");
			 num.setText("");
			 lastprice.setText("");
				
			 commodityData.clear();
		 }
		 		Alert alert = new Alert(AlertType.INFORMATION);
		        alert.initOwner(MainApp.getPrimaryStage());
		        alert.setTitle("Information");
		        alert.setHeaderText("Submit");
		        alert.setContentText(isSubmit);
		        alert.showAndWait();
	}


	public void setStage(Stage stage) {
		this.stage=stage;
	}


	public void setVo(ImportBillVO m) {
		billid.setText(m.getID());
		id.setText("ID:"+MainApp.getID());
		memberl=mbs.findMemberByID(m.getMemberID());
		operator.setText(""+m.getUserID());
		altogether.setText(""+m.getSum());
		member.setText(memberl.getName());
		note.setText(m.getRemark());
		comlist=m.getCommodityList();
		for(int i=0;i<comlist.getListSize();i++){
			commodityData.add(new CommodityItemData(comlist.get(i)));
		}
			commodityTable.setItems(commodityData);
			rightB.setVisible(false);
			 addB.setVisible(false);
			deleteB.setVisible(false);
			 returnB.setVisible(false);
			 search.setVisible(false);
	}


	public void setVO(ImportBillVO m) {
		unpassbill=m;
		billid.setText(m.getID());
		id.setText("ID:"+MainApp.getID());
		memberl=mbs.findMemberByID(m.getMemberID());
		operator.setText(""+m.getUserID());
		altogether.setText(""+m.getSum());
		member.setText(memberl.getName());
		note.setText(m.getRemark());
		comlist=m.getCommodityList();
		for(int i=0;i<comlist.getListSize();i++){
			commodityData.add(new CommodityItemData(comlist.get(i)));
		}
			commodityTable.setItems(commodityData);
			rightB.setVisible(false);
			returnB.setVisible(false);
			reviseB.setVisible(true);
	}


	public void red(ImportBillVO m) {
		// TODO Auto-generated method stub
		id.setText("ID:"+MainApp.getID());
		memberl=mbs.findMemberByID(m.getMemberID());
		operator.setText(""+m.getUserID());
		altogether.setText(""+m.getSum());
		member.setText(memberl.getName());
		note.setText(m.getRemark());
		comlist=m.getCommodityList();
		for(int i=0;i<comlist.getListSize();i++){
			commodityData.add(new CommodityItemData(comlist.get(i)));
		}
			commodityTable.setItems(commodityData);
			 returnB.setVisible(false);
			 search.setVisible(false);
			 deleteB.setVisible(false);
	}

}
