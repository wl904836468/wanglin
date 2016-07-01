package com.wanglin.dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wanglin.entity.Account;
import com.wanglin.util.DButil;

public class AcountDaoImpl  {
	
	static Connection conn=null;

	public static void addAccount(Account acc) {
		try {
			conn=DButil.getConnection();
			String sql="insert into t_account values(uuid(),?,?,?);";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setDouble(1, acc.getBalance());
			ps.setInt(2, acc.getState());
			ps.setInt(3,acc.getId());
			ps.execute();
			DButil.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deleteAccount(String card) {
		try {
			conn=DButil.getConnection();
			String sql="delete from t_account where card=?;";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, card);
			ps.execute();
			DButil.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateAccount(String card,double balance,int state) {
		try {
			conn=DButil.getConnection();
			String sql="update t_account set balance=?,state=? where card=?;";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setDouble(1, balance);
			ps.setInt(2, state);
			ps.setString(3, card);
			ps.execute();
			DButil.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Account queryAccount(String card) {
		Account account=null;
		try {
			conn=DButil.getConnection();
			String sql="select * from t_account where card=?; ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, card);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				account=new Account();
				account.setCard(rs.getString("card"));
				account.setBalance(rs.getDouble("balance"));
				account.setState(rs.getInt("state"));
				account.setId(rs.getInt("id"));
			}
			DButil.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

}
