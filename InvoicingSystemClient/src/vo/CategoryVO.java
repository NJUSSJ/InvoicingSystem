package vo;

import java.util.ArrayList;

public class CategoryVO {
	String name;
	String parent;
	ArrayList<CategoryVO> subCategory;
	ArrayList<CommodityVO> subCommodity;
	
	public CategoryVO(String name,String parent,ArrayList<CategoryVO> sub_category,
			ArrayList<CommodityVO> sub_commodity) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.subCategory=subCategory;
		this.subCommodity=subCommodity;
	}
	public String getName(){
		return name;
	}
	public String getParent(){
		return parent;
	}
}
