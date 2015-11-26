package edu.nju.express.data.userdata;




import edu.nju.express.common.CommonData;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.UserPO;

public class UserFileDao extends CommonData<UserPO> implements UserDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserFileDao(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage modify(UserPO po) {
		// TODO Auto-generated method stub
		return update(po.getId(), po);
	}

	

}
