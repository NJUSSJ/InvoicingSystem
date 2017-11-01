package stubs;

import java.util.ArrayList;

import vo.AccountVO;
import businesslogicservice.accountblservice.*;

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
	public AccountVO getAccount(long id) {
		// TODO Auto-generated method stub
		System.out.println("����˻����ݶ���");
		return new AccountVO(id, deposit, Bank);
	}

	@Override
	public String addAccount(AccountVO account) {
		// TODO Auto-generated method stub
		System.out.println("�����˻����ݶ���");
		return "Succeed";
	}

	@Override
	public String deleteAccount(AccountVO account) {
		// TODO Auto-generated method stub
		System.out.println("ɾ���˻����ݶ���");
		return "Succeed";
	}

	@Override
	public String modifyAccount(long id) {
		// TODO Auto-generated method stub
		System.out.println("�޸��˻����ݶ���");
		return "Succeed";
	}

	

}
