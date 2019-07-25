<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/Demo.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(function (){
	$("#go").click(function (){
		var jumpPage = $("#jumpPage").val();
		//验证 
		var special = '${requestScope.special}';
		if(special==1){
			location.href="${pageContext.request.contextPath}/member?method=browseSMer&nowPage="+jumpPage;
		}else if(special==0){
			location.href="${pageContext.request.contextPath}/member?method=browseMer&nowPage="+jumpPage;
		}
	});
});
</script>
</head>
<body>
	<div class="con">
		<%@include file="/jsp/comm/header.jsp" %>
		<div class="G_center">
			<div class="G_center01">
				<img alt="" src="img/NewGoods_05.gif">
			</div>
			<table width="720px" height="600px">
				<tr bgcolor="#F7F3F7" valign="middle" align="center">
					<td height="30" class="blackTitle">商品图片</td>
					<td height="30" class="blackTitle">商品基本信息</td>
					<td height="30" class="blackTitle">商品描述</td>
					<td height="30" class="blackTitle">基本操作</td>
				</tr>
				
				<c:forEach items="${requestScope.castPageModel.currentDataList }" var="specialMer">
				       <tr valign="middle" bgcolor="#FFFFFF">
							<td width="100" align="center"><a href="详情1.html?id=${specialMer.id}"
								target=_blank> <img src="${pageContext.request.contextPath}${specialMer.picture}" width="60" height="60"
									border="1">
							</a></td>
							<td width="160" class="text"><a href="详情1.html" target=_blank><span
									class="blueText">${specialMer.mername }</span></a><br> 
									市场价： ￥${specialMer.price }
									<br> 
									<c:if test="${specialMer.special == 1}">
									        特 价：￥${specialMer.sprice }<br> 
									</c:if>
									生产厂家：${specialMer.manufacturer }<br>
							</td>
							<td class="text">${specialMer.merdesc }</td>
							<td width="100">
							    <a href="详情1.html?id=${specialMer.id}">
							        <img src="img/icon_car.gif" border=0>
							    </a><br> 
							    <a href="详情1.html?id=${specialMer.id}">
								     <img alt="" src="img/icon_buy.gif" border=0>
								</a>
							</td>
						</tr>
						<tr>
							<td colspan="4" height="2" bgcolor="#F7F3F7"></td>
						</tr>
				</c:forEach>
				
				<tr align="center">
				    <c:if test="${requestScope.special == 1}">
						<td colspan="4">
					        <a href="${pageContext.request.contextPath}/member?method=browseSMer&nowPage=1">首页</a>  
					        <a href="${pageContext.request.contextPath}/member?method=browseSMer&nowPage=${requestScope.castPageModel.upPage}">上一页</a>   
					        <a href="${pageContext.request.contextPath}/member?method=browseSMer&nowPage=${requestScope.castPageModel.nextPage}">下一页  </a>   
					        <a href="${pageContext.request.contextPath}/member?method=browseSMer&nowPage=${requestScope.castPageModel.totalPage}">末页</a>   
					                    去第<input type="text" id="jumpPage" style="width: 20px;">页<input type="button" value="GO" id="go">            
					                    第${requestScope.castPageModel.nowPage}页/共${requestScope.castPageModel.totalPage}页　 总数${requestScope.castPageModel.totalNum}
					    </td>	
					</c:if>
				    <c:if test="${requestScope.special == 0}">
						<td colspan="4">
					        <a href="${pageContext.request.contextPath}/member?method=browseMer&nowPage=1">首页</a>  
					        <a href="${pageContext.request.contextPath}/member?method=browseMer&nowPage=${requestScope.castPageModel.upPage}">上一页</a>   
					        <a href="${pageContext.request.contextPath}/member?method=browseMer&nowPage=${requestScope.castPageModel.nextPage}">下一页  </a>   
					        <a href="${pageContext.request.contextPath}/member?method=browseMer&nowPage=${requestScope.castPageModel.totalPage}">末页</a>   
					                    去第<input type="text" id="jumpPage" style="width: 20px;">页<input type="button" value="GO" id="go">            
					                    第${requestScope.castPageModel.nowPage}页/共${requestScope.castPageModel.totalPage}页　 总数${requestScope.castPageModel.totalNum}
					    </td>	
					</c:if>
					
				
				    
				</tr>
			</table>
		</div>
		<%@include file="/jsp/comm/footer.jsp" %>
	</div>
</body>
</html>