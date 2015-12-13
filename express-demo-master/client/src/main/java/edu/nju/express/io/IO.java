package edu.nju.express.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IO {
	// 写文件
	public static void writerTxt(String text) {
		BufferedWriter fw = null;
		try {
			File file = new File("data/login.txt");
			fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8")); // 指定编码格式，以免读取时中文字符异常
			
			fw.write(text);
			fw.flush(); // 全部写入缓存中的内容
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 读文件
	public static String readTxt() {

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("data/login.txt"), "UTF-8")); // 指定读取文件的编码格式，要和写入的格式一致，以免出现中文乱码,
			String str = null;
			while ((str = reader.readLine()) != null) {
				return str;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}