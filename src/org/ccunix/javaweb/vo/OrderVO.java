package org.ccunix.javaweb.vo;

import org.ccunix.javaweb.model.OrderModel;

public class OrderVO extends OrderModel{
	private double money;

	public OrderVO() {
	}
	public OrderVO(int id, int member, int cart, String orderNo, String orderDate, int orderStatus,double money) {
		super(id, member, cart, orderNo, orderDate, orderStatus);
		this.money = money;
	}

	
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
}
