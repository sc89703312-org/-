package edu.nju.express.businesslogic.logisticsbl;


import edu.nju.express.blservice.LogisticsBLService;
import edu.nju.express.businesslogic.logisticsbl.Info.OrderToLogisticsInfo;
import edu.nju.express.businesslogic.orderbl.OrderBL;
import edu.nju.express.vo.LogisticsVO;
import static edu.nju.express.init.RMIHelper.logRecordDataService;



public class LogisticsBL implements LogisticsBLService{

	OrderToLogisticsInfo orderBL;
	
	public LogisticsBL(OrderToLogisticsInfo orderBL){
		this.orderBL=orderBL;
		
	}
	
	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.LogisticsBLService#view(java.lang.String)
	 */
	@Override
	public LogisticsVO view(String id) {
		// TODO Auto-generated method stub
		
		return orderBL.searchById(id);
	}

}
