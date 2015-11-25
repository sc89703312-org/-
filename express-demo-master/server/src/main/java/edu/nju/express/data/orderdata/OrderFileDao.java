package edu.nju.express.data.orderdata;



import edu.nju.express.common.CommonData;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.OrderPO;

public class OrderFileDao extends CommonData<OrderPO> implements OrderDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderFileDao(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage update(OrderPO po) {
		// TODO Auto-generated method stub
		return update(po.getId(), po);
	}

	
	
	
	
	
	
}
