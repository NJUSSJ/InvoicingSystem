package po;

import java.io.Serializable;

public class PackagePromotionPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long id;
	String commodityid;
	double discount;
	public PackagePromotionPO(long id,String commodityid,double discount){
		this.id=id;
		this.commodityid=commodityid;
		this.discount=discount;
	}
	public long getID(){
		return id;
	}
	public String getCommodityID(){
		return commodityid;
	}
	public double getDiscount(){
		return discount;
	}
}
