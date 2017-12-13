package vo;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StockInventoryInfoVO {
	private final IntegerProperty lineNum;
	private final StringProperty name;
	private final StringProperty model;
	private final IntegerProperty stockNum;
	private final DoubleProperty averagePrice;
	
	public StockInventoryInfoVO(int lineNum,String name,String model,int stockNum,double averagePrice) {
		this.lineNum=new SimpleIntegerProperty(lineNum);
		this.name=new SimpleStringProperty(name);
		this.model=new SimpleStringProperty(model);
		this.stockNum=new SimpleIntegerProperty(stockNum);
		this.averagePrice=new SimpleDoubleProperty(averagePrice);
		
	}
	
	public int getLineNum() {
		return lineNum.get();
	}
	
	public void setLineNum(int lineNum) {
		this.lineNum.set(lineNum);
	}
	
	public IntegerProperty lineNumProperty() {
		return lineNum;
	}
	
	public String getName() {
		return name.get();
	}
	
	public void setName(String name) {
		this.name.set(name);	
	}
	
	public StringProperty NameProperty() {
		return name;
	}
	
	public String getModel() {
		return model.get();
	}
	
	public void setModel(String model) {
		this.model.set(model);
	}
	
	public StringProperty ModelProperty() {
		return model;
	}
	
	public int getStockNum() {
		return stockNum.get();
	}
	
	public void setStockNum(int num) {
		this.stockNum.set(num);
	}
	
	public IntegerProperty StockProperty() {
		return stockNum;
	}
	
	public double getAveragePrice() {
		return averagePrice.get();
	}
	
	public void setAveragePrice(double price) {
		this.averagePrice.set(price);
	}
	
	public DoubleProperty AveragePriceProperty() {
		return averagePrice;
	}
	
	
}
