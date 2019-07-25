<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/css/Demo.css">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(document).ready(
		function (){
			$("#saveMember").click(function(){
				//对保存按钮加点击事件
				var url="${pageContext.request.contextPath}/member?method=update";
				var m = new Object();
				m.id = $("#id").val();//隐藏的输入框
				m.memberLevel = $("#memberLevel").val();//隐藏的输入框
				m.memberName = $("#memberName").val();//真实姓名
				m.loginName = $("#loginName").val();//登陆名称 
				m.loginPwd = $("#loginPwd").val();//密码 
				alert(m.loginPwd);
				m.phone = $("#phone").val();//联系电话 
				m.address = $("#address").val();//地址
				m.zip = $("#zip").val();//邮编 
				m.email = $("#email").val();//邮编 
				
				
				
				$.post(url,m,function(data,status){
					if("success"==data.trim()){
						alert("更新成功 ");
						
						location.href="${pageContext.request.contextPath}/member?method=memberLogOut";
					}else{
						alert("更新失败  ");
					} 
					console.log(data);
				});
			});
		}
);
</script>
</head>
<body>
	<div class="con3">
		<%@include file="/jsp/comm/header.jsp" %>
         <div class="X_center">
         <div class="X_center01"> <img alt="" src="img/EditUser_01.gif"> </div>
     <form action="mem.do?method=updateMember" style="margin:0px;" method="post" onSubmit="return CheckForm.Check(this,2)">             	
	<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
      <tr>
        <td height="30" colspan="2">&nbsp;</td>
      </tr>
      <tr bgcolor="#F7F3F7">
        <td width="260" height="26" class="text" align="right">会员级别
          ：</td>
        <td height="26" class="text">
           ${sessionScope.userInfo.levelName } 
           <input type="hidden" name="memberLevel" id="memberLevel" value="${sessionScope.userInfo.memberLevel } ">
           <input type="hidden" name="id" id="id" value="${sessionScope.userInfo.id } ">
        </td>
      </tr>
      <tr bgcolor="#F7F3F7">
        <td width="260" height="26" class="text" align="right">真实姓名
          ：</td>
        <td height="26"><input type="text" name="memberName" id="memberName" size="30" class="textBox" value="${sessionScope.userInfo.memberName }" require="true" dataType="Require" msg="真实姓名不能为空!"/></td>
      </tr>
      <tr bgcolor="#F7F3F7">
        <td width="260" height="26" class="text" align="right">登录帐号
          ：</td>
        <td height="26"><input type="text" name="loginName" id="loginName" size="30" class="textBox" value="${sessionScope.userInfo.loginName }" require="true" dataType="Require" msg="登录名不能为空!"/></td>
      </tr>
      <tr bgcolor="#F7F3F7">
        <td width="260" height="26" class="text" align="right">登录密码
          ：</td>
        <td height="26"><input type="password" name="loginPwd" id="loginPwd" size="30" class="textBox"/></td>
      </tr>
      <tr bgcolor="#F7F3F7">
        <td width="260" height="26" class="text" align="right">核对密码	
          ：</td>
        <td height="26"><input name="password" type="password" class="textBox" id="reLoginPwd" onBlur="checkPwd()" size="30"/></td>
      </tr>
      <tr bgcolor="#F7F3F7">
        <td width="260" height="26" class="text" align="right">联系电话
          ：</td>
        <td height="26"><input type="text" name="phone" id="phone" size="30" class="textBox" value="${sessionScope.userInfo.phone }" require="true" dataType="Phone" msg="联系电话不正确!"/></td>
      </tr>
      <tr bgcolor="#F7F3F7">
        <td width="260" height="26" class="text" align="right">联系地址
          ：</td>
        <td height="26"><input type="text" name="address"  id="address" size="30" class="textBox" value="${sessionScope.userInfo.address }" require="true" dataType="Require" msg="联系地址不能为空!"/></td>
      </tr>
      <tr bgcolor="#F7F3F7">
        <td width="260" height="26" class="text" align="right">邮政编码
          ：</td>
        <td height="26"><input type="text" name="zip" id="zip" size="30" class="textBox" value="${sessionScope.userInfo.zip }" require="true" dataType="Zip" msg="邮政编码不正确!"/></td>
      </tr>
      <tr bgcolor="#F7F3F7">
        <td width="260" height="26" class="text" align="right">电子邮箱
          ：</td>
        <td height="26"><input type="text" name="email" id="email" size="30" class="textBox" value="${sessionScope.userInfo.email }" require="false" dataType="Email" msg="电子邮箱不正确!"/></td>
      </tr>
      <tr>
        <td height="40" colspan="2" align="center">
			<input class="C_Input" type="button" value="保存" id="saveMember"/>
	   </td>
      </tr>
    </table>
	</form> 
      </div>
     <%@include file="/jsp/comm/footer.jsp" %>
</div>		
		
</body>
</html>