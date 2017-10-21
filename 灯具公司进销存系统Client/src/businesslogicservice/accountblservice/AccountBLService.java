package businesslogicservice.accountblservice;

import java.util.ArrayList;

import vo.AccountVO;

public interface AccountBLService {
	
	public AccountVO getAccount(long id);
	public String addAccount(AccountVO account);
	public String deleteAccount(AccountVO account);
	public String modifyAccount(long id);
	public ArrayList<AccountVO> getAccountList(String field,long id);
}
