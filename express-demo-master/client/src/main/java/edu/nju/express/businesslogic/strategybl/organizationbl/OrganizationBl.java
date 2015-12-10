package edu.nju.express.businesslogic.strategybl.organizationbl;

import java.util.ArrayList;

import edu.nju.express.blservice.OrganizationBlService;
import edu.nju.express.businesslogic.accountbl.Info.OrganizationInfo;
import edu.nju.express.businesslogic.hallbl.HallBL;
import edu.nju.express.businesslogic.stationbl.StationBl;
import edu.nju.express.businesslogic.strategybl.constantsettingbl.ConstantSettingBl;
import edu.nju.express.businesslogic.strategybl.organizationbl.Info.ConstantAddCityInfo;
import edu.nju.express.businesslogic.strategybl.organizationbl.Info.HallOperationInfo;
import edu.nju.express.businesslogic.strategybl.organizationbl.Info.StationOperationInfo;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.log.LogController;
import edu.nju.express.po.LogMessage;
import edu.nju.express.po.LoginInfo;
import edu.nju.express.vo.HallVO;
import edu.nju.express.vo.StationVO;


/**
 * 机构管理功能实现
 * @author Dora
 *
 */
public class OrganizationBl implements OrganizationBlService,OrganizationInfo{

	StationOperationInfo stationbl;
	HallOperationInfo hallbl;
	ConstantAddCityInfo constantSettingBL;
	
	public OrganizationBl(StationOperationInfo stationbl,
			              HallOperationInfo hallbl,
			              ConstantAddCityInfo constantSettingBL){
		
		this.stationbl = stationbl;
		this.hallbl = hallbl;
		this.constantSettingBL = constantSettingBL;
	}
	
	/**
	 * 查看中转站列表
	 * @see StationBl
	 * @see edu.nju.express.blservice.OrganizationBlService#viewStationList()
	 */
	@Override
	public ArrayList<StationVO> viewStationList() {
		return stationbl.showStation();
		
	}

	/**
	 * (non-Javadoc)
	 * 新建中转站
	 * @see StationBl
	 * @see edu.nju.express.blservice.OrganizationBlService#createStation(java.lang.String, java.lang.String)
	 */
	@Override
	public ResultMessage createStation(String id, String name) {
		
	 ResultMessage temp=	stationbl.addStation(id, name);
		
     	if(temp.equals(ResultMessage.VALID))
			constantSettingBL.addCity(name,id);
		
     	LogController.insertLog(new LogMessage("增加中转站", LoginInfo.getUserName()));
		
		return temp;
		
		
	}

	/**
	 * 删除中转站
	 * (non-Javadoc)
	 * @see StationBl
	 * @see ConstantSettingBl
	 * @see edu.nju.express.blservice.OrganizationBlService#deleteStation(java.lang.String)
	 */
	@Override
	public ResultMessage deleteStation(String id) {
		
		LogController.insertLog(new LogMessage("删除中转站", LoginInfo.getUserName()));
		
		   ResultMessage temp=	stationbl.deleteStation(id);
			
	     	if(temp.equals(ResultMessage.VALID))
				constantSettingBL.deleteCity(id);
			
	     	LogController.insertLog(new LogMessage("删除中转站", LoginInfo.getUserName()));
			
			return temp;
		
	}

	/**
	 * (non-Javadoc)
	 * 查看营业厅列表
	 * @see HallBL
	 * @see edu.nju.express.blservice.OrganizationBlService#viewHallList()
	 */
	@Override
	public ArrayList<HallVO> viewHallList() {
		return hallbl.showHall();
	}

	/**
	 * (non-Javadoc)
	 * 新建营业厅
	 * @see HallBL
	 * @see edu.nju.express.blservice.OrganizationBlService#createHall(java.lang.String, java.lang.String)
	 */
	@Override
	public ResultMessage createHall(String id, String name) {
		
		LogController.insertLog(new LogMessage("增加营业厅", LoginInfo.getUserName()));
		
		
		return hallbl.addHall(id, name);
	}

	/**
	 * 删除营业厅
	 * @see HallBL
	 * @see edu.nju.express.blservice.OrganizationBlService#deleteHall(java.lang.String)
	 */
	@Override
	public ResultMessage deleteHall(String id) {
		// TODO Auto-generated method stub
		
		LogController.insertLog(new LogMessage("删除营业厅", LoginInfo.getUserName()));
		
		
		return hallbl.removeHall(id);
	}

}
