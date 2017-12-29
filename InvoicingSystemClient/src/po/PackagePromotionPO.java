package po;

import java.io.Serializable;

public class PackagePromotionPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long id;
	String commoditylist;
	double discount;
	public PackagePromotionPO(long id,String commoditylist,double discount){
		this.id=id;
		this.commoditylist=commoditylist;
		this.discount=discount;
	}
	public long getID(){
		return id;
	}
	public String getCommoditylist(){
		return commoditylist;
	}
	public double getDiscount(){
		return discount;
	}
}
