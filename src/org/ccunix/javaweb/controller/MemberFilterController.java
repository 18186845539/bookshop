package org.ccunix.javaweb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ccunix.javaweb.model.CartModel;
import org.ccunix.javaweb.model.CartSelectedMerModel;
import org.ccunix.javaweb.model.OrderModel;
import org.ccunix.javaweb.service.iface.OrderServiceIface;
import org.ccunix.javaweb.service.iface.ShopCarServiceIface;
import org.ccunix.javaweb.service.impl.OrderServiceImpl;
import org.ccunix.javaweb.service.impl.ShopCarServiceImpl;
import org.ccunix.javaweb.vo.CartSelectedMerVO;
import org.ccunix.javaweb.vo.MemberVO;
@WebServlet("/queryFilter/manager")
public class MemberFilterController extends HttpServlet{
	private ShopCarServiceIface shopCarServiceIface = new ShopCarServiceImpl(); 
	private OrderServiceIface orderServiceIface = new OrderServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		System.out.println(method);
		if("addCart".equals(method)) {
			addCart(req, resp);
		}else if("queryCart".equals(method)) {
			queryCart(req, resp);
		}else if("delCart".equals(method)) {
			delCart(req, resp);
		}else if("updateCart".equals(method)) {
			updateCart(req, resp);
		}else if("ordersQuery".equals(method)) {
			ordersQuery(req, resp);
		}else if("querySelectedMer".equals(method)) {
			querySelectedMer(req, resp);
		}
	}
	public void querySelectedMer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cart = req.getParameter("cart");
		String orderId = req.getParameter("orderId");
		List<CartSelectedMerModel> cartSelectedMerList =  orderServiceIface.getOrdersListByCart(Integer.parseInt(cart));
		
		OrderModel orderModel = orderServiceIface.getOrdersById(orderId);
		
		req.setAttribute("cartSelectedMerList", cartSelectedMerList);
		req.setAttribute("orderModel", orderModel);
		req.getRequestDispatcher("/jsp/order/checkOrder.jsp").forward(req, resp);
	}
	/**
	 * 订单管理
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void ordersQuery(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		MemberVO memberVO = (MemberVO) session.getAttribute("userInfo");
		List<OrderModel> orderList = orderServiceIface.getOrdersByMember(memberVO.getId());
		
		req.setAttribute("orderList", orderList);
		
		req.getRequestDispatcher("/jsp/order/orderManager.jsp").forward(req, resp);
	}
	public void updateCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String strId = req.getParameter("id");
		String strNum = req.getParameter("num");
		System.out.println("要更新的商品项id是:"+strId+",更新的数量是:"+strNum);
		int itemId = Integer.parseInt(strId);
		int num = Integer.parseInt(strNum);
		HttpSession session = req.getSession(false);
		CartModel cartModel = (CartModel) session.getAttribute("cartModel");
		shopCarServiceIface.updateCartselected(itemId, cartModel.getId(), num);
		
		//查看是否存在购物车   会员的id   cartstatus = 0
		MemberVO memberVO = (MemberVO) session.getAttribute("userInfo");
		CartModel updateCartModel = shopCarServiceIface.isShopCartItemExistId(memberVO.getId());	
		session.setAttribute("cartModel", updateCartModel);
		queryCart(req, resp);
		
	}
	public void delCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String strId = req.getParameter("id");
		System.out.println("要删除的商品项id是:"+strId);
		int id = Integer.parseInt(strId);
		//拿到购物车的信息
		HttpSession session = req.getSession(false);
		CartModel cartModel = (CartModel) session.getAttribute("cartModel");
		shopCarServiceIface.deleteShopCartByItemId(id, cartModel.getId());
		
		//查看是否存在购物车   会员的id   cartstatus = 0
		MemberVO memberVO = (MemberVO) session.getAttribute("userInfo");
		CartModel updateCartModel = shopCarServiceIface.isShopCartItemExistId(memberVO.getId());	
		session.setAttribute("cartModel", updateCartModel);
		queryCart(req, resp);
	}
	/**
	 * 查询购物车详情
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void queryCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		CartModel cartModel = (CartModel) session.getAttribute("cartModel");
		//查询  根据购物车id查询
		List<CartSelectedMerVO> cartSelectedMerList = shopCarServiceIface.getShopCartItemList(cartModel.getId());
		//绑定在request上
		req.setAttribute("cartSelectedMerList", cartSelectedMerList);
		req.getRequestDispatcher("/jsp/cart/shopCartShow.jsp").forward(req, resp);
	}
	/**
	 * 添加购物控制器
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String strPrice = req.getParameter("price");
		if(id!=null && strPrice!=null) {
			int merchandise = Integer.parseInt(id);
			double price = Double.parseDouble(strPrice);
			//判断购物车详情中  是否存在该商品   存在   更新操作   不存在  插入操作
			//在session中去取购物车
			HttpSession session = req.getSession(false);
			if(session!=null && session.getAttribute("cartModel")!=null) {
				CartModel cartModel = (CartModel) session.getAttribute("cartModel");
				boolean s = shopCarServiceIface.isExistShopCartItem(merchandise,cartModel.getId());
				//获得用户信息   打折信息
				MemberVO memberVO = (MemberVO) session.getAttribute("userInfo");
				
				if(s) {
					//有  更新
					boolean s1 =  shopCarServiceIface.updateCartselected(merchandise,cartModel.getId());
					
				}else {
					//不存在    插入
					shopCarServiceIface.addShopCartItem(cartModel.getId(), merchandise, price,memberVO.getFavourable());
				}
				//查询  根据购物车id查询
				List<CartSelectedMerVO> cartSelectedMerList = shopCarServiceIface.getShopCartItemList(cartModel.getId());
				//查询一下购物车信息 
				//查看是否存在购物车   会员的id   cartstatus = 0
     			CartModel updateCartModel = shopCarServiceIface.isShopCartItemExistId(memberVO.getId());	
     			session.setAttribute("cartModel", updateCartModel);
				//绑定在request上
				req.setAttribute("cartSelectedMerList", cartSelectedMerList);
				req.getRequestDispatcher("/jsp/cart/shopCartShow.jsp").forward(req, resp);
				
			}
		}else {
			//输入有序
		}
	}

}
