package com.careerit.shoppingcart.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.careerit.shoppingcart.domain.Book;

/**
 * Servlet implementation class BuyItemsServlet
 */
@WebServlet(name = "buyitems", urlPatterns = { "/buyitems" })
public class BuyItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if(session ==null || session.getAttribute("user")==null) {
			response.sendRedirect("login.jsp");
			return;
		}
		
		Object object = session.getAttribute("cartitems");
		if(object !=null) {
			List<Book> books = (List<Book>) object;
			float total_price = 0;
			for(Book book:books) {
				total_price += book.getPrice();
			}
			session.setAttribute("total_price", total_price);
			
		}
		RequestDispatcher rd = request.getRequestDispatcher("buyitems.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
