package edu.nju.express.loglist;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;

import edu.nju.express.po.PersistentObj;



public class LogList<E extends PersistentObj> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	
	String path;
	ArrayList<E> list = new ArrayList<E>();
	
	
	
	
	public LogList(String file) {
		// TODO Auto-generated constructor stub
	
	path = "data/log/"+ file+".txt";
	list = getAll();
	
	}
	
	
	
	
	
	public void insert(E e){
	
		list.add(e);
		
	}
	
	
	public ArrayList<E> showAll(){
		return list;
	}
	
	
	public ArrayList<E> getAll(){
		list.clear();
		ObjectInputStream is = null;

		File file = new File(path);
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
				@SuppressWarnings("unchecked")
				E temp = (E) is.readObject();
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
	
	
	
	
	public void flush() {
		// TODO Auto-generated method stub
		
		
		
		try {
			File f = new File(path);
			FileWriter fw =  new FileWriter(f);
			fw.write("");
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	 
	 
	 for(int i=0;i<list.size();i++){
	 try {
		 
		E po  = list.get(i);
		 
			ObjectOutputStream os;
			File file = new File(path);
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
}
