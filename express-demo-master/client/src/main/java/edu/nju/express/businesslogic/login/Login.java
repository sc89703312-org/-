package edu.nju.express.businesslogic.login;

import static edu.nju.express.init.RMIHelper.userDataService;
import static edu.nju.express.init.RMIHelper.loginInfoDataService;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.common.Role;
import edu.nju.express.dataservice.LoginInfoDataService;
import edu.nju.express.dataservice.UserDataService;
import edu.nju.express.init.RMIHelper;
import edu.nju.express.io.IO;
import edu.nju.express.po.LoginInfo;
import edu.nju.express.po.UserPO;
/**
 * 
 * @author lenovo
 * @version 2015年12月9日22:36:39
 * 
 * 用于登陆模块的验证操作以及设置登录信息
 */

public class Login {
	
	
	/** 登陆人员列表*/
    ArrayList<UserPO> users;
	
	public Login() {
		// TODO Auto-generated constructor stub
	
		users = new ArrayList<>();
	}
	
	
	/**
	 * 
	 * @param account
	 * @param password
	 * @return 根据输入的账户和密码进行检测
	 * 
	 * 如果账户或者密码不存在则返回 Null   否则返回相应的Role
	 */
	public Role login(String account,String password){
		
		    boolean accountValid = false;
			boolean passwordValid = false;
		
		
			
		    
			
			try{
			 users = userDataService.getAll();
		     }catch (RemoteException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
			
			
			
			
			int i=0;
			for(;i<users.size();i++){
				if(users.get(i).getId().equals(account)){
					accountValid = true;
					break;
				}
			}
		
			if(accountValid){
				System.out.println("Account exsit");
				
				if(users.get(i).getPassword().equals(password))
				{
					System.out.println("Login Successfully");
					passwordValid = true;

					LoginInfo.setUserName(users.get(i).getName());
					LoginInfo.setUserID(users.get(i).getId());
					LoginInfo.setUserPassword(users.get(i).getPassword());


					try {
						loginInfoDataService.insert(new LoginInfo(
								users.get(i).getId(),
								users.get(i).getName()));
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					return users.get(i).getRole();
				}else {
					System.out.println("Password error");
				}
				
				
			}
			else
			    System.out.println("Account error");
			
			return null;
	}
}
