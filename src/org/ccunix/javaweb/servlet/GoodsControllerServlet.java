package org.ccunix.javaweb.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ccunix.javaweb.model.CastPageModel;
import org.ccunix.javaweb.model.GoodsModel;
import org.ccunix.javaweb.service.iface.GoodsServiceIface;
import org.ccunix.javaweb.service.impl.GoodsServiceImpl;

public class GoodsControllerServlet extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//拿到处理的method
		String method = request.getParameter("method");
		//连接一下service
		GoodsServiceIface goodsServiceIface = new GoodsServiceImpl();
		
		if("doGoodsListQuery".equals(method)) {
			try {
				//原始数据
				List<GoodsModel> goodsList = goodsServiceIface.getGoodsList();
				
				String nowPage = request.getParameter("nowPage");
				//绑定分页
				CastPageModel castPageModel = null;
				if(nowPage==null) {
					//刚进入 查询首页  1
					//绑定分页
					castPageModel = new CastPageModel(goodsList, 1);
				}else {
					//upPage  nextPage
					castPageModel = new CastPageModel(goodsList,Integer.parseInt(nowPage));
				}
				
				
				//重新组装数据
				castPageModel.setCurrentDataInfo();
				
				System.out.println("数据行:"+goodsList.size());
				System.out.println("分页后的数据"+castPageModel.getCurrentDataList().size());
				request.setAttribute("castPageModel", castPageModel);
				
				//转发
				request.getRequestDispatcher("/goodsListQuery.jsp").forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("deleteGoodsByGid".equals(method)) {
			//按照gid删除商品 
			String gid = request.getParameter("gid");
			System.out.println("要商品的编号是:"+gid);
			try {
				boolean b = goodsServiceIface.deleteGoodsByGid(gid);
				if(b) {
					//转发
					//request.getRequestDispatcher("/goodsServlet?method=doGoodsListQuery").forward(request, response);
					//重定向
					response.sendRedirect("/javaweb20180825-1/goodsServlet?method=doGoodsListQuery");
				}else {
					response.getWriter().println("<font color='red'>delete error!!!!</font>");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("queryGoodsByGid".equals(method)) {
			//按照gid查询商品 
			String gid = request.getParameter("gid");
			System.out.println("要查询的编号是:"+gid);
			//查找商品信息
			//1件商品
			try {
				GoodsModel  goodsModel = goodsServiceIface.queryGoodsByGid(gid);
				if(goodsModel!=null) {
                    request.setAttribute("goodsModel", goodsModel);
					// 转发出去
					request.getRequestDispatcher("/goodsUpdateQuery.jsp").forward(request, response);
					
				}else {
					response.getWriter().println("<font color='red'>query error!!!!</font>");
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("updateGoodsByGid".equals(method)) {
			//进行更新
			String gid = request.getParameter("gid");
			String name = request.getParameter("name");
			String str_price = request.getParameter("price");
			String descs = request.getParameter("descs");
			String img = request.getParameter("img");
			
			System.out.println("商品修改 gid="+gid);
			System.out.println("商品修改 descs="+descs);
			
			double price = Double.parseDouble(str_price);
			try {
				boolean  b = goodsServiceIface.updateGoodsByGid(gid,name,price,descs,img);
				if(b) {
					//重定向
					response.sendRedirect("/javaweb20180825-1/goodsServlet?method=doGoodsListQuery");
				}else {
					response.getWriter().println("<font color='red'>upadate error!!!!</font>");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
	}
}
