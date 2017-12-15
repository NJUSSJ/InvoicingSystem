package presentation.commodityui;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import MainApp.MainApp;
import businesslogic.commoditybl.CommodityController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import vo.StockInventoryInfoVO;

public class StockInventoryViewController implements Initializable {
	@FXML
	private Label LogOut;
	
	@FXML
	private Button Invent;
	
	@FXML
	private Button Export;
	
	@FXML
	private Button Return;
	
	@FXML
	private TableView<StockInventoryInfoVO> table;
	
	@FXML
	private TableColumn<StockInventoryInfoVO, Number> lineNum;
	
	@FXML
	private TableColumn<StockInventoryInfoVO, String> name;
	
	@FXML
	private TableColumn<StockInventoryInfoVO, String> model;
	
	@FXML
	private TableColumn<StockInventoryInfoVO, Number> stockNum;
	
	@FXML
	private TableColumn<StockInventoryInfoVO, Number> averagePrice;
	
	@FXML
	private TableColumn<StockInventoryInfoVO, String> finishedTime;
	
	@FXML
	private Label todayDate;
	
	@FXML
	private Label ID;

	private ObservableList<StockInventoryInfoVO> InventoryInfo=FXCollections.observableArrayList();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ID.setText("ID:"+MainApp.getID());
		Date todayDate=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy年mm月dd日");
		
		String tmp=dateFormat.format(todayDate);
		this.todayDate.setText(tmp);
		
		ArrayList<StockInventoryInfoVO> list=new CommodityController().getInventoryInfo();
		
		for(int i=0;i<list.size();i++) {
			InventoryInfo.add(list.get(i));
		}
		
		
		lineNum.setCellValueFactory(cellData->cellData.getValue().lineNumProperty());
		name.setCellValueFactory(cellData->cellData.getValue().NameProperty());
		model.setCellValueFactory(cellData->cellData.getValue().ModelProperty());
		stockNum.setCellValueFactory(cellData->cellData.getValue().StockProperty());
		averagePrice.setCellValueFactory(cellData->cellData.getValue().AveragePriceProperty());
		
