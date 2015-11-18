package edu.nju.express.data.userdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import edu.nju.express.po.UserPO;

public class UserFileDao implements UserDao{

	ArrayList<UserPO> list;
	
	public UserFileDao() {
		list = new ArrayList<UserPO>();
		getAll();
	}
	
	@Override
	public int insert(UserPO po) {
		for (int i = 0; i < list.size(); i++)
			if (((UserPO) list.get(i)).getId().equals(po.getId()))
				return -1;
		list.add(po);
		return 0;
	}

	@Override
	public int delete(String id) {
		for (int i = 0; i < list.size(); i++)
			if (((UserPO) list.get(i)).getId().equals(id)){
				list.remove(i);
				return 0;
			}
		return -1;
	}

	@Override
	public int modify(UserPO po) {
		for (int i = 0; i < list.size(); i++)
			if (((UserPO) list.get(i)).getId().equals(po.getId())){
				list.set(i, po);
				return 0;
			}
		return -1;
	}

	@Override
	public UserPO find(String id) {
		for (int i = 0; i < list.size(); i++)
			if (((UserPO) list.get(i)).getId().equals(id))
				return (UserPO) list.get(i);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<UserPO> getAll() {
		list.clear();
		File file = new File("user.txt");
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			list = (ArrayList<UserPO>) ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void flush() {
		ObjectOutputStream oos = null;
		File f = new File("user.txt");
		try {
			oos = new ObjectOutputStream(new FileOutputStream(f));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			oos.writeObject(list);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
