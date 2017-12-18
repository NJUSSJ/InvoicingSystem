package businesslogic.tablebl;

import java.util.ArrayList;
import java.sql.Date;

import businesslogic.billbl.SaleBillController;
import vo.SaleBillVO;
import vo.SaleDetailsTableVO;

public class SaleDetailsTable{
	/**
	 * 只跟根据时间段查找销售记录
	 */
	public SaleDetailsTableVO findByDate(Date begin, Date end) {
		ArrayList<SaleBillVO> result=new SaleBillController().findSaleBillsByInterval(begin, end);
		return new SaleDetailsTableVO(begin,end,result);
	}
	/**根据时间段和关键字查找销售记录
	 * @param commodityName 商品名，可为null
	 * @param userName 客户名，可为null
	 * @param operatorName 操作员名，可为null
	 */
	public SaleDetailsTableVO findByField(Date begin, Date end,String commodityName,
			String memberName,String userName) {
		ArrayList<SaleBillVO> bills=new SaleBillController().findSaleBillsByField(begin, end, commodityName, memberName, userName);
		return new SaleDetailsTableVO(begin,end,bills);
	}
	/**
	 * 将销售明细表根据指定的路径导出为excel表
	 * @param 到处路径
	 * @return 到处结果
	 */
	public boolean exportAsExcel(SaleDetailsTableVO vo, String path) {

		return false;
	}



}
