package com.careerit.shoppingcart.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.careerit.shoppingcart.domain.Book;
import com.careerit.shoppingcart.service.BookService;
import com.careerit.shoppingcart.service.BookServiceImpl;


@WebServlet("/addtocart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BookService bookService = new BookServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String idStr= request.getParameter("id");
			Book book =null;
			if(idStr !=null) {
				int id = Integer.parseInt(idStr);
				 book = bookService.getBookById(id);
				
						
			}
			
			HttpSession session = request.getSession();
			if(session ==null || session.getAttribute("user")==null) {
				response.sendRedirect("login.jsp");
				return;
			}
			
			Object cartItems = session.getAttribute("cartitems");
			List<Book> books = new ArrayList<Book>();
			if(cartItems != null) {
				books = (List<Book>) cartItems;
			}
			books.add(book);
			session.setAttribute("cartitems", books);
			
			RequestDispatcher rd = request.getRequestDispatcher("viewcart.jsp");
			rd.forward(request, response);
			
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
