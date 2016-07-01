package com.wanglin.dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wanglin.entity.Account;
import com.wanglin.entity.Trade;
import com.wanglin.util.DButil;

public class ConnectQuery {
	
	static Connection conn=null;
	
	/**
	 *t_user与t_account连接查询
	 */
	public static List<Account> connect1(int id){
		List<Account> li=new ArrayList<Account>();
		Account acc=null;
		try {
			conn=DButil.getConnection();
			String sql="select t_account.card,t_account.balance,t_account.state,t_account.id from t_account inner join t_user where t_user.id=t_account.id and t_user.id=?; ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				acc=new Account();
				acc.setCard(rs.getString("card"));
				acc.setBalance(rs.getDouble("balance"));
				acc.setState(rs.getInt("state"));
				li.add(acc);
			}
			DButil.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return li;
	}
	
	/**
	 * t_account与t_trade连接查询
	 */
	public static List<Trade> connect2(String card){
		List<Trade> li=new ArrayList<Trade>();
		Trade tra=null;
		try {
			conn=DButil.getConnection();
			String sql="select t_trade.ordernum,t_trade.time,t_trade.money,t_trade.type from t_trade inner join t_account where t_account.card=t_trade.card,card=?; ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, card);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				tra=new Trade();
				tra.setOrdernum(rs.getInt("ordernum"));
				tra.setTime(rs.getDate("time"));
				tra.setMoney(rs.getDouble("money"));
				tra.setType(rs.getInt("type"));
				li.add(tra);
			}
			DButil.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return li;
		
	}

}
