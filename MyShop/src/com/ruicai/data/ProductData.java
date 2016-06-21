package com.ruicai.data;
/**
 * 
 *	商品信息的类
 *	商品属性
 *		商品编号
 *		商品名称
 *		商品数量
 *		商品价格
 *
 */
public class ProductData {
	int pId;
	String pName;
	int pNum;
	String pPrice;
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getpNum() {
		return pNum;
	}
	public void setpNum(int pNum) {
		this.pNum = pNum;
	}
	public String getpPrice() {
		return pPrice;
	}
	public void setpPrice(String pPrice) {
		this.pPrice = pPrice;
	}
	
	
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public ProductData(String pName, int pNum, String pPrice,int pId) {
		super();
		this.pName = pName;
		this.pNum = pNum;
		this.pPrice = pPrice;
		this.pId = pId;
	}
	/**
	 * 重写toString方法实现打印商品信息
	 */
	@Override
	public String toString() {
		return "商品ID"+pId+"      商品名称 ：" + pName + "      商品数量 ：" + pNum + "      商品价格 ：" + pPrice;
	}
	
	
	
}
