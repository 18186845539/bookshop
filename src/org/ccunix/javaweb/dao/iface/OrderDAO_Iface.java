package org.ccunix.javaweb.dao.iface;

import java.util.List;

import org.ccunix.javaweb.model.CartSelectedMerModel;
import org.ccunix.javaweb.model.OrderModel;
import org.ccunix.javaweb.vo.OrderVO;

public interface OrderDAO_Iface {
    /**
     * 提交订单
     * @param memberId
     * @param cartId
     * @param orderNo
     * @param orderDate
     * @return
     */
	public boolean submitOrder(int memberId, int cartId, String orderNo, String orderDate);
	public List<OrderVO> getOrderList(int member);
	public boolean deleteOrder(int orderId);
	public OrderVO getOrdersByCart(int cart);
	public List<OrderModel> getOrdersByMember(int member);
	public List<CartSelectedMerModel> getOrdersListByCart(int cart);
	public OrderModel getOrdersById(String orderId);
}
