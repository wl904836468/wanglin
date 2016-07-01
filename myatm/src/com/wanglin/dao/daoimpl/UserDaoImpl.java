package com.wanglin.dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.wanglin.entity.User;
import com.wanglin.util.DButil;

public class UserDaoImpl  {
	
	static Connection conn=null;

	public static void addUser(User user) {
		try {
			conn=DButil.getConnection();
			String sql="insert into t_user values(?,?,?);";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getName());
			ps.execute();
			DButil.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deleteUser(int id) {
		try {
			conn=DButil.getConnection();
			String sql="delete from t_user where id=?;";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			DButil.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateUser(int id,String password) {
		try {
			conn=DButil.getConnection();
			String sql="update t_user set password=? where id=?;";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setInt(2, id);
			ps.execute();
			DButil.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static User queryUser(int id) {
		User user=null;
		try {
			conn=DButil.getConnection();
			String sql="select * from t_user where id=?; ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				user=new User();
				user.setId(rs.getInt("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
			}
			DButil.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public static boolean query(int id) {
		boolean flag=false;
		try {
			conn=DButil.getConnection();
			String sql="select * from t_user where id=?; ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				flag=true;
			}
			DButil.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

}
