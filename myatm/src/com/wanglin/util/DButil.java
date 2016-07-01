package com.wanglin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DButil {
	
	private static String URL;
	private static String USER_NAME;
	private static String PWD;
	private static String DRIVER_CLASS;
	private static Connection conn=null;
	
	static{
		ResourceBundle rb=ResourceBundle.getBundle("com.wanglin.util.config");
		URL=rb.getString("URL");
		USER_NAME=rb.getString("USER_NAME");
		PWD=rb.getString("PWD");
		DRIVER_CLASS=rb.getString("DRIVER_CLASS");
	}
	
	public static Connection getConnection(){
		try {
			Class.forName(DRIVER_CLASS);
			
			conn=DriverManager.getConnection(URL, USER_NAME, PWD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
