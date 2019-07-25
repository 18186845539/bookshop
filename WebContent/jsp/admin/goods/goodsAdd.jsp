<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/base.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/base.js"></script>
</head>
<body>

<h3>商品添加</h3>
<form action="<%=request.getContextPath() %>/html/goods/regedit.do" method="post" onsubmit="return validateForm()">
   <table>
       <tr>
           <td>商品名:</td>
           <td><input type="text" name="name" id="name"><span  id="error_mess_name" class="errorSpan"></span> </td>
       </tr>
       <tr>
           <td>价格:</td>
           <td><input type="text" name="price" id="price"><span id="error_mess_price" class="errorSpan"> </span> </td>
       </tr>
       <tr>
           <td>库存:</td>
           <td><input type="text" name="num" id="num"><span id="error_mess_price" class="errorSpan"> </span> </td>
       </tr>
       <tr>
           <td>描述:</td>
           <td><input type="text" name="descs" id="descs"> </td>
       </tr>

       <tr>
           <td>图片:</td>
           <td><input type="file" name="photo" id="photo"> <span  class="errorSpan" >${message}</span> </td>
       </tr>
       <tr>
           <td><input type="submit" value="注册"> </td>
           <td><input type="reset" name="重置"> </td>
       </tr>
   </table>
</form>
</body>
</html>