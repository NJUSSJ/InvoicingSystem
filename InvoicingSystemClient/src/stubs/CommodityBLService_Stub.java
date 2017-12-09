package stubs;

import java.sql.Time;
import java.util.ArrayList;

import businesslogicservice.commodityblservice.CommodityBLService;
import po.CategoryPO;
import po.CommodityPO;
import vo.CategoryVO;
import vo.CommodityVO;

public class CommodityBLService_Stub implements CommodityBLService{

	@Override
	public boolean addCommodity(CommodityVO commodityVO) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean deleteCommodity(CommodityVO commodityVO) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean updateCommodity(CommodityVO commodityVO) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public CommodityVO findCommodityByName(String name) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public CommodityVO findCommodityByID(long id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<CommodityVO> findCommodityByField(String field) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean addCategory(CategoryVO categoryVO) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean deleteCategory(CategoryVO categoryVO) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean updateCategory(CategoryVO categoryVO) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public CategoryVO findCategoryByName(String name) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public CategoryVO findCategoryByID(long id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public CommodityVO toCommodityVO(CommodityPO commodityPO) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public CategoryVO toCategoryVO(CategoryPO categoryPO) {
		// TODO 自动生成的方法存根
		return null;
	}

	
	@Override
	public ArrayList<CategoryVO> findUpCategory(CategoryVO vo) {

		return null;
	}

	@Override
	public ArrayList<CategoryVO> findDownCategory(CategoryVO vo) {

		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<CommodityVO> findDownCommodity(CategoryVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}



	
}
