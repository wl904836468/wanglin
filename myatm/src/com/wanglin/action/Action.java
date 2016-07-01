package com.wanglin.action;

import java.util.List;

import com.wanglin.dao.daoimpl.AcountDaoImpl;
import com.wanglin.dao.daoimpl.TradeDaoImpl;
import com.wanglin.dao.daoimpl.UserDaoImpl;
import com.wanglin.entity.Account;
import com.wanglin.entity.Trade;
import com.wanglin.entity.User;

public class Action {
	
	/**
	 * 注册用户
	 */
	public static void zhuce(int id, String password,String name){
		User user=new User();
		user.setId(id);
		user.setPassword(password);
		user.setName(name);
		UserDaoImpl.addUser(user);
	}
	/**
	 * 注册银行卡
	 */
	public static void zhuceka(int id){
		Account account=new Account();
		account.setBalance(0);
		account.setState(0);
		account.setId(id);
		AcountDaoImpl.addAccount(account);
	}
	/**
	 * 转账
	 */
	public static void move(double money,String card1,String card2){
		Account acc1=AcountDaoImpl.queryAccount(card1);
		AcountDaoImpl.updateAccount(card1, acc1.getBalance()-money, 0);
		Trade trade1=new Trade();
		trade1.setMoney(money);
		trade1.setType(3);
		trade1.setCard(card1);
		TradeDaoImpl.addTrade(trade1);
		Account acc2=AcountDaoImpl.queryAccount(card2);
		AcountDaoImpl.updateAccount(card2, acc2.getBalance()+money, 0);
		Trade trade2=new Trade();
		trade2.setMoney(money);
		trade2.setType(2);
		trade2.setCard(card2);
		TradeDaoImpl.addTrade(trade2);
	}
	/**
	 * 存钱
	 */
	public static void save(double money,String card){
		Account acc=AcountDaoImpl.queryAccount(card);
		AcountDaoImpl.updateAccount(card, acc.getBalance()+money, 0);
		Trade trade=new Trade();
		trade.setMoney(money);
		trade.setType(0);
		trade.setCard(card);
		TradeDaoImpl.addTrade(trade);
	}
	/**
	 * 取钱
	 */
	public static void take(double money,String card){
		Account acc=AcountDaoImpl.queryAccount(card);
		AcountDaoImpl.updateAccount(card, acc.getBalance()-money, 0);
		Trade trade=new Trade();
		trade.setMoney(money);
		trade.setType(1);
		trade.setCard(card);
		TradeDaoImpl.addTrade(trade);
	}
	/**
	 * 查询交易详细
	 */
	public static List<Trade> check(String card){
		
		return TradeDaoImpl.queryTrade(card);
	}

	/**
	 * 修改密码
	 */
	public static void changePass(int id,String password){
		UserDaoImpl.updateUser(id, password);
	}
	
}
