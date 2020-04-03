<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*,java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>客户列表</title>
	</head>
	<body>
		<h1><b>客户列表</b></h1>
		<h3><b>查询条件</b></h3>
		<form action="/Web/servlet" method="post">
			<table>
                <tr>
                    <td width="80px">客户ID：</td>
                    <td><input type="text" size=18 name="IDL"></td>
                </tr>
                <tr>
                    <td>客户姓名：</td>
                    <td><input type="text" size=18 name="NameL" ></td>
                </tr>
            </table>
            <input type="submit" name="searchL" value="查询" onclick="window.location.href('List.jsp')">
        </form>
        	<table style="width:1010px;" border=1 id="tb">
        		<tr>
					<th colspan = "7">客户列表</th>
				</tr>
        		<tr align="center" height="30px">
        			<th style="width:80px;">客户ID</th>
					<th style="width:100px;">客户姓名</th>
					<th style="width:40px;">性别</th>
					<th style="width:120px;">文化程度</th>
					<th style="width:200px;">职业</th>
					<th style="width:360px;">住址</th>
					<th style="width:110px;">《操作》</th>
        		</tr>
        		<%ArrayList<String[]> arr =(ArrayList<String[]>) request.getAttribute("NameL");
        		for(String[] i:arr){
        		%>
				<tr>
					<td><%=i[0]%></td>
					<td><%=i[1]%></td>
					<td><%=i[2]%></td>
					<td><%=i[3]%></td>
					<td><%=i[4]%></td>
					<td><%=i[5]%></td>
					<td>
					<form action="/Web/servlet" method="post">
						<input type="hidden" name="idL" value="<%=i[0]%>">
						<input type="hidden" name="nameL" value="<%=i[1]%>">
						<input type="hidden" name="sexL" value="<%=i[2]%>">
						<input type="hidden" name="educationL" value="<%=i[3]%>">
						<input type="hidden" name="occupationL" value="<%=i[4]%>">
						<input type="hidden" name="addressL" value="<%=i[5]%>">
						<nobr>
						<input type="submit" name="removeL" value='删除'>
						<input type="submit" name='modifyL' value='修改'>
						</nobr>
					</form>
					</td>
				</tr>
        <%}%> </table>
        <a>
            <input type="submit" name="addL" value="添加" onclick="window.location.href('Add.jsp')">
        </a>
	</body>
</html>