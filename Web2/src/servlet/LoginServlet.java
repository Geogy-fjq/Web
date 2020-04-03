package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DBUtil;

/** 
 * Servlet implementation class LoginServlet
 */  
@WebServlet("/LoginServlet") 
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID=2L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//登录账户密码验证
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		HttpSession ses=request.getSession();
			    
		String ID=request.getParameter("ID");
		String password=request.getParameter("password");
		
		if(ID=="") {
			request.setAttribute("msg","用户名不能为空！");
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
		else if(password=="") {
			request.setAttribute("msg","密码不能为空！");
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
		else {
			DBUtil db=new DBUtil();
			ArrayList<String[]> arr=db.findAllUsers("work");
			int a=0;
			for(String s[]:arr){
				if(s[0].equals(ID)&&(s[1].equals(password))){
					a=1;
					ses.setAttribute("ID",ID);
					ses.setAttribute("password",password);
					request.getRequestDispatcher("GoodsServlet").forward(request,response);
				}
			}
			if(a==0){
				request.setAttribute("msg","用户名或密码错误，请重新输入！");
				request.getRequestDispatcher("login.jsp").forward(request,response);
			}
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
