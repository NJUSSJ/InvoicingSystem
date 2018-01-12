package businesslogic.memberbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.billbl.GiftBillController;
import businesslogic.billbl.ImportBillController;
import businesslogic.billbl.ImportReturnBillController;
import businesslogic.billbl.PayBillController;
import businesslogic.billbl.ReceiveBillController;
import businesslogic.billbl.SaleBillController;
import businesslogic.billbl.SaleReturnBillController;
import po.MemberPO;
import rmi.RemoteHelper;
import vo.GiftBillVO;
import vo.ImportBillVO;
import vo.ImportReturnBillVO;
import vo.MemberVO;
import vo.PayBillVO;
import vo.ReceiveBillVO;
import vo.SaleBillVO;
import vo.SaleReturnBillVO;

public class Member{

	public boolean addMember(MemberVO a) {
		MemberPO tmpUserPO=a.toPO();
		try {
			return RemoteHelper.getInstance().getMemberDataService().insert(tmpUserPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteMember(MemberVO a) {
		MemberPO tmpUserPO=a.toPO();
		try {
			long id=a.getID();
			ArrayList<SaleBillVO> saleBills=new SaleBillController().findSaleBillsByState(0);
			if(saleBills!=null&&saleBills.size()>0) {
				for(SaleBillVO vo:saleBills) {
					if(vo.getMemberID()==id) {
						return false;
					}
				}
			}
			ArrayList<SaleReturnBillVO> saleReturnBills=new SaleReturnBillController().findSaleReturnBillsByState(0);
			if(saleReturnBills!=null&&saleReturnBills.size()>0) {
				for(SaleReturnBillVO vo:saleReturnBills) {
					if(vo.getMemberID()==id) {
						return false;
					}
				}
			}
			ArrayList<ImportBillVO> importBills=new ImportBillController().findImportBillsByState(0);
			if(importBills!=null&&importBills.size()>0) {
				for(ImportBillVO vo:importBills) {
					if(vo.getMemberID()==id) {
						return false;
					}
				}
			}
			
			ArrayList<ImportReturnBillVO> importReturnBills=new ImportReturnBillController().findImportReturnBillsByState(0);
			if(importReturnBills!=null&&importReturnBills.size()>0) {
				for(ImportReturnBillVO vo:importReturnBills) {
					if(vo.getMemberID()==id) {
						return false;
					}
				}
			}
			
			ArrayList<PayBillVO> payBills=new PayBillController().findPayBillsByState(0);
			if(payBills!=null&&payBills.size()>0) {
				for(PayBillVO vo:payBills) {
					if(vo.getMemberID()==id) {
						return false;
					}
				}
			}
			
			ArrayList<ReceiveBillVO> receiveBills=new ReceiveBillController().findReceiveBillsByState(0);
			if(receiveBills!=null&&receiveBills.size()>0) {
				for(ReceiveBillVO vo:receiveBills) {
					if(vo.getMemberID()==id) {
						return false;
					}
				}
			}
			
			ArrayList<GiftBillVO> giftBills=new GiftBillController().findGiftBillsByState(0);
			if(giftBills!=null&&giftBills.size()>0) {
				for(GiftBillVO vo:giftBills) {
					if(vo.getMemberID()==id) {
						return false;
					}
				}
			}
			return RemoteHelper.getInstance().getMemberDataService().delete(tmpUserPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public MemberVO findMemberByName(String name) {
		try {
			MemberPO tmpPO=RemoteHelper.getInstance().getMemberDataService().findMemberbyName(name);
			return toMemberVO(tmpPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateMember(MemberVO a) {
		MemberPO tmpMemberPO=a.toPO();
		try {
			return RemoteHelper.getInstance().getMemberDataService().update(tmpMemberPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<MemberVO> findMembersByField(String field) {
		ArrayList<MemberVO> temp=null;
		try {
			temp=new ArrayList<MemberVO>();
			ArrayList<MemberPO> members= RemoteHelper.getInstance().getMemberDataService().
					findMembersbyField(field);
			if(members==null){
				return null;
			}
			for(int i=0;i<members.size();i++){
			temp.add(toMemberVO(members.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return temp;
	}
	public MemberVO toMemberVO(MemberPO memberPO){
		if(memberPO==null){
			return null;
		}
		return new MemberVO(memberPO.getID(),memberPO.getRank(),memberPO.getPostCode(),
				memberPO.getCategory(),memberPO.getName(),memberPO.getPhoneNum(),
				memberPO.getAddress(),memberPO.getEmail(),memberPO.getShouldPay(),
				memberPO.getShouldGet(),memberPO.getQuota(),memberPO.getDefaultOperatorID());
	}
	public ArrayList<MemberVO> findMembers(){
		ArrayList<MemberVO> temp=new ArrayList<MemberVO>();
		try {
			ArrayList<MemberPO> members=RemoteHelper.getInstance().getMemberDataService().findMembers();
			for(int i=0;i<members.size();i++){
				temp.add(toMemberVO(members.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} 
		return temp;
	}
	public MemberVO findMemberByID(long id){
		try {
			return toMemberVO(RemoteHelper.getInstance().getMemberDataService().findMemberbyID(id));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}


}
