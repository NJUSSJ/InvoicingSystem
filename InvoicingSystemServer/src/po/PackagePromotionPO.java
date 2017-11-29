package po;

import java.io.Serializable;
import java.util.ArrayList;

public class PackagePromotionPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long id;
	String commodityid;
	double discount;
	public PackagePromotionPO(long id,ArrayList<Long> commodityid,double discount){
		this.id=id;
		for(int i=0;i<commodityid.size();i++){
			this.commodityid+=commodityid.get(i);
			if(i!=commodityid.size()-1){
				this.commodityid+=" ";
			}
		}
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
