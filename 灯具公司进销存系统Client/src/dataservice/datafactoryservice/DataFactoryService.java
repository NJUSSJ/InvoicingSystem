package dataservice.datafactoryservice;

import dataservice.accountdataservice.*;
import businesslogicservice.userblservice.UserBLService;
import dataservice.billdataservice.BillDatasService;
import dataservice.commoditydataservice.CommodityDataService;
import dataservice.logdataservice.LogDataService;
import dataservice.tabledataservice.TableDataService;

public interface DataFactoryService {
	public UserBLService getUserData();
	public AccountDataService getAccountData();
	public BillDatasService getBillData();
	public  TableDataService getTableData();
	public LogDataService getLogData();
	public CommodityDataService getCommodityData();
	
}
