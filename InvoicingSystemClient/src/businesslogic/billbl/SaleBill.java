 package businesslogic.billbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import businesslogic.commoditybl.CommodityController;
import businesslogic.memberbl.MemberController;
import businesslogic.promotionbl.PromotionController;
import businesslogic.userbl.UserController;
import businesslogic.utilitybl.Utility;
import po.SaleBillPO;
import rmi.RemoteHelper;
import vo.CommodityVO;
import vo.GiftBillVO;
import vo.MemberPromotionVO;
import vo.MemberVO;
import vo.PackagePromotionVO;
import vo.PricePromotionVO;
import vo.SaleBillVO;
import vo.UserVO;
import vo.WarningBillVO;

public class SaleBill{

	public SaleBillVO toSaleBillVO(SaleBillPO po) {
		if(po==null){
			return null;
		}
		CommodityList list=new CommodityList(po.getCommodityList());
		return new SaleBillVO(po.getID(),po.getUserID(),po.getMemberID(),list,po.getSum(),po.getState(),
	po.getTime(),po.getRemark(),po.getCoupon(),po.getDiscount(),po.getUltimate());
	}
	public boolean submitSaleBill(SaleBillVO saleBill) {
		try {
			return RemoteHelper.getInstance().getSaleBillDataService().insert(saleBill.toSaleBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean checkSaleBill(boolean pass, String id) {
		try {
			SaleBillVO vo=toSaleBillVO(RemoteHelper.getInstance().getSaleBillDataService().findSaleBillbyID(id));
			if(pass){
				vo.setState(1);
				MemberController memberCon=new MemberController();
				PromotionController pcon=new PromotionController();
				CommodityController ccon=new CommodityController();
				GiftBillController gcon=new GiftBillController();
				WarningBillController wcon=new WarningBillController();
				UserController ucon=new UserController();
				//生成一个单据id以备用
				long billid=Utility.creatID();
				//随机找出一个库存人员
				ArrayList<UserVO> allUsers=ucon.findUsers();
				ArrayList<UserVO> stockUsers=new ArrayList<UserVO>();
				for(UserVO uvo:allUsers){
					if(uvo.getRank()==4){
						stockUsers.add(uvo);
					}
				}
				int index=(int)(Math.random()*(stockUsers.size()));
				long stockid=stockUsers.get(index).getID();
				//修改库存数量,最近售价,如果少于警戒量则生成报警单
				CommodityList list=vo.getList();
				for(int i=0;i<list.getListSize();i++){
					long commodityid=list.get(i).getCommodityID();
					CommodityVO commodityVO=ccon.findCommodityByID(commodityid);
					int rest=commodityVO.getStockNum()-list.get(i).getNum();
					if(rest<0){
						vo.setState(2);
						return false;
					}
				}
				WarningBillVO warningBill=new WarningBillVO(billid,stockid,
						new CommodityList(),new Date(Utility.getNow().getTime()),0);
				for(int i=0;i<list.getListSize();i++){
					long commodityid=list.get(i).getCommodityID();
					CommodityVO commodityVO=ccon.findCommodityByID(commodityid);
					int rest=commodityVO.getStockNum()-list.get(i).getNum();
					commodityVO.setStockNum(rest);
					commodityVO.setLateSalePrice(list.get(i).getSalePrice());
					ccon.updateCommodity(commodityVO);
					if(commodityVO.getStockNum()<commodityVO.getLimit()){
						int dis=commodityVO.getLimit()-commodityVO.getStockNum();
						warningBill.getList().addCommodity(new CommodityLineItem(dis,
					commodityVO.getID(),commodityVO.getSalePrice(),commodityVO.getImportPrice(),""));
					}
				}
				if(warningBill.getList().getListSize()>0){
					wcon.submitWarningBill(warningBill);
				}
				//修改销售单里进货商的应付
				MemberVO member=memberCon.findMemberByID(vo.getMemberID());
				double money=vo.getSum()+member.getShouldPay();
				member.setShouldPay(money);
				memberCon.updateMember(member);
				//根据通过的销售单生成一份库存赠送单
				ArrayList<MemberPromotionVO> memberPros=pcon.findMemberPromotionByRank(member.getRank());
				CommodityList giftList=new CommodityList();
				int num;
				long giftid;
				double salePrice,importPrice;
				for(MemberPromotionVO memberPro:memberPros){
					CommodityList proList=memberPro.getGifts();
					for(int i=0;i<proList.getListSize();i++){
						num=proList.get(i).getNum();
						giftid=proList.get(i).getCommodityID();
						salePrice=ccon.findCommodityByID(giftid).getSalePrice();
						importPrice=ccon.findCommodityByID(giftid).getImportPrice();
						giftList.addCommodity(new CommodityLineItem(num,giftid,salePrice,importPrice,""));
					}
				}
				gcon.submitGiftBill(new GiftBillVO(billid,stockid,vo.getMemberID(),giftList,new Date(Utility.getNow().getTime()),0));
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
	public SaleBillVO findSaleBillByID(String id) {
		try {
			return toSaleBillVO(RemoteHelper.getInstance().getSaleBillDataService().findSaleBillbyID(id));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<SaleBillVO> findSaleBillsByTime(Date time) {
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
		ArrayList<MemberPromotionVO> memberPromotions=pcon.findMemberPromotionByRank(rank);
		for(MemberPromotionVO vo:memberPromotions){
			if(vo.getCoupon()>maxm){
				maxm=vo.getCoupon();
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
	public ArrayList<SaleBillVO> findSaleBillsByInterval(Date begin,Date end){
		ArrayList<SaleBillVO> bills=findSaleBills();
		ArrayList<SaleBillVO> result=new ArrayList<SaleBillVO>();
		for(SaleBillVO each:bills){
			if(each.getTime().after(begin)&&each.getTime().before(end)){
				bills.add(each);
			}
		}
		return bills;	
	}
	public ArrayList<SaleBillVO> findSaleBillsByState(int state){
		ArrayList<SaleBillVO> result=new ArrayList<SaleBillVO>();
		ArrayList<SaleBillPO> bills;
		try {
			bills = RemoteHelper.getInstance().getSaleBillDataService().findSaleBillbyState(state);
			for(SaleBillPO po:bills){
				result.add(toSaleBillVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	public ArrayList<SaleBillVO> findSaleBillsByField(Date begin,Date end,String commodityName,String memberName,String userName){
		ArrayList<SaleBillVO> result=new ArrayList<SaleBillVO>();
		try {
			ArrayList<SaleBillPO> bills=RemoteHelper.getInstance().getSaleBillDataService().findSaleBillbyField(commodityName, userName, memberName);
			for(SaleBillPO po:bills){
				result.add(toSaleBillVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<SaleBillVO> findSaleBillsByUser(long userid){
		ArrayList<SaleBillVO> result=new ArrayList<SaleBillVO>();
		try {
			ArrayList<SaleBillPO> bills=RemoteHelper.getInstance().getSaleBillDataService().findSaleBillbyUser(userid);
			for(SaleBillPO po:bills){
				result.add(toSaleBillVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
}
