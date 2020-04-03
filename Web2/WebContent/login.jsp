<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>用户登录</title>
	</head>
	<body>
		<% String msg=""; msg=(String)request.getAttribute("msg");%> 
		<div>
			<h1><b>用户登录</b></h1>
			<form action="/Web2/LoginServlet" method="post">
			<table>
			    <c:if test="${msg!=''}">  
	            <span style="color:red;">${msg}</span>  
	            </c:if>
				<tr>
					<th>用户ID</th><td><input type="text" name="ID" id="ID" style="width:180px"></td>
				</tr>
				<tr>
					<th>密码</th><td><input type="password" name="password" id="password" style="width:180px"></td>
				</tr>
			</table>
				<input type="submit" value="登录"  onclick="return check()">
			</form>
		</div>
	</body>
</html>