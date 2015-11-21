package edu.nju.express.data.paymentdata;

import java.util.ArrayList;

import edu.nju.express.common.DefineList;
import edu.nju.express.data.CommonData;
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
	public void insert(Paymentpo po) {
		// TODO Auto-generated method stub
		inList.insert(po);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		inList.delete(id);
	}

	@Override
	public void update(Paymentpo po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Paymentpo find(String id) {
		// TODO Auto-generated method stub
		return inList.find(id);
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
		return inList.getAll();
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		System.out.println("data_test does");
		inList.flush();
	}

}
