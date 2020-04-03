package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;
import util.GoodsBean;

/** 
 * Servlet implementation class GoodsServlet 
 */  
@WebServlet("/GoodsServlet") 
public class GoodsServlet extends HttpServlet {
	private static final long serialVersionUID=2L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBUtil db=new DBUtil();
		ArrayList<String[]> arr=db.findAllGoods("work");
		ArrayList<GoodsBean> goods=new ArrayList<GoodsBean>();
		for(String[] s:arr) {
			goods.add(new GoodsBean(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7]));
		}
		request.setAttribute("goods", goods);
		request.getRequestDispatcher("goods.jsp").forward(request,response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
