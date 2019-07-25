<%@page import="org.ccunix.javaweb.vo.MemberVO"%>
<%@page import="org.ccunix.javaweb.model.MemberModel"%>
<%@page import="org.ccunix.javaweb.model.UsersModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎使用电子商城系统</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/Demo.css">
</head>
<script type="text/javascript">
function isNull(field, id) {
	var value = field.value;
	if (value == null || value == "") {
		document.getElementById(id).innerHTML = "空值";
		document.getElementById(id).style.color = "red";
		return false;
	} else {
		document.getElementById(id).innerHTML = "";
		return true;
	}
}
function validate_form(thisform) {
	if (isNull(document.getElementById("Username"), 'errorUsername') == false
			| isNull(document.getElementById("Password"), 'errorPassword') == false) {
		return false;
	}
}
	function change() {
		var parent=document.getElementById("parent");
		var child=document.getElementById("child");
		parent.removeChild(child);
		document.getElementById("parent").innerHTML("您已经成功登陆.您的级别为普通会员。");
	}

</script>
<body>
	<div class="container">
		<%@include file="/jsp/comm/header.jsp" %>
		<div class="center">
			<div class="zuo">
				<div class="zuo1">
					<div id="zuo001"
						style="width: 85%; height: 30px; background-image: url('<%=request.getContextPath() %>/img/icon06.gif');">
						<form action="<%=request.getContextPath() %>/member" method="post">
						    <input type="hidden" name="method" value="doUserLogin">
							<p class="pp">会员登陆</p>
							<div id="parent">
							  <%
							     Object obj = session.getAttribute("userInfo");
							     if(obj==null){
							    	 %>
							    	 <div id="child">
										   <span class="ppp" style="font-size: 5px;">登陆帐号：</span>
										   <input type="text" class="in1" name="username" id="username" onblur="isNull(this,'errorUsername')">
										   <span id="errorUsername" style="font-size: 1px;"></span><br>
										   <span style="font-size: 5px;">登陆密码：</span>
										   <input type="password" class="in2" id="password" name="password" onblur="isNull(this,'errorPassword')">
										   <span id="errorPassword"  style="font-size: 1px;"></span><br>
										   <input type="button" class="bb1" value="注册"> 
										   <input type="submit" class="bb11" value="登陆" onclick="">
								      </div>
							    	 <%
							     }else{
							    	 MemberVO usersModel = (MemberVO)obj;
							    	 %>
							    	 <div id="child" style="text-align: center;line-height: 20px;">
							    	       <br>
										   <span class="ppp" style="font-size: 5px;"><%=usersModel.getMemberName() %>您好</span>
										   <br>
										   <span id="errorUsername" style="font-size: 1px;">您已经成功登陆</span>
										   <br>
										   <span style="font-size: 5px;">您的级别为：<%=usersModel.getLevelName() %>！</span>
										   <br>
										   <a href="${pageContext.request.contextPath}/member?method=logOut">安全退出</a>
								      </div>
							    	 <% 
							     }
							  %>
							  
							</div>
						</form>
					</div>
				</div>
				<div class="zuo2">
					<div id="zuo001"
						style="width: 85%; height: 30px; background-image: url('<%=request.getContextPath() %>/img/icon01.gif');">
						<p class="pp">商品类别</p>
						<ul>
							<c:forEach items="${requestScope.cateList}" var="cate">
							     <li class="back"><a href="${pageContext.request.contextPath}/member?method=searchMer&cateid=${cate.id }" class="aa">${cate.cateName }</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
			<div class="you">
				<div class="you1">
					<div class="div4">
						<img src="<%=request.getContextPath() %>/img/Icon_TeJia.gif"> <a href="member?method=browseSMer"
							class="b3"><img src="<%=request.getContextPath() %>/img/icon_more.gif"></a>
					</div>
					<div class="div5"></div>
				
					<c:forEach begin="0" end="2" items="${requestScope.specialMerList }" var="specialMer">
					     <div class="div6">
							<center>
								<a href="详情1.html"><img alt="" src="${pageContext.request.contextPath}${specialMer.picture}"
									style="text-align: center; border: 1px solid;width: 126px;height: 123px;"></a>
							</center>
							<br>
							<p style="text-align: center; font-size: 6px;">
								<a href="#" class="a1"
									style="text-decoration: none; color: blue;">${specialMer.mername }</a>
							</p>
							<p style="text-align: center; color: black;">市场价： ￥${specialMer.price }</p>
							<p style="text-align: center; color: black;">特 价： ￥${specialMer.sprice }</p>
							<a href="${pageContext.request.contextPath}/member?method=showMer&id=${specialMer.id}" class="bb2"><img alt=""
								src="${pageContext.request.contextPath}/img/icon_car.gif"></a> <a href="${pageContext.request.contextPath}/queryFilter/manager?method=addCart&id=${specialMer.id}&price=${specialMer.price }" class="bb3"><img
								alt="" src="${pageContext.request.contextPath}/img/icon_buy.gif"></a>
						</div>
					</c:forEach>
					

				</div>
				<div class="you2">
					<div class="div4">
						<img src="<%=request.getContextPath() %>/img/NewGoods_03.gif"> <a href="member?method=browseMer"
							class="b3"><img src="<%=request.getContextPath() %>/img/icon_more.gif"></a>
					</div>
					<div class="div5"></div>
					
					<c:forEach begin="0" end="2" items="${requestScope.notSpecialMerList }" var="specialMer">
					     <div class="div6">
							<center>
								<a href="详情1.html"><img alt="" src="${pageContext.request.contextPath}${specialMer.picture}"
									style="text-align: center; border: 1px solid;width: 126px;height: 123px;"></a>
							</center>
							<br>
							<p style="text-align: center; font-size: 6px;">
								<a href="#" class="a1"
									style="text-decoration: none; color: blue;">${specialMer.mername }</a>
							</p>
							<p style="text-align: center; color: black;">市场价： ￥${specialMer.price }</p>
							<a href="详情1.html" class="bb2"><img alt=""
								src="${pageContext.request.contextPath}/img/icon_car.gif"></a> <a href="${pageContext.request.contextPath}/queryFilter/manager?method=addCart&id=${specialMer.id}&price=${specialMer.price }" class="bb3"><img
								alt="" src="${pageContext.request.contextPath}/img/icon_buy.gif"></a>
						</div>
					</c:forEach>

				</div>
			</div>
		</div>
        <%@include file="/jsp/comm/footer.jsp" %>
	</div>
</body>
</html>