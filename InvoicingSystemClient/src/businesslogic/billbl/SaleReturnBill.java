package businesslogic.billbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import businesslogic.commoditybl.CommodityController;
import businesslogic.memberbl.MemberController;
import po.SaleReturnBillPO;
import rmi.RemoteHelper;
import vo.CommodityVO;
import vo.MemberVO;
import vo.OverBillVO;
import vo.SaleReturnBillVO;

public class SaleReturnBill{
	public SaleReturnBillVO toSaleReturnBillVO(SaleReturnBillPO po) {
		if(po==null){
			return null;
		}
		CommodityList list=new CommodityList(po.getCommodityList());
		return new SaleReturnBillVO(po.getID(),po.getUserID(),po.getMemberID(),list,po.getSum(),po.getState(),
				po.getTime(),po.getRemark());
	}
	public boolean submitSaleReturnBill(SaleReturnBillVO saleReturnBill) {
		try {
			return RemoteHelper.getInstance().getSaleReturnBillDataService().insert(saleReturnBill.toSaleReturnBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean checkSaleReturnBill(boolean pass,String id) {
		try {
			SaleReturnBillVO vo=toSaleReturnBillVO(RemoteHelper.getInstance().getSaleReturnBillDataService().findSaleReturnBillbyID(id));
			if(pass){
				vo.setState(1);
				//修改销售退货单里进货商的应收和应收额度
				MemberController memberCon=new MemberController();
				MemberVO member=memberCon.findMemberByID(vo.getMemberID());
				double money=vo.getSum()+member.getShouldGet();
				member.setShouldGet(money);
				double quota=Math.pow(10, (money+"").length()-1)*Integer.parseInt((money+"").substring(0, 1));
				member.setQuota(quota);
				memberCon.updateMember(member);
				//修改库存数量
				CommodityController ccon=new CommodityController();
				for(int i=0;i<vo.getList().getListSize();i++){
					CommodityLineItem item=vo.getList().get(i);
					CommodityVO commodityVO=ccon.findCommodityByID(item.getCommodityID());
					commodityVO.setStockNum(commodityVO.getStockNum()+item.getNum());
					ccon.updateCommodity(commodityVO);
				}
			}else{
				vo.setState(2);
			}
			return RemoteHelper.getInstance().getSaleReturnBillDataService().update(vo.toSaleReturnBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteSaleReturnBill(SaleReturnBillVO saleReturnBill) {
		try {
			return RemoteHelper.getInstance().getSaleReturnBillDataService().delete(saleReturnBill.toSaleReturnBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	public SaleReturnBillVO findSaleReturnBillByID(String id) {
		try {
			return toSaleReturnBillVO(RemoteHelper.getInstance().getSaleReturnBillDataService().findSaleReturnBillbyID(id));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<SaleReturnBillVO> findSaleReturnBillByTime(Date time) {
		ArrayList<SaleReturnBillVO> temp=new ArrayList<SaleReturnBillVO>();
		try {
			ArrayList<SaleReturnBillPO> saleReturnBills=RemoteHelper.getInstance().getSaleReturnBillDataService().
					findSaleReturnBillbyTime(time);
			for(int i=0;i<saleReturnBills.size();i++){
				temp.add(toSaleReturnBillVO(saleReturnBills.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return temp;
	}
	public ArrayList<SaleReturnBillVO> findSaleReturnBills(){
		ArrayList<SaleReturnBillVO> temp=null;
		try {
			temp=new ArrayList<SaleReturnBillVO>();
			ArrayList<SaleReturnBillPO> bills=RemoteHelper.getInstance().getSaleReturnBillDataService().findSaleReturnBills();
			for(int i=0;i<bills.size();i++){
				temp.add(toSaleReturnBillVO(bills.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return temp;
	}
	public ArrayList<SaleReturnBillVO> findSaleReturnBillsByInterval(Date begin,Date end){
		ArrayList<SaleReturnBillVO> bills=findSaleReturnBills();
		ArrayList<SaleReturnBillVO> result=new ArrayList<SaleReturnBillVO>();
		for(SaleReturnBillVO each:bills){
			if(each.getTime().after(begin)&&each.getTime().before(end)){
				result.add(each);
			}
		}
		return bills;
	}
	public ArrayList<SaleReturnBillVO> findSaleReturnBillsByState(int state){
		ArrayList<SaleReturnBillVO> result=new ArrayList<SaleReturnBillVO>();
		ArrayList<SaleReturnBillPO> bills;
		try {
			bills = RemoteHelper.getInstance().getSaleReturnBillDataService().findSaleReturnBillbyState(state);
			for(SaleReturnBillPO po:bills){
				result.add(toSaleReturnBillVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<SaleReturnBillVO> findSaleReturnBillsByField(Date begin, Date end, String memberName,
			String userName) {
		ArrayList<SaleReturnBillVO> result=new ArrayList<SaleReturnBillVO>();
		try {
			ArrayList<SaleReturnBillPO> bills=RemoteHelper.getInstance().getSaleReturnBillDataService().findSaleReturnBillbyField(userName, memberName);
			for(SaleReturnBillPO po:bills){
				if(po.getTime().before(end)&&po.getTime().after(begin)){
					result.add(toSaleReturnBillVO(po));
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<SaleReturnBillVO> findSaleReturnBillsByUser(long userid){
		ArrayList<SaleReturnBillVO> result=new ArrayList<SaleReturnBillVO>();
		try {
			ArrayList<SaleReturnBillPO> bills=RemoteHelper.getInstance().getSaleReturnBillDataService().findSaleReturnBillbyUser(userid);
			for(SaleReturnBillPO po:bills){
				result.add(toSaleReturnBillVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	public boolean fakeDelete(String id){
		SaleReturnBillVO vo=findSaleReturnBillByID(id);
		vo.setState(3);
		try {
			return RemoteHelper.getInstance().getSaleReturnBillDataService().update(vo.toSaleReturnBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
}
