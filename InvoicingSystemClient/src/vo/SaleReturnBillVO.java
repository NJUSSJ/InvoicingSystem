package vo;

import java.util.ArrayList;

/**
 * 
 * @author yrz
 *	销售退货单
 */
public class SaleReturnBillVO {
	long id;
	UserVO user;
	MemberVO member;
	ArrayList<CommodityVO> commodityList;
	int sum;
}
