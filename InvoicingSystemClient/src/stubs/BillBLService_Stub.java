package stubs;

import businesslogicservice.billblservice.BillBLService;
import vo.BillVO;

public class BillBLService_Stub implements BillBLService {

	BillVO bill;
	String ID;
	String Note;
	
	public BillBLService_Stub(BillVO bill,String ID,String Note) {
		// TODO Auto-generated constructor stub
		this.bill=bill;
		this.Note=Note;
		this.ID=ID;
	}
	@Override
	public BillVO makeImportbill(BillVO bill) {
		// TODO Auto-generated method stub
		System.out.println("制定进货单据");
		return new BillVO(ID, Note);
	}

	@Override
	public BillVO makeImport_Returnbill(BillVO bill){
		// TODO Auto-generated method stub
		System.out.println("制定进货退货单据");
		return new BillVO();
	}

	@Override
	public BillVO makeSalebill(BillVO bill) {
		// TODO Auto-generated method stub
		System.out.println("制定销售单据");
		return new BillVO(ID, Note);
	}

	@Override
	public BillVO makeSale_Returnbill(BillVO bill) {
		// TODO Auto-generated method stub
		System.out.println("制定销售退货单据");
		return new BillVO(ID, Note);
	}

	@Override
	public BillVO makePaybill(BillVO bill) {
		// TODO Auto-generated method stub
		System.out.println("制定付款单据");
		return new BillVO(ID, Note);
	}

	

	@Override
	public BillVO makeGiftbill(BillVO bill) {
		// TODO Auto-generated method stub
		System.out.println("制定赠送单");
		return new BillVO(ID, Note);
	}

	@Override
	public BillVO makeOverbill(BillVO bill) {
		// TODO Auto-generated method stub
		System.out.println("制定报溢单");
		return new BillVO(ID, Note);
	}

	@Override
	public BillVO makeDamagebill(BillVO bill) {
		// TODO Auto-generated method stub
		System.out.println("制定报溢单");
		return new BillVO(ID, Note);
	}

	@Override
	public BillVO makeWarningbill(BillVO bill) {
		// TODO Auto-generated method stub
		System.out.println("制定库存报警单");
		return new BillVO(ID, Note);
	}

	@Override
	public BillVO makeCashbill(BillVO bill) {
		// TODO Auto-generated method stub
		System.out.println("制定现金费用单");
		return new BillVO(ID, Note);
	}

	@Override
	public String conveyBill(BillVO bill) {
		// TODO Auto-generated method stub
		System.out.println("单据已发送");
		return "Succeed";
	}

	@Override
	public String checkBill(BillVO bill) {
		// TODO Auto-generated method stub
		System.out.println("审批单据");
		return "Succeed";
	}
	@Override
	public BillVO makeReceivebill(BillVO bill) {
		// TODO Auto-generated method stub
		System.out.println("制定收款单");
		return new BillVO(ID, Note);
	}

}
