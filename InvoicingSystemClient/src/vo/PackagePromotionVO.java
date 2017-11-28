package vo;

import java.util.ArrayList;

public class PackagePromotionVO {
	long id;
	ArrayList<Long> commoditiesid;
	double discount;
	public PackagePromotionVO(long id,ArrayList<Long> commoditiesid,double discount){
		this.id=id;
		this.commoditiesid=commoditiesid;
		this.discount=discount;
	}
}
