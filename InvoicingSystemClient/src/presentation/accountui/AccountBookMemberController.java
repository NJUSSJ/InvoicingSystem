package presentation.accountui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AccountBookMemberController implements Initializable{

	@FXML
	private TableView<AccountBookMemberData> memberTabel;
	@FXML
	private TableColumn<AccountBookMemberData, String> category;
	@FXML
	private TableColumn<AccountBookMemberData, String> name;
	@FXML
	private TableColumn<AccountBookMemberData, String> tel;
	@FXML
	private TableColumn<AccountBookMemberData, String> shouldget;
	@FXML
	private TableColumn<AccountBookMemberData, String> shouldpay;
	
	private ObservableList<AccountBookMemberData> memberData;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		memberTabel.setItems(memberData);
		category.setCellValueFactory(cellData->cellData.getValue().getCategory());
		name.setCellValueFactory(cellData->cellData.getValue().getName());
		tel.setCellValueFactory(cellData->cellData.getValue().getTel());
		shouldget.setCellValueFactory(cellData->cellData.getValue().getShouldGet());
		shouldpay.setCellValueFactory(cellData->cellData.getValue().getShouldPay());
		
	}

	public void setList(ObservableList<AccountBookMemberData> list) {
		this.memberData=list;
		this.memberTabel.setItems(memberData);
	}
}
