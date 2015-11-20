package edu.nju.express.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class DefineList<E> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	String path;
	ArrayList<E> list = new ArrayList<E>();
	
	
	
	
	public DefineList(String file) {
		// TODO Auto-generated constructor stub
	
	path = file+".txt";
	
	}
	
	
	
	public void insert(E e){
		list.add(e);
	}
	
	
	
	
	public void delete(String id){
		
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
