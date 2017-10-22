package driver;

import po.PromotionPO;
import stubs.PromotionDataServiceMySqlImpl_Stub;

public class PromotionDataService_Driver {
	public void drive(PromotionDataServiceMySqlImpl_Stub promotoindataservice ) {
		promotoindataservice.delete(new PromotionPO());
		promotoindataservice.find();
		promotoindataservice.insert(new PromotionPO());
		
	}
}
