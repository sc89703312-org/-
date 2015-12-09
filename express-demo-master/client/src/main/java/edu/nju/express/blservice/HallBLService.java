package edu.nju.express.blservice;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.*;


public interface HallBLService {

	/**机构管理时需要调用这个方法增加营业厅
	 * @author guhan
	 * @param id 营业厅编号
	 * @param location 营业厅地址
	 * @return ResultMessage 如果id已经存在，则返回INVALID, 不可重建
	 */
	public ResultMessage addHall(String id, String location);;

	/**机构管理时需要调用这个方法删除营业厅
	 * @author guhan
	 * @param id 营业厅编号
	 * @return ResultMessage 如果id已经存在，则返回INVALID, 不可重建
	 */
	public ResultMessage removeHall(String id);

	/**总经理查看有哪些营业厅时调用这个方法
	 * @author guhan
	 * @return HallVO 的 list
	 */
	public ArrayList<HallVO> showHall();

	
	
}
