package org.ccunix.javaweb.vo;

import org.ccunix.javaweb.model.CartSelectedMerModel;

public class CartSelectedMerVO extends CartSelectedMerModel {

	private String merName;// 商品名称
	private double merPrice;// 商品的价格

	public CartSelectedMerVO(int id, int cart, int merchandise, int number, double price, double money, String merName,
			double merPrice) {
		super(id, cart, merchandise, number, merPrice, money);
		this.merName = merName;
		this.merPrice = merPrice;
	}
	
	public CartSelectedMerVO(int id, String merName, double merPrice, double price, int number, double money) {
		setId(id);
		setMerName(merName);
		setMerPrice(merPrice);
		setPrice(price);
		setNumber(number);
		setMoney(money);
		
	}

	public String getMerName() {
		return merName;
	}

	public void setMerName(String merName) {
		this.merName = merName;
	}

	public double getMerPrice() {
		return merPrice;
	}

	public void setMerPrice(double merPrice) {
		this.merPrice = merPrice;
	}
}
