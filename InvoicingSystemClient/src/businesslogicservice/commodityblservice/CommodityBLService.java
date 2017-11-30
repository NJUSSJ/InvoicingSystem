package businesslogicservice.commodityblservice;

import java.util.ArrayList;

import vo.CategoryVO;
import vo.CommodityVO;




public interface CommodityBLService {
	
	public CommodityVO toCommodityVO(String name,long id,String model, int stockNum, double importPrice, double salePrice,
			double lateImportPrice, double lateSalePrice,String parent);

	public CommodityVO getCommodity(String name);
	
	public ArrayList<CommodityVO> getCommodityList(String field);
	
	public CategoryVO getCategory(String name);
	
	public ArrayList<CategoryVO> getCategoryList(String field);
	
	public String addCommodity(CommodityVO c);
	
	public String addCategory(CategoryVO c);
	
	public String deleteCommodity(CommodityVO c);
	
	public String deleteCategory(CategoryVO c);
	
	public String modifyCommodity(CommodityVO c);
	
	public String modifyCategory(CategoryVO c);
}
