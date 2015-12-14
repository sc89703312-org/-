package org.server.bankingdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.nju.express.dataimpl.BankingDataService_Impl;
import edu.nju.express.dataservice.BankingDataService;
import edu.nju.express.po.BankingAccountPO;

public class BankingDataTest {

	
	BankingDataService bankingBL;
	
	public BankingDataTest() {
		// TODO Auto-generated constructor stub
	
		try {
			bankingBL = new BankingDataService_Impl();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@Before
	public void setUp(){
		System.out.println("进行银行账户数据层测试阶段");
		System.out.println("————————————————————————————");
		System.out.println();System.out.println();
	}
	
	
	
	@After
	public void tearDown(){
		System.out.println();System.out.println();
		System.out.println("—————————————————————————————");
		System.out.println("结束此次测试");
	}
	
	
	
	
	@Test
	public void testAllBankingAccount() throws RemoteException{
		
		System.out.println("   银行账户              余额");
		ArrayList<BankingAccountPO> accounts = new ArrayList<>();
		accounts = (bankingBL.getAccount()==null)?new ArrayList<BankingAccountPO>():bankingBL.getAccount();
		
		for(BankingAccountPO po:accounts)
			System.out.println(po.getName()+"     "+po.getMoney());
		
	}
	
	
	

	
}
