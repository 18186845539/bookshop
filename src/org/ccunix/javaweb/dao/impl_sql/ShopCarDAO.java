package org.ccunix.javaweb.dao.impl_sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.ccunix.javaweb.model.CartModel;
import org.ccunix.javaweb.util.DBManager;
import org.ccunix.javaweb.vo.CartSelectedMerVO;
import org.ccunix.javaweb.vo.MerchandiseVO;
import org.ccunix.javaweb.vo.ShopCarVO;

public class ShopCarDAO {

	public boolean addShopCar(int member, double money) {
		Connection connection = null;
		PreparedStatement ps = null;
		connection = DBManager.getConnection();
		String sql = "insert into cart(member,money,cartstatus) values (?,?,0)";
		try {
			// 事务
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			ps.setInt(1, member);
			ps.setDouble(2, money);
			int row = ps.executeUpdate();
			connection.commit();// 手动提交
			if (row > 0) {
				return true;
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBManager.close(connection, ps);
		}
		return false;
	}

	public boolean addShopCartItem(int cart, int merchandise, double price) {
		Connection connection = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		connection = DBManager.getConnection();
		String sql = "insert into cartselectedmer(cart,merchandise,number,price,money)  values (?,?,1,?,?)";
		String sql2 = "update cart set money = ( select sum(money) from cartselectedmer where cart = ? ) " 
	              + " where id=?";
		
		try {
			// 事务
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			ps.setInt(1, cart);
			ps.setInt(2, merchandise);
			ps.setDouble(3, price);
			ps.setDouble(4, price);
			ps.executeUpdate();
			
			ps2 = connection.prepareStatement(sql2);
			ps2.setInt(1, cart);
			ps2.setInt(2, cart);
			//更新购物车money
			ps2.executeUpdate();
			
			connection.commit();// 手动提交
			return true;
			
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBManager.close(connection, ps);
		}
		return false;

	}

	public boolean updateShopCartMoney(double price) {

		return false;
	}

	public List<ShopCarVO> getShopCartList(String member) {

		return null;
	}

	public boolean deleteShopCart(int cart) {

		return false;
	}

	public boolean deleteShopCartItem(int cart) {

		return false;
	}

	public CartModel isShopCartItemExistId(int merchandise) {
		CartModel cartModel = null;
		Connection connection = null;
		PreparedStatement ps = null;
		connection = DBManager.getConnection();
		String sql = "select id,member,money,cartstatus from cart where member=? and cartstatus=0";
		try {
			// 事务
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			ps.setInt(1, merchandise);
			ResultSet set = ps.executeQuery();
			if (set.next()) {
				cartModel = new CartModel(set.getInt("id"), set.getInt("member"), set.getDouble("money"),
						set.getInt("cartStatus"));

			}
			connection.commit();// 手动提交
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBManager.close(connection, ps);
		}
		return cartModel;
	}

	public boolean isExistShopCartItem(int merchandise, int cart) {
		Connection connection = null;
		PreparedStatement ps = null;
		connection = DBManager.getConnection();
		String sql = "select merchandise from cartselectedmer where merchandise=? and cart=?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, merchandise);
			ps.setInt(2, cart);
			ResultSet set = ps.executeQuery();
			if (set.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(connection, ps);
		}

		return false;
	}
    /**
     * 更新购物车详情信息
     * @param merchandise 商品编号id
     * @param cart 购物车
     * @return
     */
	public boolean updateCartselectedMer(int merchandise, int cart) {
		Connection connection = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		connection = DBManager.getConnection();
		String sql = "update cartselectedmer set number=number+1,money=money+price where merchandise=? and cart=?";
		String sql2 = "update cart set money = ( select sum(money) from cartselectedmer where cart = ? ) " 
		              + " where id=?";
		try {
			// 事务
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			ps.setInt(1, merchandise);
			ps.setInt(2, cart);
			//更新购物详情
			ps.executeUpdate();
			
			ps2 = connection.prepareStatement(sql2);
			ps2.setInt(1, cart);
			ps2.setInt(2, cart);
			//更新购物车money
			ps2.executeUpdate();
			
			connection.commit();// 手动提交
			return true;
			
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBManager.close(connection, ps);
		}
		return false;
	}
	public boolean updateCartselectedMer(int itemId, int cart,int num) {
		Connection connection = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		connection = DBManager.getConnection();
		String sql = "update cartselectedmer set number=?,money=price*? where id=?";
		String sql2 = "update cart set money = ( select sum(money) from cartselectedmer where cart = ? ) " 
				+ " where id=?";
		try {
			// 事务
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			ps.setInt(1, num);
			ps.setInt(2, num);
			ps.setInt(3, itemId);
			//更新购物详情
			ps.executeUpdate();
			
			ps2 = connection.prepareStatement(sql2);
			ps2.setInt(1, cart);
			ps2.setInt(2, cart);
			//更新购物车money
			ps2.executeUpdate();
			connection.commit();// 手动提交
			return true;
			
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBManager.close(connection, ps);
		}
		return false;
	}

	public List<CartSelectedMerVO> getShopCartItemList(int cart) {
		List<CartSelectedMerVO> cartSelectedMerList = new ArrayList<CartSelectedMerVO>();
		Connection connection = null;
		PreparedStatement ps = null;
		connection = DBManager.getConnection();
		String sql = "select c.ID id,m.MerName merName,m.Price merPrice,c.Price price,c.Number number,c.Money money "
				+ " from merchandise m,cartselectedmer c where m.ID=c.Merchandise and c.Cart=?";
		try {
	
			ps = connection.prepareStatement(sql);
			ps.setInt(1, cart);
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				CartSelectedMerVO cartSelectedMerVO = new CartSelectedMerVO(set.getInt("id"), set.getString("merName"),
						set.getDouble("merPrice"), set.getDouble("price"), set.getInt("number"),
						set.getDouble("money"));
				
				cartSelectedMerList.add(cartSelectedMerVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(connection, ps);
		}
		return cartSelectedMerList;
	}

	public boolean deleteShopCartByItemId(int id,int cart) {
		Connection connection = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		connection = DBManager.getConnection();
		String sql = "delete from cartselectedmer where id=?";
		String sql2 = "update cart set money = ( select sum(money) from cartselectedmer where cart = ? ) " 
	              + " where id=?";
		try {
			// 事务
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			//更新购物详情
			ps.executeUpdate();
			
			ps2 = connection.prepareStatement(sql2);
			ps2.setInt(1, cart);
			ps2.setInt(2, cart);
			//更新购物车money
			ps2.executeUpdate();
			
			connection.commit();// 手动提交
			return true;
			
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBManager.close(connection, ps);
		}
		return false;
	}

}
