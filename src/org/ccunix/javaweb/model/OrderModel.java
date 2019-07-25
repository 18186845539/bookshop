package org.ccunix.javaweb.model;

import java.io.Serializable;

public class OrderModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1023750002718882535L;
	private int id;
	private int member;
	private int cart;
	private String orderNo;
	private String orderDate;
	private int orderStatus;
	private MemberModel memberModel;//会员对象    n:1
	private CartModel cartModel;//购物车对象   1:1
	
	
	
	public OrderModel() {
	}
	//hibernate使用
	public OrderModel( String orderNo, String orderDate, int orderStatus) {
		this.orderNo = orderNo;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}
	public OrderModel(int id, int member, int cart, String orderNo, String orderDate, int orderStatus) {
		this.id = id;
		this.member = member;
		this.cart = cart;
		this.orderNo = orderNo;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMember() {
		return member;
	}

	public void setMember(int member) {
		this.member = member;
	}

	public int getCart() {
		return cart;
	}

	public void setCart(int cart) {
		this.cart = cart;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public MemberModel getMemberModel() {
		return memberModel;
	}
	public void setMemberModel(MemberModel memberModel) {
		this.memberModel = memberModel;
	}
	public CartModel getCartModel() {
		return cartModel;
	}
	public void setCartModel(CartModel cartModel) {
		this.cartModel = cartModel;
	}
}
