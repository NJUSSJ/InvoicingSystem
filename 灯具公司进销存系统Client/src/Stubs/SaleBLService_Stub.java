package Stubs;

import businesslogicservice.saleblservice.SaleBLService;
import vo.CommodityVO;
import vo.MemberVO;
import vo.PromotionVO;

public class SaleBLService_Stub implements SaleBLService {

	@Override
	public void import_() {
		// TODO Auto-generated method stub
		System.out.println("Import Succeed");
	}

	@Override
	public void importReturn() {
		// TODO Auto-generated method stub
		System.out.println("Import_Return Succeed");
	}

	@Override
	public void sell() {
		// TODO Auto-generated method stub
		System.out.println("Sell Succeed");
	}

	@Override
	public void sellReturn() {
		// TODO Auto-generated method stub
		System.out.println("Sell_Return Succeed");
	}

	@Override
	public PromotionVO getPromotion() {
		System.out.println("�ɹ���ȡ������Ϣ");
		return null;
	}

	@Override
	public MemberVO getMember(String name) {
		// TODO Auto-generated method stub
		System.out.println("�ɹ���ȡ�ͻ���Ϣ");
		return null;
	}

	@Override
	public CommodityVO getCommodity(int id) {
		// TODO Auto-generated method stub
		System.out.println("�ɹ������Ʒ��Ϣ");
		return null;
	}

}
