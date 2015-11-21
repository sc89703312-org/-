package edu.nju.express.data.paymentdata;

import java.util.ArrayList;

import edu.nju.express.common.DefineList;
import edu.nju.express.po.Paymentpo;

public class PaymentDataTest implements PaymentDao {

	
	DefineList<Paymentpo> payments;
	
	public PaymentDataTest() {
		// TODO Auto-generated constructor stub
	
	
		payments = new DefineList<Paymentpo>("payment");
	}
	
	
	
	@Override
	public void insert(Paymentpo po) {
		// TODO Auto-generated method stub
		payments.insert(po);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Paymentpo po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Paymentpo find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Paymentpo> viewByHall(String number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Paymentpo> viewByDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Paymentpo> getAll() {
		// TODO Auto-generated method stub
		return payments.getAll();
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		System.out.println("data_test does");
		payments.flush();
	}

}
