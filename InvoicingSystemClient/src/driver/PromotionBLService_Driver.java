package driver;

import businesslogicservice.promotionblservice.PromotionBLService;
import stubs.PromotionBLService_Stub;

public class PromotionBLService_Driver {
	public void drive(PromotionBLService_Stub promotionblservice) {
		promotionblservice.addPromotion();
		promotionblservice.deletePromotion();
		promotionblservice.getPromotinoList();
	}
}
