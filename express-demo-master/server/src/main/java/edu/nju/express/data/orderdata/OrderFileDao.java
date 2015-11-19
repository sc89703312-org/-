package edu.nju.express.data.orderdata;

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

import edu.nju.express.po.OrderPO;

public class OrderFileDao implements OrderDao {
	ArrayList<OrderPO> list = new ArrayList<OrderPO>();
	
	public OrderFileDao(){
		list = getAll();
	}
	
	@Override
	public void insert(OrderPO po) {
		// TODO Auto-generated method stub
		list.add(po);
	}

	@Override
	public void update(OrderPO po) {
		// TODO Auto-generated method stub
		String id = po.getID();
		for(int i=0;list.get(i)!=null;i++){
			if(list.get(i).getID().equals(id)){
				list.remove(i);
				list.add(i, po);
			}
		}
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		for(int i=0;list.get(i)!=null;i++){
			if(list.get(i).getID().equals(id)){
				list.remove(i);
			}
		}
	}

	@Override
	public OrderPO find(String id) {
		// TODO Auto-generated method stub
		for(int i=0;list.get(i)!=null;i++){
			if(list.get(i).getID().equals(id)){
				return list.get(i);
			}
		}
		return null;
	}

	@Override
	public ArrayList<OrderPO> getAll() {
		// TODO Auto-generated method stub
		list.clear();
		ObjectInputStream os = null;
		File file = new File("order.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
				return list;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try{
			os = new ObjectInputStream(new FileInputStream(file));
			if(file.length()==0){
				os.close();
				return null;
			}
			while(true){
				OrderPO po =(OrderPO) os.readObject();
				list.add(po);
			}
		}
		catch(Exception ex){
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		return this.list;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

		 try {
				File f = new File("order.txt");
				FileWriter fw =  new FileWriter(f);
				fw.write("");
				fw.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		 
		 try{
			 File f = new File("order.txt");
			 ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(f));
			 for(int i=0;list.get(i)!=null;i++){
				 os.writeObject(list.get(i));
			 }
			 os.flush();
			 os.close();
		 }
		 catch(FileNotFoundException  e){
			 e.printStackTrace();
		 }
		 catch(IOException e){
			 e.printStackTrace();
		 }
		
	}
	
	
}
