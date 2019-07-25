package org.ccunix.javaweb.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ccunix.javaweb.service.iface.UsersServiceIface;
import org.ccunix.javaweb.service.impl.UsersServiceImpl;
import org.ccunix.javaweb.util.CharacterUtil;

public class UserRegeditServlet extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//解决了post传输乱码
		//request.setCharacterEncoding("UTF-8");
		System.out.println("注册........................");
		//就是用get提交
		request.getParameter("");//拿的是通过name 取值  单值
		
		String[] hobbys = request.getParameterValues("hobby");
		String hobby="";
		for(String h:hobbys){
			System.out.println("爱好是:"+CharacterUtil.parseString(h, "ISO-8859-1", "UTF-8"));
			hobby = hobby+CharacterUtil.parseString(h, "ISO-8859-1", "UTF-8")+",";
		}
		
		//调用service层
		UsersServiceIface usersServiceIface = new UsersServiceImpl();
		String username = "bobo";
		String password="123456";
		String sex="123456";
		int age=30;
		boolean b;
		try {
			b = usersServiceIface.regedit(username, password, sex, hobby, age,"");
			if(b){
				System.out.println("成功页面");
			}else{
				System.out.println("失败页面");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
