package businesslogic.accountbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import po.AccountPO;
import po.BookPO;
import presentation.accountui.AccountBookData;
import rmi.RemoteHelper;
import vo.AccountVO;

public class Account{

	public AccountVO findAccountByID(long id) {
		try {
			return toAccountVO(RemoteHelper.getInstance().getAccountDataService().findAccountbyID(id));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean addAccount(AccountVO accountVO) {
		
		try {
			return RemoteHelper.getInstance().getAccountDataService().insert(accountVO.toAccountPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteAccount(AccountVO accountVO) {
		try {
			return RemoteHelper.getInstance().getAccountDataService().delete(accountVO.toAccountPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateAccount(AccountVO accountVO) {
		try {
			return RemoteHelper.getInstance().getAccountDataService().update(accountVO.toAccountPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public AccountVO toAccountVO(AccountPO accountPO){
		if(accountPO==null){
			return null;
		}
		return new AccountVO(accountPO.getID(),accountPO.getDeposit(),accountPO.getName());
	}

	public ArrayList<AccountVO> findAccountByField(String field) {
		ArrayList<AccountVO> temp=new ArrayList<AccountVO>();
		try {
			ArrayList<AccountPO> accounts = RemoteHelper.getInstance().getAccountDataService().
					findAcountbyField(field);
			if(accounts==null||accounts.isEmpty()) return temp;
			for(int i=0;i<accounts.size();i++){
				temp.add(toAccountVO(accounts.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	public ArrayList<AccountVO> findAccounts(){
		ArrayList<AccountVO> temp=new ArrayList<>();
		try {
			temp=new ArrayList<AccountVO>();
			ArrayList<AccountPO> accounts = RemoteHelper.getInstance().getAccountDataService().findAccounts();
			if(accounts.isEmpty()) return temp;
			for(int i=0;i<accounts.size();i++){
				temp.add(toAccountVO(accounts.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return temp;
	}
	/*
	 * backUP
	 */
	public boolean backUpDataBase(Date time) {
		
		try {
		
			 return RemoteHelper.getInstance().getAccountDataService().backUpDataBase(time);
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	/*
	 * Restore
	 */
	public ArrayList<AccountBookData> restore(){
		
		ArrayList<AccountBookData> result=new ArrayList<>();
		try {
			ArrayList<BookPO> temp= RemoteHelper.getInstance().getAccountDataService().restore();
			if(temp.isEmpty()) return result;
			
			for(int i=0;i<temp.size();i++) {
				AccountBookData tmpData=new AccountBookData(temp.get(i).getDate(), temp.get(i).getCommodity(), temp.get(i).getAccount(), temp.get(i).getMember());
				result.add(tmpData);
			}
			return result;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
