package org.ccunix.javaweb.vo;

import org.ccunix.javaweb.model.CartModel;
import org.ccunix.javaweb.model.CartSelectedMerModel;
import org.ccunix.javaweb.model.MerchandiseModel;
/**
 * 从数据库取值后封装的对象
 * @author Administrator
 *
 */
public class ShopCarVO {
	/**
	 * 商品数据库表
	 */
	private MerchandiseModel merchandiseModel;
	/**
	 * 购物车数据库表
	 */
	private CartModel cartModel;
	/**
	 * 购物车详情数据库表
	 */
	private CartSelectedMerModel cartSelectedMerModel;
	public ShopCarVO() {}
	public ShopCarVO(MerchandiseModel merchandiseModel, CartModel cartModel,
			CartSelectedMerModel cartSelectedMerModel) {
		super();
		this.merchandiseModel = merchandiseModel;
		this.cartModel = cartModel;
		this.cartSelectedMerModel = cartSelectedMerModel;
	}
	public MerchandiseModel getMerchandiseModel() {
		return merchandiseModel;
	}
	public void setMerchandiseModel(MerchandiseModel merchandiseModel) {
		this.merchandiseModel = merchandiseModel;
	}
	public CartModel getCartModel() {
		return cartModel;
	}
	public void setCartModel(CartModel cartModel) {
		this.cartModel = cartModel;
	}
	public CartSelectedMerModel getCartSelectedMerModel() {
		return cartSelectedMerModel;
	}
	public void setCartSelectedMerModel(CartSelectedMerModel cartSelectedMerModel) {
		this.cartSelectedMerModel = cartSelectedMerModel;
	}
	
}
