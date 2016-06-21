package com.wanglin.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test3 {
	
	public static void main(String[] args) throws IOException {
		int c;
		FileInputStream fis=new FileInputStream("C:\\1.jpg");
		FileOutputStream fos=new FileOutputStream("D:\\1.jpg");
		while((c=fis.read())!=-1){
			fos.write(c);
		}
		fis.close();
		fos.close();
	}

}
