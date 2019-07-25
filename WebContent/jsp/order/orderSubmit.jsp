<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/css/Demo.css">
<script src="<%=request.getContextPath() %>/js/index.js"></script>
</head>
<body>
	<div class="container" style="height: 600px;">
	   <%@include file="/jsp/comm/header.jsp" %>
	    
		<div class="X_center">
			<div class="X_center01">
				<img alt="" src="<%=request.getContextPath() %>/img/icon_goods.gif">
			</div>
			<table cellspacing="0" cellpadding="0" border="0">
				<tr valign="middle">
					<td><img hspace="5" src="<%=request.getContextPath() %>/img/Car_07.gif" /></td>
					<td class="C_Carbg_Default">查看购物车物品</td>
					<td><img height="39" src="<%=request.getContextPath() %>/img/Car_15.gif" width="1" /></td>
					<td valign="middle"><img hspace="5" src="<%=request.getContextPath() %>/img/Car_09.gif" /></td>
					<td class="C_Carbg_Default">确认订单信息</td>
					<td><img height="39" src="<%=request.getContextPath() %>/img/Car_15.gif" width="1" /></td>
					<td valign="middle"><img hspace="5" src="<%=request.getContextPath() %>/img/Car_11.gif" /></td>
					<td class="C_Carbg_Current">订单提交成功</td>
					<td><img height="39" src="<%=request.getContextPath() %>/img/Car_15.gif" width="1" /></td>
				</tr>
			</table>
			<div style="float: left;">
				<img width="100" height="100" style="padding: 50px; float: left;"
					alt="" src="<%=request.getContextPath() %>/img/Car_icon_10.gif">
			</div>
			<div style="float: left;">
				<table width="500px" border="0" height="170px;"
					style="margin-left: 10px;" cellpadding="1" cellspacing="0"
					bgcolor="#F7F3F7">
					<tr bgcolor="#F7F3F7" height="10" class="text">
						<td>恭喜您，订单提交成功</td>
					</tr>
					<tr bgcolor="#FFFFFF" height="3">
						<td></td>
					</tr>
					<tr bgcolor="#F7F3F7" height="10" class="text">
						<td>订单编号：${sessionScope.orderVO.orderNo }</td>
					</tr>
					<tr bgcolor="#FFFFFF" height="3" class="text">
						<td></td>
					</tr>
					<tr bgcolor="#F7F3F7" height="10" class="text">
						<td>总金额：￥${sessionScope.orderVO.money }</td>
					</tr>
					<tr bgcolor="#FFFFFF" height="3" class="text">
						<td></td>
					</tr>
					<tr bgcolor="#F7F3F7" height="10" class="text">
						<td>下单日期：${sessionScope.orderVO.orderDate}</td>
					</tr>
				</table>

			</div>

			<%@include file="/jsp/comm/footer.jsp" %>
		</div>
	</div>
</body>
</html>