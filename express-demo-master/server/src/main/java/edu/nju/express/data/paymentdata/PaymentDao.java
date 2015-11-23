package edu.nju.express.data.paymentdata;

import java.util.ArrayList;

import edu.nju.express.po.Paymentpo;




public interface PaymentDao {

	public void insert(Paymentpo po);
	public void delete(String id);
	public void update(String id,Paymentpo po);
	public Paymentpo find(String id);
	
	public ArrayList<Paymentpo> viewByHall(String number);
	public ArrayList<Paymentpo> viewByDate(String date);
	
	
	public ArrayList<Paymentpo> getAll();
	
	
	public void flush();
}
