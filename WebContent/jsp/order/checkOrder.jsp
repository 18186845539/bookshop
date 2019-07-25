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
	<div class="container" style="height: 700px;">
	    <%@include file="/jsp/comm/header.jsp" %>
		<div class="X_center">
			<div class="X_center01">
				<img alt="" src="<%=request.getContextPath() %>/img/icon_goods.gif">
			</div>
			<table cellspacing="1" cellpadding="0" width="94%" border="0"
				bgcolor="#F7F3F7">
				<tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="1"
							bgcolor="#FFFFFF">
							<tr bgcolor="#F7F3F7" class="text">
								<td width="260" height="26" align="right">订单编号：</td>
								<td>&nbsp;${requestScope.}</td>
							</tr>
							<tr bgcolor="#F7F3F7" class="text">
								<td width="260" height="26" align="right">金额：</td>
								<td>&nbsp;￥50.0元</td>
							</tr>
							<tr bgcolor="#F7F3F7" class="text">
								<td width="260" height="26" align="right">下单日期：</td>
								<td>&nbsp;2018年05月31日 10:08:38</td>
							</tr>
							<tr bgcolor="#F7F3F7" class="text">
								<td width="260" height="26" align="right">会员级别：</td>
								<td>&nbsp;普通会员</td>
							</tr>
							<tr bgcolor="#F7F3F7" class="text">
								<td width="260" height="26" align="right">会员优惠：</td>
								<td>&nbsp;95折</td>
							</tr>
							<tr bgcolor="#F7F3F7" class="text">
								<td width="260" height="26" align="right">收货人姓名：</td>
								<td>&nbsp;steven</td>
								
							</tr>
							<tr bgcolor="#F7F3F7" class="text">
								<td width="260" height="26" align="right">收货人联系电话：</td>
								<td>&nbsp;13121612353</td>
							</tr>
							<tr bgcolor="#F7F3F7" class="text">
								<td width="260" height="26" align="right">收货人邮编：</td>
								<td>&nbsp;1000001</td>
							</tr>
							<tr bgcolor="#F7F3F7" class="text">
								<td width="260" height="26" align="right">收货人详细地址：</td>
								<td>&nbsp;我的家在东北</td>
							</tr>
						</table>
					</td>
				<tr>
				<td style="background-color: white;"height="30">
						<center>订 &nbsp;单 &nbsp;购 &nbsp;物 &nbsp;明 &nbsp;细 &nbsp;表</center>
				</td>
				</tr>
			</table>
				<table cellspacing="1" cellpadding="0" width="94%" border="0"
				bgcolor="#F7F3F7">
				<tr height="26">
					<td class="blackTitle" align="center">商品名称</td>
					<td class="blackTitle" align="center">市场价</td>
					<td class="blackTitle" align="center">会员价</td>
					<td class="blackTitle" align="center">数量</td>
					<td class="blackTitle" align="center">金额</td>
				</tr>
				<!-- <tr align="center" bgcolor="#FFFFFF">
                <td colspan="6" height="26" class="redText" style="font-size: 10px;color: red">对不起，您目前尚未选购任何商品！</td>
              </tr>	 -->
             
             <tr class="text" align="center" bgcolor="#FFFFFF" id="child">
					<td id="child">&nbsp;<a href="#"
						target="_blank"> <span class="blueText">管理是什么</span>
					</a>
					</td>
					<td id="child">￥56.0</td>
					<td id="child">￥<span id="price81">50.0</span></td>
					<td id="child">1</td>
					<td id="child">￥<span id="money81">50.0</span></td>
				</tr>
            
			</table>
			<table width="100%" border="0" cellpadding="0" cellspacing="1"
							bgcolor="#FFFFFF">
					<tr height="20">
					<td></td>
					</tr>
					<tr height="20">
					<td><center><a style="text-align: center;color: red;font-size: 14px;"  href=orderManager.html>返回</a></center></td>
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