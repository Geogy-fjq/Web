<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*,java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>登陆界面</title>
	</head>
	<body>
		<h2 align="center" style="color:red"><b>欢迎登录客户信息管理系统！</b></h2>
		<form action="/Web/servlet" method="post">
            <p align="center">
            	<input type="submit" name="land" value="登录">
            </p>
        </form>
	</body>
</html>