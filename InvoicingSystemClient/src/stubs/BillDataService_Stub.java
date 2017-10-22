package stubs;

import java.rmi.RemoteException;

import dataservice.billdataservice.BillDatasService;
import po.BillPO;

public class BillDataService_Stub implements BillDatasService{

	@Override
	public BillPO importBill(BillPO ib) throws RemoteException {
		// TODO Auto-generated method stub
		return new BillPO();
	}

	@Override
	public BillPO exportBill(BillPO ib) throws RemoteException {
		// TODO Auto-generated method stub
		return new BillPO();
	}

	@Override
	public BillPO salesBill(BillPO ib) throws RemoteException {
		// TODO Auto-generated method stub
		return new BillPO();
	}

	@Override
	public BillPO salesExportBill(BillPO ib) throws RemoteException {
		// TODO Auto-generated method stub
		
		return new BillPO();
	}

	@Override
	public BillPO payBillPO(BillPO pb) throws RemoteException {
		// TODO Auto-generated method stub
		return new BillPO();
	}

	@Override
	public BillPO getMoneyBill(BillPO gb) throws RemoteException {
		// TODO Auto-generated method stub
		return new BillPO();
	}

	@Override
	public BillPO giftBill(BillPO gb) throws RemoteException {
		// TODO Auto-generated method stub
		return new BillPO();
	}

	@Override
	public BillPO cashBill(BillPO cb) throws RemoteException {
		// TODO Auto-generated method stub
		return new BillPO();
	}

	@Override
	public BillPO overBill(BillPO ob) throws RemoteException {
		// TODO Auto-generated method stub
		return new BillPO();
	}

	@Override
	public BillPO damageBill(BillPO db) throws RemoteException {
		// TODO Auto-generated method stub
		return new BillPO();
	}

	@Override
	public BillPO warnBill(BillPO wb) throws RemoteException {
		// TODO Auto-generated method stub
		return new BillPO();
	}

	@Override
	public void delete(BillPO b) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete Succeed");
	}

	@Override
	public BillPO find(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return new BillPO();
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Init");
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Finish");
		
	}

}
