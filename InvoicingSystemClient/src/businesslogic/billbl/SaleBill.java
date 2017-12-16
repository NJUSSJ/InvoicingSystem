 package businesslogic.billbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import businesslogic.memberbl.MemberController;
import businesslogic.promotionbl.PromotionController;
import po.SaleBillPO;
import rmi.RemoteHelper;
import vo.MemberPromotionVO;
import vo.MemberVO;
import vo.PackagePromotionVO;
import vo.PricePromotionVO;
import vo.SaleBillVO;

public class SaleBill{

	public SaleBillVO toSaleBillVO(SaleBillPO po) {
		CommodityList list=new CommodityList(po.getCommodityList());
		return new SaleBillVO(po.getID(),po.getUserID(),po.getMemberID(),list,po.getSum(),po.getState(),
				po.getTime(),po.getRemark());
	}
	public boolean submitSaleBill(SaleBillVO saleBill) {
		try {
			return RemoteHelper.getInstance().getSaleBillDataService().insert(saleBill.toSaleBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean checkSaleBill(boolean pass, long id) {
		try {
			SaleBillVO vo=toSaleBillVO(RemoteHelper.getInstance().getSaleBillDataService().findSaleBillbyID(id));
			if(pass){
				vo.setState(1);
				//修改销售单里进货商的应付
				MemberController memberCon=new MemberController();
				MemberVO member=memberCon.findMemberByID(id);
				double money=vo.getSum()+member.getShouldPay();
				member.setShouldPay(money);
				memberCon.updateMember(member);
				//根据通过的销售单生成一份库存赠送单
				PromotionController pcon=new PromotionController();
				
			}else{
				vo.setState(2);
			}
			return RemoteHelper.getInstance().getSaleBillDataService().update(vo.toSaleBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteSaleBill(SaleBillVO saleBill) {
		try {
			return RemoteHelper.getInstance().getSaleBillDataService().delete(saleBill.toSaleBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	public SaleBillVO findSaleBillByID(long id) {
		try {
			return toSaleBillVO(RemoteHelper.getInstance().getSaleBillDataService().findSaleBillbyID(id));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<SaleBillVO> findSaleBillByTime(Date time) {
		ArrayList<SaleBillVO> temp=new ArrayList<SaleBillVO>();
		try {
			ArrayList<SaleBillPO> saleBills=RemoteHelper.getInstance().getSaleBillDataService().
					findSaleBillbyTime(time);
			for(int i=0;i<saleBills.size();i++){
				temp.add(toSaleBillVO(saleBills.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return temp;
	}
	public ArrayList<SaleBillVO> findSaleBills(){
		ArrayList<SaleBillVO> temp=null;
		try {
			temp=new ArrayList<SaleBillVO>();
			ArrayList<SaleBillPO> bills=RemoteHelper.getInstance().getSaleBillDataService().findSaleBills();
			for(int i=0;i<bills.size();i++){
				temp.add(toSaleBillVO(bills.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return temp;
	}
	/**
	 * 
	 * @param rank 客户的等级
	 * @param list 销售单中的商品信息列表
	 * @return 经过促销策略（客户，特价包）以后的折后总价
	 */
	public double handleSale(int rank,CommodityList list){
		PromotionController pcon=new PromotionController();
		double origin=list.getSaleTotal();
		//第一步：分析特价包降价
		ArrayList<PackagePromotionVO> packagePromotions=pcon.findPackagePromotions();
		for(PackagePromotionVO p:packagePromotions){
			boolean pass=true;
			String[] temp=p.getList().toString().split(" ");
			for(String each:temp){
				long id=Long.parseLong(each.substring(0, each.indexOf(",")));
				if(!list.hasCommodity(id)){
					pass=false;
					break;
				}
			}
			if(pass){
				for(String each:temp){
					String[] info=each.split(",");
					int num=Integer.parseInt(info[1]);
					double salePrice=Double.parseDouble(info[2]);
					origin=origin-num*salePrice*(1-p.getDiscount());//减去每件商品折扣掉的钱
				}
				
			}
		}
		//第二步：分析总价降价
		ArrayList<MemberPromotionVO> memberPromotions=pcon.findMemberPromotions();
		double min=origin;
		for(MemberPromotionVO m:memberPromotions){
			if(rank<m.getRank()){
				continue;
			}else{
				double temp=origin*m.getDiscount();
				if(temp<min){
					min=temp;
				}
			}
		}
		return min;
	}
	/**
	 * 
	 * @param rank 客户的等级
	 * @param sum 折后总价
	 * @return 经过促销策略（客户，总价）以后的代金券总额
	 */
	public int handleCoupon(int rank,double sum){
		int maxm=0,maxp=0;
		PromotionController pcon=new PromotionController();
		ArrayList<MemberPromotionVO> memberPromotions=pcon.findMemberPromotions();
		for(MemberPromotionVO m:memberPromotions){
			if(rank>=m.getRank()){
				if(m.getCoupon()>maxm){
					maxm=m.getCoupon();
				}
			}
		}
		ArrayList<PricePromotionVO> pricePromotions=pcon.findPricePromotions();
		for(PricePromotionVO p:pricePromotions){
			if(sum>=p.getPriceline()){
				if(p.getCoupon()>maxp){
					maxp=p.getCoupon();
				}
			}
		}
		return maxm+maxp;
	}
}
