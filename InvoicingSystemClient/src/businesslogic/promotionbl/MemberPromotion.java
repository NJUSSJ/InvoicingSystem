package businesslogic.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.MemberPromotionPO;
import rmi.RemoteHelper;
import vo.MemberPromotionVO;

public class MemberPromotion {
	public boolean addMemberPromotionVO(MemberPromotionVO memberPromotionVO){
		try {
			return RemoteHelper.getInstance().getMemberPromotionDataService().
					insert(memberPromotionVO.toMemberPromotionPO());
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean deleteMemberPromotionVO(MemberPromotionVO memberPromotionVO){
		try {
			return RemoteHelper.getInstance().getMemberPromotionDataService().
					delete(memberPromotionVO.toMemberPromotionPO());
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
	}
	public ArrayList<MemberPromotionVO> findMemberPromotionVO(){
		ArrayList<MemberPromotionVO> temp = null;
		try {
			temp=new ArrayList<MemberPromotionVO>();
			ArrayList<MemberPromotionPO> mp=RemoteHelper.getInstance().getMemberPromotionDataService().findMemberPromotions();
			for(int i=0;i<mp.size();i++){
				temp.add(toMemberPromotionVO(mp.get(i)));
			}
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return temp;
		
	}
	public ArrayList<MemberPromotionVO> findMemberPromotionByRank(){
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
