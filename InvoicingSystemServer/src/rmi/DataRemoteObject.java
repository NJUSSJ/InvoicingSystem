package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.ArrayList;

import data.accountdata.AccountDataImpl;
import data.billdata.CashBillDataImpl;
import data.billdata.GiftBillDataImpl;
import data.billdata.ImportBillDataImpl;
import data.billdata.ImportReturnBillDataImpl;
import data.billdata.LossBillImpl;
import data.billdata.OverBillDataImpl;
import data.billdata.PayBillDataImpl;
import data.billdata.ReceiveBillDataImpl;
import data.billdata.SaleBillDataImpl;
import data.billdata.SaleReturnDataImpl;
import data.billdata.WarningBillDataImpl;
import data.commoditydata.CommodityDataImpl;
import data.logdata.LogDataImpl;
import data.memberdata.MemberDataImpl;
import data.userdata.UserDataImpl;
import dataservice.accountdataservice.AccountDataService;
import dataservice.billdataservice.CashBillDataService;
import dataservice.billdataservice.GiftBillDataService;
import dataservice.billdataservice.ImportBillDataService;
import dataservice.billdataservice.ImportReturnBillDataService;
import dataservice.billdataservice.LossBillDataService;
import dataservice.billdataservice.OverBillDataService;
import dataservice.billdataservice.PayBillDataService;
import dataservice.billdataservice.ReceiveBillDataService;
import dataservice.billdataservice.SaleBillDataService;
import dataservice.billdataservice.SaleReturnBillDataService;
import dataservice.billdataservice.WarningBillDataService;
import dataservice.commoditydataservice.CommodityDataService;
import dataservice.logdataservice.LogDataService;
import dataservice.memberdataservice.MemberDataService;
import dataservice.userdataservice.UserDataService;
import po.AccountPO;
import po.CashBillPO;
import po.CommodityPO;
import po.GiftBillPO;
import po.ImportBillPO;
import po.ImportReturnBillPO;
import po.LogPO;
import po.LossBillPO;
import po.MemberPO;
import po.OverBillPO;
import po.PayBillPO;
import po.ReceiveBillPO;
import po.SaleBillPO;
import po.SaleReturnBillPO;
import po.UserPO;
import po.WarningBillPO;

/**
 * 
 * @author shisj
 *
 */
