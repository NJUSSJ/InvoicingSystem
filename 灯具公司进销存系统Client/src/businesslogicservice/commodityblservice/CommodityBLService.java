package businesslogicservice.commodityblservice;

import java.util.ArrayList;

import vo.CategoryVO;
import vo.CommodityVO;




public interface CommodityBLService {

	public ArrayList<CommodityVO> getCommodityList(String field);

	public CommodityVO getCommodity(String field);
	
	public ArrayList<CategoryVO> getCategory();
	
	public String addCommodity(CommodityVO c);
	
	public String addCategory(CategoryVO c);
	
	public String deleteCommodity(CommodityVO c);
	
	public String deleteCategory(CategoryVO c);
	
	public String modifyCommodity(CommodityVO c);
	
	public String modifyCategory(CategoryVO c);
}
