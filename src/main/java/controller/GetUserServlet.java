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


@WebServlet("/")
public class GetUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 private ContenDAO contentDAO;

	    public GetUserServlet() {
	        this.contentDAO =new ContenDAO();
	    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		

			switch (action) {

			case "/delete":			
				int id = Integer.parseInt(request.getParameter("id"));
				try {
					contentDAO.deleteContent(id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:

					doGet(request, response);

				break;
			

			}
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
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
}
