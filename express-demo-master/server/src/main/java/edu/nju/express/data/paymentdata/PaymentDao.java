package edu.nju.express.data.paymentdata;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.Paymentpo;




public interface PaymentDao {

	public ResultMessage insert(Paymentpo po);
	public ResultMessage delete(String id);
	public ResultMessage update(String id,Paymentpo po);
	public Paymentpo find(String id);
	
	public ArrayList<Paymentpo> viewByHall(String number);
	public ArrayList<Paymentpo> viewByDate(String date);
	
	
	public ArrayList<Paymentpo> viewAllPaymentSubmitted();
	
	public ArrayList<Paymentpo> getAll();
	
	public ArrayList<Paymentpo> showAll();
	
	public double caculatePostManSalary(String postManID);
	
	public ArrayList<String> viewAllOrderListByHall(String HallID);
	
	public void flush();
}
