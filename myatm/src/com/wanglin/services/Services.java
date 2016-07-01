package com.wanglin.services;

import java.util.Scanner;

import com.wanglin.action.Action;
import com.wanglin.dao.daoimpl.AcountDaoImpl;
import com.wanglin.dao.daoimpl.ConnectQuery;
import com.wanglin.dao.daoimpl.UserDaoImpl;

public class Services {
	
	public static Scanner sc=new Scanner(System.in);
	
	static int i;
	/**
	 * 登录界面
	 * 
	 * 
	 * 
	 */
	public static void login(){
		
		System.out.println("==================登录==================");
		System.out.print("请输入账号：");
		int id=sc.nextInt();
		System.out.print("请输入密码：");
		String passWord=sc.next();
		if(i<=3){
			if(UserDaoImpl.query(id)){
				if(UserDaoImpl.queryUser(id).getPassword().equals(passWord)){
					System.out.println("登录成功");
					displayUser(id);
				}else{
					System.out.println("密码错误");
					i++;
					login();
				}
			}else{
				System.out.println("账号不存在");
				firstMeun();
			}
		}else{
			for (int j = 0; j < ConnectQuery.connect1(id).size(); j++) {
				AcountDaoImpl.updateAccount(ConnectQuery.connect1(id).get(j).getCard(), ConnectQuery.connect1(id).get(j).getBalance(),1);
			}
			System.out.println("账号内银行卡已被冻结");
			login();
		}

	}
	
	/**
	 * 注册界面
	 * 
	 * 
	 * 
	 */
	public static void zhuce(){
		
		System.out.println("==================注册==================");
		System.out.print("请输入注册的姓名：");
		String name=sc.next();
		System.out.print("请输入注册的账号：");
		int id=sc.nextInt();
		System.out.print("请输入注册的密码：");
		String password=sc.next();
		if(UserDaoImpl.query(id)){
			System.out.println("账号已存在");
			zhuce();
		}else{
			Action.zhuce(id, password, name);
			System.out.println("注册成功");
			firstMeun();
		}
	}
	
	/**
	 * 首页界面
	 * 
	 * 
	 * 
	 */
	public static void firstMeun(){
		
		System.out.println("----------------欢迎进入ATM系统----------------");
		System.out.println("1.登录    2.注册    3.退出");
		while(true){
			String str=sc.next();
			if(str.equals("1")){
				login();
				break;
			}else if(str.equals("2")){
				zhuce();
				break;
			}else if(str.equals("3")){
				System.out.println("欢迎下次光临。");
				break;
			}else{
				System.out.println("您的输入错误，请重新输入。");
			}
		}
		System.exit(0);
	}
	/**
	 * 用户展示界面
	 */
	
	public static void displayUser(int id){
		
		System.out.println("=================请选择=================");
		while(true){
		System.out.println("1.办卡 2.选卡  3.修改密码  4.退出 ");
		String str=sc.next();
			if(str.equals("1")){
				Action.zhuceka(id);
				System.out.println("办卡成功");
				displayUser(id);
				break;
			}else if(str.equals("2")){
				if(ConnectQuery.connect1(id).size()==0){
					System.out.println("没有银行卡,请办卡");
					displayUser(id);
				}else{
					int i=0;
					for ( i = 0; i < ConnectQuery.connect1(id).size(); i++) {
						System.out.println(i+": "+ConnectQuery.connect1(id).get(i).getCard());
					}
					System.out.println("请选择输入序号,选择银行卡");
					int in=sc.nextInt();
					if(in<=ConnectQuery.connect1(id).size()-1){
						if(ConnectQuery.connect1(id).get(in).getState()==0){
							displayCard(ConnectQuery.connect1(id).get(in).getCard());
						}else{
							System.out.println("卡已经被冻结");
							displayUser(id);
						}
					}else{
						System.out.println("请输入正确序号");
						displayUser(id);
					}
				}
				break;
			}else if(str.equals("3")){
				System.out.println("请输入要修改的密码:");
				String password=sc.next();
				Action.changePass(id, password);
				System.out.println("修改成功");
				displayUser(id);
				break;
			}else if(str.equals("4")){
				firstMeun();
				break;
			}else{
				System.out.println("输入有误，请重新输入");
			}
		}
	}

	/**
	 * 银行卡展示界面
	 * 
	 * 
	 * 
	 */
	public static void displayCard(String card){
		
		System.out.println("=================请选择=================");
		while(true){
		System.out.println("1.查询银行卡状态 2.存款  3.取款 4.转帐   5.客户交易明细，6.返回");
		String str=sc.next();
			if(str.equals("1")){
				System.out.println(AcountDaoImpl.queryAccount(card));
				displayCard(card);
				break;
			}else if(str.equals("2")){
				System.out.println("请输入存款金额:");
				double money=sc.nextDouble();
				Action.save(money, card);
				System.out.println("存款成功");
				displayCard(card);
				break;
			}else if(str.equals("3")){
				System.out.println("请输入取款金额:");
				double money=sc.nextDouble();
				Action.take(money, card);
				System.out.println("取款成功");
				displayCard(card);
				break;
			}else if(str.equals("4")){
				System.out.println("请输入转账金额:");
				double money=sc.nextDouble();
				System.out.println("请输入对方银行卡号:");
				String card2=sc.next();
				Action.move(money, card, card2);
				System.out.println("转账成功");
				displayCard(card);
				break;
			}else if(str.equals("5")){
				for (int i = 0; i < Action.check(card).size(); i++) {
					System.out.println(Action.check(card).get(i));
				}
				displayCard(card);
				break;
			}else if(str.equals("6")){
				displayUser(AcountDaoImpl.queryAccount(card).getId());
				break;
			}else{
				System.out.println("输入有误，请重新输入");
			}
		}
	}
	public static void main(String[] args) {
		firstMeun();
	}
}
