/**
 * @author shisj
 */
package rmi;

import java.rmi.Remote;

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
import dataservice.promotiondataservice.MemberPromotionDataService;
import dataservice.promotiondataservice.PackagePromotionDataService;
import dataservice.promotiondataservice.PricePromotionDataService;
import dataservice.userdataservice.UserDataService;

public class RemoteHelper {
	private Remote remote;
	private static RemoteHelper remotehelper=new RemoteHelper();
	
	public static RemoteHelper getInstance() {
		return remotehelper;
	}
	
	private RemoteHelper() {
		
	}
	
	public void setRemote(Remote remote) {
		this.remote=remote;
	}
	
	public UserDataService getUserDataService() {
		return (UserDataService)remote;
	}
	
	public MemberDataService getMemberDataService(){
		return (MemberDataService)remote;
	}
	
	public LogDataService getLogDataService(){
		return (LogDataService)remote;
	}
	
	public AccountDataService getAccountDataService(){
		return (AccountDataService)remote;
	}
	public CommodityDataService getCommodityDataService(){
		return (CommodityDataService)remote;
	}
	public MemberPromotionDataService getMemberPromotionDataService(){
		return (MemberPromotionDataService)remote;
	}
	public PackagePromotionDataService getPackagePromotionDataService(){
		return (PackagePromotionDataService)remote;
	}
	public PricePromotionDataService getPricePromotionDataService(){
		return (PricePromotionDataService)remote;
	}
	public CashBillDataService getCashBillPromotinoDataService(){
		return (CashBillDataService)remote;
	}
	public GiftBillDataService getGiftBillDataService(){
		return (GiftBillDataService)remote;
	}
	public ImportBillDataService getImportBillDataService(){
		return (ImportBillDataService)remote;
	}
	public ImportReturnBillDataService getImportReturnBillDataService(){
		return (ImportReturnBillDataService)remote;
	}
	public LossBillDataService getLossBillDataService(){
		return (LossBillDataService)remote;
	}
	public OverBillDataService getOverBillDataService(){
		return (OverBillDataService)remote;
	}
	public PayBillDataService getPayBillDataService(){
		return (PayBillDataService)remote;
	}
	public ReceiveBillDataService getReceiveBillDataService(){
		return (ReceiveBillDataService)remote;
	}
	public SaleBillDataService getSaleBillDataService(){
		return (SaleBillDataService)remote;
	}
	public SaleReturnBillDataService getSaleReturnBillDataService(){
		return (SaleReturnBillDataService)remote;
	}
	public WarningBillDataService getWarningBillDataService(){
		return (WarningBillDataService)remote;
	}
}
