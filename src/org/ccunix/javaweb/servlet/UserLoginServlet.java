package org.ccunix.javaweb.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.ccunix.javaweb.model.GoodsModel;
import org.ccunix.javaweb.model.UsersModel;
@WebServlet("/doLogin")
public class UserLoginServlet extends HttpServlet{
	
	public UserLoginServlet(){
		System.out.println("对象初始化..................");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("初始化init.........................");
		super.init();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String encoding = config.getInitParameter("encoding");
		System.out.println("字符编码是"+encoding);
		System.out.println("servlet中配置了信息  那么就封装ServletConfig");
		
		
		//config.getInitParameterNames();   拿到所有name值
		
		
		super.init(config);
	}
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("调用service.........................");
		super.service(arg0, arg1);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//post请求 调用这个方法
		System.out.println("do post...........................");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//在Cookie中去读取
		
		String isAutoLogin = req.getParameter("isAutoLogin");
		
		System.out.println(isAutoLogin);
		
		System.out.println("doget..........................");
		//前台来的请求  get
		////http://localhost:8080/javaweb20180820-1/doLogin?username=tom&password=123456
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		if("admin".equals(username) && "admin".equals(password)){
			//在session中存一个用户信息   正确的   session会话对象  打开浏览器的整个过程   一直关闭
			UsersModel model = new UsersModel();
			model.setUsername(username);
			model.setPassword(password);
			model.setLimits(1);//没有权限
			HttpSession session = req.getSession(true);//true代表 如果容器中  没有sesson对象  那么就创建session  false 如果容器中没有session就返回null 有就返回这个session对象
			//session.setAttribute("userInfo", model);
			//application  容器对象    打开tomcat  直到tomcat关闭
			
			ServletContext application =  req.getServletContext();
			session.setAttribute("userInfo", model);
			//跳转到正确页面
			//把数据存到一个地方
			ArrayList<GoodsModel> goodsModels = new ArrayList<GoodsModel>();
			goodsModels.add(new GoodsModel("1001", "Iphone4", "手机挺好1", 3000, "imgs/phone1.jpg"));
			goodsModels.add(new GoodsModel("1002", "Iphone4S", "手机挺好2", 3500, "imgs/phone2.jpg"));
			goodsModels.add(new GoodsModel("1001", "Iphone5", "手机挺好3", 4000, "imgs/phone3.jpg"));
			goodsModels.add(new GoodsModel("1001", "Iphone5S", "手机挺好4", 4500, "imgs/phone4.jpg"));
			goodsModels.add(new GoodsModel("1001", "Iphone8", "手机挺好5", 8000, "imgs/phone5.jpg"));
			
			//page 只在当前页面中有效   
			//request请求对象    当前页和转发过程中有效
			//session会话对象   浏览器只要不关闭   会话中的值  有效
			//application容器对象  只要tomcat不关闭  这个值  就有效
			
			//是否保存Cookie
			if(isAutoLogin!=null) {
				Cookie cookie_username = new Cookie("username", username);
				Cookie cookie_password = new Cookie("password", password);
				cookie_username.setPath("/");
				cookie_password.setPath("/");
				resp.addCookie(cookie_username);
				resp.addCookie(cookie_password);
			}
			
			req.setAttribute("goodsModels", goodsModels);
			
			//resp.sendRedirect("success.jsp");//重定向
			req.getRequestDispatcher("/jstl.jsp").forward(req, resp); //转发  服务器内部  做的一个转发
		}else{
			//跳转到错误页面
			resp.sendRedirect("error.html");//重定向
		}
		
		System.out.println("do get");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy.................................");
		super.destroy();
	}
}
