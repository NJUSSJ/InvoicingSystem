package Client.dataservice.promotiondataservice;

import Client.po.PromotionPO;

public interface promotiondataservice {
	
	public PromotionPO insert(PromotionPO po);

	public PromotionPO delete(PromotionPO p);
}
