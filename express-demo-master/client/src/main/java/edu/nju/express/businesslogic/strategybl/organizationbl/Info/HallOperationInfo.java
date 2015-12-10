package edu.nju.express.businesslogic.strategybl.organizationbl.Info;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.HallVO;
/**
 * 机构管理模块需要的营业厅模块接口
 * @author Dora
 *
 */
public interface HallOperationInfo {

	
	
	public ArrayList<HallVO> showHall();
	
    public ResultMessage addHall(String id,String name);
	
	public ResultMessage removeHall(String id);
}
