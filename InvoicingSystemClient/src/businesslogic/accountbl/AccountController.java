package businesslogic.accountbl;

import java.util.ArrayList;

import businesslogicservice.accountblservice.AccountBLService;
import po.AccountPO;
import vo.AccountVO;

public class AccountController implements AccountBLService{
	Account accountImpl=new Account();
	@Override
	public AccountVO findAccountByID(long id) {
		// TODO �Զ����ɵķ������
		return accountImpl.findAccountByID(id);
	}

	@Override
	public boolean addAccount(AccountVO accountVO) {
		// TODO �Զ����ɵķ������
		return accountImpl.addAccount(accountVO);
	}

	@Override
	public boolean deleteAccount(AccountVO accountVO) {
		// TODO �Զ����ɵķ������
		return accountImpl.deleteAccount(accountVO);
	}

	@Override
	public boolean updateAccount(AccountVO accountVO) {
		// TODO �Զ����ɵķ������
		return accountImpl.updateAccount(accountVO);
	}

	@Override
	public AccountVO toAccountVO(AccountPO accountPO) {
		// TODO �Զ����ɵķ������
		return accountImpl.toAccountVO(accountPO);
	}

	@Override
	public ArrayList<AccountVO> findAccountByField(String field) {
		// TODO �Զ����ɵķ������
		return accountImpl.findAccountByField(field);
	}

	@Override
	public ArrayList<AccountVO> findAccounts() {
		// TODO �Զ����ɵķ������
		return accountImpl.findAccounts();
	}
	
	
}
