package edu.nju.express.common;

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

import edu.nju.express.po.Accountpo;
import edu.nju.express.po.PersistentObj;


public class DefineList<E extends PersistentObj> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	String path;
	ArrayList<E> list = new ArrayList<E>();
	
	
	
	
	public DefineList(String file) {
		// TODO Auto-generated constructor stub
	
	path = "data/"+ file+".ser";
	list = getAll();
	
	}
	
	public ResultMessage insert(E e){
		
		
		
		
		
		
		if (list.size()==0) {
			list.add(e);
			return ResultMessage.VALID;
		}else{
			
			
			if(binaryFind(0, list.size()-1, e.getId())!=-1)
				return ResultMessage.INVALID;
			
			
			
			
			else{
			
			if(e.getId().compareTo(list.get(0).getId())<0) {
			list.add(0,e);			
		}else if(e.getId().compareTo(list.get(list.size()-1).getId())>0){
			list.add(e);
		}
		else{
			for(int i=0;i<list.size()-1;i++){
				
				System.out.println(list.get(i).getId()+" "+list.get(i+1).getId());
				
				if(list.get(i).getId().compareTo(e.getId())<0
				    &&list.get(i+1).getId().compareTo(e.getId())>0){
					list.add(i+1,e);
				    break;
				}
		}
		
		}
		
		
			
			return ResultMessage.VALID;
			}
		
		
		
		
		
		}
	
	
	
	
	}
	
	
	
	
	public ResultMessage delete(String id){
		
		if(list.size()==0)
			return ResultMessage.INVALID;
		
		if(binaryFind(0, list.size()-1, id)==-1)
			return ResultMessage.INVALID;
		
		else {
			list.remove(binaryFind(0, list.size(), id));
			return ResultMessage.VALID;
		}
		
		
	
	}

	public E find(String id){
	
		
		if(list.size()==0)
			return null;
		if(binaryFind(0, list.size()-1, id)==-1)
			return null;
		return list.get(binaryFind(0, list.size()-1, id));
	}
	
	
	
	
	public ResultMessage update(String id, E po){
		
		
		
		if(list.size()==0)
			return ResultMessage.INVALID;
		
		int index = binaryFind(0, list.size()-1, id);
		
		if(index>=0){
		list.remove(index);
		list.add(index,po);
		
		return ResultMessage.VALID;
		}else {
			return ResultMessage.INVALID;
		}
	}
	
	
	public int binaryFind(int left, int right, String ID) {
		
		
		int index = -1;
		if (right >= left) {
			int middle = (left + right) >> 1;
			E po = list.get(middle);
			if (po.getId().compareTo(ID) > 0) {
				middle--;
				index = binaryFind(left, middle, ID);
			} else if (po.getId().compareTo(ID) < 0) {
				middle++;
				index = binaryFind(middle, right, ID);
			} else if (po.getId().compareTo(ID) == 0) {
				index = middle;
			}
		}
		return index;
	}
	
	
	public ArrayList<E> showAll(){
		return list;
	}
	
	
	

	
	
	@SuppressWarnings("unchecked")
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
//			while (true) {
//				@SuppressWarnings("unchecked")
//				E temp = (E) is.readObject();
//				list.add(temp);
//			}
			list   =  (ArrayList<E>)is.readObject();
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
	 
	 
//	 for(int i=0;i<list.size();i++){
	 try {
		 
//		E po  = list.get(i);
		 
		 
		 
		 
			ObjectOutputStream os;
			File file = new File(path);
			FileOutputStream fos = new FileOutputStream(file, true);
			if (file.length() < 1) {
				os = new ObjectOutputStream(fos);
			} else {
				os = new MyObjectOutputStream(fos);
			}
			os.writeObject(list);
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
//	}
	
	
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
