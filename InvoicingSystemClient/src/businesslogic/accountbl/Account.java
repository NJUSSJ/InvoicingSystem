package businesslogic.accountbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AccountPO;
import rmi.RemoteHelper;
import vo.AccountVO;

public class Account{

	public AccountVO findAccountByID(long id) {
		// TODO Auto-generated method stub
		try {
			return toAccountVO(RemoteHelper.getInstance().getAccountDataService().findAccountbyID(id));
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	public boolean addAccount(AccountVO accountVO) {
		// TODO Auto-generated method stub
		
		try {
			return RemoteHelper.getInstance().getAccountDataService().insert(accountVO.toAccountPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteAccount(AccountVO accountVO) {
		// TODO Auto-generated method stub
		try {
			return RemoteHelper.getInstance().getAccountDataService().delete(accountVO.toAccountPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateAccount(AccountVO accountVO) {
		// TODO Auto-generated method stub
		try {
			return RemoteHelper.getInstance().getAccountDataService().delete(accountVO.toAccountPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	
	public AccountVO toAccountVO(AccountPO accountPO){
		return new AccountVO(accountPO.getID(),accountPO.getDeposit(),accountPO.getName());
	}

	public ArrayList<AccountVO> findAccountByField(String field) {
		// TODO Auto-generated method stub
		ArrayList<AccountVO> temp=new ArrayList<AccountVO>();
		
		try {
			ArrayList<AccountPO> accounts = RemoteHelper.getInstance().getAccountDataService().findAcountbyField(field);
			for(int i=0;i<accounts.size();i++){
				temp.add(toAccountVO(accounts.get(i)));
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return temp;
	}

}
