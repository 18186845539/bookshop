package org.ccunix.javaweb.dao.impl_hibernate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.ccunix.javaweb.dao.iface.OrderDAO_Iface;
import org.ccunix.javaweb.model.CartModel;
import org.ccunix.javaweb.model.CartSelectedMerModel;
import org.ccunix.javaweb.model.MemberModel;
import org.ccunix.javaweb.model.OrderModel;
import org.ccunix.javaweb.util.DBManager;
import org.ccunix.javaweb.vo.OrderVO;
import org.hibernate.Query;
import org.hibernate.Session;

public class OrderDAO_Impl implements OrderDAO_Iface {

	public boolean submitOrder(int memberId, int cartId, String orderNo, String orderDate) {
		try {
			//获得session
			Session session = DBManager.getSession();
			//开启事务
			session.beginTransaction();
            //创建订单对象
			OrderModel orderModel = new OrderModel(orderNo, orderDate, 1);
            //通过get获得会员信息
			MemberModel memberModel = (MemberModel) session.get(MemberModel.class, memberId);
			//通过get获得购物车信息
			CartModel cartModel = (CartModel) session.get(CartModel.class, cartId);
            //对订单进行设置会员和购物车属性
			orderModel.setMemberModel(memberModel);
			orderModel.setCartModel(cartModel);
            //添加订单信息
			session.save(orderModel);
            //更改购物车状态
			cartModel.setCartStatus(1);
            //存到数据库  持久化
			session.update(cartModel);
			//数据库提交   session事务关闭
			session.getTransaction().commit();
            return true;			  
		} catch (Exception e) {
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

		Session session = DBManager.getSession();
		
		/*Query query = session.createQuery("From MemberModel where id=:id");
		query.setParameter("id", member);
		
		MemberModel memberModel =(MemberModel) query.uniqueResult();*/
		
		MemberModel memberModel =(MemberModel)session.get(MemberModel.class,member);
		
		List<OrderModel> orderList = new ArrayList<OrderModel>();
		
		Set<OrderModel> orderSet = memberModel.getOrdersSet();
		
		for (Iterator<OrderModel> iterator = orderSet.iterator(); iterator.hasNext();) {
			OrderModel orderModel = iterator.next();
			//加入到list中
			orderList.add(orderModel);
		}
		
		return orderList;
	}

	@Override
	public List<CartSelectedMerModel> getOrdersListByCart(int cart) {
		Session session = DBManager.getSession();
		CartModel cartModel =(CartModel) session.get(CartModel.class, cart);
		List<CartSelectedMerModel> cartSelectMerlist = new ArrayList<CartSelectedMerModel>();
		
		Set<CartSelectedMerModel> cartSelectMerSet = cartModel.getCartSelectedMerSet();
		
		for (Iterator<CartSelectedMerModel> iterator = cartSelectMerSet.iterator(); iterator.hasNext();) {
			CartSelectedMerModel cartSelectedMerModel = iterator.next();
			cartSelectMerlist.add(cartSelectedMerModel);
			
		}
		return cartSelectMerlist;
	}
	public static void main(String[] args) {
		/*List<OrderModel> orderList =  new OrderDAO_Impl().getOrdersByMember(19);
		
		for(OrderModel order:orderList) {
			System.out.println(order.getId()+"\t"+order.getCartModel().getMoney());
		}*/
		
		
		List<CartSelectedMerModel> cartSelectMerlist = new OrderDAO_Impl().getOrdersListByCart(25);
	    for(CartSelectedMerModel item:cartSelectMerlist) {
	    	System.out.println(item.getId());
	    }
	}

	@Override
	public OrderModel getOrdersById(String orderId) {
		Session session = DBManager.getSession();
		OrderModel orderModel =(OrderModel) session.get(OrderModel.class, orderId);
		return orderModel;
	}
}

