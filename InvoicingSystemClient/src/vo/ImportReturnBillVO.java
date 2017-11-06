package vo;

import java.util.ArrayList;

/**
 * 
 * @author yrz
 *	进过退货单
 */
public class ImportReturnBillVO {
	long id;
	UserVO user;
	MemberVO member;
	ArrayList<CommodityVO> commodityList;
	int sum;
}
