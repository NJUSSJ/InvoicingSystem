package vo;

import java.util.ArrayList;

/**
 * 
 * @author yrz
 * �ֽ���õ�
 *
 */
public class CashBillVO {
	long id;
	UserVO user;
	MemberVO member;
	ArrayList<AccountVO> accountList;
	String[][] items;
}
