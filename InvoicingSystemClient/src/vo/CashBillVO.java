package vo;

import java.util.ArrayList;

/**
 * 
 * @author yrz
 * 现金费用单
 *
 */
public class CashBillVO {
	long id;
	UserVO user;
	MemberVO member;
	ArrayList<AccountVO> accountList;
	String[][] items;
}
