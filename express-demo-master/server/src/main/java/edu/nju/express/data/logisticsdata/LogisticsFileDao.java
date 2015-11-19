package edu.nju.express.data.logisticsdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import edu.nju.express.po.LogisticsPO;

public class LogisticsFileDao implements LogisticsDao{
	ArrayList<LogisticsPO> list = new ArrayList<LogisticsPO>();
	
	@Override
	public void insert(LogisticsPO po) {
		// TODO Auto-generated method stub
		list.add(po);
	}

	@Override
	public void update(LogisticsPO po) {
		// TODO Auto-generated method stub
		String id = po.getid();
		for(int i=0;list.get(i)!=null;i++){
			if(list.get(i).getid().equals(id)){
				list.remove(i);
				list.add(i, po);
			}
		}
	}

	@Override
	public LogisticsPO find(String id) {
		// TODO Auto-generated method stub
		for(int i=0;list.get(i)!=null;i++){
			if(list.get(i).getid().equals(id)){
				return list.get(i);
			}
		}
		return null;
	}

	@Override
	public ArrayList<LogisticsPO> getAll() {
		// TODO Auto-generated method stub
		list.clear();
		ObjectInputStream os = null;
		File file = new File("logistics.txt");
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
				LogisticsPO po =(LogisticsPO) os.readObject();
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
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		try {
			File f = new File("logistics.txt");
			FileWriter fw =  new FileWriter(f);
			fw.write("");
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try{
			File f = new File("logistics.txt");
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
