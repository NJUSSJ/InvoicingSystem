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
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteCategory(CategoryVO categoryVO){
		try {
			return RemoteHelper.getInstance().getCategoryDataService().delete(categoryVO.toCategoryPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateCategory(CategoryVO categoryVO){
		try {
			return RemoteHelper.getInstance().getCategoryDataService().update(categoryVO.toCategoryPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	public CategoryVO findCategoryByID(long id){
		try {
			return toCategoryVO(RemoteHelper.getInstance().getCategoryDataService().findCategorybyID(id));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	public CategoryVO findCategoryByName(String name){
		try {
			return toCategoryVO(RemoteHelper.getInstance().getCategoryDataService().findCategorybyName(name));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	public CategoryVO toCategoryVO(CategoryPO categoryPO){
		if(categoryPO==null){
			return null;
		}
		return new CategoryVO(categoryPO.getID(),categoryPO.getName(),categoryPO.getParentID());
	}
	/**
	 * 
	 * @param vo:传入的商品分类vo
	 * @return 商品分类的上一级
	 */
	public ArrayList<CategoryVO> findUpCategory(CategoryVO vo) {
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
			e.printStackTrace();
		}
		return temp;
	}
	public ArrayList<CategoryVO> findDownCategory(CategoryVO vo) {
		ArrayList<CategoryVO> temp = null;
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
	public ArrayList<CommodityVO> findDownCommodity(CategoryVO vo) {
		ArrayList<CommodityVO> temp=null;
		try {
			temp=new ArrayList<CommodityVO>();
			ArrayList<CommodityPO> commodity = RemoteHelper.getInstance().getCommodityDataService().findCommoditiesbyParent(vo.getParentID());
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
	public long findLargestIDofCategory(){
		try {
			return RemoteHelper.getInstance().getCategoryDataService().getLargestIDofCategory();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return -2;
	}
}
