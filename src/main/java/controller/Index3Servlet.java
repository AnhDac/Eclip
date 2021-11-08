package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContenDAO;
import models.Content;

@WebServlet("/123123213")
public class Index3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 private ContenDAO contentDAO;

	    public Index3Servlet() {
	        this.contentDAO =new ContenDAO();
	    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		try {
			switch (action) {
			
			case "/show":
				listContent(request, response);
				break;
			case"/delete":
				deleteContent(request, response);
				break;
			default:
				helloUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		
	}
	private void deleteContent(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		contentDAO.deleteContent(id);
		response.setContentType("text/plain");
		response.getWriter().write("dadcnguyen");
	}

	
	private void listContent(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, ServletException, IOException {
		List<Content> listContent = contentDAO.selectAllContents();
		
		request.setAttribute("listContent", listContent);
		 PrintWriter out = response.getWriter();
		 //out.print(listContent);
		 out.print("<p> hihihi </p>");
		request.setAttribute("ten", "Đắc1");
//		RequestDispatcher rd = request.getRequestDispatcher("views/viewContents.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("viewContents.tiles");
		rd.forward(request, response);
		 //rd.include(request,response); 
	}
	
	
	private void helloUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String userName = request.getParameter("userName").trim();
		if(userName == null || "".equals(userName)){
			userName = "Guest";
		}
		
		String greetings = "Hello " + userName;	
		response.setContentType("text/plain");
		response.getWriter().write(greetings);
		
	}

}
