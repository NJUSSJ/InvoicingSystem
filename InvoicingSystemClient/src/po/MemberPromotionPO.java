package po;

import java.util.ArrayList;

public class MemberPromotionPO {
	long id;
	int rank;
	String giftsid;//ÔùÆ·
	int coupon;
	public MemberPromotionPO(long id,int rank,ArrayList<Long> giftsid,int coupon){
		this.id=id;
		this.rank=rank;
		for(int i=0;i<giftsid.size();i++){
			this.giftsid+=giftsid.get(i);
			if(i!=giftsid.size()-1){
				this.giftsid+=" ";
			}
		}
		this.coupon=coupon;
	}
}
