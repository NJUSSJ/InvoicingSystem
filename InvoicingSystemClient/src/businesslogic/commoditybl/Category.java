package businesslogic.commoditybl;

import java.util.ArrayList;

import po.CategoryPO;
import vo.CategoryVO;

public class Category {
	public boolean addCategory(CategoryVO categoryVO){
		return false;
	}
	public boolean deleteCategory(CategoryVO categoryVO){
		return false;
	}
	public boolean updateCategory(CategoryVO categoryVO){
		return false;
	}
	public CategoryVO findCategoryByID(long id){
		return null;
	}
	public CategoryVO findCategoryByName(String name){
		return null;
	}
	public CategoryVO toCategoryVO(CategoryPO categoryPO){
		return new CategoryVO(categoryPO.getID(),categoryPO.getName(),categoryPO.getParentID());
	}
}
