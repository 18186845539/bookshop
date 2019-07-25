<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/css/Demo.css">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.3.1.min.js"></script>
<script src="<%=request.getContextPath() %>/js/index.js"></script>
<script src="<%=request.getContextPath() %>/js/Ajax.js"></script>
<script src="<%=request.getContextPath() %>/js/cart.js"></script>
</head>
<body>
	<div class="con3">
	    <%@include file="/jsp/comm/header.jsp" %>
		<div class="X_center">
			<div class="X_center01">
				<img alt="" src="<%=request.getContextPath() %>/img/icon_order.gif">
			</div>
			<table cellspacing="1" cellpadding="0" width="94%" border="0"
				bgcolor="#F7F3F7">
				<tr height="26">
					<td class="blackTitle" align="center">订单编号</td>
					<td class="blackTitle" align="center">金额</td>
					<td class="blackTitle" align="center">下单日期</td>
					<td class="blackTitle" align="center">订单状态</td>
					<td class="blackTitle" align="center">编 辑</td>
				</tr>
				<c:forEach items="${requestScope.orderList }" var="order">
				
					<tr align="center" bgcolor="#FFFFFF" id="del">
						<td id="del" style="font-size: 14px;">${order.orderNo } </td>
						<td id="del" style="font-size: 14px;color: red;">￥${order.cartModel.money }</td>
						<td id="del" style="font-size: 14px;">${order.orderDate } </td>
						<td id="del" style="font-size: 14px;">
						   <c:if test="${order.orderStatus eq 1}">
						                 已下单，未受理
						   </c:if>
						   <c:if test="${order.orderStatus eq 2}">
						                 已受理，发货中
						   </c:if>
						   <c:if test="${order.orderStatus eq 3}">
						                 订单已签收
						   </c:if>
						</td>
						<td id="del" class="blueText">
						<a href="${pageContext.request.contextPath}/queryFilter/manager?method=querySelectedMer&cart=${order.cartModel.id}&orderId=${order.id}">查看订单</a> &nbsp;
						<a href="JavaScript:delOneOrder(${ordersModel.id})">删除订单</a></td>
				
					</tr>
				
				</c:forEach>
				
				
				
				
				
			</table>
		</div>
		
		<%@include file="/jsp/comm/footer.jsp" %>
	
	</div>
</body>
</html>