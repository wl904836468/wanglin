package com.wanglin.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.wanglin.entity.Book;

public class Test1 {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Book bo=new Book(91,"yellow book","chenjun",999);
		FileOutputStream fos=new FileOutputStream("E:\\book.dat");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(bo);
		fos.close();
		oos.close();
		FileInputStream fis=new FileInputStream("E:\\book.dat");
		ObjectInputStream ois=new ObjectInputStream(fis);
		System.out.println((Book)ois.readObject());
		fis.close();
		ois.close();
	}

}
