package businesslogic.commoditybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CategoryPO;
import po.CommodityPO;
import rmi.RemoteHelper;
import vo.CategoryVO;
import vo.CommodityVO;

public class Category {
	/**
	 * 增加商品分类
	 * @param categoryVO 商品分类vo
	 * @return  增加商品的结果
	 */
	public boolean addCategory(CategoryVO categoryVO){
		try {
			return RemoteHelper.getInstance().getCategoryDataService().insert(categoryVO.toCategoryPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 删除商品分类
	 * @param categoryVO 商品分类vo
	 * @return 删除商品的结果
	 */
	public boolean deleteCategory(CategoryVO categoryVO){
		try {
			return RemoteHelper.getInstance().getCategoryDataService().delete(categoryVO.toCategoryPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 更新商品分类
	 * @param categoryVO 商品分类vo
	 * @return 更新商品的结果
	 */
	public boolean updateCategory(CategoryVO categoryVO){
		try {
			return RemoteHelper.getInstance().getCategoryDataService().update(categoryVO.toCategoryPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 根据id查找单个商品分类
	 * @param id 商品分类id
	 * @return 查找到的商品分类vo，如果没有则返回null
	 */
	public CategoryVO findCategoryByID(long id){
		try {
			return toCategoryVO(RemoteHelper.getInstance().getCategoryDataService().findCategorybyID(id));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据商品分类名称查找单个商品分类
	 * @param name 商品分类名称
	 * @return 查找到的商品分类，如果查不到则返回null
	 */
	public CategoryVO findCategoryByName(String name){
		try {
			return toCategoryVO(RemoteHelper.getInstance().getCategoryDataService().findCategorybyName(name));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 将商品分类po转化为商品分类vo
	 * @param categoryPO 商品分类po
	 * @return 转化的vo，如果为null则返回bull
	 */
	public CategoryVO toCategoryVO(CategoryPO categoryPO){
		if(categoryPO==null){
			return null;
		}
		return new CategoryVO(categoryPO.getID(),categoryPO.getName(),categoryPO.getParentID());
	}
	/**
	 * 查找商品分类的父类及父类的兄弟
	 * @param vo:传入的商品分类vo
	 * @return 商品分类的上一级
	 */
	public ArrayList<CategoryVO> findUpCategory(CategoryVO vo) {
		ArrayList<CategoryVO> temp=null;
		if(vo==null){
			return null;
		}
		try {
			temp=new ArrayList<CategoryVO>();
			CategoryPO parent=RemoteHelper.getInstance().getCategoryDataService().findCategorybyID(vo.getParentID());
			CategoryPO grandParent=RemoteHelper.getInstance().getCategoryDataService().findCategorybyID(parent.getParentID());
			ArrayList<CategoryPO> upCategory = RemoteHelper.getInstance().getCategoryDataService().findCategorybyParent(grandParent.getID());
			for(int i=0;i<upCategory.size();i++){
				temp.add(toCategoryVO(upCategory.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return temp;
	}
	/**
	 * 查找商品分类的子类
	 * @param vo 商品分类vo
	 * @return 商品的子类，如果为null则返回null
	 */
	public ArrayList<CategoryVO> findDownCategory(CategoryVO vo) {
		ArrayList<CategoryVO> temp = null;
		if(vo==null){
			return null;
		}
		try {
			temp=new ArrayList<CategoryVO>();
			ArrayList<CategoryPO> category = RemoteHelper.getInstance().getCategoryDataService().findCategorybyParent(vo.getID());
			if(category==null){
				return null;
			}
			for(int i=0;i<category.size();i++){
				temp.add(toCategoryVO(category.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return temp;
	}
	/**
	 * 查找商品分类下面的所有商品
	 */
	public ArrayList<CommodityVO> findDownCommodity(CategoryVO vo) {
		ArrayList<CommodityVO> temp=null;
		if(vo==null){
			return null;
		}
		try {
			temp=new ArrayList<CommodityVO>();
			ArrayList<CommodityPO> commodity = RemoteHelper.getInstance().getCommodityDataService().findCommoditiesbyParent(vo.getID());
			CommodityController controller=new CommodityController();
			if(commodity==null){
				return null;
			}
			for(int i=0;i<commodity.size();i++){
				temp.add(controller.toCommodityVO(commodity.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return temp;
	}
	/**
	 * 返回数据库中商品分类的最大id，出错时返回-2
	 */
	public long findLargestIDofCategory(){
		try {
			return RemoteHelper.getInstance().getCategoryDataService().getLargestIDofCategory();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return -2;
	}
}
