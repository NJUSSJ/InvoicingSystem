package vo;

import java.util.ArrayList;

public class PackagePromotionVO {
	long id;
	ArrayList<Long> commodityid;
	double discount;
	public PackagePromotionVO(long id,ArrayList<Long> commodityid,double discount){
		this.id=id;
		this.commodityid=commodityid;
		this.discount=discount;
	}
}
