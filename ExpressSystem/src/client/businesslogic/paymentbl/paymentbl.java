package client.businesslogic.paymentbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import client.ResultMessage;
import client.blservice.paymentblservice.Paymentblservice;
import client.businesslogic.bankingbl.Bankingbl;
import client.dataservice.paymentdataservice.Paymentdataservice;
import client.main.RMIHelper;
import client.po.paymentpo.Paymentpo;
import client.vo.bankingvo.BankingAccountVO;
import client.vo.paymentvo.Paymentvo;


public class Paymentbl implements Paymentblservice {

	ArrayList<Paymentpo> tempArrayList = new ArrayList<Paymentpo>();
	ArrayList<Paymentvo> tempVoList = new ArrayList<Paymentvo>();
	Paymentdataservice paymentDataService ;
	ArrayList<BankingAccountVO> accountlist = new ArrayList<BankingAccountVO>();
	private Paymentpo temp;
	Bankingbl account;
	
	public Paymentbl(Bankingbl account) {
		// TODO Auto-generated constructor stub
	
	paymentDataService =RMIHelper.getPaymentDataService();
	this.account = account;
	
	//accountlist = account.showAccount("");
	}
	
	
	
	@Override
	public ResultMessage createReceipt(Paymentvo vo) {
		// TODO Auto-generated method stub
		 
		if (!(vo.getBankaccount().equals("sc")||vo.getBankaccount().equals("a")||vo.getBankaccount().equals("sc89703312"))) {
			return ResultMessage.INVALID;
		}
		
//		boolean exsit=false;
//		
//		for(int i=0;i<accountlist.size();i++){
//			if(vo.getBankaccount().equals(accountlist.get(i).getName())){
//				exsit = true;
//				break;
//			}
//		}
//		
		
		
		
		
		
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
