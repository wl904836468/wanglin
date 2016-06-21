package com.ruicai.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ruicai.data.Product;
import com.ruicai.data.ProductData;
import com.ruicai.data.UserData;
import com.ruicai.utils.Utils;

/**
 * 程序开始的界面
 *	主要功能
 *	1，注册
 *  2，登陆
 *  3，进入系统
 */
public class Center {
		//打卡键盘监听
		public static Scanner sc = new Scanner(System.in);
		//初始化用户信息集合
		public static List<UserData> users = new ArrayList<UserData>();
		 //初始化商品信息
		public static List<ProductData> products = Product.getProduct();
		public static void main(String[] args) {
			System.out.println("---------------欢迎进入瑞才商品管理系统 --------------");
			
			while(true){
				System.out.print("1,登陆  2,注册  3,退出");
				int choose = sc.nextInt();
				switch (choose) {
				case 1:
					Login();
					break;
				case 2:
					Regist();
					break;
				case 3:
					System.exit(0);
					break;
				default:
					break;
				}
				
				
				
			}
		
		}
		/**
		 * 针对页面上的业务，采用javaScript【Js】
		 * 注册账户的方法
		 * 1：屏蔽特殊字符，注册的时候注意用户名的长度
		 * -----
		 * 最简单：
		 *   直接获取用户名和密码然后保存
		 *       
		 */
		private static void Regist() {
			boolean flag = false;
			System.out.println("请输入注册的用户名：");
			String name = sc.next();//获取用户名
			System.out.println("请输入注册的密码：");
			String passWord = sc.next();//获取密码
			/**
			 * 如果到web阶段，注册的时候也要进行用户重名验证，【数据库去查询数据】
			 * 给出提示。。。
			 * 这个项目用的是集合保存数据
			 */
			for(int i = 0;i<users.size();i++){
				//遍历集合如果和输入的姓名相同的话给出提示，不能注册
				if(name.equals(users.get(i).getName())){
					flag = true;
				}
			}
			if(flag){
				  // 给出一个提示发送到前台---》前台用户可以看到
					System.out.println("该账号已经被抢先啦！！");
			}else{
				//数据库中没有这个用户，可以注册---》用户名和密码【保存】到数据库中
               //调用构造方法初始化用户，放入集合中。完成注册
				UserData user = new UserData(name,passWord);
				users.add(user);//把对象保存到【集合】数据库中
				System.out.println("注册成功");//给出用户提示
				
			}
		}
		/**
		 * 登陆账户的方法
		 * 1：获取输入的数据【用户名，密码，验证码】
		 * 2：提交数据到服务器，服务器去查询数据库，看是否存在该用户【ajax技术】
		 *   --》 1：用户名或者密码错误
		 *       2：不存在该用户
		 * ----
		 * 
		 */
		private static void Login() {
			boolean flag = false;
			System.out.println("请输入您的用户名：");
			String name = sc.next();
			System.out.println("请输入您的密码：");
			String passWord = sc.next();
			/**
			 * 从数据库去查看所有的数据，匹配是否存在该用户
			 */
			for(int i = 0;i<users.size();i++){
				if(users.get(i).getName().equals(name)&&users.get(i).getPassWord().equals(passWord)){
					flag = true;
				}
			}
			/**
			 * while(true)
			 */
			while(flag){
				System.out.println("欢迎光临！");
				System.out.print("1,逛一逛  2,我的购物车  3,退出");
				int choose = sc.nextInt();
					switch (choose) {
					case 1:
						Utils.showMenu(products,sc);//调用Utils类的显示菜单的方法
						break;
					case 2:
						Utils.showMyCar();
						break;
					case 3:
						System.exit(0);
						break;

					default:
						break;
					}
			}
			System.out.println("用户名或者密码输入错误！");
			
		}
		
		
		
		
}
