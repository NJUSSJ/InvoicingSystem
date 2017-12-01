package vo;

import java.util.ArrayList;

import po.PackagePromotionPO;

public class PackagePromotionVO {
	long id;
	ArrayList<Long> commodityid;
	double discount;
	public PackagePromotionVO(long id,ArrayList<Long> commodityid,double discount){
		this.id=id;
		this.commodityid=commodityid;
		this.discount=discount;
	}
	public PackagePromotionPO toPackagePromotionPO(){
		return new PackagePromotionPO(id,commodityid,discount);
	}
}
