/*package edu.nju.express.data.balancedata;

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

import edu.nju.express.po.Balancepo;


public class BalanceFileDao implements BalanceDao {

	
	ArrayList<Balancepo> list = new ArrayList<Balancepo>();
	
	public BalanceFileDao() {
		// TODO Auto-generated constructor stub
	
		list = getAll();
	
	}
	
	
	
	
	@Override
	public void insert(Balancepo po) {
		// TODO Auto-generated method stub
		list.add(po);

	}

	@Override
	public ArrayList<Balancepo> findByDate(String date) {
		// TODO Auto-generated method stub
		
		ArrayList<Balancepo> tempList = new ArrayList<Balancepo>();
		
		for(int i=0;i<list.size();i++){
			if(list.get(i).getDate().equals(date))
				tempList.add(list.get(i));
		}
		
		return tempList;
	}

	
	
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<list.size();i++){
			if(list.get(i).getDate().equals(id)){
				list.remove(i);
				break;
			}
		}
		
	}

	@Override
	public void update(Balancepo po,String id) {
		// TODO Auto-generated method stub
		
		delete(id);
		insert(po);
		
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
				
				if(is!=null)
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







	@Override
	public void flush() {
		// TODO Auto-generated method stub
		try {
			File f = new File("balance.txt");
			FileWriter fw =  new FileWriter(f);
			fw.write("");
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	 
	 
	 for(int i=0;i<list.size();i++){
	 try {
		 
		Balancepo po  = list.get(i);
		 
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
	}




	@Override
	public ArrayList<Balancepo> showAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
*/