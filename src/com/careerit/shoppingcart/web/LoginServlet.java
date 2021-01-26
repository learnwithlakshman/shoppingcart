package com.careerit.shoppingcart.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.careerit.shoppingcart.domain.User;
import com.careerit.shoppingcart.service.UserService;
import com.careerit.shoppingcart.service.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService = new UserServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			if(userService.login(email, password)) {
				HttpSession session = request.getSession();
				User user = userService.loadUserByEmail(email);
				session.setAttribute("user", user);
				response.sendRedirect("dashboard");
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				request.setAttribute("errorMessage", "Bad credentials");
				rd.include(request, response);
			}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
