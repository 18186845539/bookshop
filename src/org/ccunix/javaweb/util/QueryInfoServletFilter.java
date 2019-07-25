package org.ccunix.javaweb.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 过滤器
 * 实现Filter
 * @author Administrator
 *
 */
public class QueryInfoServletFilter  implements Filter{

	@Override
	public void destroy() {
		System.out.println("查询过滤器销毁.......................");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("查询执行过滤操作.....................");
		//在这里去处理 是否调用下一个匹配器  判断  符合条件的走
		//用户登陆信息  Session
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		//获得session
		HttpSession session = request.getSession(false);// 不能创建
		
		if(session!=null && session.getAttribute("userInfo")!=null) {
			//可以正常访问
			arg2.doFilter(req, resp);//通行
		}else {
			//限行
			request.getRequestDispatcher("/jsp/comm/logOut.jsp").forward(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("查询过滤器实例化........................");
	}

}
