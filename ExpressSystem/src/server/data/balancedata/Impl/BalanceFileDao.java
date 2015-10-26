package server.data.balancedata.Impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import client.po.balancepo.Balancepo;
import client.po.paymentpo.Paymentpo;
import server.data.balancedata.BalanceDao;
import server.data.paymentdata.impl.PaymentFileDao.MyObjectOutputStream;

public class BalanceFileDao implements BalanceDao {

	
	ArrayList<Balancepo> list;
	
	public BalanceFileDao() {
		// TODO Auto-generated constructor stub
	list = new ArrayList<Balancepo>();
	
	}
	
	
	
	
	@Override
	public void insert(Balancepo po) {
		// TODO Auto-generated method stub
		list.add(po);
		
		
		try {
			ObjectOutputStream os;
			File file = new File("balance.txt");
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
	public ArrayList<Balancepo> find(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Balancepo po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Balancepo po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Balancepo> getAll() {
		// TODO Auto-generated method stub
		list.clear();
		ObjectInputStream is = null;

		File file = new File("balance.txt");
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
				Balancepo temp = (Balancepo) is.readObject();
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
