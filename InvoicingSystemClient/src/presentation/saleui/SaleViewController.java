package presentation.saleui;

import java.net.URL;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import MainApp.MainApp;
import businesslogic.billbl.CommodityLineItem;
import businesslogic.billbl.CommodityList;
import businesslogic.billbl.SaleBillController;
import businesslogic.commoditybl.CommodityController;
import businesslogic.memberbl.MemberController;
import businesslogicservice.billblservice.SaleBillBLService;
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
import vo.MemberVO;
import vo.SaleBillVO;

public class SaleViewController implements Initializable  {
	@FXML
	private Label id;
	Stage stage;
	@FXML
	private Button logout;
	@FXML
	private Button search;
	@FXML
	private Label discountbefore;
	@FXML
	private Label discountafter;
	@FXML
	private TextField coupon;
	@FXML
	private TextField haspay;
	@FXML
	private Label discount;
	
	@FXML
	private Label billid;
	
	@FXML
	private Label operator;
	
	@FXML
	private TextField name;
	
	@FXML
	private TextField member;
	
	@FXML
	private TextField stock;
	
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
	CommodityItemData itemdata;
	CommodityLineItem item=null;
	CommodityList comlist=new CommodityList();
	CommodityVO a;
	MemberVO memberl=null;
	CommodityBLService cbs=new CommodityController();
	MemberBLService mbs=new MemberController();
	SaleBillBLService sbbs=new SaleBillController();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		java.util.Date utiltime=new java.util.Date();
		time=new Date(utiltime.getTime());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		String str=sdf.format(time);
		DecimalFormat df=new DecimalFormat("#####");
		billid.setText("XSD-"+str+"-"+df.format(times));
		id.setText("ID:"+MainApp.getID());
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
	}

	
	private void getInf(CommodityItemData newValue) {
		// TODO Auto-generated method stub
		item=newValue.getItem();
	}


	@FXML
	public void delete(){
		int selectedIndex = commodityTable.getSelectionModel().getSelectedIndex();
	   	 if (selectedIndex >= 0) {
	   		commodityTable.getItems().remove(selectedIndex);
	           comlist.deleteCommodity(item);
	           commodityData.remove(selectedIndex);
	          discountbefore.setText(""+comlist.getSaleTotal());
	          double discountl=sbbs.handleSale(memberl.getRank(), comlist)/comlist.getSaleTotal();
	           discount.setText(""+discountl);
	           double finalsale=sbbs.handleSale(memberl.getRank(), comlist)-Double.parseDouble(coupon.getText());
	          discountafter.setText(""+finalsale);
	   	      
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
			lastprice.setText(""+a.getSalePrice());
			num.setText(0+"");
		}
	}
	@FXML
	public void confirm(){
		memberl=mbs.findMemberByName(member.getText());
		itemdata=new CommodityItemData(0,a,Integer.parseInt(num.getText()),Double.parseDouble(lastprice.getText()),notea.getText());
	    item=new CommodityLineItem(Integer.parseInt(num.getText()),a.getID(),Double.parseDouble(lastprice.getText()),a.getImportPrice());
	    comlist.addCommodity(item);
		commodityData.add(itemdata);
	    commodityTable.setItems(commodityData);
	    discountbefore.setText(""+comlist.getSaleTotal());
	    double discountl=1.0-(sbbs.handleSale(memberl.getRank(), comlist)/comlist.getSaleTotal());
        discount.setText(""+discountl);
        double finalsale=sbbs.handleSale(memberl.getRank(), comlist)-Double.parseDouble(coupon.getText());
       discountafter.setText(""+finalsale);
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
	public void setBill(){
		SaleBillVO salebill=new SaleBillVO(billid.getText(),Long.parseLong(id.getText()),memberl.getID(),comlist,
			comlist.getSaleTotal(),0,time,note.getText(),Integer.parseInt(coupon.getText()),Double.parseDouble(discount.getText()),Double.parseDouble(discountafter.getText()),Double.parseDouble(haspay.getText()));
		String isSubmit="fail Submit";
		 if(sbbs.submitSaleBill(salebill)){
			 times++;
			 isSubmit="Succeed Submit";
		 }
	     Alert alert = new Alert(AlertType.INFORMATION);
		        alert.initOwner(MainApp.getPrimaryStage());
		        alert.setTitle("Information");
		        alert.setHeaderText("Submit");
		        alert.setContentText(isSubmit);
		        alert.showAndWait();
	}


	public void setStage(Stage stage) {
		// TODO Auto-generated method stub
		this.stage=stage;
	}


	public void setVo(SaleBillVO m) {
		// TODO Auto-generated method stub
		
	}


}



