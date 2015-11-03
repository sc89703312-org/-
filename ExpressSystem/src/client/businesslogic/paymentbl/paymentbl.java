package client.businesslogic.paymentbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import client.ResultMessage;
import client.blservice.paymentblservice.Paymentblservice;
import client.dataservice.paymentdataservice.Paymentdataservice;
import client.main.RMIHelper;
import client.po.paymentpo.Paymentpo;
import client.vo.paymentvo.Paymentvo;


public class paymentbl implements Paymentblservice {

	ArrayList<Paymentpo> tempArrayList = new ArrayList<Paymentpo>();
	ArrayList<Paymentvo> tempVoList = new ArrayList<Paymentvo>();
	Paymentdataservice paymentDataService ;
	private Paymentpo temp;
	
	public paymentbl() {
		// TODO Auto-generated constructor stub
	
	paymentDataService =RMIHelper.getPaymentDataService();
	
	}
	
	
	
	@Override
	public ResultMessage createReceipt(Paymentvo vo) {
		// TODO Auto-generated method stub
		 
		if (!(vo.getBankaccount().equals("sc")||vo.getBankaccount().equals("a")||vo.getBankaccount().equals("sc89703312"))) {
			return ResultMessage.INVALID;
		}
		
		else{
		try {
			paymentDataService.insert(convertVO(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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



	
}
