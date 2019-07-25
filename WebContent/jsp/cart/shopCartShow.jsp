<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/Demo.css">
<script type="text/javascript">
function modifyNum(id,num){
	//验证通过  是有效的数字  而且非空
	
	location.href="${pageContext.request.contextPath}/queryFilter/manager?method=updateCart&id="+id+"&num="+num;
}

function delCart(id){
	location.href="${pageContext.request.contextPath}/queryFilter/manager?method=delCart&id="+id;
}
</script>
</head>
<body>
	<div class="container">
		 <%@include file="/jsp/comm/header.jsp" %>
         <div class="X_center">
         <div class="X_center01"> <img alt="" src="${pageContext.request.contextPath}/img/icon_goods.gif"> </div>
	     <table cellspacing="0" cellpadding="0" border="0">
	            <tr valign="center">
	              <td><img hspace="5" src="${pageContext.request.contextPath}/img/Car_07.gif" /></td>
	              <td class="C_Carbg_Current">查看购物车物品</td>
	              <td><img height="39" src="${pageContext.request.contextPath}/img/Car_15.gif" width="1" /></td>
	              <td align="middle"><img hspace="5" src="${pageContext.request.contextPath}/img/Car_09.gif" /></td>
	              <td class="C_Carbg_Default">确认订单信息</td>
	              <td><img height="39" src="${pageContext.request.contextPath}/img/Car_15.gif" width="1" /></td>
	              <td align="middle"><img hspace="5" src="${pageContext.request.contextPath}/img/Car_11.gif" /></td>
	              <td class="C_Carbg_Default">订单提交成功</td>
	              <td><img height="39" src="${pageContext.request.contextPath}/img/Car_15.gif" width="1" /></td>
	            </tr>
	        </table>
			<table cellspacing="1" cellpadding="0" width="94%" border="0" bgcolor="#F7F3F7">
	              <tr height="26">
	                <td class="blackTitle" align="center">商品名称</td>
	                <td class="blackTitle" align="center">市场价</td>
	                <td class="blackTitle" align="center">会员价</td>
	                <td class="blackTitle" align="center">数量</td>
	                <td class="blackTitle" align="center">金额</td>
	                <td class="blackTitle" align="center">删除</td>
	              </tr>
	              <c:forEach items="${requestScope.cartSelectedMerList }" var="cartSelectedMer">
		               <tr class="text" align="center" bgcolor="#FFFFFF">
							<td>
								&nbsp;<a href="mer.do?method=showMer&id=15" target="_blank"> 
								  <span class="blueText">${cartSelectedMer.merName } </span>
								</a>					
							</td>
							<td>￥${cartSelectedMer.merPrice }</td>
							<td>￥<span id="price81">${cartSelectedMer.price }</span></td>
							<td><input type="text" class="textBox" onchange="modifyNum(${cartSelectedMer.id},this.value)" value="${cartSelectedMer.number }" size="4"/></td>
							<td>￥<span id="money81">${cartSelectedMer.money }</span></td>
							<td><input onClick="delCart(${cartSelectedMer.id })" type="image" src="${pageContext.request.contextPath}/img/delete_01.gif" border="0"/></td>
					   </tr>
	              </c:forEach>
	              <tr>
		              <td colspan="6" class="Order_Total" align="center"><img hspace="5" src="${pageContext.request.contextPath}/img/me03.gif" align="absmiddle" /> 
						总金额：￥<span id="totalMoney">${sessionScope.cartModel.money }</span>（不包括配送费用）		
					  </td>
	              </tr>				
	              			
	        </table>
       	    <div style="margin-left: 300px;">
	            <input type="image" src="${pageContext.request.contextPath}/img/Car_icon_01.gif" style="BORDER: 0px;WIDTH: 126px; HEIGHT: 39px;" onClick="clearCart()">
				<img style="CURSOR: hand;" onClick="location.href='gengDuo1.html';" src="${pageContext.request.contextPath}/img/Car_icon_02.gif" />
				<img src="${pageContext.request.contextPath}/img/Car_icon_03.gif" onClick="location.href='${pageContext.request.contextPath}/jsp/order/confirmOrder.jsp';" border="0" style="CURSOR: hand"/>
			</div>
         </div>		
		<%@include file="/jsp/comm/footer.jsp" %>
	</div>
</body>
</html>