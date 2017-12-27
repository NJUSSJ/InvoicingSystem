package presentation.billui;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class TaskCellFactory implements Callback<TableColumn<BillData, String>, TableCell<BillData, String>> {
    BillData post=null;
	@Override
	public TableCell<BillData, String> call(TableColumn<BillData, String> param) {
		// TODO Auto-generated method stub
		TextFieldTableCell<BillData, String> cell=new TextFieldTableCell<>();
		cell.setOnMouseClicked((MouseEvent t)->{
			if(t.getClickCount()==2){
			if(post.getchoose().equals("ÊÇ")){
				post.setChoose("·ñ");
			}else{
				post.setChoose("ÊÇ");
			}
			}
		});
		return cell;
	}

public void setData(BillData newValue) {
	// TODO Auto-generated method stub
	post=newValue;
}

}
