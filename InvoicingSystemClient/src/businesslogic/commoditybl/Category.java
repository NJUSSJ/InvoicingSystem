package businesslogic.commoditybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CategoryPO;
import po.CommodityPO;
import rmi.RemoteHelper;
import vo.CategoryVO;
import vo.CommodityVO;

public class Category {
	/**
	 * ������Ʒ����
	 * @param categoryVO ��Ʒ����vo
	 * @return  ������Ʒ�Ľ��
	 */
	public boolean addCategory(CategoryVO categoryVO){
		try {
			return RemoteHelper.getInstance().getCategoryDataService().insert(categoryVO.toCategoryPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * ɾ����Ʒ����
	 * @param categoryVO ��Ʒ����vo
	 * @return ɾ����Ʒ�Ľ��
	 */
	public boolean deleteCategory(CategoryVO categoryVO){
		try {
			return RemoteHelper.getInstance().getCategoryDataService().delete(categoryVO.toCategoryPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * ������Ʒ����
	 * @param categoryVO ��Ʒ����vo
	 * @return ������Ʒ�Ľ��
	 */
	public boolean updateCategory(CategoryVO categoryVO){
		try {
			return RemoteHelper.getInstance().getCategoryDataService().update(categoryVO.toCategoryPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * ����id���ҵ�����Ʒ����
	 * @param id ��Ʒ����id
	 * @return ���ҵ�����Ʒ����vo�����û���򷵻�null
	 */
	public CategoryVO findCategoryByID(long id){
		try {
			return toCategoryVO(RemoteHelper.getInstance().getCategoryDataService().findCategorybyID(id));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * ������Ʒ�������Ʋ��ҵ�����Ʒ����
	 * @param name ��Ʒ��������
	 * @return ���ҵ�����Ʒ���࣬����鲻���򷵻�null
	 */
	public CategoryVO findCategoryByName(String name){
		try {
			return toCategoryVO(RemoteHelper.getInstance().getCategoryDataService().findCategorybyName(name));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * ����Ʒ����poת��Ϊ��Ʒ����vo
	 * @param categoryPO ��Ʒ����po
	 * @return ת����vo�����Ϊnull�򷵻�bull
	 */
	public CategoryVO toCategoryVO(CategoryPO categoryPO){
		if(categoryPO==null){
			return null;
		}
		return new CategoryVO(categoryPO.getID(),categoryPO.getName(),categoryPO.getParentID());
	}
	/**
	 * ������Ʒ����ĸ��༰������ֵ�
	 * @param vo:�������Ʒ����vo
	 * @return ��Ʒ�������һ��
	 */
	public ArrayList<CategoryVO> findUpCategory(CategoryVO vo) {
		ArrayList<CategoryVO> temp=null;
		if(vo==null){
			return null;
		}
		try {
			temp=new ArrayList<CategoryVO>();
			CategoryPO parent=RemoteHelper.getInstance().getCategoryDataService().findCategorybyID(vo.getParentID());
			CategoryPO grandParent=RemoteHelper.getInstance().getCategoryDataService().findCategorybyID(parent.getParentID());
			ArrayList<CategoryPO> upCategory = RemoteHelper.getInstance().getCategoryDataService().findCategorybyParent(grandParent.getID());
			for(int i=0;i<upCategory.size();i++){
				temp.add(toCategoryVO(upCategory.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return temp;
	}
	/**
	 * ������Ʒ���������
	 * @param vo ��Ʒ����vo
	 * @return ��Ʒ�����࣬���Ϊnull�򷵻�null
	 */
	public ArrayList<CategoryVO> findDownCategory(CategoryVO vo) {
		ArrayList<CategoryVO> temp = null;
		if(vo==null){
			return null;
		}
		try {
			temp=new ArrayList<CategoryVO>();
			ArrayList<CategoryPO> category = RemoteHelper.getInstance().getCategoryDataService().findCategorybyParent(vo.getID());
			if(category==null){
				return null;
			}
			for(int i=0;i<category.size();i++){
				temp.add(toCategoryVO(category.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return temp;
	}
	/**
	 * ������Ʒ���������������Ʒ
	 */
	public ArrayList<CommodityVO> findDownCommodity(CategoryVO vo) {
		ArrayList<CommodityVO> temp=null;
		if(vo==null){
			return null;
		}
		try {
			temp=new ArrayList<CommodityVO>();
			ArrayList<CommodityPO> commodity = RemoteHelper.getInstance().getCommodityDataService().findCommoditiesbyParent(vo.getID());
			CommodityController controller=new CommodityController();
			if(commodity==null){
				return null;
			}
			for(int i=0;i<commodity.size();i++){
				temp.add(controller.toCommodityVO(commodity.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return temp;
	}
	/**
	 * �������ݿ�����Ʒ��������id������ʱ����-2
	 */
	public long findLargestIDofCategory(){
		try {
			return RemoteHelper.getInstance().getCategoryDataService().getLargestIDofCategory();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return -2;
	}
}
