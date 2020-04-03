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
		<form action="/work/servlet" method="post">
			<table>
                <tr>
                    <td width="80px">客户ID：</td>
                    <td><input type="text" size=18 name="ID"></td>
                </tr>
                <tr>
                    <td>客户姓名：</td>
                    <td><input type="text" size=18 name="Name" ></td>
                </tr>
            </table>
            <p >
            	<input type="submit" name="search" value="查询">
            </p>
		</form>
        <%
        Class.forName("com.mysql.jdbc.Driver");//注册驱动程序
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/work?user=root&password=123456");//获得链接对象
		Statement st=con.createStatement();//创建语句对象用来将 SQL语句发送到数据库
		String sql = "select*from customer";
		ResultSet rs= st.executeQuery(sql);//将获得的数据赋值给rs
		%>
		<form action="/work/servlet" method="get">
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
        		<%
        		while(rs.next()){
        		%>
				<tr>
					<td><%=rs.getString("id")%></td>
					<td><%=rs.getString("name")%></td>
					<td><%=rs.getString("sex") %></td>
					<td><%=rs.getString("education") %></td>
					<td><%=rs.getString("occupation") %></td>
					<td><%=rs.getString("address")%></td>
					<td>
					<input type="hidden" name="id" value="<%=rs.getString("id")%>">
					<input type="hidden" name="name" value="<%=rs.getString("name")%>">
					<input type="hidden" name="sex" value="<%=rs.getString("sex")%>">
					<input type="hidden" name="education" value="<%=rs.getString("education")%>">
					<input type="hidden" name="occupation" value="<%=rs.getString("occupation")%>">
					<input type="hidden" name="address" value="<%=rs.getString("address")%>">
					<input type="submit" name='remove' value='删除'>
					<a> 
						<input type="button" name='modify' value='修改' onclick="window.location.href('Modify.jsp')">
					</a>
					</td>
				</tr>
        <%}%> </table>
        </form>
		<% if(rs!=null) {
			rs.close();
		}
		if(st!=null) {
			st.close();
		}
		if(con!=null) {
			con.close();
		}%>
        <a href="http://localhost:8080/Web/JSP/Add.jsp">
            <input type="submit" name="add" value="添加" >
        </a>
	</body>
</html>