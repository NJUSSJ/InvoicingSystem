package vo;

import java.util.ArrayList;

/**
 * 
 * @author yrz
 *	���
 */
public class PayBillVO {
	long id;
	UserVO user;
	MemberVO member;
	ArrayList<AccountVO> accountList;
	String[][] items;
}
