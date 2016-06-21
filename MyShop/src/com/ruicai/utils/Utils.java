package com.ruicai.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ruicai.data.Product;
import com.ruicai.data.ProductData;

/**
 * 工具类
 * 用于封装各种方法
 *
 */
public class Utils {
	//初始化一些公共的数据
	static Scanner scanner;
	//初始化所有的商品信息
	static List<ProductData> pData = new ArrayList<>();
	//初始化当前选择的商品的所在集合的位置
	static int position = 0;
	//定义一个数组来存放购买的商品
	static List<ProductData> total = new ArrayList<>();
	
	
	/**
	 * 显示我的购物车的方法
	 */
	public static void showMyCar() {
		System.out.println("=============================");
		if(total.size() == 0){
			System.out.println("购物车空空如也！去逛逛吧");
		}else{
			for (int i = 0;i<total.size();i++) {
				//打印商品信息，这里重写了toString方法
				System.out.println(total.get(i).toString());
			}
			System.out.println("=============================");
			System.out.println("1,去结算        2,再看看");
			int choose = scanner.nextInt();
			if(choose == 1){
				int totalPrice = 0;
				/**
				 * 商品结算： 1：遍历
				 *         2：数量乘以价格，
				 */
				for (int i = 0;i<total.size();i++) {
					totalPrice = totalPrice+Integer.valueOf(total.get(i).getpPrice())*total.get(i).getpNum();
				}
				System.out.println("您一共消费了："+totalPrice);
			}else{
				/**
				 * 再看看---》再次显示主菜单
				 */
				showMenu(pData,scanner);
			}
			
		}
		
	}
	/**
	 * 显示商品菜单的方法
	 * 并购买的方法
	 */
	public static void showMenu(List<ProductData> products,Scanner sc) {
		//把传递过来的商品信息赋值给当前的
		pData = products;
		scanner = sc;//这样做的好处是不用新建Scanner对象
		//显示商品菜单
		for (ProductData productData : products) {
			System.out.println(productData);
			
		}
		//定义一个flag 用来判断是否有用户选择的商品
		boolean flag = false;
		//购买商品
		System.out.println("＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
		System.out.println("通过商品id来购买你喜欢的商品");
		int id = sc.nextInt();
		for (int i = 0;i<products.size();i++) {
			ProductData data = products.get(i);
			if(data.getpId() == id){
				flag = true;
				position = i;
			}
		}
		//如果有选择的商品则开始进行购买
		if(flag){
			
			buySomthing();
			
		}else{
			System.out.println("对不起！！我们没有你想要的");
		}
		
	}
	/**
	 * 购买商品的方法
	 */
	private static void buySomthing() {
		//1:
		//2:
		ProductData buy = pData.get(position);
		System.out.println("确认您当前选择的商品");
		System.out.println("商品名称:"+buy.getpName());
		System.out.println("商品价格:"+buy.getpPrice());
		System.out.println("商品数量:"+buy.getpNum());
		System.out.println("=============================");
		System.out.println("请输入你购买的数量：");
		int  num = scanner.nextInt();
		if(num<=buy.getpNum()){
			//当前买的商品保存在数组中
			total.add(new ProductData(buy.getpName(),num,buy.getpPrice(),buy.getpId()));
			//购买了商品之后要刷新之前商品的库存
			buy.setpNum(buy.getpNum()-num);
			System.out.println("已经把您要的放到了购物车哟！！！！");
		}else{
			System.out.println("当前库存不够，再去看看吧！");
		}	
	}
}
