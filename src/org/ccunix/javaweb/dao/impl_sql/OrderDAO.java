package org.ccunix.javaweb.dao.impl_sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.ccunix.javaweb.dao.iface.OrderDAO_Iface;
import org.ccunix.javaweb.model.CartSelectedMerModel;
import org.ccunix.javaweb.model.OrderModel;
import org.ccunix.javaweb.util.DBManager;
import org.ccunix.javaweb.vo.OrderVO;

public class OrderDAO implements OrderDAO_Iface{

	public boolean submitOrder(int memberId, int cartId, String orderNo, String orderDate) {
		Connection connection = null;
		PreparedStatement ps = null;
		connection = DBManager.getConnection();
		String sql = "insert into orders (member,cart,orderNo,orderDate,orderStatus) values (?,?,?,?,?)";
		String sql2 = "update cart set cartStatus=1 where id=?";
		try {
			// 启动事务
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			ps.setInt(1, memberId);
			ps.setInt(2, cartId);
			ps.setString(3, orderNo);
			ps.setString(4, orderDate);
			ps.setInt(5, 1);
			int row1 = ps.executeUpdate();

			ps = connection.prepareStatement(sql2);
			ps.setInt(1, cartId);
			int row2 = ps.executeUpdate();

			if (row1 > 0 && row2 > 0) {
				connection.commit();
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
		}
		return false;
	}

	public List<OrderVO> getOrderList(int member) {
		return null;
	}

	public boolean deleteOrder(int orderId) {
		return false;
	}

	public OrderVO getOrdersByCart(int cart) {
		OrderVO orderVO = null;
		Connection connection = null;
		PreparedStatement ps = null;
		connection = DBManager.getConnection();
		String sql = "select orders.id,orders.member,cart,orderNo,orderDate,orderStatus,cart.money from orders,cart"
				+ " where orders.cart=cart.id and cart.id=?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, cart);
			ResultSet set = ps.executeQuery();
			if (set.next()) {
				orderVO = new OrderVO(set.getInt("id"), set.getInt("member"), set.getInt("cart"),
						set.getString("orderNo"), set.getString("orderDate"), set.getInt("orderStatus"),
						set.getDouble("money"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return orderVO;
	}

	@Override
	public List<OrderModel> getOrdersByMember(int member) {
		
		return null;
	}

	@Override
	public List<CartSelectedMerModel> getOrdersListByCart(int cart) {

		return null;
	}

	@Override
	public OrderModel getOrdersById(String orderId) {
		
		return null;
	}

}
