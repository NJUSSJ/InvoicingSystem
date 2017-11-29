package businesslogicservice.billblservice;

import java.sql.Date;
import java.util.ArrayList;

import businesslogic.billbl.CommodityLineItem;
import businesslogic.billbl.CommodityList;
import po.ImportBillPO;
import vo.ImportBillVO;

public interface ImportBillBLService  {
	public ImportBillVO toImportBillVO(ImportBillPO po);
	public boolean conveyBill(ImportBillVO importbill);
	public ImportBillVO checkBill(ImportBillVO importbill);
}
