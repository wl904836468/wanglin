package com.wanglin.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test2 {
	
	public static void main(String[] args) {
		String str="hello world";
		
		try {
			FileOutputStream fos=new FileOutputStream("E:\\test.txt");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(str);
			FileInputStream fis=new FileInputStream("E:\\test.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			System.out.println((String)ois.readObject());
			fos.close();
			oos.close();
			fis.close();
			ois.close();
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
