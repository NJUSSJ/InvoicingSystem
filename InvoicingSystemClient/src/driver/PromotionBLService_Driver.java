package driver;

import stubs.PromotionBLService_Stub;
import vo.PromotionVO;

public class PromotionBLService_Driver {
	public void drive(PromotionBLService_Stub promotionblservice) {
		promotionblservice.addPromotion(new PromotionVO());
		promotionblservice.deletePromotion(123);
		promotionblservice.getPromotinoList("123", 123);
		promotionblservice.getPromotion(123);;
		
	}
}
