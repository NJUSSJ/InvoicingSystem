package businesslogic.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.billbl.CommodityList;
import po.MemberPromotionPO;
import rmi.RemoteHelper;
import vo.MemberPromotionVO;

public class MemberPromotion {
	public boolean addMemberPromotionVO(MemberPromotionVO memberPromotionVO){
		try {
			return RemoteHelper.getInstance().getMemberPromotionDataService().
					insert(memberPromotionVO.toMemberPromotionPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean deleteMemberPromotionVO(MemberPromotionVO memberPromotionVO){
		try {
			return RemoteHelper.getInstance().getMemberPromotionDataService().
					delete(memberPromotionVO.toMemberPromotionPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	public ArrayList<MemberPromotionVO> findMemberPromotions(){
		ArrayList<MemberPromotionVO> temp = null;
		try {
			temp=new ArrayList<MemberPromotionVO>();
			ArrayList<MemberPromotionPO> mp=RemoteHelper.getInstance().getMemberPromotionDataService().findMemberPromotions();
			for(int i=0;i<mp.size();i++){
				temp.add(toMemberPromotionVO(mp.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return temp;
		
	}
	/**
	 * 
	 * @return 所有符合该等级的客户促销策略
	 */
	public ArrayList<MemberPromotionVO> findMemberPromotionByRank(int rank){
		ArrayList<MemberPromotionVO> result=new ArrayList<MemberPromotionVO>();
		try {
			ArrayList<MemberPromotionPO> pos=RemoteHelper.getInstance().getMemberPromotionDataService().findMemberPromotionsbyRank(rank);
			for(MemberPromotionPO po:pos){
				result.add(toMemberPromotionVO(po));
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return result;
	}
	public MemberPromotionVO toMemberPromotionVO(MemberPromotionPO memberPromotionPO){
		return new MemberPromotionVO(memberPromotionPO.getID(),memberPromotionPO.getRank(),
	memberPromotionPO.getDiscount(),new CommodityList(memberPromotionPO.getGifts()),memberPromotionPO.getCoupon());
	}
}
