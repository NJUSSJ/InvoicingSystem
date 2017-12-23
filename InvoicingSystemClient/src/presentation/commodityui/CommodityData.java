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
    StringProperty parent=new SimpleStringProperty();
    CommodityVO commodityVO;
    public CommodityData(CommodityVO vo){
    	setVO(vo);
    }
	public  StringProperty getId() {
		return id;
	}
	public  StringProperty getName() {
		return name;
	}

	public  StringProperty getModel() {
		return model;
	}
	public  StringProperty getNum() {
		return num;
	}
	public  StringProperty getSale() {
		return saleprice;
	}
	public  StringProperty getImport() {
		return importprice;
	}
	public  StringProperty getLateSale() {
		return latesale;
	}
	public  StringProperty getLateImport() {
		return lateimport;
	}
	public StringProperty getParent(){
		return parent;
	}
	public CommodityVO getVO() {
		return commodityVO;
	}
	public void setVO(CommodityVO vo){
		id.set(Long.toString(vo.getID()));
    	name.set(vo.getName());
    	model.set(vo.getModel());
    	num.set(Integer.toString(vo.getStockNum()));
    	importprice.set(Double.toString(vo.getImportPrice()));
    	saleprice.set(Double.toString(vo.getSalePrice()));
    	latesale.set(Double.toString(vo.getLateSalePrice()));
    	lateimport.set(Double.toString(vo.getLateImportPrice()));
    	parent.set(vo.getParent()+"");
    	commodityVO=vo;
	}
	
}
