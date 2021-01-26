package com.careerit.shoppingcart.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.careerit.shoppingcart.dao.BookDao;
import com.careerit.shoppingcart.dao.BookDaoImpl;
import com.careerit.shoppingcart.domain.Book;

public class BookServiceImpl implements BookService {

	private BookDao bookDao = new BookDaoImpl();
	private static Logger logger = LogManager.getLogger(BookServiceImpl.class);

	@Override
	public List<Book> getAllBooks() {
		List<Book> books = bookDao.selectAllBooks();
		logger.info("Total books found :" + books.size());
		return books;
	}

}
