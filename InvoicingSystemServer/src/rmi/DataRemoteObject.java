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
import data.commoditydata.CategoryDataImpl;
import data.commoditydata.CommodityDataImpl;
import data.logdata.LogDataImpl;
import data.memberdata.MemberDataImpl;
import data.promotiondata.MemberPromotionDataImpl;
import data.promotiondata.PackagePromotionDataImpl;
import data.promotiondata.PricePromotionDataImpl;
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
import dataservice.commoditydataservice.CategoryDataService;
import dataservice.commoditydataservice.CommodityDataService;
import dataservice.logdataservice.LogDataService;
import dataservice.memberdataservice.MemberDataService;
import dataservice.promotiondataservice.MemberPromotionDataService;
import dataservice.promotiondataservice.PackagePromotionDataService;
import dataservice.promotiondataservice.PricePromotionDataService;
import dataservice.userdataservice.UserDataService;
import po.AccountPO;
import po.CashBillPO;
import po.CategoryPO;
import po.CommodityPO;
import po.GiftBillPO;
import po.ImportBillPO;
import po.ImportReturnBillPO;
import po.LogPO;
import po.LossBillPO;
import po.MemberPO;
import po.MemberPromotionPO;
import po.OverBillPO;
import po.PackagePromotionPO;
import po.PayBillPO;
import po.PricePromotionPO;
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
,SaleReturnBillDataService,PricePromotionDataService,PackagePromotionDataService,MemberPromotionDataService,CategoryDataService{

	
	
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
	
	private PricePromotionDataService pricepromotionservice;
	
	private MemberPromotionDataService memberpromotionservice;
	
	private PackagePromotionDataService packagepromotion;
	
	private CategoryDataService categoryservice;
	
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
		pricepromotionservice=new PricePromotionDataImpl();
		memberpromotionservice=new MemberPromotionDataImpl();
		packagepromotion=new PackagePromotionDataImpl();
		categoryservice=new CategoryDataImpl();
		
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

	/*
	 * PricePromotionDataService
	 */
	@Override
	public boolean insert(PricePromotionPO po) throws RemoteException {
		return pricepromotionservice.insert(po);
	}

	@Override
	public boolean delete(PricePromotionPO po) throws RemoteException {
		return pricepromotionservice.delete(po);
	}

	@Override
	public boolean update(PricePromotionPO po) throws RemoteException {
		return pricepromotionservice.update(po);
	}

	@Override
	public ArrayList<PricePromotionPO> findPricePromotions() throws RemoteException {
		return pricepromotionservice.findPricePromotions();
	}

	/*
	 * PackagePromotionDataService
	 */
	@Override
	public boolean insert(PackagePromotionPO po) throws RemoteException {
		return packagepromotion.insert(po);
	}

	@Override
	public boolean delete(PackagePromotionPO po) throws RemoteException {
		return packagepromotion.delete(po);
	}

	@Override
	public boolean update(PackagePromotionPO po) throws RemoteException {
		return packagepromotion.update(po);
	}

	@Override
	public ArrayList<PackagePromotionPO> findPackagePromotions() throws RemoteException {
		return packagepromotion.findPackagePromotions();
	}

	/*
	 * MemberPromotionDataService
	 */
	@Override
	public boolean insert(MemberPromotionPO po) throws RemoteException {
		return memberpromotionservice.insert(po);
	}

	@Override
	public boolean delete(MemberPromotionPO po) throws RemoteException {
		return memberpromotionservice.delete(po);
	}

	@Override
	public boolean update(MemberPromotionPO po) throws RemoteException {
		return memberpromotionservice.update(po);
	}

	@Override
	public ArrayList<MemberPromotionPO> findMemberPromotions() throws RemoteException {
		return memberpromotionservice.findMemberPromotions();
	}

	@Override
	public ArrayList<MemberPromotionPO> findMemberPromotionsbyRank(int rank) throws RemoteException {
		return memberpromotionservice.findMemberPromotionsbyRank(rank);
	}

	/*
	 * (non-Javadoc)
	 * @see dataservice.commoditydataservice.CategoryDataService#insert(po.CategoryPO)
	 */
	@Override
	public boolean insert(CategoryPO po) throws RemoteException {
		return categoryservice.insert(po);
	}

	@Override
	public boolean update(CategoryPO po) throws RemoteException {
		return categoryservice.update(po);
	}

	@Override
	public boolean delete(CategoryPO po) throws RemoteException {
		return categoryservice.delete(po);
	}

	@Override
	public ArrayList<CategoryPO> findCategories() throws RemoteException {
		return categoryservice.findCategories();
	}

	@Override
	public ArrayList<CategoryPO> findCategorybyParent(long parentid) throws RemoteException {
		return categoryservice.findCategorybyParent(parentid);
	
	}

	@Override
	public CategoryPO findCategorybyID(long id) throws RemoteException {
		return categoryservice.findCategorybyID(id);
	}

	@Override
	public ArrayList<CommodityPO> findCommoditiesbyParent(long parentid) throws RemoteException {
		return commodityService.findCommoditiesbyParent(parentid);
	}

	@Override
	public MemberPO findMemberbyID(long id) throws RemoteException {
		
		return memberService.findMemberbyID(id);
	}

	@Override
	public ArrayList<UserPO> findUsers() throws RemoteException {
		return userService.findUsers();
	}

	@Override
	public ArrayList<GiftBillPO> findGiftBillsByField(String user, String member) throws RemoteException  {
		return giftbillservice.findGiftBillsByField(user, member);
	}

	

	@Override
	public ArrayList<UserPO> findUserbyField(String field) throws RemoteException {
		return userService.findUserbyField(field);
	}

	@Override
	public ArrayList<SaleReturnBillPO> findSaleReturnBillbyField(String usesr, String member) throws RemoteException {
		return salereturnbillservice.findSaleReturnBillbyField(usesr, member);
	}

	@Override
	public ArrayList<SaleBillPO> findSaleBillbyField(String commodity, String user, String member)
			throws RemoteException {
		return salebillservice.findSaleBillbyField(commodity, user, member);
	}

	@Override
	public ArrayList<WarningBillPO> findWarningBillbyField(String user) throws RemoteException {
		return warningbillservice.findWarningBillbyField(user);
	}

	@Override
	public ArrayList<ReceiveBillPO> findReceiveBillbyField(String user, String member) throws RemoteException {
		return receivebillservice.findReceiveBillbyField(user, member);
	}

	@Override
	public ArrayList<PayBillPO> findPayBillbyField(String user, String member) throws RemoteException {
		return paybillservice.findPayBillbyField(user, member);
	}

	@Override
	public ArrayList<OverBillPO> findOverBillbyField(String user) throws RemoteException {
		return overbillservice.findOverBillbyField(user);
	}

	@Override
	public ArrayList<LossBillPO> findLossBillbyField(String user) throws RemoteException {
		return lossbillservice.findLossBillbyField(user);
	}

	@Override
	public ArrayList<ImportReturnBillPO> findImportReturnBillbyField(String user, String member)
			throws RemoteException {
		return findImportReturnBillbyField(user, member);
	}

	@Override
	public ArrayList<ImportBillPO> findImportBillsByField(String user, String member) throws RemoteException {
		return importbillservice.findImportBillsByField(user, member);
	}

	@Override
	public ArrayList<CashBillPO> findCashBillbyField(String user) throws RemoteException {
		return cashbillservice.findCashBillbyField(user);
	}

	@Override
	public CategoryPO findCategorybyName(String Name) throws RemoteException {
		
		return categoryservice.findCategorybyName(Name);
	}

	@Override
	public ArrayList<SaleReturnBillPO> findSaleReturnBillbyUser(long userid) throws RemoteException {
		return salereturnbillservice.findSaleReturnBillbyUser(userid);
	}

	@Override
	public ArrayList<SaleBillPO> findSaleBillbyUser(long userid) throws RemoteException {
		return salebillservice.findSaleBillbyUser(userid);
	}

	@Override
	public ArrayList<WarningBillPO> findWarningBillbyUser(long userid) throws RemoteException {
		return warningbillservice.findWarningBillbyUser(userid);
	}

	@Override
	public ArrayList<ReceiveBillPO> findReceiveBillbyUser(long userid) throws RemoteException {
		return receivebillservice.findReceiveBillbyUser(userid);
	}

	@Override
	public ArrayList<PayBillPO> findPayBillbyUser(long userid) throws RemoteException {
		return paybillservice.findPayBillbyUser(userid);
	}

	@Override
	public ArrayList<OverBillPO> findOverBillbyUser(long userid) throws RemoteException {
		return overbillservice.findOverBillbyUser(userid);
	}

	@Override
	public ArrayList<LossBillPO> findLossBillbyUser(long userid) throws RemoteException {
		return lossbillservice.findLossBillbyUser(userid);
	}

	@Override
	public ArrayList<ImportReturnBillPO> findImportReturnBillbyUser(long userid) throws RemoteException {
		return importreturnbillservice.findImportReturnBillbyUser(userid);
	}

	@Override
	public ArrayList<ImportBillPO> findImportBillsByUser(long userid) throws RemoteException {
		return importbillservice.findImportBillsByUser(userid);
	}

	@Override
	public ArrayList<GiftBillPO> findGiftBillbyUser(long userid) throws RemoteException {
		return giftbillservice.findGiftBillbyUser(userid);
	}

	@Override
	public ArrayList<CashBillPO> findCashBillbyUser(long userid) throws RemoteException {
		return cashbillservice.findCashBillbyUser(userid);
	}
	
}
