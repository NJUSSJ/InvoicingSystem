package businesslogic.commoditybl;

import java.util.ArrayList;

import businesslogicservice.commodityblservice.CommodityBLService;
import po.CategoryPO;
import po.CommodityPO;
import vo.CategoryVO;
import vo.CommodityVO;

public class CommodityController implements CommodityBLService{
	Commodity commodityImpl=new Commodity();
	Category categoryImpl=new Category();
	@Override
	public boolean addCommodity(CommodityVO commodityVO) {
		// TODO �Զ����ɵķ������
		return commodityImpl.addCommodity(commodityVO);
	}

	@Override
	public boolean deleteCommodity(CommodityVO commodityVO) {
		// TODO �Զ����ɵķ������
		return commodityImpl.deleteCommodity(commodityVO);
	}

	@Override
	public boolean updateCommodity(CommodityVO commodityVO) {
		// TODO �Զ����ɵķ������
		return commodityImpl.updateCommodity(commodityVO);
	}

	@Override
	public CommodityVO findCommodityByName(String name) {
		// TODO �Զ����ɵķ������
		return commodityImpl.findCommodityByName(name);
	}

	@Override
	public CommodityVO findCommodityByID(long id) {
		// TODO �Զ����ɵķ������
		return commodityImpl.findCommodityByID(id);
	}

	@Override
	public ArrayList<CommodityVO> findCommodityByField(String field) {
		// TODO �Զ����ɵķ������
		return commodityImpl.findCommodityByField(field);
	}

	@Override
	public boolean addCategory(CategoryVO categoryVO) {
		// TODO �Զ����ɵķ������
		return categoryImpl.addCategory(categoryVO);
	}

	@Override
	public boolean deleteCategory(CategoryVO categoryVO) {
		// TODO �Զ����ɵķ������
		return categoryImpl.deleteCategory(categoryVO);
	}

	@Override
	public boolean updateCategory(CategoryVO categoryVO) {
		// TODO �Զ����ɵķ������
		return categoryImpl.updateCategory(categoryVO);
	}

	@Override
	public CategoryVO findCategoryByName(String name) {
		// TODO �Զ����ɵķ������
		return categoryImpl.findCategoryByName(name);
	}

	@Override
	public CategoryVO findCategoryByID(long id) {
		// TODO �Զ����ɵķ������
		return categoryImpl.findCategoryByID(id);
	}

	@Override
	public CommodityVO toCommodityVO(CommodityPO commodityPO) {
		// TODO �Զ����ɵķ������
		return commodityImpl.toCommodityVO(commodityPO);
	}

	@Override
	public CategoryVO toCategoryVO(CategoryPO categoryPO) {
		// TODO �Զ����ɵķ������
		return categoryImpl.toCategoryVO(categoryPO);
	}

	@Override
	public ArrayList<CategoryVO> findChildCategory(CategoryVO vo) {
		// TODO �Զ����ɵķ������
		return categoryImpl.findChildCategory(vo);
	}

	@Override
	public ArrayList<CategoryVO> findBrotherCategory(CategoryVO vo) {
		// TODO �Զ����ɵķ������
		return categoryImpl.findBrotherCategory(vo);
	}
	
}
