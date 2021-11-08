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

import models.Content;
import dao.ContenDAO;

/**
 * Servlet implementation class ContenServlet
 */
@WebServlet("/dddddddd")
public class ContenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private ContenDAO contentDAO;

	    public ContenServlet() {
	        this.contentDAO =new ContenDAO();
	    }

		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String action = request.getServletPath();
			try {
				
				switch (action) {
				case "/delete":
					deleteContent(request, response);
					break;

				}
			} catch (SQLException ex) {
				throw new ServletException(ex);
			}
		}
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String action = request.getServletPath();
			
			try {
				switch (action) {
				case "/viewcontent":
					listContent(request, response);
					break;

				case "/delete":
					deleteContent(request, response);
					break;
				default:
					listContent(request, response);
					break;
				}
			} catch (SQLException ex) {
				throw new ServletException(ex);
			}
		}
		private void listContent(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, ServletException, IOException {
			List<Content> listContent = contentDAO.selectAllContents();
			
			request.setAttribute("listContent", listContent);
			 PrintWriter out = response.getWriter();
			 //out.print(listContent);
			 out.print("<p> hihihi </p>");
			request.setAttribute("ten", "Đắc1");
//			RequestDispatcher rd = request.getRequestDispatcher("views/viewContents.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("viewContents.tiles");
			rd.forward(request, response);
			 //rd.include(request,response); 
		}
		private void deleteContent(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			contentDAO.deleteContent(id);
			
		}

}