		table.setItems(InventoryInfo);
		
      
	}
	
	public void Invent() {
		StockInventoryInfoVO info=table.getSelectionModel().getSelectedItem();
		if(info==null) {
			Alert error=new Alert(Alert.AlertType.WARNING);
        	error.setTitle("No Selection");
        	error.setHeaderText("No commodity seleted");
        	error.setContentText("Please select a commodity");
        	error.showAndWait();
		}
		else {
			MainApp.showStockInventorySub(info);
		}
		
		
	}
	
	public void Return() {
		MainApp.showStockMainUI();
	}
	
	public void handleExport() {
		FileChooser fileChooser=new FileChooser();
		
		//set extension filter
		FileChooser.ExtensionFilter extFilter=new ExtensionFilter("XLS files (*.xls)", "*.xls");
		fileChooser.getExtensionFilters().add(extFilter);
	
		//show save file dialog
		File file=fileChooser.showSaveDialog(MainApp.getPrimaryStage());
		if(file!=null) {
			String filepath=file.getPath();
			if(!filepath.endsWith(".xls")) {
			filepath+=".xls";
			}
			SaveFiletoPath(filepath);
		}
		
	}
	public void SaveFiletoPath(String filepath) {
		@SuppressWarnings("resource")
		HSSFWorkbook wb=new HSSFWorkbook();
		HSSFSheet sheet=wb.createSheet("sheet1");
		
		HSSFRow row1 =sheet.createRow(0);
		HSSFCell cell1=row1.createCell(0);
		
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 9));
		
		HSSFFont font=wb.createFont();
		font.setFontName("微软雅黑");
		font.setBold(true);
		font.setFontHeight((short)400);
		
		HSSFFont font2=wb.createFont();
		font2.setFontName("微软雅黑");
		font2.setBold(true);
		font2.setFontHeight((short)150);
		
		HSSFFont font3=wb.createFont();
		font3.setFontName("微软雅黑");
		font3.setFontHeight((short)150);
		
		
		//Title Style
		HSSFCellStyle style1=wb.createCellStyle();
		style1.setAlignment(HorizontalAlignment.CENTER);
		style1.setFont(font);
		
		cell1.setCellValue(todayDate.getText()+"  库存盘点");
		cell1.setCellStyle(style1);
		
		//Column Style
		HSSFCellStyle style2=wb.createCellStyle();
		style2.setAlignment(HorizontalAlignment.CENTER);
		style2.setFont(font2);
		
		//信息 Style
		HSSFCellStyle style3=wb.createCellStyle();
		style3.setAlignment(HorizontalAlignment.CENTER);
		style3.setFont(font3);
		
		/*
		 * 设置字段行
		 */
		HSSFRow row2=sheet.createRow(2);
		
		HSSFCell LineNumCell=row2.createCell(0);
		
		sheet.addMergedRegion(new CellRangeAddress(2,2, 0, 1));
		
		LineNumCell.setCellValue("行号");
		LineNumCell.setCellStyle(style2);
		
		HSSFCell NameCell=row2.createCell(2);
		
		sheet.addMergedRegion(new CellRangeAddress(2,2, 2, 3));
		
		NameCell.setCellValue("名称");
		NameCell.setCellStyle(style2);
		
		HSSFCell ModelCell=row2.createCell(4);
		
		sheet.addMergedRegion(new CellRangeAddress(2,2, 4, 5));
		
		ModelCell.setCellValue("型号");
		ModelCell.setCellStyle(style2);
		
		HSSFCell StockNumCell=row2.createCell(6);
		
		sheet.addMergedRegion(new CellRangeAddress(2,2, 6, 7));
		
		StockNumCell.setCellValue("库存数量");
		StockNumCell.setCellStyle(style2);
		
		HSSFCell AveragePriceCell=row2.createCell(8);
		
		sheet.addMergedRegion(new CellRangeAddress(2,2, 8, 9));
		
		AveragePriceCell.setCellValue("库存均价");
		AveragePriceCell.setCellStyle(style2);
		
		
		
		/*
		 * 填入具体信息
		 */
		for(int i=0;i<InventoryInfo.size();i++) {
			HSSFRow row=sheet.createRow(i+3);
			
			HSSFCell LineNumCellInfo=row.createCell(0);
			
			sheet.addMergedRegion(new CellRangeAddress(i+3,i+3, 0, 1));
			
			LineNumCellInfo.setCellValue(InventoryInfo.get(i).getLineNum());
			LineNumCellInfo.setCellStyle(style3);
			
			HSSFCell NameCellInfo=row.createCell(2);
			
			sheet.addMergedRegion(new CellRangeAddress(i+3,i+3, 2, 3));
			
			NameCellInfo.setCellValue(InventoryInfo.get(i).getName());
			NameCellInfo.setCellStyle(style3);
			
			HSSFCell ModelCellInfo=row.createCell(4);
			
			sheet.addMergedRegion(new CellRangeAddress(i+3,i+3, 4, 5));
			
			ModelCellInfo.setCellValue(InventoryInfo.get(i).getModel());
			ModelCellInfo.setCellStyle(style3);
			
			HSSFCell StockNumCellInfo=row.createCell(6);
			
			sheet.addMergedRegion(new CellRangeAddress(i+3,i+3, 6, 7));
			
			StockNumCellInfo.setCellValue(InventoryInfo.get(i).getStockNum());
			StockNumCellInfo.setCellStyle(style3);
			
			HSSFCell AveragePriceCellInfo=row.createCell(8);
			
			sheet.addMergedRegion(new CellRangeAddress(i+3,i+3, 8, 9));
			
			AveragePriceCellInfo.setCellValue(InventoryInfo.get(i).getAveragePrice());
			AveragePriceCellInfo.setCellStyle(style3);
			
			
			
			
		}
		
		
		
		try {
			FileOutputStream fo=new FileOutputStream(filepath);
			wb.write(fo);
			fo.close(); 
			Alert error=new Alert(Alert.AlertType.CONFIRMATION);
        	error.setTitle("Success");
        	error.setHeaderText("");
        	error.setContentText("导出成功！");
        	error.showAndWait();
		} catch (IOException e) {
			Alert error=new Alert(Alert.AlertType.WARNING);
        	error.setTitle("Export Warning");
        	error.setHeaderText("");
        	error.setContentText("导出失败！");
        	error.showAndWait();
		}
		
		
	}
	
}
