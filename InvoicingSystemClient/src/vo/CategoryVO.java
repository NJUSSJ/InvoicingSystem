package vo;

import java.util.ArrayList;

public class CategoryVO {
	String name;
	String parent;
	ArrayList<CategoryVO> sub_category;
	ArrayList<CommodityVO> sub_commodity;
	
	public CategoryVO(String name,String parent,
	ArrayList<CategoryVO> sub_category,
	ArrayList<CommodityVO> sub_commodity) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.sub_category=sub_category;
		this.sub_commodity=sub_commodity;
	}

	public CategoryVO() {
		// TODO �Զ����ɵĹ��캯�����
	}
}
