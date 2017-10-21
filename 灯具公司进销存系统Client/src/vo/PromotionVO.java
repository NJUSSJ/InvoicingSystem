package vo;

import java.util.ArrayList;

public class PromotionVO {
	double discount;
	double discunt_TotalPrice;
	ArrayList<CommodityVO> combinationPack;
	int memberRank;
	
	public PromotionVO(double discount,double discount_TotalPrice,ArrayList<CommodityVO> combinationPack,int memberRank) {
		// TODO Auto-generated constructor stub
		this.combinationPack=combinationPack;
		this.discount=discount;
		this.discunt_TotalPrice=discount_TotalPrice;
		this.memberRank=memberRank;
	}
}
