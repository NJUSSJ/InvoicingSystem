package businesslogic.accountbl;

import java.util.ArrayList;

import businesslogicservice.accountblservice.AccountBLService;
import po.AccountPO;
import vo.AccountVO;

public class AccountController implements AccountBLService{
	Account accountImpl=new Account();
	@Override
	public AccountVO findAccountByID(long id) {
		// TODO 自动生成的方法存根
		return accountImpl.findAccountByID(id);
	}

	@Override
	public boolean addAccount(AccountVO accountVO) {
		// TODO 自动生成的方法存根
		return accountImpl.addAccount(accountVO);
	}

	@Override
	public boolean deleteAccount(AccountVO accountVO) {
		// TODO 自动生成的方法存根
		return accountImpl.deleteAccount(accountVO);
	}

	@Override
	public boolean updateAccount(AccountVO accountVO) {
		// TODO 自动生成的方法存根
		return accountImpl.updateAccount(accountVO);
	}

	@Override
	public AccountVO toAccountVO(AccountPO accountPO) {
		// TODO 自动生成的方法存根
		return accountImpl.toAccountVO(accountPO);
	}

	@Override
	public ArrayList<AccountVO> findAccountByField(String field) {
		// TODO 自动生成的方法存根
		return accountImpl.findAccountByField(field);
	}

	@Override
	public ArrayList<AccountVO> findAccounts() {
		// TODO 自动生成的方法存根
		return accountImpl.findAccounts();
	}
	
	
}
