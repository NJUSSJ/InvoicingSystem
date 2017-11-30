package dataservice.promotiondataservice;

import po.PromotionPO;

public interface PromotionDataService {
	
	public PromotionPO insert(PromotionPO po);

	public PromotionPO delete(PromotionPO p);
}
