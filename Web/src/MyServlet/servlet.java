package MyServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * MyServlet implementation class servlet
 */
@WebServlet("/servlet")
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String URL = "jdbc:mysql://localhost:3306/work?user=root&password=123456&useSSL=false&useUnicode=true&characterEncoding=UTF-8";
	public Connection connection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(URL);
		return connection;
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    /*
	 * 查找信息
	 */
	public ArrayList<String[]> search(HttpServletRequest request,Connection con) {
		String ID=request.getParameter("IDL");
		String Name=request.getParameter("NameL");
		ArrayList<String[]> arr = new ArrayList<String[]>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Statement st=con.createStatement();
			ResultSet rs=null;
			if(Name.trim().length()==0) {
				rs= st.executeQuery("select * from customer where id ="+ID);
			}
			else if(ID.trim().length()==0) {
				rs= st.executeQuery("select * from customer where name like'%"+Name+"%'");
			}
			else {
				rs= st.executeQuery("select * from customer where id like'%"+ID+"%' and name like'%"+Name+"%'");
			}
			while(rs.next()) {
				String[] str=new String[] {rs.getString("id"),rs.getString("name"),rs.getString("sex"),rs.getString("education"),rs.getString("occupation"),rs.getString("address")};
				arr.add(str);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
	/*
	 * 删除信息
	 */
	public void remove(HttpServletRequest request,Connection con) {
		try {
			String id = request.getParameter("idL");
			Statement st=con.createStatement();
			st.executeLargeUpdate("delete  from customer where id ="+id);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}
	/*
	 * 添加信息
	 */
	public void add(HttpServletRequest request,Connection con) {
		try {
			String sql="insert into customer(id,name,sex,education,occupation,address) values(?,?,?,?,?,?)";//定义插入语句
			PreparedStatement ps=con.prepareStatement(sql);//预编译语句对象
			ps.setString(1, request.getParameter("idA"));
			ps.setString(2, request.getParameter("nameA"));
			ps.setString(3, request.getParameter("sexA"));
			ps.setString(4, request.getParameter("educationA"));
			ps.setString(5, request.getParameter("occupationA"));
			ps.setString(6, request.getParameter("addressA"));
			ps.executeUpdate();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 修改信息
	 */
	public void modify(HttpServletRequest request,Connection con) throws SQLException {
		//添加
		String sql = "insert into customer(id,name,sex,education,occupation,address) values (?,?,?,?,?,?)";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1, request.getParameter("idM"));
		st.setString(2, request.getParameter("nameM"));
		st.setString(3, request.getParameter("sexM"));
		st.setString(4, request.getParameter("educationM"));
		st.setString(5, request.getParameter("occupationM"));
		st.setString(6, request.getParameter("addressM"));
		st.executeUpdate();
		//删除
		String id = request.getParameter("idL");
		Statement sta=con.createStatement();
		sta.executeLargeUpdate("delete from customer where id ="+id);//删除旧数据
	}
	/*
	 * 将数据整合成数组
	 */
	public ArrayList<String[]>  count(Connection con) throws ClassNotFoundException, SQLException{
		Statement st=con.createStatement();
		ResultSet rs= st.executeQuery("select * from customer");
		ArrayList<String[]> arrC = new ArrayList<String[]>();
		while(rs.next()) {
			String[] str=new String[] {rs.getString("id"),rs.getString("name"),rs.getString("sex"),rs.getString("education"),rs.getString("occupation"),rs.getString("address")};
			arrC.add(str);
		}
		return arrC;
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf8");
			response.setCharacterEncoding("utf8");
			
			//登录界面
			if(request.getParameter("land")!=null) {
				try {
					ArrayList<String[]> arr1 = count(connection());//进入List页面,显示所有数据记录
					request.setAttribute("NameL", arr1);
					RequestDispatcher dispatcher1 = request.getRequestDispatcher("List.jsp");
					dispatcher1.forward(request,response);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//List：查找按钮
			if(request.getParameter("searchL")!=null) {
				ArrayList<String[]> arr2 = search(request, connection());
				request.setAttribute("NameL", arr2);
				RequestDispatcher dispatcher2 = request.getRequestDispatcher("List.jsp");
				dispatcher2.forward(request,response);
			}
			//List：删除按钮
			else if(request.getParameter("removeL")!=null) {
				remove(request, connection());
				response.getWriter().println("<!DOCTYPE html>\r\n" + 
						"<html>\r\n" + 
						"<head>\r\n" + 
						"<meta charset=\"UTF-8\">\r\n" + 
						"<title>删除成功</title>\r\n" + 
						"</head>\r\n" + 
						"<body>"+"<form action=\"/Web/servlet\" method=\"post\">\r\n" + 
								"<div align=\"center\">\r\n" + 
								"		<table>  \r\n" + 
								"	<tr>  \r\n" + 
								"	<td>\r\n" + 
								"	<font size=\"6\" style=\"color:red\">删除成功！</font>\r\n" + 
								"	</td> \r\n" + 
								"	</tr>\r\n" + 
								"	</table>\r\n" + 
								"	</div>"+
								"	<a><input type=\"button\" name=\"jump\" value=\"返回\" onclick=\"window.location.href('List.jsp')\" height=\"200\" width=\"700\"  style=\"position: relative ;left:560px;top:20px;\"></a>\r\n" + 
								"	</form>\r\n" + 
								"</body>\r\n" + 
								"</html>");
			}
			//添加页面(Add)：保存按钮
			else if(request.getParameter("saveA")!=null) {
				add(request, connection());
				response.getWriter().println("<!DOCTYPE html>\r\n" + 
						"<html>\r\n" + 
						"<head>\r\n" + 
						"<meta charset=\"UTF-8\">\r\n" + 
						"<title>添加成功</title>\r\n" + 
						"</head>\r\n" + 
						"<body>"+"<form action=\"/Web/servlet\" method=\"post\">\r\n" + 
								"<div align=\"center\">\r\n" + 
								"		<table>  \r\n" + 
								"	<tr>  \r\n" + 
								"	<td>\r\n" + 
								"	<font size=\"6\" style=\"color:red\">添加成功！</font>\r\n" + 
								"	</td> \r\n" + 
								"	</tr>\r\n" + 
								"	</table>\r\n" + 
								"	</div>"+
								"	<a><input type=\"button\" name=\"jump\" value=\"返回\" onclick=\"window.location.href('Add.jsp')\" height=\"200\" width=\"700\"  style=\"position: relative ;left:560px;top:20px;\"></a>\r\n" + 
								"	</form>\r\n" + 
								"</body>\r\n" + 
								"</html>");
			}
			//跳转到修改页面
			else if(request.getParameter("modifyL")!=null) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("Modify.jsp");
				dispatcher.forward(request,response);
			}
			//修改页面(Modify)：保存按钮
			else if(request.getParameter("saveM")!=null) {
				modify(request, connection());
				response.getWriter().println("<!DOCTYPE html>\r\n" + 
							"<html>\r\n" + 
							"<head>\r\n" + 
							"<meta charset=\"UTF-8\">\r\n" + 
							"<title>修改成功</title>\r\n" + 
							"</head>\r\n" + 
							"<body>"+"<form action=\"/Web/servlet\" method=\"post\">\r\n" + 
									"<div align=\"center\">\r\n" + 
									"		<table>  \r\n" + 
									"	<tr>  \r\n" + 
									"	<td>\r\n" + 
									"	<font size=\"6\" style=\"color:red\">修改成功！</font>\r\n" + 
									"	</td> \r\n" + 
									"	</tr>\r\n" + 
									"	</table>\r\n" + 
									"	</div>"+
									"	<a><input type=\"button\" name=\"jump\" value=\"返回\" onclick=\"window.location.href('List.jsp')\" height=\"200\" width=\"700\"  style=\"position: relative ;left:560px;top:20px;\"></a>\r\n" + 
									"	</form>\r\n" + 
									"</body>\r\n" + 
									"</html>");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
