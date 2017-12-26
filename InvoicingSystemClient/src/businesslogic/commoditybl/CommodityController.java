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
	 * @param commodityVO ��Ʒvo
	 * @return �����Ʒ���
	 */
	@Override
	public boolean addCommodity(CommodityVO commodityVO) {
		return commodityImpl.addCommodity(commodityVO);
	}
	/**
	 * 
	 * @param commodityVO ��Ʒvo
	 * @return ɾ�����
	 */
	@Override
	public boolean deleteCommodity(CommodityVO commodityVO) {
		return commodityImpl.deleteCommodity(commodityVO);
	}
	/**
	 * 
	 * @param commodityVO ��Ʒvo
	 * @return ���½��
	 */
	@Override
	public boolean updateCommodity(CommodityVO commodityVO) {
		return commodityImpl.updateCommodity(commodityVO);
	}
	/**
	 * 
	 * @param name ��Ʒ����
	 * @return ���ҵ�����Ʒvo�����Ϊ���򷵻�null
	 */
	@Override
	public CommodityVO findCommodityByName(String name) {
		return commodityImpl.findCommodityByName(name);
	}
	/**
	 * 
	 * @param id ��Ʒid
	 * @return ���ҵ�����Ʒvo�����Ϊ���򷵻�null
	 */
	@Override
	public CommodityVO findCommodityByID(long id) {
		return commodityImpl.findCommodityByID(id);
	}
	/**
	 * 
	 * @param field ���ݹؼ���ģ��������Ʒ
	 * @return ���ҽ�������Ϊ��,���ؿ�list
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
	 * @param commodityPO ��Ʒpo
	 * @return ��poת��Ϊvo�Ľ���������null�򷵻�null
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
