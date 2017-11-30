package businesslogic.promotionbl;

import java.util.ArrayList;

import po.MemberPromotionPO;
import vo.MemberPromotionVO;

public class MemberPromotion {
	public boolean addMemberPromotionVO(MemberPromotionVO memberPromotionVO){
		return false;
		
	}
	public boolean deleteMemberPromotionVO(MemberPromotionVO memberPromotionVO){
		return false;
		
	}
	public ArrayList<MemberPromotionVO> findMemberPromotionVO(){
		return null;
		
	}
	public MemberPromotionVO toMemberPromotionVO(MemberPromotionPO memberPromotionPO){
		ArrayList<Long> giftsid=new ArrayList<Long>();
		String[] temp=memberPromotionPO.getGiftsID().split(" ");
		for(int i=0;i<temp.length;i++){
			giftsid.add(Long.parseLong(temp[i]));
		}
		return new MemberPromotionVO(memberPromotionPO.getID(),memberPromotionPO.getRank(),
				giftsid,memberPromotionPO.getCoupon());
	}
}
