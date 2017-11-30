package stubs;

import java.util.ArrayList;

import vo.AccountVO;
import businesslogicservice.accountblservice.*;
import po.AccountPO;

public class AccountBLService_Stub implements AccountBLService {
	
	long id;
	AccountVO account;
	double deposit;
	String Bank;
	ArrayList<AccountVO> accountList=new ArrayList<>();
	public AccountBLService_Stub(long id,AccountVO account,double deposit,String Bank) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.account=account;
		this.deposit=deposit;
		this.Bank=Bank;
	}
	@Override
	public AccountVO findAccountByID(long id) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public boolean addAccount(AccountVO accountVO) {
		// TODO 自动生成的方法存根
		return false;
	}
	@Override
	public boolean deleteAccount(AccountVO accountVO) {
		// TODO 自动生成的方法存根
		return false;
	}
	@Override
	public boolean updateAccount(AccountVO accountVO) {
		// TODO 自动生成的方法存根
		return false;
	}
	@Override
	public AccountVO toAccountVo(AccountPO accountPO) {
		// TODO 自动生成的方法存根
		return null;
	}

	

}
