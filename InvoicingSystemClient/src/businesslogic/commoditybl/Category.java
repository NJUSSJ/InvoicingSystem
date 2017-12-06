package businesslogic.commoditybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CategoryPO;
import po.CommodityPO;
import rmi.RemoteHelper;
import vo.CategoryVO;
import vo.CommodityVO;

public class Category {
	public boolean addCategory(CategoryVO categoryVO){
		try {
			return RemoteHelper.getInstance().getCategoryDataService().insert(categoryVO.toCategoryPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteCategory(CategoryVO categoryVO){
		try {
			return RemoteHelper.getInstance().getCategoryDataService().delete(categoryVO.toCategoryPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateCategory(CategoryVO categoryVO){
		try {
			return RemoteHelper.getInstance().getCategoryDataService().update(categoryVO.toCategoryPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	public CategoryVO findCategoryByID(long id){
		return null;//toCategoryVO(RemoteHelper.getInstance().getCategoryDataService().find);
	}
	public CategoryVO findCategoryByName(String name){
		return null;
	}
	public CategoryVO toCategoryVO(CategoryPO categoryPO){
		return new CategoryVO(categoryPO.getID(),categoryPO.getName(),categoryPO.getParentID());
	}
	/**
	 * 
	 * @param vo:传入的商品分类vo
	 * @return 商品分类的上一级
	 */
	public ArrayList<CategoryVO> findUpCategory(CategoryVO vo) {
		// TODO 自动生成的方法存根
		ArrayList<CategoryVO> temp=null;
		try {
			temp=new ArrayList<CategoryVO>();
			CategoryPO parent=RemoteHelper.getInstance().getCategoryDataService().findCategorybyID(vo.getParentID());
			CategoryPO grandParent=RemoteHelper.getInstance().getCategoryDataService().findCategorybyID(parent.getParentID());
			ArrayList<CategoryPO> upCategory = RemoteHelper.getInstance().getCategoryDataService().findCategorybyParent(grandParent.getID());
			for(int i=0;i<upCategory.size();i++){
				temp.add(toCategoryVO(upCategory.get(i)));
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return temp;
	}
	public ArrayList<CategoryVO> findDownCategory(CategoryVO vo) {
		// TODO 自动生成的方法存根
		ArrayList<CategoryVO> temp = null;
		try {
			temp=new ArrayList<CategoryVO>();
			ArrayList<CategoryPO> category = RemoteHelper.getInstance().getCategoryDataService().findCategorybyParent(vo.getID());
			for(int i=0;i<category.size();i++){
				temp.add(toCategoryVO(category.get(i)));
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return temp;
	}
	public ArrayList<CommodityVO> findDownCommodity(CategoryVO vo) {
		// TODO 自动生成的方法存根
		ArrayList<CommodityVO> temp=null;
		
		try {
			temp=new ArrayList<CommodityVO>();
			ArrayList<CommodityPO> commodity = RemoteHelper.getInstance().getCommodityDataService().findCommoditiesbyParent(vo.getParentID());
			CommodityController controller=new CommodityController();
			for(int i=0;i<commodity.size();i++){
				temp.add(controller.toCommodityVO(commodity.get(i)));
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return temp;
	}
}
