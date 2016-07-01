package com.wanglin.dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wanglin.entity.Trade;
import com.wanglin.util.DButil;

public class TradeDaoImpl  {
	
	static Connection conn=null;

	public static void addTrade(Trade trade) {
		try {
			conn=DButil.getConnection();
			String sql="insert into t_trade(time,money,type,card) values(now(),?,?,?);";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setDouble(1, trade.getMoney());
			ps.setInt(2, trade.getType());
			ps.setString(3, trade.getCard());
			ps.execute();
			DButil.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deleteTrade(int ordernum) {
		try {
			conn=DButil.getConnection();
			String sql="delete from t_trade where ordernum=?;";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, ordernum);
			ps.execute();
			DButil.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	public static List<Trade> queryTrade(String card) {
		Trade trade=null;
		List<Trade> li=new ArrayList<Trade>();
		try {
			conn=DButil.getConnection();
			String sql="select * from t_trade where card=?; ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, card);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				trade=new Trade();
				trade.setOrdernum(rs.getInt("ordernum"));
				trade.setTime(rs.getDate("time"));
				trade.setMoney(rs.getDouble("money"));
				trade.setType(rs.getInt("type"));
				trade.setCard(rs.getString("card"));
				li.add(trade);
			}
			DButil.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return li;
	}

}
