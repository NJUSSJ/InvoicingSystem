package businesslogicservice.saleblservice;

import vo.CommodityVO;
import vo.MemberVO;
import vo.PromotionVO;

public interface SaleBLService {
	public String import_();
	
	public String importReturn();
	
	public String sell();
	
	public String sellReturn();
	
	public PromotionVO getPromotion();
	
	public MemberVO getMember(String name);
	
	public CommodityVO getCommodity(int id);
}
