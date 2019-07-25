package org.ccunix.javaweb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ccunix.javaweb.model.CastPageModel;
import org.ccunix.javaweb.service.iface.LeavewordServiceIface;
import org.ccunix.javaweb.service.impl.LeavewordServiceImpl;
import org.ccunix.javaweb.vo.LeaveWordVO;
import org.ccunix.javaweb.vo.MemberVO;

@WebServlet(name = "myUserServlet", urlPatterns = "/leaveWord", loadOnStartup = 1, initParams = {
		@WebInitParam(name = "name", value = "小明"), @WebInitParam(name = "pwd", value = "123456") })
public class LeaveWordServletController extends HttpServlet {
	// 留言服务
	private LeavewordServiceIface leavewordServiceIface = new LeavewordServiceImpl();

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("config name==========" + config.getInitParameter("name"));
		System.out.println("config pwd==========" + config.getInitParameter("pwd"));
		super.init(config);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		System.out.println(method);
		if ("browseIndexLeaveWord".equals(method)) {
			browseIndexLeaveWord(req, resp);
		} else if ("submitLeaveWord".equals(method)) {
			submitLeaveWord(req, resp);
		}
	}

	/**
	 * 发表留言
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void submitLeaveWord(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		System.out.println(title+"\t"+content);
		//取session
		HttpSession session = req.getSession(false);
		if(session!=null && session.getAttribute("userInfo")!=null) {
			//调用
			MemberVO memberVO =(MemberVO)session.getAttribute("userInfo");
			int member = memberVO.getId();
			boolean b = leavewordServiceIface.addLeaveword(title, content,member);
			
			if(b) {
				resp.getWriter().println("success");
				//req.getRequestDispatcher("/leaveWord?method=browseIndexLeaveWord").forward(req, resp);
			}
		}else{
			resp.getWriter().println("error");
		}
		
	}

	/**
	 * 浏览留言
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	public void browseIndexLeaveWord(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 组装数据
		// 留言信箱
		List<LeaveWordVO> leaveWordList = leavewordServiceIface.getLeaveWordModelList();
		System.out.println("留言条数:" + leaveWordList.size());
		// 分页
		String nowPage = req.getParameter("nowPage");
		// 绑定分页
		CastPageModel castPageModel = null;
		if (nowPage == null) {
			// 刚进入 查询首页 1
			// 绑定分页
			castPageModel = new CastPageModel(leaveWordList, 1);
		} else {
			// upPage nextPage
			castPageModel = new CastPageModel(leaveWordList, Integer.parseInt(nowPage));
		}
		// 重新组装数据
		castPageModel.setCurrentDataInfo();

		req.setAttribute("castPageModel", castPageModel);
		// 跳转到留言主页
		req.getRequestDispatcher("/jsp/customerword/leavewordShow.jsp").forward(req, resp);
	}
}
