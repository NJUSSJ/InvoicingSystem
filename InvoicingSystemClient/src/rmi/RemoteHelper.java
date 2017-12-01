/**
 * @author shisj
 */
package rmi;

import java.rmi.Remote;

import dataservice.accountdataservice.AccountDataService;
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
}
