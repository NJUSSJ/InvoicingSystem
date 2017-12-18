package businesslogic.commoditybl;

import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.commodityblservice.CommodityBLService;
import po.CategoryPO;
import po.CommodityPO;
import vo.CategoryVO;
import vo.CommodityVO;
import vo.StockCheckInfoVO;
import vo.StockInventoryInfoVO;

public class CommodityController implements CommodityBLService{
	Commodity commodityImpl=new Commodity();
	Category categoryImpl=new Category();
	@Override
	public boolean addCommodity(CommodityVO commodityVO) {
		return commodityImpl.addCommodity(commodityVO);
	}

	@Override
	public boolean deleteCommodity(CommodityVO commodityVO) {
		return commodityImpl.deleteCommodity(commodityVO);
	}

	@Override
	public boolean updateCommodity(CommodityVO commodityVO) {
		return commodityImpl.updateCommodity(commodityVO);
	}

	@Override
	public CommodityVO findCommodityByName(String name) {
		return commodityImpl.findCommodityByName(name);
	}

	@Override
	public CommodityVO findCommodityByID(long id) {
		return commodityImpl.findCommodityByID(id);
	}

	@Override
	public ArrayList<CommodityVO> findCommodityByField(String field) {
		return commodityImpl.findCommodityByField(field);
	}

	@Override
	public boolean addCategory(CategoryVO categoryVO) {
		return categoryImpl.addCategory(categoryVO);
	}

	@Override
	public boolean deleteCategory(CategoryVO categoryVO) {
		return categoryImpl.deleteCategory(categoryVO);
	}

	@Override
	public boolean updateCategory(CategoryVO categoryVO) {
		return categoryImpl.updateCategory(categoryVO);
	}

	@Override
	public CategoryVO findCategoryByName(String name) {
		return categoryImpl.findCategoryByName(name);
	}

	@Override
	public CategoryVO findCategoryByID(long id) {
		return categoryImpl.findCategoryByID(id);
	}

	@Override
	public CommodityVO toCommodityVO(CommodityPO commodityPO) {
		return commodityImpl.toCommodityVO(commodityPO);
	}

	@Override
	public CategoryVO toCategoryVO(CategoryPO categoryPO) {
		return categoryImpl.toCategoryVO(categoryPO);
	}

	@Override
	public ArrayList<CategoryVO> findUpCategory(CategoryVO vo) {
		return categoryImpl.findUpCategory(vo);
	}

	@Override
	public ArrayList<CategoryVO> findDownCategory(CategoryVO vo) {
		return categoryImpl.findDownCategory(vo);
	}

	@Override
	public ArrayList<CommodityVO> findDownCommodity(CategoryVO vo) {
		return categoryImpl.findDownCommodity(vo);
	}

	@Override
	public ArrayList<StockCheckInfoVO> getStockInfo(Date start, Date end) {
		ArrayList<StockCheckInfoVO> test=new ArrayList<>();
		StockCheckInfoVO testVO=new StockCheckInfoVO(11, "µõµÆ", "XT101", 100, 100, 100, 100, 100, 100, 100, 100);
		test.add(testVO);
		return test;
	}

	@Override
	public ArrayList<StockInventoryInfoVO> getInventoryInfo() {
		ArrayList<StockInventoryInfoVO> test=new ArrayList<>();
		StockInventoryInfoVO info=new StockInventoryInfoVO(1, "µÆ´ø", "XT100", 101, 1000);
		test.add(info);
		return test;
	}

	@Override
	public ArrayList<CommodityVO> findCommodities() {
		return commodityImpl.findCommodities();
	}
	
}
