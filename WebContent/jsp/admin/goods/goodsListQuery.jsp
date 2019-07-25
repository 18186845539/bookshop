<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
   function jumpPage(){
	   var nowPage = document.getElementById("nowPage");
	   
	   //验证
	   
	   //正确的
	   alert(nowPage.value);
	   //js去调用资源
	   location.href="${pageContext.request.contextPath}/goodsServlet?method=doGoodsListQuery&nowPage="+nowPage.value;
   }
</script>
<body>

<div>
     <h2>商品列表</h2>
     <h3><a href="goodsAdd.jsp">添加商品</a></h3>
     <table border="1px" cellspacing="0">
         <tr>
            <th>序号</th>
            <th>商品编号</th>
            <th>商品名称</th>
            <th>价格</th>
            <th>库存</th>
            <th>描述</th>
            <th>图片展示</th>
            <th>操作1</th>
            <th>操作2</th>
         </tr>
        
         <c:forEach items="${requestScope.goodsList}" var="model" varStatus="status">
              <tr>
	            <td><c:out value="${status.index +1 }"></c:out> </td>
	            <td><c:out value="${model.gid }"></c:out></td>
	            <td><c:out value="${model.name }"></c:out></td>
	            <td><c:out value="${model.price }"></c:out></td>
	            <td><c:out value="${model.num }"></c:out></td>
	            <td><c:out value="${model.descs }"></c:out></td>
	            <td><c:out value="${model.img }"></c:out></td>
	            <td><a href="<%=request.getContextPath()%>/goodsServlet?method=deleteGoodsByGid&gid=${model.gid }">删除</a></td>
	            <td><a href="<%=request.getContextPath()%>/goodsServlet?method=queryGoodsByGid&gid=${model.gid }">修改</a></td>
	         </tr>
         </c:forEach>
         
        <tr>
           <td colspan="9" align="center">
                   <a href="<%=request.getContextPath() %>/goodsServlet?method=doGoodsListQuery&nowPage=${requestScope.castPageModel.upPage }">上一页  </a>
                                               总共${requestScope.castPageModel.totalPage }页  当前第${requestScope.castPageModel.nowPage }页 
                   <a href="<%=request.getContextPath() %>/goodsServlet?method=doGoodsListQuery&nowPage=${requestScope.castPageModel.nextPage }">下一页  </a>
                                               
                                               跳转<input type="text" name="nowPage" id="nowPage"> 页<button onclick="jumpPage()">确定</button>
           </td>
        </tr>
     </table>

</div>
</body>
</html>