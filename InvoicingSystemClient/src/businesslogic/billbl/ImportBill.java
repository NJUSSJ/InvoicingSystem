package businesslogic.billbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import businesslogic.commoditybl.CommodityController;
import businesslogic.memberbl.MemberController;
import po.ImportBillPO;
import rmi.RemoteHelper;
import vo.CommodityVO;
import vo.ImportBillVO;
import vo.MemberVO;

public class ImportBill{

	public ImportBillVO toImportBillVO(ImportBillPO po) {
		if(po==null){
			return null;
		}
		CommodityList list=new CommodityList(po.getCommodityList());
		return new ImportBillVO(po.getID(),po.getUserID(),po.getMemberID(),list,po.getSum(),po.getState(),
				po.getTime(),po.getRemark());
	}

	public boolean submitImportBill(ImportBillVO importBill) {
		try {
			return RemoteHelper.getInstance().getImportBillDataService().insert(importBill.toImportBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkImportBill(boolean pass, String id) {
		try {
			ImportBillVO vo=toImportBillVO(RemoteHelper.getInstance().getImportBillDataService().findImportBillbyID(id));
			if(pass){
				vo.setState(1);
				//修改进货单里供货商的应收和应收额度
				MemberController memberCon=new MemberController();
				MemberVO member=memberCon.findMemberByID(vo.getMemberID());
				double money=vo.getCommodityList().getImportTotal()+member.getShouldGet();
				member.setShouldGet(money);
				double quota=member.getShouldGet()-member.getShouldPay();
				member.setQuota(quota);
				memberCon.updateMember(member);
				//修改库存数量，最近进价
				CommodityController ccon=new CommodityController();
				CommodityList list=vo.getCommodityList();
				for(int i=0;i<list.getListSize();i++){
					CommodityLineItem item=list.get(i);
					CommodityVO commodityVO=ccon.findCommodityByID(item.getCommodityID());
					commodityVO.setLateImportPrice(item.getImportPrice());
					commodityVO.setStockNum(commodityVO.getStockNum()+item.getNum());
					ccon.updateCommodity(commodityVO);
				}
			}else{
				vo.setState(2);
			}
			return RemoteHelper.getInstance().getImportBillDataService().update(vo.toImportBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteImportBill(ImportBillVO importBill) {
		try {
			return RemoteHelper.getInstance().getImportBillDataService().delete(importBill.toImportBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 根据id查找进货单
	 */
	public ImportBillVO findImportBillByID(String id) {
		try {
			return toImportBillVO(RemoteHelper.getInstance().getImportBillDataService().findImportBillbyID(id));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据时间查找进货单
	 */
	public ArrayList<ImportBillVO> findImportBillByTime(Date time) {
		ArrayList<ImportBillVO> temp=new ArrayList<ImportBillVO>();
		try {
			ArrayList<ImportBillPO> importBills=RemoteHelper.getInstance().getImportBillDataService().
					findImportBillbyTime(time);
			
			if(importBills.isEmpty()||importBills==null) return temp;
			for(int i=0;i<importBills.size();i++){
				temp.add(toImportBillVO(importBills.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return temp;
	}
	/**
	 * 查找所有进货单
	 */
	public ArrayList<ImportBillVO> findImportBills(){
		ArrayList<ImportBillVO> temp=null;
		try {
			temp=new ArrayList<ImportBillVO>();
			ArrayList<ImportBillPO> bills;
			bills = RemoteHelper.getInstance().getImportBillDataService().findImportBills();
			for(int i=0;i<bills.size();i++){
				temp.add(toImportBillVO(bills.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return temp;
	}
	/**
	 * 根据时间区间查找进货单 经营历程表
	 */
	public ArrayList<ImportBillVO> findImportBillsByInterval(Date begin,Date end){
		ArrayList<ImportBillVO> bills=findImportBills();
		if(bills==null)return null;
		ArrayList<ImportBillVO> result=new ArrayList<ImportBillVO>();
		for(ImportBillVO each:bills){
			if(each.getTime().after(begin)&&each.getTime().before(end)){
				if(each.getState()==1||each.getState()==3){
					result.add(each);
				}
			}
		}
		return result;
	}
	/**
	 * 根据时间区间，顾客名，操作员名查找进货单 经营历程表
	 */
	public ArrayList<ImportBillVO> findImportBillsByField(Date begin,Date end,String memberName,String userName){
		ArrayList<ImportBillVO> result=new ArrayList<ImportBillVO>();
		try {
			ArrayList<ImportBillPO> bills=RemoteHelper.getInstance().getImportBillDataService().
					findImportBillsByField(userName, memberName);
			if(bills==null)return null;
			for(ImportBillPO po:bills){
				if(po.getTime().before(end)&&po.getTime().after(begin)){
					if(po.getState()==1||po.getState()==3){
						result.add(toImportBillVO(po));
					}
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 根据状态查找进货单
	 */
	public ArrayList<ImportBillVO> findImportBillsByState(int state){
		ArrayList<ImportBillVO> result=new ArrayList<ImportBillVO>();
		ArrayList<ImportBillPO> bills;
		try {
			bills = RemoteHelper.getInstance().getImportBillDataService().findImportBillbyState(state);
			for(ImportBillPO po:bills){
				result.add(toImportBillVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	/**
	 * 根据操作员id查找进货单
	 */
	public ArrayList<ImportBillVO> findImportBillsByUser(long userid){
		ArrayList<ImportBillVO> result=new ArrayList<ImportBillVO>();
		try {
			ArrayList<ImportBillPO> bills=RemoteHelper.getInstance().getImportBillDataService().findImportBillsByUser(userid);
			for(ImportBillPO po:bills){
				result.add(toImportBillVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 从邮箱中删除进货单
	 */
	public boolean fakeDelete(String id){
		ImportBillVO vo=findImportBillByID(id);
		vo.setState(vo.getState()+2);
		try {
			return RemoteHelper.getInstance().getImportBillDataService().update(vo.toImportBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
}
