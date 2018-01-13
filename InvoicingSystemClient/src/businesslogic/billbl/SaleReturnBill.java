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
				//�޸������˻���������̵�Ӧ�պ�Ӧ�ն��
				MemberController memberCon=new MemberController();
				MemberVO member=memberCon.findMemberByID(vo.getMemberID());
				double money=vo.getList().getSaleTotal()+member.getShouldGet();
				member.setShouldGet(money);
				double quota=member.getShouldGet()-member.getShouldPay();
				member.setQuota(quota);
				memberCon.updateMember(member);
				//�޸Ŀ������
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
	/**
	 * ����id���������˻���
	 */
	public SaleReturnBillVO findSaleReturnBillByID(String id) {
		try {
			return toSaleReturnBillVO(RemoteHelper.getInstance().getSaleReturnBillDataService().findSaleReturnBillbyID(id));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * ����ʱ����������˻���
	 */
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
	/**
	 * �������������˻���
	 */
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
	/**
	 * ����ʱ��������������˻��� ��Ӫ���̱�
	 */
	public ArrayList<SaleReturnBillVO> findSaleReturnBillsByInterval(Date begin,Date end){
		ArrayList<SaleReturnBillVO> bills=findSaleReturnBills();
		ArrayList<SaleReturnBillVO> result=new ArrayList<SaleReturnBillVO>();
		for(SaleReturnBillVO each:bills){
			if(each.getTime().after(begin)&&each.getTime().before(end)){
				if(each.getState()==1||each.getState()==3){
					result.add(each);
				}
			}
		}
		return result;
	}
	/**
	 * ����״̬���������˻���
	 */
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
	/**
	 * ����ʱ�����䣬�ͻ���������Ա�����������˻���
	 * @return
	 */
	public ArrayList<SaleReturnBillVO> findSaleReturnBillsByField(Date begin, Date end, String memberName,
			String userName) {
		ArrayList<SaleReturnBillVO> result=new ArrayList<SaleReturnBillVO>();
		try {
			ArrayList<SaleReturnBillPO> bills=RemoteHelper.getInstance().getSaleReturnBillDataService().findSaleReturnBillbyField(userName, memberName);
			for(SaleReturnBillPO po:bills){
				if(po.getTime().before(end)&&po.getTime().after(begin)){
					if(po.getState()==1||po.getState()==3){
						result.add(toSaleReturnBillVO(po));
					}
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * ���ݲ���Աid���������˻���
	 */
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
	/**
	 * ��������ɾ�������˻���
	 */
	public boolean fakeDelete(String id){
		SaleReturnBillVO vo=findSaleReturnBillByID(id);
		vo.setState(vo.getState()+2);
		try {
			return RemoteHelper.getInstance().getSaleReturnBillDataService().update(vo.toSaleReturnBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
}
