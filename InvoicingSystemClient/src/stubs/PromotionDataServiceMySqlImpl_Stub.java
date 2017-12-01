package stubs;

import java.util.ArrayList;

import po.PromotionPO;

public class PromotionDataServiceMySqlImpl_Stub {
	public void insert(PromotionPO po){
		System.out.println("Insert successed");
	}
	public void delete(PromotionPO p){
		System.out.println("Delete successed");
	}
	public ArrayList<PromotionPO> find(){
		ArrayList<PromotionPO> list=new ArrayList<PromotionPO>();
		return list;
	}
}
