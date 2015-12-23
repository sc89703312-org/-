package edu.nju.express.data.accountdata;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import edu.nju.express.po.Accountpo;




public class AccountFileDao {
	/*
	
	ArrayList<Accountpo> list = new ArrayList<Accountpo>() ;
	
	
	
	public AccountFileDao() {
		// TODO Auto-generated constructor stub
	
	
		list = getAll();
		
	}
	
	
	
	

	@Override
	public void insert(Accountpo po) {
		// TODO Auto-generated method stub
		
		
		list.add(po);
	}

	@Override
	public Accountpo find(String date) {
		// TODO Auto-generated method stub
		
		Accountpo temp =null;
		
		
		for(int i=0;i<list.size();i++){
			if(list.get(i).getDate().equals(date)){
				temp = list.get(i);
				break;
			}
		}
		
		
		
		return temp;
	}
	
	
	

	@Override
	public ArrayList<Accountpo> getAll() {
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
				Accountpo temp = (Accountpo) is.readObject();
				list.add(temp);
			}
		} catch (Exception ex) {
			try {
				
				if(is!=null)
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		return list;
	}

	
	
	
	@Override
	public void flush() {
		// TODO Auto-generated method stub
		try {
			File f = new File("account.txt");
			FileWriter fw =  new FileWriter(f);
			fw.write("");
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	 
	 
	 for(int i=0;i<list.size();i++){
	 try {
		 
		Accountpo po  = list.get(i);
		 
			ObjectOutputStream os;
			File file = new File("account.txt");
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



	@Override
	public ArrayList<Accountpo> showAll() {
		// TODO Auto-generated method stub
		return null;
	}
*/
}
