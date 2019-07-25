package org.ccunix.javaweb.model;

import java.io.Serializable;
import java.util.Set;

public class CartModel  implements Serializable{
	/**
	 * 购物车主键
	 */
	private int id;
	/**
	 * 会员id
	 */
	private int member;
	/**
	 * 总金额
	 */
	private double money;
	/**
	 * 购物车装状态  0-未提交购物车  1-提交的购物车
	 */
	private int cartStatus=0;
	
	private MemberModel memberModel;//会员表   member   多:1
	private Set<CartSelectedMerModel> cartSelectedMerSet; //购物详情

	public CartModel() {

	}

	public CartModel(int id, int member, double money, int cartStatus) {
		this.id = id;
		this.member = member;
		this.money = money;
		this.cartStatus = cartStatus;
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

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public int getCartStatus() {
		return cartStatus;
	}

	public void setCartStatus(int cartStatus) {
		this.cartStatus = cartStatus;
	}

	public MemberModel getMemberModel() {
		return memberModel;
	}

	public void setMemberModel(MemberModel memberModel) {
		this.memberModel = memberModel;
	}

	public Set<CartSelectedMerModel> getCartSelectedMerSet() {
		return cartSelectedMerSet;
	}

	public void setCartSelectedMerSet(Set<CartSelectedMerModel> cartSelectedMerSet) {
		this.cartSelectedMerSet = cartSelectedMerSet;
	}

}
