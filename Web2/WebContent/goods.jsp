<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" import="java.sql.*,java.util.*,util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>商品列表</title>
	</head>
	<body>
		<div >
		<h1><b>商品列表</b></h1>
		<table border="1" style="width:1150px">
			<tr>
				<th width="50px">图片</th>
				<th width="100px">商品ID</th>
				<th width="150px">商品名称</th>
				<th width="100px">生产厂商</th>
				<th width="100px">类别</th>
				<th width="100px">型号</th>
				<th width="100px">产地</th>
				<th width="300px">商品描述</th>
				<th width="150px">上传</th>
			</tr>
			<c:forEach var="i" items="${requestScope.goods}"> 
			<tr>
				<td><img height="50px " width="50px" src="${pageContext.request.contextPath}/picture/goods${i.getId()}.jpg"></td>
				<td>${i.getId()}</td>
				<td>${i.getName()}</td>
				<td>${i.getFactory()}</td>
				<td>${i.getCategory()}</td>
				<td>${i.getModel()}</td>
				<td>${i.getPlace()}</td>
				<td>${i.getDescribe()}</td>
				<td>
				<form action="/Web2/UploadServlet" method="post" enctype="multipart/form-data">
					<input type="file" name="file" value="选择文件">
					<input type="hidden" name="id" value="${i.getId()}"><br/>
					<input type="submit" name="upload" value="上传">
				</form>
				</td>
			</tr>
			</c:forEach>
		</table><br/>
		<p>登陆人数:${num}</p>
	</div>
	</body>
</html>