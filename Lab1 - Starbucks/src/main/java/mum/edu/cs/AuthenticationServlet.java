package mum.edu.cs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mum.edu.data.DataFacade;

public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
 		requestDispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
   		DataFacade data = (DataFacade) getServletContext().getAttribute("dataSource");
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		String expectedPassword = data.findPassword(name);
		
		if(expectedPassword == null || !expectedPassword.equals(password)) {
		
 			response.sendRedirect("login");

		} else {

			response.sendRedirect("advice");
		
		}
	}

}
