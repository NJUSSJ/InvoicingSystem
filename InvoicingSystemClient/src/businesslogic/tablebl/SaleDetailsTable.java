package businesslogic.tablebl;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.billbl.SaleBillController;
import vo.SaleBillVO;
import vo.SaleDetailsTableVO;

public class SaleDetailsTable{
	/**
	 * ֻ������ʱ��β������ۼ�¼
	 */
	public SaleDetailsTableVO findByDate(Date begin, Date end) {
		ArrayList<SaleBillVO> result=new SaleBillController().findSaleBillByInterval(begin, end);
		return new SaleDetailsTableVO(result);
	}
	/**����ʱ��κ͹ؼ��ֲ������ۼ�¼
	 * @param field ����Ĺؼ��֣�������Ʒ�����ͻ���ҵ��Ա
	 */
	public SaleDetailsTableVO findByField(Date begin, Date end, String field) {
		SaleBillController sbcon=new SaleBillController();
		//ArrayList<SaleBillVO> all=sbcon.find
		return null;
	}
	/**
	 * ��������ϸ�����ָ����·������Ϊexcel��
	 * @param ����·��
	 * @return �������
	 */
	public boolean exportAsExcel(SaleDetailsTableVO vo, String path) {

		return false;
	}



}
