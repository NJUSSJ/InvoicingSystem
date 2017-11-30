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
		ArrayList<Long> subCommodityID=new ArrayList<Long>();
		String[] tempSubCom=categoryPO.getSubCategoryID().split(" ");
		for(int i=0;i<tempSubCom.length;i++){
			subCommodityID.add(Long.parseLong(tempSubCom[i]));
		}
		ArrayList<Long> subCategoryID=new ArrayList<Long>();
		String[] tempSubCate=categoryPO.getSubCategoryID().split(" ");
		for(int i=0;i<tempSubCate.length;i++){
			subCategoryID.add(Long.parseLong(tempSubCate[i]));
		}
		return new CategoryVO(categoryPO.getID(),categoryPO.getName(),categoryPO.getParent(),
				subCommodityID,subCategoryID);
	}
}
