package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.ArrayList;

import data.accountdata.AccountDataImpl;
import data.commoditydata.CommodityDataImpl;
import data.logdata.LogDataImpl;
import data.memberdata.MemberDataImpl;
import data.userdata.UserDataImpl;
import dataservice.accountdataservice.AccountDataService;
import dataservice.commoditydataservice.CommodityDataService;
import dataservice.logdataservice.LogDataService;
import dataservice.memberdataservice.MemberDataService;
import dataservice.userdataservice.UserDataService;
import po.AccountPO;
import po.CommodityPO;
import po.LogPO;
import po.MemberPO;
import po.UserPO;

/**
 * 
 * @author shisj
 *
 */
public class DataRemoteObject extends UnicastRemoteObject implements UserDataService,AccountDataService,LogDataService
,MemberDataService,CommodityDataService{

	
	
	private static final long serialVersionUID = 1L;

	
	private UserDataService userService;
	
	private AccountDataService accountService;
	
	private LogDataService logService;
	
	private MemberDataService memberService;
	
	private CommodityDataService commodityService;
	
	
	protected DataRemoteObject() throws RemoteException {
		userService=new UserDataImpl();
		accountService=new AccountDataImpl();
		logService=new LogDataImpl();
		memberService=new MemberDataImpl();
		commodityService=new CommodityDataImpl();
	}
	
	/*
	 * UserDataService
	 */
	@Override
	public UserPO findUserbyID(long id) throws RemoteException {
		return userService.findUserbyID(id);
	}

	
	@Override
	public UserPO findUserbyName(String name) throws RemoteException {
		return userService.findUserbyName(name);
	}


	@Override
	public boolean insert(UserPO po) throws RemoteException {
		return userService.insert(po);
	}

	@Override
	public boolean delete(UserPO po) throws RemoteException {
		return userService.delete(po);
	}

	@Override
	public boolean update(UserPO po) throws RemoteException {
		return userService.update(po);
	}

	/*
	 * AccountDataService
	 */
	@Override
	public AccountPO findAccountbyID(long id) throws RemoteException {
		return accountService.findAccountbyID(id);
	}

	@Override
	public ArrayList<AccountPO> findAccounts() throws RemoteException {
		return accountService.findAccounts();
	}

	@Override
	public boolean insert(AccountPO po) throws RemoteException {
		return accountService.insert(po);
	}

	@Override
	public boolean delete(AccountPO po) throws RemoteException {
		return accountService.delete(po);
	}

	@Override
	public boolean update(AccountPO po) throws RemoteException {
		return accountService.update(po);
	}

	/*
	 * LogDataServive
	 */
	@Override
	public boolean insert(LogPO po) throws RemoteException {
		return logService.insert(po);
	}

	@Override
	public ArrayList<LogPO> findLogs() throws RemoteException {
		return logService.findLogs();
	}

	@Override
	public ArrayList<LogPO> findLogbyOperator(long operatorID) throws RemoteException {
		return logService.findLogbyOperator(operatorID);
	}

	@Override
	public ArrayList<LogPO> findLogbyType(String type) throws RemoteException {
		return logService.findLogbyType(type);
	}

	@Override
	public int getLogNum() throws RemoteException {
		return logService.getLogNum();
	}

	@Override
	public boolean delete(Date time) throws RemoteException {
		return logService.delete(time);
	}

	@Override
	public boolean update(LogPO po) throws RemoteException {		
		return logService.update(po);
	}

	/*
	 * MemberDataService
	 */
	@Override
	public MemberPO findMemberbyName(String name) throws RemoteException {
		return memberService.findMemberbyName(name);
	}

	@Override
	public ArrayList<MemberPO> findMembers() throws RemoteException {
		return memberService.findMembers();
	}

	@Override
	public ArrayList<MemberPO> findMembersbyField(String field) throws RemoteException {
		return memberService.findMembersbyField(field);
	}

	@Override
	public boolean insert(MemberPO po) throws RemoteException {
		return memberService.insert(po);
	}

	@Override
	public boolean delete(MemberPO po) throws RemoteException {
		return memberService.delete(po);
	}

	@Override
	public boolean update(MemberPO po) throws RemoteException {
		return memberService.update(po);
	}

	/*
	 * CommodityDataService
	 */
	@Override
	public CommodityPO findCommoditybyID(long id) throws RemoteException {
		return commodityService.findCommoditybyID(id);
	}

	@Override
	public ArrayList<CommodityPO> findCommodities() throws RemoteException {
		return commodityService.findCommodities();
	}

	@Override
	public ArrayList<CommodityPO> findCommoditiesbyField(String field) throws RemoteException {
		return commodityService.findCommoditiesbyField(field);
	}

	@Override
	public CommodityPO findCommoditybyName(String name) throws RemoteException {
		return commodityService.findCommoditybyName(name);
	}

	@Override
	public boolean insert(CommodityPO po) throws RemoteException {
		return commodityService.insert(po);
	}

	@Override
	public boolean delete(CommodityPO po) throws RemoteException {
		return commodityService.delete(po);
	}

	@Override
	public boolean update(CommodityPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return commodityService.update(po);
	}
	
	
	
	
	
}
