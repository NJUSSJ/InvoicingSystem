package businesslogic.accountbl;

import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.accountblservice.AccountBLService;
import po.AccountPO;
import po.BookPO;
import presentation.accountui.BookData;
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

	@Override
	public boolean backUpDataBase(Date time) {
		return accountImpl.backUpDataBase(time);
	}

	@Override
	public ArrayList<BookData> retore() {
		return accountImpl.restore();
	}
	
	
}
