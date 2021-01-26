package com.careerit.shoppingcart.dao;

import java.util.List;

import com.careerit.shoppingcart.domain.Book;

public interface BookDao {

		public List<Book> selectAllBooks();
}
