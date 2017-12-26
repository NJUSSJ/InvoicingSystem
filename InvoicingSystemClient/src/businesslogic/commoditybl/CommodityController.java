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
	/**
	 * 
	 * @param commodityVO 商品vo
	 * @return 添加商品结果
	 */
	@Override
	public boolean addCommodity(CommodityVO commodityVO) {
		return commodityImpl.addCommodity(commodityVO);
	}
	/**
	 * 
	 * @param commodityVO 商品vo
	 * @return 删除结果
	 */
	@Override
	public boolean deleteCommodity(CommodityVO commodityVO) {
		return commodityImpl.deleteCommodity(commodityVO);
	}
	/**
	 * 
	 * @param commodityVO 商品vo
	 * @return 更新结果
	 */
	@Override
	public boolean updateCommodity(CommodityVO commodityVO) {
		return commodityImpl.updateCommodity(commodityVO);
	}
	/**
	 * 
	 * @param name 商品名称
	 * @return 查找到的商品vo，如果为空则返回null
	 */
	@Override
	public CommodityVO findCommodityByName(String name) {
		return commodityImpl.findCommodityByName(name);
	}
	/**
	 * 
	 * @param id 商品id
	 * @return 查找到的商品vo，如果为空则返回null
	 */
	@Override
	public CommodityVO findCommodityByID(long id) {
		return commodityImpl.findCommodityByID(id);
	}
	/**
	 * 
	 * @param field 根据关键字模糊查找商品
	 * @return 查找结果，如果为空,返回空list
	 */
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
	/**
	 * 
	 * @param commodityPO 商品po
	 * @return 该po转换为vo的结果，如果是null则返回null
	 */
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
		return commodityImpl.getStockInfo(start, end);
	}

	@Override
	public ArrayList<StockInventoryInfoVO> getInventoryInfo() {
		return commodityImpl.getInventoryInfo();
	}

	@Override
	public ArrayList<CommodityVO> findCommodities() {
		return commodityImpl.findCommodities();
	}

	@Override
	public long findLargestIDofCommodity() {
		return commodityImpl.findLargestIDofCommodity();
	}

	@Override
	public long findLargestIDofCategory() {
		return categoryImpl.findLargestIDofCategory();
	}
	
}
