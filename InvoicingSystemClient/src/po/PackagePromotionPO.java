package po;

import java.util.ArrayList;

public class PackagePromotionPO {
	long id;
	String commoditiesid;
	double discount;
	public PackagePromotionPO(long id,ArrayList<Long> commoditiesid,double discount){
		this.id=id;
		for(int i=0;i<commoditiesid.size();i++){
			this.commoditiesid+=commoditiesid.get(i);
			if(i!=commoditiesid.size()-1){
				this.commoditiesid+=" ";
			}
		}
		this.discount=discount;
	}
}
