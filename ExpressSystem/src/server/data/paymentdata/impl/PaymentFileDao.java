package server.data.paymentdata.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import client.po.paymentpo.Paymentpo;
import server.data.paymentdata.PaymentDao;

public class PaymentFileDao implements PaymentDao {

	ArrayList<Paymentpo> list;
	
	public PaymentFileDao() {
		// TODO Auto-generated constructor stub
	   list = new ArrayList<Paymentpo>();
	}
	
	
	
	@Override
	public void insert(Paymentpo po) {
		// TODO Auto-generated method stub
//		list.add(po);
		
		
		try {
			ObjectOutputStream os;
			File file = new File("payment.txt");
			FileOutputStream fos = new FileOutputStream(file, true);
			if (file.length() < 1) {
				os = new ObjectOutputStream(fos);
			} else {
				os = new MyObjectOutputStream(fos);
			}
			os.writeObject(po);
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Paymentpo po) {
		// TODO Auto-generated method stub
		}

	@Override
	public void update(Paymentpo po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Paymentpo find(String id) {
		// TODO Auto-generated method stub
		ArrayList<Paymentpo> templist = getAll();
		
		for(int i=0;i<templist.size();i++){
			if(templist.get(i).getId().equals(id))
				return templist.get(i);
		}
		
		
		
		return null;
	}

	@Override
	public ArrayList<Paymentpo> viewByHall(String number) {
		// TODO Auto-generated method stub
		
		ArrayList<Paymentpo> tempList = new ArrayList<Paymentpo>();
		getAll();
		
		for(int i=0;i<list.size();i++){
			if(list.get(i).getCourier_id().substring(0, 6).equals(number))
				tempList.add(list.get(i));
		}
		
		return tempList;
	}

	@Override
	public ArrayList<Paymentpo> viewByDate(String date) {
		// TODO Auto-generated method stub
		ArrayList<Paymentpo> tempList = new ArrayList<Paymentpo>();
		getAll();
		
		for(int i=0;i<list.size();i++){
			if(list.get(i).getDate().equals(date))
				tempList.add(list.get(i));
		}
		
		return tempList;
	}

	
	
	@Override
	public ArrayList<Paymentpo> getAll() {
		// TODO Auto-generated method stub
		list.clear();
		ObjectInputStream is = null;

		File file = new File("payment.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
				return list;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			is = new ObjectInputStream(new FileInputStream(file));
			while (true) {
				Paymentpo temp = (Paymentpo) is.readObject();
				list.add(temp);
			}
		} catch (Exception ex) {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	
	
	
	
	public class MyObjectOutputStream extends ObjectOutputStream {
		public MyObjectOutputStream() throws IOException {
			super();
		}

		public MyObjectOutputStream(OutputStream out) throws IOException {
			super(out);
		}

		protected void writeStreamHeader() throws IOException {
			return;
		}
}





}