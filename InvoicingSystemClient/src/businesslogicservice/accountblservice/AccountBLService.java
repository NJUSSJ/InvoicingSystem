package businesslogicservice.accountblservice;

import java.util.ArrayList;

import po.AccountPO;
import vo.AccountVO;

public interface AccountBLService {
	
	public AccountVO findAccountByID(long id);
	public ArrayList<AccountVO> findAccountByField(String field);
	public boolean addAccount(AccountVO accountVO);
	public boolean deleteAccount(AccountVO accountVO);
	public boolean updateAccount(AccountVO accountVO);
	public AccountVO toAccountVO(AccountPO accountPO);
}