public class DataRemoteObject extends UnicastRemoteObject implements UserDataService,AccountDataService,LogDataService
,MemberDataService,CommodityDataService,CashBillDataService,GiftBillDataService,ImportBillDataService,ImportReturnBillDataService
,LossBillDataService,OverBillDataService,PayBillDataService,ReceiveBillDataService,WarningBillDataService,SaleBillDataService
,SaleReturnBillDataService{

	
	
	private static final long serialVersionUID = 1L;

	
	private UserDataService userService;
	
	private AccountDataService accountService;
	
	private LogDataService logService;
	
	private MemberDataService memberService;
	
	private CommodityDataService commodityService;
	
	private CashBillDataService cashbillservice;
	
	private GiftBillDataService giftbillservice;
	
	private ImportReturnBillDataService importreturnbillservice;
	
	private ImportBillDataService importbillservice;
	
	private LossBillDataService lossbillservice;
	
	private OverBillDataService overbillservice;
	
	private PayBillDataService paybillservice;
	
	private ReceiveBillDataService receivebillservice;
	
	private SaleBillDataService salebillservice;
	
	private SaleReturnBillDataService salereturnbillservice;
	
	private WarningBillDataService warningbillservice;
	
	protected DataRemoteObject() throws RemoteException {
		userService=new UserDataImpl();
		accountService=new AccountDataImpl();
		logService=new LogDataImpl();
		memberService=new MemberDataImpl();
		commodityService=new CommodityDataImpl();
		cashbillservice=new CashBillDataImpl();
		giftbillservice=new GiftBillDataImpl();
		importbillservice=new ImportBillDataImpl();
		importreturnbillservice=new ImportReturnBillDataImpl();
		lossbillservice=new LossBillImpl();
		overbillservice=new OverBillDataImpl();
		paybillservice=new PayBillDataImpl();
		receivebillservice=new ReceiveBillDataImpl();
		salebillservice=new SaleBillDataImpl();
		salereturnbillservice=new SaleReturnDataImpl();
		warningbillservice=new WarningBillDataImpl();
		
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
	
	@Override
	public ArrayList<AccountPO> findAcountbyField(String field) throws RemoteException {
		return accountService.findAcountbyField(field);
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
		return commodityService.update(po);
	}

	/*
	 * (non-Javadoc)
	 * @CashBillDataService#insert(po.CashBillPO)
	 */
	@Override
	public boolean insert(CashBillPO po) throws RemoteException {
		return cashbillservice.insert(po);
	}

	@Override
	public boolean delete(CashBillPO po) throws RemoteException {
		return cashbillservice.delete(po);
	}

	@Override
	public boolean update(CashBillPO po) throws RemoteException {
		return cashbillservice.update(po);
	}

	@Override
	public CashBillPO findCashBillbyID(String id) throws RemoteException {
		return cashbillservice.findCashBillbyID(id);
	}

	@Override
	public ArrayList<CashBillPO> findCashBills() throws RemoteException {
		return cashbillservice.findCashBills();
	}

	@Override
	public ArrayList<CashBillPO> findCashBillbyTime(Date time) throws RemoteException {
		return cashbillservice.findCashBillbyTime(time);
	}

	@Override
	public ArrayList<CashBillPO> findCashBillbyState(int state) throws RemoteException {
		return cashbillservice.findCashBillbyState(state);
	}
	
	/*
	 * @GiftBillDataService
	 */
	@Override
	public boolean insert(GiftBillPO po) throws RemoteException {
		return giftbillservice.insert(po);
	}

	@Override
	public boolean delete(GiftBillPO po) throws RemoteException {
		return giftbillservice.delete(po);
	}

	@Override
	public boolean update(GiftBillPO po) throws RemoteException {
		return giftbillservice.update(po);
	}

	@Override
	public GiftBillPO findGiftBillbyID(long id) throws RemoteException {
		return giftbillservice.findGiftBillbyID(id);
	}

	@Override
	public ArrayList<GiftBillPO> findGiftBillbyState(int state) throws RemoteException {
		return giftbillservice.findGiftBillbyState(state);
	}

	@Override
	public ArrayList<GiftBillPO> findGiftBills() throws RemoteException {
		return giftbillservice.findGiftBills();
	}

	@Override
	public ArrayList<GiftBillPO> findGiftBillsbyTime(Date time) throws RemoteException {
		return giftbillservice.findGiftBillsbyTime(time);
	}

	/*
	 * ImportBillDataService
	 */
	@Override
	public boolean insert(ImportBillPO po) throws RemoteException {
		return importbillservice.insert(po);
	}

	@Override
	public boolean delete(ImportBillPO po) throws RemoteException {
		return importbillservice.delete(po);
	}

	@Override
	public boolean update(ImportBillPO po) throws RemoteException {
		return importbillservice.update(po);
	}

	@Override
	public ImportBillPO findImportBillbyID(String id) throws RemoteException {
		return importbillservice.findImportBillbyID(id);
	}

	@Override
	public ArrayList<ImportBillPO> findImportBillbyState(int state) throws RemoteException {
		return importbillservice.findImportBillbyState(state);
	}

	@Override
	public ArrayList<ImportBillPO> findImportBillbyTime(Date time) throws RemoteException {
		return importbillservice.findImportBillbyTime(time);
	}

	@Override
	public ArrayList<ImportBillPO> findImportBills() throws RemoteException {
		return importbillservice.findImportBills();
	}

	/*
	 * (non-Javadoc)
	 * @see dataservice.billdataservice.ImportReturnBillDataService#insert(po.ImportReturnBillPO)
	 */
	@Override
	public boolean insert(ImportReturnBillPO po) throws RemoteException {
		return importreturnbillservice.insert(po);
	}

	@Override
	public boolean delete(ImportReturnBillPO po) throws RemoteException {
		return importreturnbillservice.delete(po);
	}

	@Override
	public boolean update(ImportReturnBillPO po) throws RemoteException {
		return importreturnbillservice.update(po);
	}

	@Override
	public ImportReturnBillPO findImportReturnBillbyID(String id) throws RemoteException {
		return importreturnbillservice.findImportReturnBillbyID(id);
	}

	@Override
	public ArrayList<ImportReturnBillPO> findImportReturnBillbyState(int state) throws RemoteException {
		return importreturnbillservice.findImportReturnBillbyState(state);
	}

	@Override
	public ArrayList<ImportReturnBillPO> findImportReturnBills() throws RemoteException {
		return importreturnbillservice.findImportReturnBills();
	}

	@Override
	public ArrayList<ImportReturnBillPO> findImportReturnBillbyTime(Date time) throws RemoteException {
		return importreturnbillservice.findImportReturnBillbyTime(time);
	}

	/*
	 * LossBillDataService
	 */
	@Override
	public boolean insert(LossBillPO po) throws RemoteException {
		return lossbillservice.insert(po);
	}

	@Override
	public boolean delete(LossBillPO po) throws RemoteException {
		return lossbillservice.delete(po);
	}

	@Override
	public boolean update(LossBillPO po) throws RemoteException {
		return lossbillservice.update(po);
	}

	@Override
	public LossBillPO findLossBillbyID(long id) throws RemoteException {
		return lossbillservice.findLossBillbyID(id);
	}

	@Override
	public ArrayList<LossBillPO> findLossBillbyState(int state) throws RemoteException {
		return lossbillservice.findLossBillbyState(state);
	}

	@Override
	public ArrayList<LossBillPO> findLossBills() throws RemoteException {
		return lossbillservice.findLossBills();
	}

	@Override
	public ArrayList<LossBillPO> findLossBillbyTime(Date time) throws RemoteException {
		return lossbillservice.findLossBillbyTime(time);
	}

	/*
	 * OverBillDataService
	 */
	@Override
	public boolean insert(OverBillPO po) throws RemoteException {
		return overbillservice.insert(po);
	}

	@Override
	public boolean delete(OverBillPO po) throws RemoteException {
		return overbillservice.delete(po);
	}

	@Override
	public boolean update(OverBillPO po) throws RemoteException {
		return overbillservice.update(po);
	}

	@Override
	public OverBillPO findOverBillbyID(long id) throws RemoteException {
		return overbillservice.findOverBillbyID(id);
	}

	@Override
	public ArrayList<OverBillPO> findOverBills() throws RemoteException {
		return overbillservice.findOverBills();
	}

	@Override
	public ArrayList<OverBillPO> findOverBillbyTime(Date time) throws RemoteException {
		return overbillservice.findOverBillbyTime(time);
	}

	@Override
	public ArrayList<OverBillPO> findOverBillbyState(int state) throws RemoteException {
		return overbillservice.findOverBillbyState(state);
	}

	/*
	 * (non-Javadoc)
	 * @see dataservice.billdataservice.PayBillDataService#insert(po.PayBillPO)
	 */
	@Override
	public boolean insert(PayBillPO po) throws RemoteException {
		return paybillservice.insert(po);
	}

	@Override
	public boolean delete(PayBillPO po) throws RemoteException {
		return paybillservice.delete(po);
	}

	@Override
	public boolean update(PayBillPO po) throws RemoteException {
		return paybillservice.update(po);
	}

	@Override
	public PayBillPO findPayBillbyID(String id) throws RemoteException {
		return paybillservice.findPayBillbyID(id);
	}

	@Override
	public ArrayList<PayBillPO> findPayBills() throws RemoteException {
		return paybillservice.findPayBills();
	}

	@Override
	public ArrayList<PayBillPO> findPayBillbyTime(Date time) throws RemoteException {
		return paybillservice.findPayBillbyTime(time);
	}

	@Override
	public ArrayList<PayBillPO> findPayBillbyState(int state) throws RemoteException {
		return paybillservice.findPayBillbyState(state);
	}
	
	
	/*
	 * ReceiveBillDataService
	 */
	@Override
	public boolean insert(ReceiveBillPO po) throws RemoteException {
		return receivebillservice.insert(po);
	}

	@Override
	public boolean delete(ReceiveBillPO po) throws RemoteException {
		return receivebillservice.delete(po);
	}

	
	@Override
	public boolean update(ReceiveBillPO po) throws RemoteException {
		return receivebillservice.update(po);
	}

	@Override
	public ReceiveBillPO findReceiveBillbyID(String id) throws RemoteException {
		return receivebillservice.findReceiveBillbyID(id);
	}

	@Override
	public ArrayList<ReceiveBillPO> findReceiveBills() throws RemoteException {
		return receivebillservice.findReceiveBills();
	}

	@Override
	public ArrayList<ReceiveBillPO> findReceiveBillbyTime(Date time) throws RemoteException {
		return receivebillservice.findReceiveBillbyTime(time);
	}

	@Override
	public ArrayList<ReceiveBillPO> findReceiveBillbyState(int state) throws RemoteException {
		return receivebillservice.findReceiveBillbyState(state);
	}

	/*
	 * WarningBillDataService
	 */
	@Override
	public boolean insert(WarningBillPO po) throws RemoteException {
		return warningbillservice.insert(po);
	}

	@Override
	public boolean delete(WarningBillPO po) throws RemoteException {
		return warningbillservice.delete(po);
	}

	@Override
	public boolean update(WarningBillPO po) throws RemoteException {
		return warningbillservice.update(po);
	}

	@Override
	public WarningBillPO findWarningBillbyID(long id) throws RemoteException {
		return warningbillservice.findWarningBillbyID(id);
	}

	@Override
	public ArrayList<WarningBillPO> findWarningBills() throws RemoteException {
		return warningbillservice.findWarningBills();
	}

	@Override
	public ArrayList<WarningBillPO> findWarningBillbyTime(Date time) throws RemoteException {
		return warningbillservice.findWarningBillbyTime(time);
	}

	@Override
	public ArrayList<WarningBillPO> findWarningBillbyState(int state) throws RemoteException {
		return warningbillservice.findWarningBillbyState(state);
	}
	
	/*
	 * SaleBillDataService
	 */
	@Override
	public boolean insert(SaleBillPO po) throws RemoteException {
		return salebillservice.insert(po);
	}

	@Override
	public boolean delete(SaleBillPO po) throws RemoteException {
		return salebillservice.delete(po);
	}

	@Override
	public boolean update(SaleBillPO po) throws RemoteException {
		return salebillservice.update(po);
	}

	@Override
	public SaleBillPO findSaleBillbyID(String id) throws RemoteException {
		return salebillservice.findSaleBillbyID(id);
	}

	@Override
	public ArrayList<SaleBillPO> findSaleBills() throws RemoteException {
		return salebillservice.findSaleBills();
	}

	@Override
	public ArrayList<SaleBillPO> findSaleBillbyTime(Date time) throws RemoteException {
		return salebillservice.findSaleBillbyTime(time);
	}

	@Override
	public ArrayList<SaleBillPO> findSaleBillbyState(int state) throws RemoteException {
		return salebillservice.findSaleBillbyState(state);
	}

	/*
	 * SaleReturnBill
	 */
	@Override
	public boolean insert(SaleReturnBillPO po) throws RemoteException {
		return salereturnbillservice.insert(po);
	}

	@Override
	public boolean delete(SaleReturnBillPO po) throws RemoteException {
		return salereturnbillservice.delete(po);
	}

	@Override
	public boolean update(SaleReturnBillPO po) throws RemoteException {
		return salereturnbillservice.update(po);
	}

	@Override
	public SaleReturnBillPO findSaleReturnBillbyID(String id) throws RemoteException {
		return salereturnbillservice.findSaleReturnBillbyID(id);
	}

	@Override
	public ArrayList<SaleReturnBillPO> findSaleReturnBills() throws RemoteException {
		return salereturnbillservice.findSaleReturnBills();
	}

	@Override
	public ArrayList<SaleReturnBillPO> findSaleReturnBillbyTime(Date time) throws RemoteException {
		return salereturnbillservice.findSaleReturnBillbyTime(time);
	}

	@Override
	public ArrayList<SaleReturnBillPO> findSaleReturnBillbyState(int state) throws RemoteException {
		return salereturnbillservice.findSaleReturnBillbyState(state);
	}

	
	
	
	
	
	
}
