package businesslogicservice.accountblservice;

import po.AccountPO;
import vo.AccountVO;

public interface AccountBLService {
	
	public AccountVO findAccountByID(long id);
	public boolean addAccount(AccountVO accountVO);
	public boolean deleteAccount(AccountVO accountVO);
	public boolean updateAccount(AccountVO accountVO);
	public AccountVO toAccountVo(AccountPO accountPO);
}
