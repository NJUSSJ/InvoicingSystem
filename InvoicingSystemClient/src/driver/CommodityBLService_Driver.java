package driver;

import stubs.CommodityBLService_Stub;
import vo.CategoryVO;
import vo.CommodityVO;

public class CommodityBLService_Driver {
public void drive(CommodityBLService_Stub stub){
	if(stub.getCommodity("1189")!=null){
		System.out.println("getCommodity success!");
	}
	if(stub.getCategory("")!=null){
		System.out.println("getCategory success!");
	}
	if((stub.addCommodity(new CommodityVO(null, 0, null, 0, 0, 0, 0, 0, null))).equals("add commodity success")){
		System.out.println("add c pass!");
	}
	if((stub.addCategory(new CategoryVO(null, null, null, null))).equals("add category success")){
		System.out.println("add cg pass!");
	}
	if((stub.deleteCommodity(new CommodityVO(null, 0, null, 0, 0, 0, 0, 0, null))).equals("delete commodity success")){
		System.out.println("delete c pass!");
	}
	if((stub.deleteCategory(new CategoryVO(null, null, null, null))).equals("delete category success")){
		System.out.println("delete cg pass!");
	}
	if((stub.modifyCommodity(new CommodityVO(null, 0, null, 0, 0, 0, 0, 0, null))).equals("modify commodity success")){
		System.out.println("modify c pass!");
	}
	if((stub.modifyCategory(new CategoryVO(null, null, null, null))).equals("modify category success")){
		System.out.println("modify cg pass!");
	}
}
}