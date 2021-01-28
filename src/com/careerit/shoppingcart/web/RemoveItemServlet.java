package com.careerit.shoppingcart.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.careerit.shoppingcart.domain.Book;

/**
 * Servlet implementation class RemoveItemServlet
 */
@WebServlet(name = "removeitem", urlPatterns = { "/removeitem" })
public class RemoveItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		if(session ==null || session.getAttribute("user")==null) {
			response.sendRedirect("login.jsp");
			return;
		}
		Object cartItems = session.getAttribute("cartitems");
		List<Book> books = new ArrayList<Book>();
		if(cartItems != null) {
			books = (List<Book>) cartItems;
			Iterator<Book> iterator = books.iterator();
			while(iterator.hasNext()) {
				Book book = iterator.next();
				if(book.getId() == id) {
					iterator.remove();
					break;
				}
			}
			session.setAttribute("cartitems", books);
		}
		response.sendRedirect("viewcart.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
