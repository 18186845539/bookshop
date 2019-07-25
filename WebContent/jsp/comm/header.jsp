<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    $(function(){
    	$("#searchMer").click(function(){
    		 var cateid = $("#category").val();
    		 var likeName = $("#qKey").val();
    		 alert(likeName+","+cateid);
    		 location.href="${pageContext.request.contextPath}/member?method=searchMer&cateid="+cateid+"&likeName="+likeName;
    	});
        //下拉菜单选中方法 
    	if("${requestScope.cateid}"!=''){
    		$("#category").val("${requestScope.cateid}");
    	}else{
    		$("#category").val("0");
    	}
    })
</script>
<div class="head">
	<img alt="" src="<%=request.getContextPath() %>/img/s.png">
	<div class="div1">
		<table>
			<tr>
				<td><input id="qKey" name="qKey" value="商品关键字"></td>
				<td><select id="category">
						<option value="0">所有商品</option>
						<c:forEach items="${requestScope.cateList}" var="cate">
						     <option value="${cate.id }">${cate.cateName }</option>
						</c:forEach>
				    </select>
				</td>
				<td><button class="bu1" id="searchMer"></button></td>
			</tr>
		</table>
	</div>
</div>
<div class="menu">
	<img alt="" src="<%=request.getContextPath() %>/img/icon02.gif" class="img1">
	<div class="test">
		<ol>
			<li class="nav"><a href="${pageContext.request.contextPath}/member?method=browseIndexMer" class="nn">商城首页</a></li>
			<li class="nav"><a href="<%=request.getContextPath() %>/queryFilter/manager?method=queryCart" class="nn">购物车管理</a></li>
			<li class="nav"><a href="<%=request.getContextPath() %>/queryFilter/manager?method=ordersQuery" class="nn">订单管理</a></li>
			<li class="nav"><a href="${pageContext.request.contextPath}/leaveWord?method=browseIndexLeaveWord" class="nn">顾客留言</a></li>
			<li class="nav"><a href="<%=request.getContextPath() %>/queryFilter/updateMember" class="nn">修改注册资料</a></li>
		</ol>
	</div>
	<img alt="" src="<%=request.getContextPath() %>/img/icon07.gif" class="img2">
</div>
