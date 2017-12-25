package businesslogicservice.accountblservice;

import java.sql.Date;
import java.util.ArrayList;

import po.AccountPO;
import presentation.accountui.AccountBookData;
import vo.AccountVO;

public interface AccountBLService {
	
	public AccountVO findAccountByID(long id);
	public ArrayList<AccountVO> findAccountByField(String field);
	public boolean addAccount(AccountVO accountVO);
	public boolean deleteAccount(AccountVO accountVO);
	public boolean updateAccount(AccountVO accountVO);
	public AccountVO toAccountVO(AccountPO accountPO);
	public ArrayList<AccountVO> findAccounts();
	public boolean backUpDataBase(Date time);
	public ArrayList<AccountBookData> retore();
}
