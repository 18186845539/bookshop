<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/css/Demo.css">
</head>
<body>
	<div class="container">
		 <%@include file="/jsp/comm/header.jsp" %>
         <div class="X_center">
         <div class="X_center01"> <img alt="" src="img/icon_goods.gif"> </div>
         <div class="X_center02"><img alt="" src="<%=request.getContextPath() %>/${requestScope.merchandiseVO.picture }" align="left">
	         <font style="font-size: 15px;">
	         &nbsp;商品类别：${requestScope.merchandiseVO.categroyName }<br>
			 &nbsp;商品名称：${requestScope.merchandiseVO.mername }<br>
			 &nbsp;商品型号：${requestScope.merchandiseVO.mermodel }<br>
			 &nbsp;市场价：￥${requestScope.merchandiseVO.price }<br>
			 <c:if test="${requestScope.merchandiseVO.special == 1}">				
			      &nbsp;特  价：￥${requestScope.merchandiseVO.sprice }<br>
			 </c:if>
			 &nbsp;生产厂家：${requestScope.merchandiseVO.manufacturer }<br>
			 &nbsp;出厂日期：${requestScope.merchandiseVO.leavefactorydate }<br>
			 &nbsp;商品描述：${requestScope.merchandiseVO.merdesc }<br>
			 </font>
         </div>
         	<center>
				<button
					style="background-image: url('img/icon_buy.gif'); width: 62px; height: 25px;" onclick="location.href='GouWuCar.html'"></button>
			</center>
         </div>		
		 <%@include file="/jsp/comm/footer.jsp" %>
	</div>
</body>
</html>