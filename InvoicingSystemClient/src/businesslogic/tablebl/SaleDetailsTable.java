package businesslogic.tablebl;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.billbl.SaleBillController;
import vo.SaleBillVO;
import vo.SaleDetailsTableVO;

public class SaleDetailsTable{
	/**
	 * 只跟根据时间段查找销售记录
	 */
	public SaleDetailsTableVO findByDate(Date begin, Date end) {
		ArrayList<SaleBillVO> result=new SaleBillController().findSaleBillByInterval(begin, end);
		return new SaleDetailsTableVO(result);
	}
	/**根据时间段和关键字查找销售记录
	 * @param field 传入的关键字，包括商品名，客户，业务员
	 */
	public SaleDetailsTableVO findByField(Date begin, Date end, String field) {
		SaleBillController sbcon=new SaleBillController();
		//ArrayList<SaleBillVO> all=sbcon.find
		return null;
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
