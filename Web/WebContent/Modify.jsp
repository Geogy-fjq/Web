<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*,java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>修改客户信息</title>
		<style>
		</style>
	</head>
	<body>
		<h2><b>修改客户信息</b></h2>
		<form action="/Web/servlet" method="post">
			<table>
                <tr>
                    <td>客户ID</td>
                    <td><input type="text" size=18 name="idM" value ="<%= request.getParameter("idL")%>"></td>
                </tr>
                <tr>
                    <td>客户姓名</td>
                    <td><input type="text" size=18 name="nameM" value ="<%=request.getParameter("nameL") %>"></td>
                </tr>
                <tr>
                    <td>性别</td>       
            		<td><input type="radio" name="sexM" checked="checked" value="男">男
    				<input type="radio" name="sexM" value="女">女</td> 
                </tr>
                <tr>
                    <td>职业</td>
                    <td><input type="text" size=18 name="occupationM" value=" <%=request.getParameter("occupationL")%>"></td>
                </tr>
                <tr>
                    <td>文化程度</td>
                    <td>
	                    <select name="educationM">
	                    <option value="-请选择-">-请选择-</option>
	                    <option value="小学">小学</option>
	                    <option value="初中">初中</option>
	                	<option value="高中">高中</option>
	                	<option value="专科">专科</option>
	                	<option value="本科">本科</option>
	                	<option value="硕士研究生">硕士研究生</option>
	                	<option value="博士研究生">博士研究生</option>
                		</select>
                	</td>
                </tr>
                <tr>
                    <td>住址</td>
                    <td><input type="text" size=36 name="addressM" value=" <%=request.getParameter("addressL")%>"></td>
                </tr>
            </table>
            <input type="hidden" name='messageM' value=<%=request.getParameter("idL") %>>
	        <input type="submit" name="saveM" value="保存" >
	        <a>
	        <input type="button" name="backM" value="返回" onclick="window.location.href('List.jsp')">
	        </a>
        </form>
	</body>
</html>