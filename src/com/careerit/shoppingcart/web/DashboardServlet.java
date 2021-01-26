package com.careerit.shoppingcart.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.careerit.shoppingcart.domain.Book;
import com.careerit.shoppingcart.service.BookService;
import com.careerit.shoppingcart.service.BookServiceImpl;

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private BookService bookService = new BookServiceImpl();
    public DashboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		List<Book> books = bookService.getAllBooks();
		request.setAttribute("books", books);
		RequestDispatcher rd = request.getRequestDispatcher("viewbooks.jsp");
		rd.forward(request, response);
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
