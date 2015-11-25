package edu.nju.express.common;

import java.io.Serializable;
import java.util.ArrayList;

import edu.nju.express.po.PersistentObj;

public class CommonData<T extends PersistentObj> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public DefineList<T> inList;
	String path;
	
	
	public CommonData(String path) {
		// TODO Auto-generated constructor stub
		inList = new DefineList<T>(path);
	}
	
	
	
	public ResultMessage insert(T e){        
		return inList.insert(e);
	}
	
	public ResultMessage delete(String id){
		return inList.delete(id);
	}
	
	public ResultMessage update(String id,T e){
		return inList.update(id, e);
	}
	
	public T find(String id){
		return inList.find(id);
	}
	
	public ArrayList<T> showAll(){
		return inList.showAll();
	}
	
	public ArrayList<T> getAll(){
		return inList.getAll();
	}
	
	public void flush(){
		inList.flush();
	}
}
