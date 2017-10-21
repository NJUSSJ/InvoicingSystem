package Stubs;

import java.sql.Time;
import java.util.ArrayList;

import businesslogicservice.saleblservice.SaleBLService;
import vo.CommodityVO;
import vo.MemberVO;
import vo.PromotionVO;
import vo.UserVO;

public class SaleBLService_Stub implements SaleBLService {
	PromotionVO pv;
	double pvdiscount;
	double pvdiscount_TotalPrice;
	ArrayList<CommodityVO> pvCombinationPack;
	int pvMemberRank;
	
	MemberVO mv;
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
	
	CommodityVO cv;
	String cvName;
	int cvID;
	int cvStock_num;
	int cvPrice;
	int cvBatch;//批次
	int cvBatch_num;
	Time cvProduce_time;
	
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
		System.out.println("成功获取促销信息");
		pvCombinationPack=new ArrayList<CommodityVO>();
		pv=new PromotionVO(pvdiscount,pvdiscount_TotalPrice,pvCombinationPack,pvMemberRank);
		return pv;
	}

	@Override
	public MemberVO getMember(String name) {
		// TODO Auto-generated method stub
		System.out.println("成功获取客户信息");
		mv=new MemberVO(mvName,mvCategory,mvPhoneNum,mvRank,mvAddress,mvPostCode,mvE_mail,
				mvShould_pay,mvShould_get,
				mvDefault_operator);
		return mv;
	}

	@Override
	public CommodityVO getCommodity(int id) {
		// TODO Auto-generated method stub
		System.out.println("成功获得商品信息");
		cv=new CommodityVO(cvName,
				cvID,
				cvStock_num,
				cvPrice,
				cvBatch,
				cvBatch_num,
				cvProduce_time);
		return cv;
	}

}
