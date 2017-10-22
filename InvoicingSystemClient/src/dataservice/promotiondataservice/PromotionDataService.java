package dataservice.promotiondataservice;

import java.util.ArrayList;

import po.PromotionPO;

public interface PromotionDataService {
	
	public void insert(PromotionPO po);

	public void delete(PromotionPO p);
	
	public ArrayList<PromotionPO> find();
}
