package edu.nju.express.blservice;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.common.ResultMessageV2;
import edu.nju.express.vo.ArriveReceiptVO;
import edu.nju.express.vo.ComGoodsVO;
import edu.nju.express.vo.ComZoneVO;
import edu.nju.express.vo.EnterReceiptVO;
import edu.nju.express.vo.ExitReceiptVO;
import edu.nju.express.vo.TransferReceiptVO;

/**
 * 
 * @author ShiroKo
 * @version 2015-12-9 21:43
 * 
 * 仓库模块的业务逻辑层接口，用于实现仓库及其相关单据的增删改查与仓库内货物的出入及移动
 *
 */

public interface CommodityBlService {
	
    /**获得所有该仓库未处理的到达单
     * @author ShiroKo
     * @return 到达单VO的ArrayList
     */
	public ArrayList<ArriveReceiptVO> showArriveReceiptList();
	
	/** 获得根据一个到达单生成的入库单
	 * 
	 * @param vo 一个到达单的VO
	 * @return 生成的入库单的VO
	 * @throws Exception
	 */
	public EnterReceiptVO showEnterReceipt(ArriveReceiptVO vo) throws Exception;
	
	/** 编辑入库单内的货物存储位置
	 * 
	 * @param vo 一个入库单的VO
	 * @param data 表示货物储存位置的数组
	 * @return 是否编辑成功的ResultMessage
	 */
	ResultMessageV2 editEnterReceipt(EnterReceiptVO vo, Object[][] data);
	
	/** 提交一个入库单
	 * 
	 * @param vo 一个入库单的VO
	 */
	public void subEnterReceipt(EnterReceiptVO vo);
	
	/** 获得所有该仓库未处理的中转单
	 * 
	 * @return 中转单VO的ArrayList
	 */
	public ArrayList<TransferReceiptVO> showTransferReceiptList();
	
	/** 获得根据中转单生成的出库单
	 * 
	 * @param vo 一个中转单的VO
	 * @return 出库单的VO
	 */
	public ExitReceiptVO showExitReceipt(TransferReceiptVO vo);
	
	/** 提交一个出库单
	 * 
	 * @param vo 一个出库单的VO
	 */
	public void subExitReceipt(ExitReceiptVO vo);
	
	
	/** 获得仓库内的货物储存情况
	 * 
	 * @return 表示仓库内货物的VO的ArrayList
	 */
	public ArrayList<ComGoodsVO> showInventory();
	
	/** 导出仓库内储存货物的列表
	 * 
	 * @param list 仓库内货物的VO的ArrayList
	 */
	public void outputInventory(ArrayList<ComGoodsVO> list);
	
	/** 获得仓库内在一定时间段内的出入库数量
	 * 
	 * @param start 起始时间
	 * @param end 结束时间
	 * @return 表示出入库数量的数组
	 */
	public int[] showCheck(String start, String end);
	
	/** 获得仓库在一定时间段内的所有入库单
	 * 
	 * @param start 起始时间
	 * @param end 结束时间
	 * @return 入库单VO的ArrayList
	 */
	public ArrayList<EnterReceiptVO> showCheckEnter(String start,String end);
	
	/** 获得仓库在一定时间段内的所有出库单
	 * 
	 * @param start 起始时间
	 * @param end 结束时间
	 * @return 出库单VO的ArrayList
	 */
	public ArrayList<ExitReceiptVO> showCheckExit(String start,String end);
	
	
	/** 获得仓库的库存空间
	 * 
	 * @return 表示仓库空间的VO
	 */
	public ComZoneVO showZone();
	
	/** 修改仓库的库存空间
	 * 
	 * @param space 表示修改的库存空间的数组
	 * @return 表示是否修改成功的ResultMessage
	 */
	public ResultMessageV2 editZone(int[] space);
	
	/** 初始化仓库的库存空间
	 * 
	 * @return 表示是否初始化成功的ResultMessage
	 */
	public ResultMessageV2 initZone();
	
	/** 移动仓库内货物的储存位置
	 * 
	 * @param data 表示移动信息的数组
	 * @return  表示是否移动成功的ResultMessage
	 */
	public ResultMessageV2 moveGoods(Object data[][]);

	
}
