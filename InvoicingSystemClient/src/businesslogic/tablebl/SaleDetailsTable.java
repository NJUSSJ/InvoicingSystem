package businesslogic.tablebl;

import java.util.ArrayList;
import java.sql.Date;

import businesslogic.billbl.SaleBillController;
import vo.SaleBillVO;
import vo.SaleDetailsTableVO;

public class SaleDetailsTable{
	/**
	 * ֻ������ʱ��β������ۼ�¼
	 */
	public SaleDetailsTableVO findByDate(Date begin, Date end) {
		ArrayList<SaleBillVO> result=new SaleBillController().findSaleBillsByInterval(begin, end);
		return new SaleDetailsTableVO(begin,end,result);
	}
	/**����ʱ��κ͹ؼ��ֲ������ۼ�¼
	 * @param commodityName ��Ʒ������Ϊnull
	 * @param userName �ͻ�������Ϊnull
	 * @param operatorName ����Ա������Ϊnull
	 */
	public SaleDetailsTableVO findByField(Date begin, Date end,String commodityName,
			String memberName,String userName) {
		ArrayList<SaleBillVO> bills=new SaleBillController().findSaleBillsByField(begin, end, commodityName, memberName, userName);
		return new SaleDetailsTableVO(begin,end,bills);
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
