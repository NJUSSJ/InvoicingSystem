package po;

import java.io.Serializable;
import java.util.ArrayList;

public class MemberPromotionPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	public long getID(){
		return id;
	}
	public int getRank(){
		return rank;
	}
	public String getGiftsID(){
		return giftsid;
	}
	public int getCoupon(){
		return coupon;
	}
}
