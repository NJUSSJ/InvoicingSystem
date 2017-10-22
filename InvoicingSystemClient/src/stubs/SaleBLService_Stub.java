package stubs;

import java.sql.Time;
import java.util.ArrayList;

import businesslogicservice.saleblservice.SaleBLService;
import vo.CommodityVO;
import vo.MemberVO;
import vo.PromotionVO;
import vo.UserVO;

public class SaleBLService_Stub implements SaleBLService {
	String pvPromotion_type;
	ArrayList<CommodityVO> pvGifts;
	int pvMemberrank;
	double pvTotalprice;
	double[][] pvVoucher;//�ܼۣ�����ȯ���ܼۣ��û���
	double pvDiscount;//�ۿ�(�û���
	ArrayList<CommodityVO> pvCommodity_group;
	double pvDiscount_TotalPrice;//��ϰ���ʹ��
	String mvName;
	String mvCategory;
	String mvPhoneNum;
	int mvRank;
	String mvAddress;
	int mvPostCode;
	String mvE_mail;
	int mvShould_pay;
	int mvShould_get;
	UserVO mvDefault_operator;
	
	String cvName;
	int cvID;
	int cvStock_num;
	int cvPrice;
	int cvBatch;//����
	int cvBatch_num;
	Time cvProduce_time;
	
	public SaleBLService_Stub(String pvPromotion_type,ArrayList<CommodityVO> pvGifts,int pvMemberrank,
	double pvTotalprice,double[][] pvVoucher,double pvDiscount,ArrayList<CommodityVO> pvCommodity_group,
	double pvDiscount_TotalPrice,String mvName,String mvCategory,String mvPhoneNum,int mvRank,String mvAddress,
	int mvPostCode,String mvE_mail,int mvShould_pay,int mvShould_get,String cvName,int cvID,
	int cvStock_num,int cvPrice,int cvBatch,int cvBatch_num,Time cvProduce_time){
		this.pvPromotion_type=pvPromotion_type;
		this.pvGifts=pvGifts;
		this.pvMemberrank=pvMemberrank;
		this.pvTotalprice=pvTotalprice;
		this.pvVoucher=pvVoucher;//�ܼۣ�����ȯ���ܼۣ��û���
		this.pvDiscount=pvDiscount;//�ۿ�(�û���
		this.pvCommodity_group=pvCommodity_group;
		this.pvDiscount_TotalPrice=pvDiscount_TotalPrice;//��ϰ���ʹ��
		this.mvName=mvName;
		this.mvCategory=mvCategory;
		this.mvPhoneNum=mvPhoneNum;
		this.mvRank=mvRank;
		this.mvAddress=mvAddress;
		this.mvPostCode=mvPostCode;
		this.mvE_mail=mvE_mail;
		this.mvShould_pay=mvShould_pay;
		this.mvShould_get=mvShould_get;
		this.cvName=cvName;
		this.cvID=cvID;
		this.cvStock_num=cvStock_num;
		this.cvPrice=cvPrice;
		this.cvBatch=cvBatch;
		this.cvBatch_num=cvBatch_num;
		this.cvProduce_time=cvProduce_time;
	}
	
	@Override
	public String import_() {
		// TODO Auto-generated method stub
		return "Import Succeed";
	}

	@Override
	public String importReturn() {
		// TODO Auto-generated method stub
		return "Import_Return Succeed";
	}

	@Override
	public String sell() {
		// TODO Auto-generated method stub
		return "Sell Succeed";
	}

	@Override
	public String sellReturn() {
		// TODO Auto-generated method stub
		return "Sell_Return Succeed";
	}

	@Override
	public PromotionVO getPromotion() {
		System.out.println("�ɹ���ȡ������Ϣ");
		return new PromotionVO(pvPromotion_type,pvGifts,pvMemberrank,pvTotalprice,
		pvVoucher,pvDiscount,pvCommodity_group,pvDiscount_TotalPrice);
	}

	@Override
	public MemberVO getMember(String name) {
		// TODO Auto-generated method stub
		System.out.println("�ɹ���ȡ�ͻ���Ϣ");
		return new MemberVO(mvName,mvCategory,mvPhoneNum,mvRank,mvAddress,mvPostCode,mvE_mail,
				mvShould_pay,mvShould_get,
				mvDefault_operator);
	}

	@Override
	public CommodityVO getCommodity(int id) {
		// TODO Auto-generated method stub
		System.out.println("�ɹ������Ʒ��Ϣ");
		return new CommodityVO(cvName,cvID,cvStock_num,cvPrice,cvBatch,cvBatch_num,cvProduce_time);
	}

}
