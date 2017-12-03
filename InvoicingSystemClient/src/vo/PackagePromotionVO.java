package vo;

import java.util.ArrayList;

import businesslogic.billbl.CommodityList;
import po.PackagePromotionPO;

public class PackagePromotionVO {
	long id;
	CommodityList list;
	double discount;
	public PackagePromotionVO(long id,CommodityList list,double discount){
		this.id=id;
		this.list=list;
		this.discount=discount;
	}
	public PackagePromotionPO toPackagePromotionPO(){
		return new PackagePromotionPO(id,list.toString(),discount);
	}
	public long getID(){
		return id;
	}
	public CommodityList getList(){
		return list;
	}
	public double getDiscount(){
		return discount;
	}
	public void setDiscount(double discount){
		this.discount=discount;
	}
	
}
