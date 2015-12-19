package edu.nju.express.data.accountdata;



import edu.nju.express.common.CommonData;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.Accountpo;

public class AccountDataTest extends CommonData<Accountpo> implements AccountDao {

	
	
	public AccountDataTest(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public ResultMessage insert(Accountpo e) {
		// TODO Auto-generated method stub
		
		if(inList.insert(e)==ResultMessage.INVALID)
		{
			inList.update(e.getId(), e);
		}
		
		
		return ResultMessage.VALID;
	}
	
	
	
	
	

}
