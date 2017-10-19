package Client.businesslogicservice.commodityblservice;

import java.util.ArrayList;

import Client.vo.commodityVO;


public interface CommodityBLService {

	public ArrayList<commodityVO> getCommodityList(String field);

	public commodityVO getCommodity(String field);
	
	public ArrayList<categoryVO> getCategory();
	
	public String addCommodity(commodityVO c);
	
	public String addCategory(categoryVO c);
	
	public String deleteCommodity(commodityVO c);
	
	public String deleteCategory(categoryVO c);
	
	public String modifyCommodity(commodityVO c);
	
	public String modifyCategory(categoryVO c);
}
