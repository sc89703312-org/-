package edu.nju.express.data.userdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import edu.nju.express.common.Role;
import edu.nju.express.common.StaffChange;
import edu.nju.express.po.UserMessagePO;

public class UserMessageFileDao implements UserMessageDao {
	
	ArrayList<UserMessagePO> list;

	public UserMessageFileDao() {
		list = new ArrayList<UserMessagePO>();
		getAll();
	}

	@Override
	public int insert(UserMessagePO po) {
		for (int i = 0; i < list.size(); i++)
			if (((UserMessagePO) list.get(i)).getId().equals(po.getId()))
				return -1;
		list.add(po);
		return 0;
	}

	@Override
	public int delete(String id) {
		for (int i = 0; i < list.size(); i++)
			if (((UserMessagePO) list.get(i)).getId().equals(id)) {
				list.remove(i);
				return 0;
			}
		return -1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<UserMessagePO> getAll() {
		list.clear();
		File file = new File("userMessage.txt");
		if (!file.exists()) {
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
			list = (ArrayList<UserMessagePO>) ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public void flush() {
		ObjectOutputStream oos = null;
		File f = new File("userMessage.txt");
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

	@Override
	public UserMessagePO find(String id) {
		for (int i = 0; i < list.size(); i++)
			if (((UserMessagePO) list.get(i)).getId().equals(id))
				return (UserMessagePO) list.get(i);
		return null;
	}

}
