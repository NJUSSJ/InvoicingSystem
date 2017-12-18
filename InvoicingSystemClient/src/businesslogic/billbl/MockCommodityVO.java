package businesslogic.billbl;

import java.sql.Time;

import vo.CommodityVO;

public class MockCommodityVO extends CommodityVO {

	public MockCommodityVO(String name, long id, String model, int stockNum, double importPrice, double salePrice,
			double lateImportPrice, double lateSalePrice, String parent,int limit) {
		super(parent, id, parent, stockNum, lateSalePrice, lateSalePrice, lateSalePrice, lateSalePrice, id,limit);
		// TODO 自动生成的构造函数存根
	}
	
	
}
