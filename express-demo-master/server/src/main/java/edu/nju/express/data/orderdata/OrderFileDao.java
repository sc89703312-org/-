package edu.nju.express.data.orderdata;



import edu.nju.express.common.ArrivalState;
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

	
	
	@Override
	public void addHistory(String spot,String id) {
		// TODO Auto-generated method stub
		OrderPO temp = find(id);
		temp.addHistory(spot);
		update(id, temp);
	}

	@Override
	public void setDeliver(String name,String id) {
		// TODO Auto-generated method stub
		OrderPO temp = find(id);
		temp.setDeliver(name);
		update(id, temp);
	}

	@Override
	public void setArrivalState(ArrivalState arrivalState,String id) {
		// TODO Auto-generated method stub
		OrderPO temp = find(id);
		temp.setArrivalState(arrivalState);
		update(id, temp);
	}

	
	
	
	
	
	
}
