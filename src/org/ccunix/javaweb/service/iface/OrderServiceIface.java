package org.ccunix.javaweb.service.iface;

import java.util.List;

import org.ccunix.javaweb.model.CartSelectedMerModel;
import org.ccunix.javaweb.model.OrderModel;
import org.ccunix.javaweb.vo.OrderVO;

public interface OrderServiceIface {
	/**
	 * 提交订单
	 * @param memberId 会员id
	 * @param cartId 购物车id
	 * @return true成功  false失败
	 */
	public boolean submitOrder(int memberId,int cartId);
	/**
	 * 查看订单信息
	 * @param member
	 * @return
	 */
	public List<OrderVO> getOrderList(int member);
	/**
	 * 删除订单
	 * @param orderId
	 * @return
	 */
	public boolean deleteOrder(int orderId);
	
	/**
	 * 根据购物车查找订单
	 * @param cart
	 * @return
	 */
	public OrderVO getOrdersByCart(int cart);
	/**
	 * 根据会员获得订单集合信息 
	 * @param id
	 * @return
	 */
	public List<OrderModel> getOrdersByMember(int member);
	/**
	 * 根据购物车或者订单号  查询订单详情
	 * @param parseInt
	 * @return
	 */
	public List<CartSelectedMerModel> getOrdersListByCart(int cart);
	/**
	 * 根据订单id查询订单信息
	 * @param orderId
	 * @return
	 */
	public OrderModel getOrdersById(String orderId);
	
}
