package edu.nju.express.data.paymentdata;

import java.util.ArrayList;

import edu.nju.express.common.CommonData;
import edu.nju.express.common.DefineList;
import edu.nju.express.common.ReceiptState;
import edu.nju.express.po.Paymentpo;

public class PaymentDataTest extends CommonData<Paymentpo> implements PaymentDao  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public PaymentDataTest(String path) {
		// TODO Auto-generated constructor stub
		super(path);
	}
	
	
	

	@Override
	public ArrayList<Paymentpo> viewByHall(String number) {
		// TODO Auto-generated method stub
		
		ArrayList<Paymentpo> payments = inList.showAll();
		ArrayList<Paymentpo> temps = new ArrayList<Paymentpo>();
		for(int i=0;i<payments.size();i++){
			if(payments.get(i).getCourier_id().substring(0, 6).equals(number))
			   temps.add(payments.get(i));
		}
		
		return temps;
	}

	@Override
	public ArrayList<Paymentpo> viewByDate(String date) {
		// TODO Auto-generated method stub
		ArrayList<Paymentpo> payments = inList.showAll();
		ArrayList<Paymentpo> temps = new ArrayList<Paymentpo>();
		for(int i=0;i<payments.size();i++){
			if(payments.get(i).getDate().equals(date))
			   temps.add(payments.get(i));
		}
		
		return temps;
	}




	@Override
	public ArrayList<Paymentpo> viewAllPaymentSubmitted() {
		// TODO Auto-generated method stub
		ArrayList<Paymentpo> payments = inList.showAll();
		ArrayList<Paymentpo> temps = new ArrayList<Paymentpo>();
		for(int i=0;i<payments.size();i++){
			if(payments.get(i).getState()==ReceiptState.SUBMITTED)
			   temps.add(payments.get(i));
		}
		
		return temps;
	}




	@Override
	public ArrayList<String> viewAllOrderListByHall(String HallID) {
		// TODO Auto-generated method stub
		ArrayList<String> orderList = new ArrayList<>();
		ArrayList<Paymentpo> payments = inList.showAll();
		for(Paymentpo po:payments){
			if(po.getHall_Id().equals(HallID))
				orderList.add(po.getOrder_id());
		}
		return orderList;
	}



	

}
