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
		String temp="";
		for(int i=0;i<commodityid.size();i++){
			temp+=commodityid.get(i);
			if(i!=commodityid.size()-1){
				temp+=" ";
			}
		}
		return new PackagePromotionPO(id,temp,discount);
	}
}
