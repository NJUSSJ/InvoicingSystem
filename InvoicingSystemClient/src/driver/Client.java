package driver;

import java.rmi.RemoteException;

import stubs.AccountBLService_Stub;
import stubs.AccountDatabaseServiceMySqlImpl_Stub;
import stubs.BillDatabaseServiceMySqlImpl_Stub;
import stubs.CommodityBLService_Stub;
import stubs.CommodityDatabaseServiceMySqlImpl_Stub;
import stubs.LogBLService_Stub;
import stubs.LogDatabaseServiceMySqlImpl_Stub;
import stubs.MemberBLService_Stub;
import stubs.MemberDatabaseServiceMySqlImpl_Stub;
import stubs.PromotionBLService_Stub;
import stubs.PromotionDataServiceMySqlImpl_Stub;

import stubs.TableBLService_Stub;
import stubs.TableDatabaseServiceMySqlImpl_Stub;
import stubs.UserBLService_Stub;
import stubs.UserDatabaseServiceMySqlImpl_Stub;

public class Client {
public static void main(String[] args){
	AccountBLService_Driver abldriver=new AccountBLService_Driver();
	abldriver.drive(new AccountBLService_Stub(0, null, 0, null));
	AccountDataService_Driver addriver=new AccountDataService_Driver();
	addriver.drive(new AccountDatabaseServiceMySqlImpl_Stub());
	
	BillDataService_Driver bddriver=new BillDataService_Driver();
	bddriver.drive(new BillDatabaseServiceMySqlImpl_Stub());
	CommodityBLService_Driver cbldriver=new CommodityBLService_Driver();
	cbldriver.drive(new CommodityBLService_Stub(null, 0, 0, 0, 0, 0, null, null));
	CommodityDataService_Driver cddriver=new CommodityDataService_Driver();
	cddriver.drive(new CommodityDatabaseServiceMySqlImpl_Stub());
	LogBLService_Driver lbldriver=new LogBLService_Driver();
	lbldriver.drive(new LogBLService_Stub(null, null, null));
	LogDataService_Driver lddriver=new LogDataService_Driver();
	lddriver.drive(new LogDatabaseServiceMySqlImpl_Stub());
	MemberBLService_Driver mbldriver=new MemberBLService_Driver();
	mbldriver.drive(new MemberBLService_Stub(null, null, null, null, 0, null, 0, null, 0, 0));
	MemberDataService_Driver mddriver=new MemberDataService_Driver();
	try {
		mddriver.drive(new MemberDatabaseServiceMySqlImpl_Stub());
	} catch (RemoteException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	PromotionBLService_Driver pbldriver=new PromotionBLService_Driver();
	pbldriver.drive(new PromotionBLService_Stub(null, null, 0, 0, null, 0, null, 0));
	PromotionDataService_Driver pddriver=new PromotionDataService_Driver();
	pddriver.drive(new PromotionDataServiceMySqlImpl_Stub());
	UserBLService_Driver ubldriver=new UserBLService_Driver();
	ubldriver.drive(new UserBLService_Stub());
	UserDataService_Driver uddriver=new UserDataService_Driver();
	uddriver.drive(new UserDatabaseServiceMySqlImpl_Stub());

	
	
	TableBLService_Driver tbldriver=new TableBLService_Driver();
	tbldriver.drive(new TableBLService_Stub(null, null, 0, 0, 0, 0, 0, 0, 0, null, null, 0, null));
	TableDataService_Driver tddriver=new TableDataService_Driver();
	tddriver.drive(new TableDatabaseServiceMySqlImpl_Stub());


}
}
