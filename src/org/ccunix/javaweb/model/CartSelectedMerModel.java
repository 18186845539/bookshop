package org.ccunix.javaweb.model;

import java.io.Serializable;

public class CartSelectedMerModel  implements Serializable{
	private int id;
	private int cart;
	private int merchandise;
	private int number;
	private double price;//会员价格
	private double money;
	
	private CartModel cartModel;//购物车   m:1
	private MerchandiseModel merchandiseModel;//商品信息   m:1
	
	public CartSelectedMerModel() {

	}

	public CartSelectedMerModel(int id, int cart, int merchandise, int number, double price, double money) {
		this.id = id;
		this.cart = cart;
		this.merchandise = merchandise;
		this.number = number;
		this.price = price;
		this.money = money;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCart() {
		return cart;
	}

	public void setCart(int cart) {
		this.cart = cart;
	}

	public int getMerchandise() {
		return merchandise;
	}

	public void setMerchandise(int merchandise) {
		this.merchandise = merchandise;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public CartModel getCartModel() {
		return cartModel;
	}

	public void setCartModel(CartModel cartModel) {
		this.cartModel = cartModel;
	}

	public MerchandiseModel getMerchandiseModel() {
		return merchandiseModel;
	}

	public void setMerchandiseModel(MerchandiseModel merchandiseModel) {
		this.merchandiseModel = merchandiseModel;
	}

}
