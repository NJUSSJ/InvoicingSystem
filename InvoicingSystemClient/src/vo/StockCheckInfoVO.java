package vo;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StockCheckInfoVO {

	private final LongProperty id;
	private final StringProperty name;
	private final StringProperty model;
	private final IntegerProperty outStockNum;
	private final IntegerProperty inStockNum;
	private final DoubleProperty outSum;
	private final DoubleProperty inSum;
	private final IntegerProperty saleNum;
	private final IntegerProperty importNum;
	private final DoubleProperty saleSum;
	private final DoubleProperty importSum;
	
	public StockCheckInfoVO(long id,String name,String model,int outStockNum,int inStockNum,
			double outSum,double inSum,int saleNum,int importNum,double saleSum,double importSum) {
		// TODO Auto-generated constructor stub
		this.id=new SimpleLongProperty(id);
		this.name=new SimpleStringProperty(name);
		this.model=new SimpleStringProperty(model);
		this.outStockNum=new SimpleIntegerProperty(outStockNum);
		this.inStockNum=new SimpleIntegerProperty(inStockNum);
		this.inSum=new SimpleDoubleProperty(inSum);
		this.outSum=new SimpleDoubleProperty(outSum);
		this.saleNum=new SimpleIntegerProperty(saleNum);
		this.importNum=new SimpleIntegerProperty(importNum);
		this.saleSum=new SimpleDoubleProperty(saleSum);
		this.importSum=new SimpleDoubleProperty(importSum);
	}
	
	public long getID() {
		return id.get();
	}
	
	public String getName() {
		return name.get();
	}
	
	public String getModel() {
		return model.get();
	}
	
	public int getOutStockNum() {
		return outStockNum.get();
	}
	
	public int getInStockNum() {
		return inStockNum.get();
	}
	
	public int getSaleNum() {
		return saleNum.get();
	}
	
	public int getImportNum() {
		return importNum.get();
	}
	
	public double getOutSum() {
		return outSum.get();
	}
	
	public double getInSum() {
		return inSum.get();
	}
	
	public double getSaleSum() {
		return saleSum.get();
	}
	
	public double getImportSum() {
		return importSum.get();
	}
	
	public void setID(long id) {
		this.id.set(id);
	}
	
	public void setName(String name) {
		this.name.set(name);
	}
	
	public void setModel(String model) {
		this.model.set(model);
	}
	
	public void setOutStockNum(int num) {
		this.outStockNum.set(num);
	}
	
	public void setInStockNum(int num) {
		this.inStockNum.set(num);
	}
	
	public void setSaleNum(int num) {
		this.saleNum.set(num);
	}
	
	public void setImportNum(int num) {
		this.importNum.set(num);
	}
	
	public void setOutSum(double sum) {
		this.outSum.set(sum);
	}
	
	public void setInSum(double sum) {
		this.inSum.set(sum);
	}
	
	public void setSaleSum(double sum) {
		this.saleSum.set(sum);
	}
	
	public void setImportSum(double sum) {
		this.importSum.set(sum);
	}
}
