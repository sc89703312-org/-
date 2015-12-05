package edu.nju.express.businesslogic.login;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.common.Role;
import edu.nju.express.dataservice.UserDataService;
import edu.nju.express.init.RMIHelper;
import edu.nju.express.po.UserPO;


public class Login {
	
	
	UserDataService userDataService;
    ArrayList<UserPO> users;
	
	public Login() {
		// TODO Auto-generated constructor stub
	
		userDataService = RMIHelper.getUserDataService();
		users = new ArrayList<>();
	}
	
	
	
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
					LoginInfo.setID(users.get(i).getId());
					LoginInfo.setUserName(users.get(i).getName());
					LoginInfo.setTime();
					System.out.println(LoginInfo.getInfo());
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
