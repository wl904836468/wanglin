package com.ruicai.data;
/**
 * 
 *	用户信息类
 */
public class UserData {
	private	String name;
	private	String passWord;
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public UserData(String name, String passWord) {
		super();
		this.name = name;
		this.passWord = passWord;
	}
	
		
		
}
