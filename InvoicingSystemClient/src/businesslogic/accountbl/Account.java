package businesslogic.accountbl;

import po.AccountPO;
import vo.AccountVO;

public class Account{

	public AccountVO findAccountByID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addAccount(AccountVO accountVO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteAccount(AccountVO accountVO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateAccount(AccountVO accountVO) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public AccountVO toAccountVO(AccountPO accountPO){
		return new AccountVO(accountPO.getID(),accountPO.getDeposit(),accountPO.getBank());
	}

}
