package businesslogic.accountbl;

import java.util.ArrayList;

import businesslogicservice.accountblservice.AccountBLService;
import po.AccountPO;
import vo.AccountVO;

public class AccountController implements AccountBLService{
	Account accountImpl=new Account();
	@Override
	public AccountVO findAccountByID(long id) {
		return accountImpl.findAccountByID(id);
	}

	@Override
	public boolean addAccount(AccountVO accountVO) {
		return accountImpl.addAccount(accountVO);
	}

	@Override
	public boolean deleteAccount(AccountVO accountVO) {
		return accountImpl.deleteAccount(accountVO);
	}

	@Override
	public boolean updateAccount(AccountVO accountVO) {
		return accountImpl.updateAccount(accountVO);
	}

	@Override
	public AccountVO toAccountVO(AccountPO accountPO) {
		return accountImpl.toAccountVO(accountPO);
	}

	@Override
	public ArrayList<AccountVO> findAccountByField(String field) {
		return accountImpl.findAccountByField(field);
	}

	@Override
	public ArrayList<AccountVO> findAccounts() {
		return accountImpl.findAccounts();
	}
	
	
}
