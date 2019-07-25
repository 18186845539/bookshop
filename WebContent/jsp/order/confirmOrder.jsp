<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/css/Demo.css">
<script src="<%=request.getContextPath() %>/js/index.js"></script>
<script src="<%=request.getContextPath() %>/js/Ajax.js"></script>
<script src="<%=request.getContextPath() %>/js/cart.js"></script>
</head>
<body>
	<div class="container"style="height: 600px;">
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
					<td class="C_Carbg_Current">确认订单信息</td>
					<td><img height="39" src="<%=request.getContextPath() %>/img/Car_15.gif" width="1" /></td>
					<td valign="middle"><img hspace="5" src="<%=request.getContextPath() %>/img/Car_11.gif" /></td>
					<td class="C_Carbg_Default">订单提交成功</td>
					<td><img height="39" src="<%=request.getContextPath() %>/img/Car_15.gif" width="1" /></td>
				</tr>
			</table>
			<table cellspacing="1" cellpadding="0" width="94%" border="0"
				bgcolor="#F7F3F7">
				<tr>
					<td>
						<form name="form1" action="cart.do?method=submitOrder"
							method="post" style="margin: 0px;">
							<table width="100%" border="0" cellpadding="0" cellspacing="1"
								bgcolor="#FFFFFF">
								<tr bgcolor="#F7F3F7" class="text">
									<td width="260" height="26" align="right">会员级别：</td>
									<td>&nbsp;${sessionScope.userInfo.levelName }</td>
								</tr>
								<tr bgcolor="#F7F3F7" class="text">
									<td width="260" height="26" align="right">会员优惠：</td>
									<td>&nbsp;${sessionScope.userInfo.favourable/10 }折</td>
								</tr>
								<tr bgcolor="#F7F3F7" class="text">
									<td width="260" height="26" align="right">收货人姓名：</td>
									<td>&nbsp;<input type="text" name="memName" id="memName"
										class="textBox" size="40" value="${sessionScope.userInfo.memberName }"></td>
								</tr>
								<tr bgcolor="#F7F3F7" class="text">
									<td width="260" height="26" align="right">收货人联系电话：</td>
									<td>&nbsp;<input type="text" name="phone" id="phone"
										class="textBox" size="40" value="${sessionScope.userInfo.phone }"></td>
								</tr>
								<tr bgcolor="#F7F3F7" class="text">
									<td width="260" height="26" align="right">收货人邮编：</td>
									<td>&nbsp;<input type="text" name="zip" id="zip"
										class="textBox" size="40" value="${sessionScope.userInfo.zip }"></td>
								</tr>
								<tr bgcolor="#F7F3F7" class="text">
									<td width="260" height="26" align="right">收货人详细地址：</td>
									<td>&nbsp;<input type="text" name="address" id="address"
										class="textBox" size="40" value="${sessionScope.userInfo.address }"></td>
								</tr>
							</table>
						</form>
					</td>
				</tr>
				<tr height="20">
					<td></td>
				</tr>
				<tr align="center">
					<td><img style="CURSOR: hand" onclick="JavaScript:location.href='cartQuery.jsp'"
						src="<%=request.getContextPath() %>/img/Car_icon_back.gif" border="0" /> <img
						src="<%=request.getContextPath() %>/img/Car_icon_06.gif" width="137" height="40" border="0"
						style="CURSOR: hand" onclick="JavaScript:location.href='${pageContext.request.contextPath}/member?method=submitOrder'" /></td>
				</tr>
				<tr height="20">
					<td></td>
				</tr>
				<tr height="20">
					<td></td>
				</tr>

			</table>
		<%@include file="/jsp/comm/footer.jsp" %>
		</div>
		</div>
</body>
</html>