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
		ArrayList<SaleBillVO> result=new SaleBillController().findSaleBillByInterval(begin, end);
		return new SaleDetailsTableVO(result);
	}
	/**����ʱ��κ͹ؼ��ֲ������ۼ�¼
	 * @param commodityName ��Ʒ������Ϊnull
	 * @param userName �ͻ�������Ϊnull
	 * @param operatorName ����Ա������Ϊnull
	 */
	public SaleDetailsTableVO findByField(Date begin, Date end,String commodityName,
			String userName,String operatorName) {
		//ArrayList<SaleBillVO> bills=new SaleBillController().
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
