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
import org.ccunix.javaweb.model.CastPageModel;
import org.ccunix.javaweb.model.CategoryModel;
import org.ccunix.javaweb.service.iface.MemberServiceIface;
import org.ccunix.javaweb.service.iface.MerchandiseServiceIface;
import org.ccunix.javaweb.service.iface.OrderServiceIface;
import org.ccunix.javaweb.service.iface.ShopCarServiceIface;
import org.ccunix.javaweb.service.impl.MemberServiceImpl;
import org.ccunix.javaweb.service.impl.MerchandiseServiceImpl;
import org.ccunix.javaweb.service.impl.OrderServiceImpl;
import org.ccunix.javaweb.service.impl.ShopCarServiceImpl;
import org.ccunix.javaweb.vo.CartSelectedMerVO;
import org.ccunix.javaweb.vo.MemberVO;
import org.ccunix.javaweb.vo.MerchandiseVO;
import org.ccunix.javaweb.vo.OrderVO;

@WebServlet("/member")
public class MemberServletController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MemberServiceIface memberServiceIface = new MemberServiceImpl();
	private MerchandiseServiceIface merchandiseServiceIface = new MerchandiseServiceImpl();
	private ShopCarServiceIface shopCarServiceIface = new ShopCarServiceImpl();
	private OrderServiceIface orderServiceIface = new OrderServiceImpl();

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		System.out.println(method);
		if ("doUserLogin".equals(method)) {
			login(req, resp);
		} else if ("update".equals(method)) {
			update(req, resp);
		} else if ("memberLogOut".equals(method)) {
			logOut(req, resp);
		} else if ("browseIndexMer".equals(method)) {
			browseIndexMer(req, resp);
		} else if ("browseSMer".equals(method)) {
			browseSMer(req, resp);
		} else if ("browseMer".equals(method)) {
			browseMer(req, resp);
		} else if ("showMer".equals(method)) {
			showMer(req, resp);
		} else if ("searchMer".equals(method)) {
			searchMer(req, resp);
		} else if ("submitOrder".equals(method)) {
			submitOrder(req, resp);
		} else if ("logOut".equals(method)) {
			logOut(req, resp);
		}

	}

	/**
	 * 提交订单控制器
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void submitOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		//用户的id
		MemberVO memberVO = (MemberVO) session.getAttribute("userInfo");
		//购物车信息
		CartModel cartModel = (CartModel) session.getAttribute("cartModel");
		
		boolean b = orderServiceIface.submitOrder(memberVO.getId(), cartModel.getId());
		if(b) {	
			//在新建一个购物车
			shopCarServiceIface.addShopCar(memberVO.getId(), 0);
			//把创建的购物车查出来
			CartModel cartModel2 = shopCarServiceIface.isShopCartItemExistId(memberVO.getId());
			//保存到session中
			session.setAttribute("cartModel", cartModel2);
			//查询一下刚才提交的订单
			OrderVO orderVO =  orderServiceIface.getOrdersByCart(cartModel.getId());
			session.setAttribute("orderVO", orderVO);
			req.getRequestDispatcher("/jsp/order/orderSubmit.jsp").forward(req, resp);
		}else {
			
		}
	}

	/**
	 * 按照关键字和商品类别 搜索商品信息
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	public void searchMer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获得数据
		// String
		String likeName = req.getParameter("likeName");// null
		String cateid = req.getParameter("cateid");
		// 商品集合
		List<MerchandiseVO> merList = null;
		if (likeName == null) {
			// 就按照商品cateid进行查询
			System.out.println("就是按照商品类别查询信息......................");
			merList = merchandiseServiceIface.getMerchandiseListByCategory(Integer.parseInt(cateid));
		} else {
			// 商品集合
			System.out.println("就是按照商品类别和商品名称匹配查询信息------------------");
			merList = merchandiseServiceIface.getMerchandiseListByLikeName(Integer.parseInt(cateid), likeName);
		}

		String nowPage = req.getParameter("nowPage");
		// 绑定分页
		CastPageModel castPageModel = null;
		if (nowPage == null) {
			// 刚进入 查询首页 1
			// 绑定分页
			castPageModel = new CastPageModel(merList, 1);
		} else {
			// upPage nextPage
			castPageModel = new CastPageModel(merList, Integer.parseInt(nowPage));
		}
		// 重新组装数据
		castPageModel.setCurrentDataInfo();
		// 封装到request域中
		req.setAttribute("castPageModel", castPageModel);
		// 把分类信息绑定在request
		req.setAttribute("cateid", cateid);
		// 商品类别集合
		List<CategoryModel> cateList = merchandiseServiceIface.getMerCategoryList();
		req.setAttribute("cateList", cateList);
		// 跳转到商品浏览页面
		req.getRequestDispatcher("/jsp/goods/merchanddiseSearchByCateid.jsp").forward(req, resp);
	}

	/**
	 * 按照商品id查看商品
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	public void showMer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获得商品id
		String str_id = req.getParameter("id");
		int id = 0;
		if (str_id != null) {
			id = Integer.parseInt(str_id);
			MerchandiseVO merchandiseVO = merchandiseServiceIface.getMerchandise(id);
			req.setAttribute("merchandiseVO", merchandiseVO);
			// 跳转 商品显示界面
			req.getRequestDispatcher("/jsp/goods/merchandiseShowById.jsp").forward(req, resp);
		}

	}

	/**
	 * 浏览特价产品
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void browseSMer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 特价商品集合
		List<MerchandiseVO> specialMerList = merchandiseServiceIface.getMerchandiseListBySpecial(1);
		String nowPage = req.getParameter("nowPage");
		// 绑定分页
		CastPageModel castPageModel = null;
		if (nowPage == null) {
			// 刚进入 查询首页 1
			// 绑定分页
			castPageModel = new CastPageModel(specialMerList, 1);
		} else {
			// upPage nextPage
			castPageModel = new CastPageModel(specialMerList, Integer.parseInt(nowPage));
		}
		// 重新组装数据
		castPageModel.setCurrentDataInfo();
		// 封装到request域中
		req.setAttribute("castPageModel", castPageModel);
		req.setAttribute("special", 1);// 特价
		// 跳转到商品浏览页面
		req.getRequestDispatcher("/jsp/goods/merchanddiseShowS.jsp").forward(req, resp);
	}

	/**
	 * 浏览新品
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void browseMer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 新品商品集合
		List<MerchandiseVO> specialMerList = merchandiseServiceIface.getMerchandiseListBySpecial(0);
		String nowPage = req.getParameter("nowPage");
		// 绑定分页
		CastPageModel castPageModel = null;
		if (nowPage == null) {
			// 刚进入 查询首页 1
			// 绑定分页
			castPageModel = new CastPageModel(specialMerList, 1);
		} else {
			// upPage nextPage
			castPageModel = new CastPageModel(specialMerList, Integer.parseInt(nowPage));
		}
		// 重新组装数据
		castPageModel.setCurrentDataInfo();
		// 封装到request域中
		req.setAttribute("castPageModel", castPageModel);
		req.setAttribute("special", 0);// 新品
		// 跳转到商品浏览页面
		req.getRequestDispatcher("/jsp/goods/merchanddiseShowS.jsp").forward(req, resp);
	}

	/**
	 * 用户浏览主页初始化数据
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	public void browseIndexMer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 特价商品集合
		List<MerchandiseVO> specialMerList = merchandiseServiceIface.getMerchandiseListBySpecial(1);
		// 新品商品集合
		List<MerchandiseVO> notSpecialMerList = merchandiseServiceIface.getMerchandiseListBySpecial(0);
		// 商品类别集合
		List<CategoryModel> cateList = merchandiseServiceIface.getMerCategoryList();

		// 封装到request域中
		req.setAttribute("specialMerList", specialMerList);
		req.setAttribute("notSpecialMerList", notSpecialMerList);
		req.setAttribute("cateList", cateList);
		req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
	}

	/**
	 * 用户登陆过程
	 * 
	 * @param req
	 * @param resp
	 */
	public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String loginName = req.getParameter("username");
		String loginPwd = req.getParameter("password");
		MemberVO memberModel = memberServiceIface.loginValidate(loginName, loginPwd);

		if (memberModel == null) {
			// 登陆失败
		} else {
			// 登陆成功
			// 查看是否存在购物车 会员的id cartstatus = 0
			CartModel cartModel = shopCarServiceIface.isShopCartItemExistId(memberModel.getId());
			if (cartModel == null) {
				// 没有车 建立一个车
				shopCarServiceIface.addShopCar(memberModel.getId(), 0);
				cartModel = shopCarServiceIface.isShopCartItemExistId(memberModel.getId());
			}

			HttpSession session = req.getSession(true);
			session.setAttribute("userInfo", memberModel);
			session.setAttribute("cartModel", cartModel);
			// 购物车绑定上
			req.getRequestDispatcher("/member?method=browseIndexMer").forward(req, resp);
		}

	}

	public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id").trim());
		int memberLevel = Integer.parseInt(req.getParameter("memberLevel").trim());
		String memberName = req.getParameter("memberName");
		String loginName = req.getParameter("loginName");
		String loginPwd = req.getParameter("loginPwd");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		String zip = req.getParameter("zip");
		String email = req.getParameter("email");

		boolean b = memberServiceIface.update(id, memberLevel, memberName, loginName, loginPwd, phone, address, zip,
				email);
		if (b) {
			resp.getWriter().println("success");
		} else {
			resp.getWriter().println("error");
		}

	}

	public void logOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		session.invalidate();
		req.getRequestDispatcher("/member?method=browseIndexMer").forward(req, resp);
	}
}
