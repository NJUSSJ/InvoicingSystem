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
	public AccountVO toAccountVo(AccountPO accountPO) {
		// TODO �Զ����ɵķ������
		return accountImpl.toAccountVO(accountPO);
	}
	
	
}
