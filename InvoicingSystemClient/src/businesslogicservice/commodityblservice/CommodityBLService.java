package businesslogicservice.commodityblservice;

import java.util.ArrayList;

import po.CategoryPO;
import po.CommodityPO;
import vo.CategoryVO;
import vo.CommodityVO;

public interface CommodityBLService {
	public boolean addCommodity(CommodityVO commodityVO);
	public boolean deleteCommodity(CommodityVO commodityVO);
	public boolean updateCommodity(CommodityVO commodityVO);
	public CommodityVO findCommodityByName(String name);
	public CommodityVO findCommodityByID(long id);
	public ArrayList<CommodityVO> findCommodityByField(String field);
	public boolean addCategory(CategoryVO categoryVO);
	public boolean deleteCategory(CategoryVO categoryVO);
	public boolean updateCategory(CategoryVO categoryVO);
	public CategoryVO findCategoryByName(String name);
	public CategoryVO findCategoryByID(long id);
	public CommodityVO toCommodityVO(CommodityPO commodityPO);
	public CategoryVO toCategoryVO(CategoryPO categoryPO);
	public ArrayList<CategoryVO> findUpCategory(CategoryVO vo);
	public ArrayList<CategoryVO> findDownCategory(CategoryVO vo);
	public ArrayList<CommodityVO> findDownCommodity(CategoryVO vo);
}
