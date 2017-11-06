package businesslogic.commoditybl;

import java.util.ArrayList;

import businesslogicservice.commodityblservice.CommodityBLService;
import vo.CategoryVO;
import vo.CommodityVO;

public class Commodity implements CommodityBLService{
	public CommodityVO getCommodity(String field){
		return null;
		
	}
	public String addCommodity(CommodityVO c){
		return null;
		
	}
	public String deleteCommodity(CommodityVO c){
		return null;
		
	}
	public String modifyCommodity(CommodityVO c){
		return null;
		
	}
	@Override
	public ArrayList<CommodityVO> getCommodityList(String field) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public CategoryVO getCategory(String name) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public ArrayList<CategoryVO> getCategoryList(String field) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public String addCategory(CategoryVO c) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public String deleteCategory(CategoryVO c) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public String modifyCategory(CategoryVO c) {
		// TODO 自动生成的方法存根
		return null;
	}
}
