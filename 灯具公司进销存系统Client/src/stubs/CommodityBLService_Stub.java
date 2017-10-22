package stubs;

import java.sql.Time;
import java.util.ArrayList;

import businesslogicservice.commodityblservice.CommodityBLService;
import vo.CategoryVO;
import vo.CommodityVO;

public class CommodityBLService_Stub implements CommodityBLService{
	CommodityVO cv;
	String cvName;
	int cvID;
	int cvStock_num;
	int cvPrice;
	int cvBatch;
	int cvBatch_num;
	Time cvProduce_time;
	@Override
	public ArrayList<CommodityVO> getCommodityList(String field) {
		// TODO 自动生成的方法存根
		
		return null;
	}

	@Override
	public CommodityVO getCommodity(String field) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<CategoryVO> getCategory() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public String addCommodity(CommodityVO c) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public String addCategory(CategoryVO c) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public String deleteCommodity(CommodityVO c) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public String deleteCategory(CategoryVO c) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public String modifyCommodity(CommodityVO c) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public String modifyCategory(CategoryVO c) {
		// TODO 自动生成的方法存根
		return null;
	}

}
