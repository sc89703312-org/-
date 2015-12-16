package edu.nju.express.businesslogic.hallbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.blservice.HallBLService;
import edu.nju.express.businesslogic.strategybl.organizationbl.Info.HallOperationInfo;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.dataservice.HallDataService;
import edu.nju.express.init.RMIHelper;
import edu.nju.express.po.HallPo;
import edu.nju.express.vo.ArrivalReceiptVO;
import edu.nju.express.vo.DeliverReceiptVO;
import edu.nju.express.vo.HallVO;
import edu.nju.express.vo.TransferReceiptVO;

public class HallBL implements HallBLService,HallOperationInfo {

	/*持有营业厅业务数据层接口的应用*/
	HallDataService hallDataService;
	
	
	public HallBL() {
		// TODO Auto-generated constructor stub
	
		
		hallDataService = RMIHelper.getHallDataService();
	}
	
	
	
	/**增加营业厅，包含营业厅的编号和位置信息
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.HallBLService#addHall(java.lang.String, java.lang.String)
	 */
	@Override
	public ResultMessage addHall(String id, String location) {
		// TODO Auto-generated method stub
		
		HallPo po = new HallPo(id, location);
		
		try {
			return hallDataService.addHall(po) ;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
	/**删除营业厅
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.HallBLService#removeHall(java.lang.String)
	 */
	@Override
	public ResultMessage removeHall(String id) {
		// TODO Auto-generated method stub
		try {
			return  hallDataService.removeHall(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	/**获得所有营业厅的信息VO
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.HallBLService#showHall()
	 */
	@Override
	public ArrayList<HallVO> showHall() {
		// TODO Auto-generated method stub
		try {
			return convertHallPO(hallDataService.showHall());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	

	
	/**把营业厅的PO转化打包成VO
	 * @author guhan
	 * @param polist 营业厅po的list
	 * @return 营业厅vo的list
	 */
	public ArrayList<HallVO> convertHallPO (ArrayList<HallPo> polist){
		ArrayList<HallVO> halls = new ArrayList<>();
		
		for(int i=0;i<polist.size();i++){
			halls.add(new HallVO(polist.get(i).getId(), polist.get(i).getName()));
		}
		return halls;
	}
	

	

}
