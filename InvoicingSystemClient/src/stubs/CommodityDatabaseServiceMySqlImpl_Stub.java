package stubs;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.commoditydataservice.CommodityDataService;
import po.CommodityPO;

public class CommodityDatabaseServiceMySqlImpl_Stub implements CommodityDataService{
	
	public CommodityPO find(long id){
		return new CommodityPO();
		
	}
	public ArrayList<CommodityPO> finds(long id,String field){
		return new ArrayList<CommodityPO>();
	}
	public void insert(CommodityPO po){
		System.out.println("insert success");
	}
	public void delete(CommodityPO po){
		System.out.println("delete success");
	}
	public void update(CommodityPO po){
		System.out.println("update success");
	}
	public void init(){
		System.out.println("Init successfully!");
	}
	public void finish(){
		System.out.println("Finish successfully!");
	}

}
