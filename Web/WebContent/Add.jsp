<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*,java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>添加客户</title>
	</head>
	<body>
		<h2><b>添加客户</b></h2>
		<form action="/Web/servlet" method="post">
			<table>
                <tr>
                    <td>客户ID</td>
                    <td><input type="text" size=18 name="idA"></td>
                </tr>
                <tr>
                    <td>客户姓名</td>
                    <td><input type="text" size=18 name="nameA"></td>
                </tr>
                <tr>
                    <td>性别</td>       
            		<td><input type="radio" name="sexA" checked="checked" value="男">男
    				<input type="radio" name="sexA" value="女">女</td> 
                </tr>
                <tr>
                    <td>文化程度</td>
                    <td>
	                    <select name="educationA">
	                    <option value="0">-请选择-</option>
	                    <option value="1">小学</option>
	                    <option value="2">初中</option>
	                	<option value="3">高中</option>
	                	<option value="4">专科</option>
	                	<option value="5">本科</option>
	                	<option value="6">硕士研究生</option>
	                	<option value="7">博士研究生</option>
                		</select>
                	</td>
                </tr>
                <tr>
                    <td>职业</td>
                    <td><input type="text" size=18 name="occupationA"></td>
                </tr>
                <tr>
                    <td>住址</td>
                    <td><input type="text" size=36 name="addressA"></td>
                </tr>
            </table>
           <input type="submit" name="saveA" value="保存" >
           <a>
           	<input type="button" name="backA" value="返回" onclick="window.location.href('List.jsp')">
           </a>
        </form>
	</body>
</html>