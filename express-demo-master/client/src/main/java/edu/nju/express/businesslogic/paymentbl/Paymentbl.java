package edu.nju.express.businesslogic.paymentbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.blservice.Paymentblservice;
import edu.nju.express.businesslogic.bankingbl.Bankingbl;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.dataservice.Paymentdataservice;
import edu.nju.express.init.RMIHelper;
import edu.nju.express.po.Paymentpo;
import edu.nju.express.vo.Paymentvo;




public class Paymentbl implements Paymentblservice {

	ArrayList<Paymentpo> tempArrayList = new ArrayList<Paymentpo>();
	ArrayList<Paymentvo> tempVoList = new ArrayList<Paymentvo>();
	Paymentdataservice paymentDataService ;
	private Paymentpo temp;
	Bankingbl account;
	
	public Paymentbl(Bankingbl account) {
		// TODO Auto-generated constructor stub
	
	paymentDataService =RMIHelper.getPaymentDataService();
	this.account = account;
	}
	
	
	
	@Override
	public ResultMessage createReceipt(Paymentvo vo) {
		// TODO Auto-generated method stub
		 
		if (!(vo.getBankaccount().equals("sc")||vo.getBankaccount().equals("a")||vo.getBankaccount().equals("sc89703312"))) {
			return ResultMessage.INVALID;
		}
		
		else{
			System.out.println("Bingo!");
			
			
			modify((int)vo.getPay(),vo.getBankaccount());
			
			
			
			
//		try {
//			paymentDataService.insert(convertVO(vo));
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return ResultMessage.VALID;
	}
	}
	
	
	
	@Override
	public Paymentvo getPayment(String id) {
		// TODO Auto-generated method stub
		try {
		temp=	paymentDataService.find(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return convertPO(temp);
	}

	@Override
	public void endPayment() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Paymentvo> viewAll() {
		// TODO Auto-generated method stub
		
		try {
			 tempArrayList=paymentDataService.getAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<tempArrayList.size();i++){
			tempVoList.add(convertPO(tempArrayList.get(i)));
		}
		
		
		
		return tempVoList;
	}
	
	
	
	
	public Paymentpo convertVO(Paymentvo vo){
		
		return new Paymentpo(vo.getDate(), vo.getPay(),
				                        vo.getCourier_id(), vo.getOrder_id(),
				                        vo.getBankaccount());
		
	}
	
	
	public Paymentvo convertPO(Paymentpo po){
		
		return new Paymentvo(po.getDate(), po.getPay(),
				                        po.getCourier_id(), po.getOrder_id(),
				                        po.getBankaccount());
		
	}



	
	
	public void modify(int pay,String name){
		this.account.modify(pay,name);
	}
	
}
