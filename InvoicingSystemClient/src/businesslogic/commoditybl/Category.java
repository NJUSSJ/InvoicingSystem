package businesslogic.commoditybl;

import java.util.ArrayList;

import businesslogicservice.commodityblservice.CommodityBLService;
import vo.CategoryVO;
import vo.CommodityVO;

public class Category implements CommodityBLService{

	@Override
	public CommodityVO toCommodityVO(String name, long id, String model, int stockNum, double importPrice,
			double salePrice, double lateImportPrice, double lateSalePrice, String parent) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public CommodityVO getCommodity(String name) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ArrayList<CommodityVO> getCommodityList(String field) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public CategoryVO getCategory(String name) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ArrayList<CategoryVO> getCategoryList(String field) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public String addCommodity(CommodityVO c) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public String addCategory(CategoryVO c) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public String deleteCommodity(CommodityVO c) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public String deleteCategory(CategoryVO c) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public String modifyCommodity(CommodityVO c) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public String modifyCategory(CategoryVO c) {
		// TODO �Զ����ɵķ������
		return null;
	}
	
}
