package org.ccunix.javaweb.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.ccunix.javaweb.dao.iface.OrderDAO_Iface;
import org.ccunix.javaweb.dao.impl_hibernate.OrderDAO_Impl;
import org.ccunix.javaweb.model.CartSelectedMerModel;
import org.ccunix.javaweb.model.OrderModel;
import org.ccunix.javaweb.service.iface.OrderServiceIface;
import org.ccunix.javaweb.util.DateFormatUtil;
import org.ccunix.javaweb.util.Util;
import org.ccunix.javaweb.vo.OrderVO;

public class OrderServiceImpl implements OrderServiceIface{
    private OrderDAO_Iface orderDao = new OrderDAO_Impl();
	@Override
	public boolean submitOrder(int memberId, int cartId) {
		//uuid
		//String orderNo = UUID.randomUUID().toString();
		String orderNo = Util.getOrderNoByUUID();
		String orderDate = DateFormatUtil.getParseDate(new Date(), "yyyy-MM-dd HH:mm:ss");
		
		return orderDao.submitOrder(memberId, cartId,orderNo,orderDate);
	}

	@Override
	public List<OrderVO> getOrderList(int member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteOrder(int orderId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OrderVO getOrdersByCart(int cart) {
		
		return orderDao.getOrdersByCart(cart);
	}

	@Override
	public List<OrderModel> getOrdersByMember(int member) {
		
		return orderDao.getOrdersByMember(member);
	}

	@Override
	public List<CartSelectedMerModel> getOrdersListByCart(int cart) {
		
		return orderDao.getOrdersListByCart(cart);
	}

	@Override
	public OrderModel getOrdersById(String orderId) {
		
		return orderDao.getOrdersById(orderId);
	}

}
