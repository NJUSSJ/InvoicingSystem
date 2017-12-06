package businesslogic.commoditybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CategoryPO;
import rmi.RemoteHelper;
import vo.CategoryVO;

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
	public ArrayList<CategoryVO> findChildCategory(CategoryVO vo){
		return null;
		
	}
	public ArrayList<CategoryVO> findBrotherCategory(CategoryVO vo){
		return null;
		
	}
}
