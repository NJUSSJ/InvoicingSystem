package Client.businesslogicservice.saleblservice;

import Client.vo.CommodityVO;
import Client.vo.MemberVO;

public interface SaleBLService {
	public void import_();
	
	public void importReturn();
	
	public void sell();
	
	public void sellReturn();
	
	public PromotionVO getPromotion();
	
	public MemberVO getMember(String name);
	
	public CommodityVO getMember(int id);
}
