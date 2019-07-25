package org.ccunix.javaweb.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/annocationTest001.do")
public class AnnocationTestServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse resp) throws ServletException, IOException {
  
		resp.setIntHeader("Refresh", 1);
		
        Date date = new Date();//当前时间
		System.out.println(date);
		//2018-09-10 14:38:10
		SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
		String str = sf.format(date);
		System.out.println(str);
		System.out.println("/annocationTest001.do测试......................");
		resp.setContentType("text/html; charset=UTF-8");
		resp.getWriter().println(str);
	}
	
	public void add() {
		
	}
}
