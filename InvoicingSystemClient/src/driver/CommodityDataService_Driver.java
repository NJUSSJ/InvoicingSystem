package driver;

import po.CommodityPO;
import stubs.CommodityDatabaseServiceMySqlImpl_Stub;

public class CommodityDataService_Driver {
	public void drive(CommodityDatabaseServiceMySqlImpl_Stub stub){
		if(stub.find(0)!=null){
			System.out.println("find pass");
		}
		if(stub.finds(0,"90")!=null){
			System.out.println("finds pass");
		}
		stub.insert(new CommodityPO());
		stub.delete(new CommodityPO());
		stub.update(new CommodityPO());
		stub.init();
		stub.finish();
		
	}
}
