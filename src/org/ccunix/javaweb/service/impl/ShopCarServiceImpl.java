package org.ccunix.javaweb.service.impl;

import java.util.List;

import org.ccunix.javaweb.dao.impl_sql.ShopCarDAO;
import org.ccunix.javaweb.model.CartModel;
import org.ccunix.javaweb.service.iface.ShopCarServiceIface;
import org.ccunix.javaweb.vo.CartSelectedMerVO;
import org.ccunix.javaweb.vo.OrderVO;
import org.ccunix.javaweb.vo.ShopCarVO;

public class ShopCarServiceImpl implements ShopCarServiceIface{
    private ShopCarDAO shopCarDao = new ShopCarDAO();
	@Override
	public boolean addShopCar(int member, double money) {
		// TODO Auto-generated method stub
		return shopCarDao.addShopCar(member, money);
	}

	@Override
	public boolean addShopCartItem(int cart, int merchandise, double price,int favourable) {
		//业务进行组装
		//把会员价格算出来
		price = price*favourable*0.01;
		return shopCarDao.addShopCartItem(cart, merchandise, price);
	}

	@Override
	public boolean updateShopCartMoney(double price) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ShopCarVO> getShopCartList(String member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteShopCart(int cart) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteShopCartItem(int cart) {
		// TODO Auto-generated method stub
		return false;
	}

	public CartModel isShopCartItemExistId(int merchandise) {
		
		return shopCarDao.isShopCartItemExistId(merchandise);
	}

	@Override
	public boolean isExistShopCartItem(int merchandise,int cart) {
		
		
		return shopCarDao.isExistShopCartItem(merchandise,cart);
	}


	@Override
	public List<CartSelectedMerVO> getShopCartItemList(int cart) {
		
		return shopCarDao.getShopCartItemList(cart);
	}

	@Override
	public boolean deleteShopCartByItemId(int id,int cart) {
		
		return shopCarDao.deleteShopCartByItemId(id,cart);
	}

	@Override
	public boolean updateCartselected(int merchandise, int cart) {
		return shopCarDao.updateCartselectedMer(merchandise,cart);
	}

	@Override
	public boolean updateCartselected(int itemId, int cart, int num) {
		return shopCarDao.updateCartselectedMer(itemId,cart,num);
	}

}
