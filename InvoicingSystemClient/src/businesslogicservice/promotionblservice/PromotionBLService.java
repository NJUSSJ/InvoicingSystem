package businesslogicservice.promotionblservice;

import java.util.ArrayList;

import vo.PromotionVO;

public interface PromotionBLService {
	public void addPromotion(PromotionVO vo);
	public void deletePromotion(long id);
	public void getPromotion(long id);
	public ArrayList<PromotionVO> getPromotinoList(String field,long id);
}
