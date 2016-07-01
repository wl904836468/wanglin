package com.wanglin.entity;

public class Account {
	
	private String card;
	private double balance;
	private int state;
	private int id;
	
	public Account(String card, double balance, int state, int id) {
		this.card = card;
		this.balance = balance;
		this.state = state;
		this.id = id;
	}

	public Account() {
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		String string=null;
		if(state==0){
			string="正常";
		}else if(state==1){
			string="冻结";
		}
		return "[银行卡号=" + card + ", 余额=" + balance + ", 银行卡状态=" + string + ", id=" + id + "]";
	}
	

}
