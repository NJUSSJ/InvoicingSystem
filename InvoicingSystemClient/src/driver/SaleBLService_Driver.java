package driver;

import stubs.SaleBLService_Stub;

public class SaleBLService_Driver {
	public void drive(SaleBLService_Stub saleblservice) {
		saleblservice.getCommodity(10);
		saleblservice.getMember("Jack");
		saleblservice.getPromotion();
		saleblservice.import_();
		saleblservice.importReturn();
		saleblservice.sell();
		saleblservice.sellReturn();
	}
}
