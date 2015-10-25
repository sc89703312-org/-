package server.data.paymentdata;

import java.util.ArrayList;

import client.po.paymentpo.Paymentpo;


public interface PaymentDao {

	public void insert(Paymentpo po);
	public void delete(Paymentpo po);
	public void update(Paymentpo po);
	public Paymentpo find(String id);
	
	public ArrayList<Paymentpo> viewByHall(String number);
	public ArrayList<Paymentpo> viewByDate(String date);
	
	
	public ArrayList<Paymentpo> getAll();
}
