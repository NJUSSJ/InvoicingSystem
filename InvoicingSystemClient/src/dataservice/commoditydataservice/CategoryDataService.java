package dataservice.commoditydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CategoryPO;

public interface CategoryDataService extends Remote{
	public boolean insert(CategoryPO po) throws RemoteException;
	public boolean update(CategoryPO po) throws RemoteException;
	public boolean delete(CategoryPO po) throws RemoteException;
	public ArrayList<CategoryPO> findCategories() throws RemoteException;
	public ArrayList<CategoryPO> findCategorybyParent(long parentid) throws RemoteException;
	public CategoryPO findCategorybyID(long id) throws RemoteException;
	public CategoryPO findCategorybyName(String Name) throws RemoteException;
}
