package businesslogic.billbl;

import java.sql.Time;

import vo.CommodityVO;

public class MockCommodityVO extends CommodityVO {

	public MockCommodityVO(String name, long id, String model, int stockNum, double importPrice, double salePrice,
			double lateImportPrice, double lateSalePrice, String parent) {
		super(parent, id, parent, stockNum, lateSalePrice, lateSalePrice, lateSalePrice, lateSalePrice, id);
		// TODO �Զ����ɵĹ��캯�����
	}
	
	
}
