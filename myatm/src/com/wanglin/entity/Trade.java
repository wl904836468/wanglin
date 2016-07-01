package com.wanglin.entity;

import java.sql.Date;

public class Trade {
	
	private int ordernum;
	private Date time;
	private double money;
	private int type;
	private String card;
	
	public Trade(int ordernum, Date time, double money, int type, String card) {
		this.ordernum = ordernum;
		this.time = time;
		this.money = money;
		this.type = type;
		this.card = card;
	}
	public Trade() {}
	
	public int getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}

	@Override
	public String toString() {
		String string=null;
		if(type==0){
			string="存款";
		}else if(type==1){
			string="取款";
		}else if(type==2){
			string="转入";
		}else if(type==3){
			string="转出";
		}
		return "[交易流水号=" + ordernum + ", 交易时间=" + time + ", 交易金额=" + money + ", 交易类型=" + string + ", 银行卡号="
				+ card + "]";
	}
	
	

}
