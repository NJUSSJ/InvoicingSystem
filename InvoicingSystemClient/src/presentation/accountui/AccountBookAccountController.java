package presentation.accountui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AccountBookAccountController implements Initializable {

	@FXML
	TableView<AccountBookAccountData> accountTable;
	@FXML
	TableColumn<AccountBookAccountData, String> id;
	@FXML
	TableColumn<AccountBookAccountData, String> deposit;
	
	private ObservableList<AccountBookAccountData> accountData;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		accountTable.setItems(accountData);
		id.setCellValueFactory(cellData->cellData.getValue().getID());
		deposit.setCellValueFactory(cellData->cellData.getValue().getDeposit());
	}
	
	public void setList(ObservableList<AccountBookAccountData> list) {
		this.accountData=list;
		accountTable.setItems(accountData);
	}
}
