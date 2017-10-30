package driver;

import stubs.BillBLService_Stub;
import vo.BillVO;

public class BillBLService_Driver {
public void drive(BillBLService_Stub stub){
	if(stub.makeImportbill(new BillVO())!=null){
		System.out.println("makeImportBill success");
	}
	if(stub.makeImport_Returnbill(new BillVO())!=null){
		System.out.println("makeImportReturnBill success");
	}
	if(stub.makeSalebill(new BillVO())!=null){
		System.out.println("makeSaleBill success");
	}
	if(stub.makeSale_Returnbill(new BillVO())!=null){
		System.out.println("makeSaleReturnBill success");
	}
	if(stub.makePaybill(new BillVO())!=null){
		System.out.println("makePayBill success");
	}
	if(stub.makeReceivebill(new BillVO())!=null){
		System.out.println("makeGetBill success");
	}
	if(stub.makeGiftbill(new BillVO())!=null){
		System.out.println("makeGiftBill success");
	}
	if(stub.makeOverbill(new BillVO())!=null){
		System.out.println("makeOverBill success");
	}
	if(stub.makeDamagebill(new BillVO())!=null){
		System.out.println("makeDamageBill success");
	}
	if(stub.makeWarningbill(new BillVO())!=null){
		System.out.println("makeWaringBill success");
	}
	if(stub.makeCashbill(new BillVO())!=null){
		System.out.println("makeCashBill success");
	}
	if(stub.conveyBill(new BillVO()).equals("Succeed")){
		System.out.println("makeConveyBill success");
	}
	if(stub.checkBill(new BillVO()).equals("Succeed")){
		System.out.println("makecheckBill success");
	}
}
}
