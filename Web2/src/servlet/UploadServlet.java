package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


/** 
 * Servlet implementation class UploadServlet
 */  
@WebServlet("/UploadServlet") 
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID=2L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String savePath=request.getServletContext().getRealPath("/picture");
		response.sendRedirect("/Web2/LoginServlet");
		Part part=request.getPart("file");
		String id="goods"+request.getParameter("id")+".jpg";
		response.getWriter().println(id);
		String path=savePath + File.separator + id;
		part.write(path);
		response.sendRedirect("/Web2/LoginServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
