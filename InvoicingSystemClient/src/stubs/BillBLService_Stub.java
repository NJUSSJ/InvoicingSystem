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
		System.out.println("�ƶ���������");
		return new BillVO(ID, Note);
	}

	@Override
	public BillVO makeImport_Returnbill(BillVO bill){
		// TODO Auto-generated method stub
		System.out.println("�ƶ������˻�����");
		return new BillVO();
	}

	@Override
	public BillVO makeSalebill(BillVO bill) {
		// TODO Auto-generated method stub
		System.out.println("�ƶ����۵���");
		return new BillVO(ID, Note);
	}

	@Override
	public BillVO makeSale_Returnbill(BillVO bill) {
		// TODO Auto-generated method stub
		System.out.println("�ƶ������˻�����");
		return new BillVO(ID, Note);
	}

	@Override
	public BillVO makePaybill(BillVO bill) {
		// TODO Auto-generated method stub
		System.out.println("�ƶ������");
		return new BillVO(ID, Note);
	}

	

	@Override
	public BillVO makeGiftbill(BillVO bill) {
		// TODO Auto-generated method stub
		System.out.println("�ƶ����͵�");
		return new BillVO(ID, Note);
	}

	@Override
	public BillVO makeOverbill(BillVO bill) {
		// TODO Auto-generated method stub
		System.out.println("�ƶ����絥");
		return new BillVO(ID, Note);
	}

	@Override
	public BillVO makeDamagebill(BillVO bill) {
		// TODO Auto-generated method stub
		System.out.println("�ƶ����絥");
		return new BillVO(ID, Note);
	}

	@Override
	public BillVO makeWarningbill(BillVO bill) {
		// TODO Auto-generated method stub
		System.out.println("�ƶ���汨����");
		return new BillVO(ID, Note);
	}

	@Override
	public BillVO makeCashbill(BillVO bill) {
		// TODO Auto-generated method stub
		System.out.println("�ƶ��ֽ���õ�");
		return new BillVO(ID, Note);
	}

	@Override
	public String conveyBill(BillVO bill) {
		// TODO Auto-generated method stub
		System.out.println("�����ѷ���");
		return "Succeed";
	}

	@Override
	public String checkBill(BillVO bill) {
		// TODO Auto-generated method stub
		System.out.println("��������");
		return "Succeed";
	}
	@Override
	public BillVO makeReceivebill(BillVO bill) {
		// TODO Auto-generated method stub
		System.out.println("�ƶ��տ");
		return new BillVO(ID, Note);
	}

}
