package Client.businesslogicservice.billblservice;

import Client.vo.BillVO;

public interface BillBLService {
	public BillVO makeImportbill(BillVO bill);
	public BillVO makeImpor_Returntbill(BillVO bill);
	public BillVO makeSalebill(BillVO bill);
	public BillVO makeSale_Returnbill(BillVO bill);
	public BillVO makePaybill(BillVO bill);
	public BillVO makeGetbill(BillVO bill);
	public BillVO makeGiftbill(BillVO bill);
	public BillVO makeOverbill(BillVO bill);
	public BillVO makeDamagebill(BillVO bill);
	public BillVO makeWaringbill(BillVO bill);
	public BillVO makeCashbill(BillVO bill);
	public String conveyBill(BillVO bill);
	public String checkBill(BillVO bill);
}
