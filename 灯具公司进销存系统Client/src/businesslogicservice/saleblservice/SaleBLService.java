package businesslogicservice.saleblservice;

import vo.CommodityVO;
import vo.MemberVO;
import vo.PromotionVO;

public interface SaleBLService {
	public void import_();
	
	public void importReturn();
	
	public void sell();
	
	public void sellReturn();
	
	public PromotionVO getPromotion();
	
	public MemberVO getMember(String name);
	
	public CommodityVO getCommodity(int id);
}
