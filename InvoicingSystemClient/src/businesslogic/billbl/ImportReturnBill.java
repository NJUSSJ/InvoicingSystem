package businesslogic.billbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import businesslogic.commoditybl.CommodityController;
import businesslogic.memberbl.MemberController;
import businesslogic.userbl.UserController;
import businesslogic.utilitybl.Utility;
import po.ImportReturnBillPO;
import rmi.RemoteHelper;
import vo.CommodityVO;
import vo.ImportReturnBillVO;
import vo.MemberVO;
import vo.UserVO;
import vo.WarningBillVO;

public class ImportReturnBill {

	public ImportReturnBillVO toImportReturnBillVO(ImportReturnBillPO po) {
		if(po==null){
			return null;
		}
		CommodityList list=new CommodityList(po.getCommodityList());
		return new ImportReturnBillVO(po.getID(),po.getUserID(),po.getMemberID(),list,po.getSum(),po.getState(),
				po.getTime(),po.getRemark());
	}

	public boolean submitImportReturnBill(ImportReturnBillVO importReturnBill) {
		try {
			return RemoteHelper.getInstance().getImportReturnBillDataService().
					insert(importReturnBill.toImportReturnBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkImportReturnBill(boolean pass,String id) {
		try {
			ImportReturnBillVO vo=toImportReturnBillVO(RemoteHelper.getInstance().
					getImportReturnBillDataService().findImportReturnBillbyID(id));
			if(pass){
				vo.setState(1);
				MemberController memberCon=new MemberController();
				CommodityController ccon=new CommodityController();
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
			
				
				//修改库存数量,如果少于警戒量则生成报警单
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
				WarningBillVO warningBill=new WarningBillVO(billid,vo.getUserID(),
						new CommodityList(),new Date(Utility.getNow().getTime()),0);
				for(int i=0;i<list.getListSize();i++){
					long commodityid=list.get(i).getCommodityID();
					CommodityVO commodityVO=ccon.findCommodityByID(commodityid);
					int rest=commodityVO.getStockNum()-list.get(i).getNum();
					commodityVO.setStockNum(rest);
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
				//修改进货退货单里供应商的应付
				MemberVO member=memberCon.findMemberByID(vo.getMemberID());
				double money=vo.getList().getImportTotal()+member.getShouldPay();
				member.setShouldPay(money);
				member.setQuota(member.getShouldGet()-member.getShouldPay());
				memberCon.updateMember(member);
			}else{
				vo.setState(2);
			}
			return RemoteHelper.getInstance().getImportReturnBillDataService().update(vo.toImportReturnBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteImportReturnBill(ImportReturnBillVO importReturnBill) {
		try {
			return RemoteHelper.getInstance().getImportReturnBillDataService().delete(importReturnBill.toImportReturnBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 根据id查找进货退货单
	 */
	public ImportReturnBillVO findImportReturnBillByID(String id) {
		try {
			return toImportReturnBillVO(RemoteHelper.getInstance().getImportReturnBillDataService().findImportReturnBillbyID(id));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据时间查找进货退货单
	 */
	public ArrayList<ImportReturnBillVO> findImportReturnBillByTime(Date time) {
		ArrayList<ImportReturnBillVO> temp=new ArrayList<ImportReturnBillVO>();
		try {
			ArrayList<ImportReturnBillPO> importReturnBills=RemoteHelper.getInstance().getImportReturnBillDataService().
					findImportReturnBillbyTime(time);
			if(importReturnBills.isEmpty()) return temp;
			for(int i=0;i<importReturnBills.size();i++){
				temp.add(toImportReturnBillVO(importReturnBills.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return temp;
	}
	/**
	 * 查找所有进货退货单
	 */
	public ArrayList<ImportReturnBillVO> findImportReturnBills(){
		ArrayList<ImportReturnBillVO> temp=null;
		try {
			temp=new ArrayList<ImportReturnBillVO>();
			ArrayList<ImportReturnBillPO> bills= RemoteHelper.getInstance().getImportReturnBillDataService().findImportReturnBills();
			for(int i=0;i<bills.size();i++){
				temp.add(toImportReturnBillVO(bills.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return temp;
	}
	/**
	 * 根据时间区间查找进货退货单 经营历程表
	 */
	public ArrayList<ImportReturnBillVO> findImportReturnBillsByInterval(Date begin,Date end){
		ArrayList<ImportReturnBillVO> bills=findImportReturnBills();
		ArrayList<ImportReturnBillVO> result=new ArrayList<ImportReturnBillVO>();
		for(ImportReturnBillVO each:bills){
			if(each.getTime().after(begin)&&each.getTime().before(end)){
				if(each.getState()==1||each.getState()==3){
					result.add(each);
				}
			}
		}
		return result;
	}
	/**
	 * 根据时间区间，顾客名，操作员名查找进货退货单
	 */
	public ArrayList<ImportReturnBillVO> findImportReturnBillsByField(Date begin,Date end,String memberName,String userName){
		ArrayList<ImportReturnBillVO> result=new ArrayList<ImportReturnBillVO>();
		try {
			ArrayList<ImportReturnBillPO> bills=RemoteHelper.getInstance().getImportReturnBillDataService().
					findImportReturnBillbyField(userName, memberName);
			if(bills==null)return null;
			for(ImportReturnBillPO po:bills){
				if(po.getTime().before(end)&&po.getTime().after(begin)){
					if(po.getState()==1||po.getState()==3){
						result.add(toImportReturnBillVO(po));
					}
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;	
	}
	/**
	 * 根据状态查找进货退货单
	 */
	public ArrayList<ImportReturnBillVO> findImportReturnBillsByState(int state){
		ArrayList<ImportReturnBillVO> result=new ArrayList<ImportReturnBillVO>();
		ArrayList<ImportReturnBillPO> bills;
		try {
			bills = RemoteHelper.getInstance().getImportReturnBillDataService().findImportReturnBillbyState(state);
			for(ImportReturnBillPO po:bills){
				result.add(toImportReturnBillVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	/**
	 * 根据操作员id查找进货退货单
	 */
	public ArrayList<ImportReturnBillVO> findImportReturnBillsByUser(long userid){
		ArrayList<ImportReturnBillVO> result=new ArrayList<ImportReturnBillVO>();
		try {
			ArrayList<ImportReturnBillPO> bills=RemoteHelper.getInstance().getImportReturnBillDataService().findImportReturnBillbyUser(userid);
			for(ImportReturnBillPO po:bills){
				result.add(toImportReturnBillVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 从邮箱中删除进货退货单
	 */
	public boolean fakeDelete(String id){
		ImportReturnBillVO vo=findImportReturnBillByID(id);
		vo.setState(vo.getState()+2);
		try {
			return RemoteHelper.getInstance().getImportReturnBillDataService().update(vo.toImportReturnBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
}
