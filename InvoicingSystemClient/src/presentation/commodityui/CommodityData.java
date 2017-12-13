package presentation.commodityui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import vo.CommodityVO;

public class CommodityData {
    StringProperty id=new SimpleStringProperty();
    StringProperty name=new SimpleStringProperty();
    StringProperty model=new SimpleStringProperty();
    StringProperty num=new SimpleStringProperty();
    StringProperty importprice=new SimpleStringProperty();
    StringProperty saleprice=new SimpleStringProperty();
    StringProperty latesale=new SimpleStringProperty();
    StringProperty lateimport=new SimpleStringProperty();
    CommodityVO a;
    public CommodityData(CommodityVO a){
    	id.set(Long.toString(a.getID()));
    	name.set(a.getName());
    	model.set(a.getModel());
    	num.set(Integer.toString(a.getStockNum()));
    	importprice.set(Double.toString(a.getImportPrice()));
    	saleprice.set(Double.toString(a.getSalePrice()));
    	latesale.set(Double.toString(a.getLateSalePrice()));
    	lateimport.set(Double.toString(a.getLateImportPrice()));
    	this.a=a;
    }
	public  StringProperty getId() {
		// TODO Auto-generated method stub
		return id;
	}
	public  StringProperty getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public  StringProperty getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	public  StringProperty getNum() {
		// TODO Auto-generated method stub
		return num;
	}
	public  StringProperty getSale() {
		// TODO Auto-generated method stub
		return saleprice;
	}
	public  StringProperty getImport() {
		// TODO Auto-generated method stub
		return importprice;
	}
	public  StringProperty getLateSale() {
		// TODO Auto-generated method stub
		return latesale;
	}
	public  StringProperty getLateImport() {
		// TODO Auto-generated method stub
		return lateimport;
	}
	public CommodityVO getVO() {
		// TODO Auto-generated method stub
		return a;
	}


}
