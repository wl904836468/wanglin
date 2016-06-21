package com.ruicai.data;

import java.util.ArrayList;
import java.util.List;

public class Product {
	//得到现有的所有商品信息
	public static List<ProductData> getProduct(){
		List<ProductData> products = new ArrayList<ProductData>();
		products.add(new ProductData("小米手机",100,"1000",1));
		products.add(new ProductData("iPhone6",200,"4000",2));
		products.add(new ProductData("小米机顶盒",550,"150",3));
		products.add(new ProductData("中华小当家面包",1000,"10",4));
		products.add(new ProductData("野生葫芦娃",7,"10000",5));
		products.add(new ProductData("石头人皮肤",1000,"100",6));
		products.add(new ProductData("越南新娘",10,"100000",7));
		return products;
		
	}
	
	
}
