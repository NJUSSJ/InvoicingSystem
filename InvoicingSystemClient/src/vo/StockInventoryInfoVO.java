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
	private final StringProperty finishedTime;
	
	public StockInventoryInfoVO(int lineNum,String name,String model,int stockNum,double averagePrice,String finishedTime) {
		this.lineNum=new SimpleIntegerProperty(lineNum);
		this.name=new SimpleStringProperty(name);
		this.model=new SimpleStringProperty(model);
		this.stockNum=new SimpleIntegerProperty(stockNum);
		this.averagePrice=new SimpleDoubleProperty(averagePrice);
		this.finishedTime=new SimpleStringProperty(finishedTime);
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
	
	
}
