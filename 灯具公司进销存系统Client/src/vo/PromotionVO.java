package vo;

import java.util.ArrayList;

public class PromotionVO {
	double discount;
	double discunt_TotalPrice;
	ArrayList<CommodityVO> CombinationPack;
	int MemberRank;
	
	public PromotionVO(double discount,double discount_TotalPrice,ArrayList<CommodityVO> CombnationPack,int MemberRank) {
		// TODO Auto-generated constructor stub
		this.CombinationPack=CombnationPack;
		this.discount=discount;
		this.discunt_TotalPrice=discount_TotalPrice;
		this.MemberRank=MemberRank;
	}
}
