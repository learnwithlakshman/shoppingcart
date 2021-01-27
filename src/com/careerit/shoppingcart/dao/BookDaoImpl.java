package com.careerit.shoppingcart.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.careerit.shoppingcart.dao.util.ConnectionUtil;
import com.careerit.shoppingcart.domain.Book;

public class BookDaoImpl implements BookDao {

	@Override
	public List<Book> selectAllBooks() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List<Book> books = new ArrayList<Book>();
		try {
			con = ConnectionUtil.util.getConnection();
			st = con.createStatement();
			rs = st.executeQuery("select * from book");
			while (rs.next()) {
				Book book = Book.builder().id(rs.getInt("id")).title(rs.getString("title")).price(rs.getFloat("price"))
						.build();
				books.add(book);

			}
		} catch (Exception e) {
			System.out.println("While loading books :" + e);
		}
		return books;
	}

	@Override
	public Book selectBookById(int id) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		Book book = null;
		try {
			con = ConnectionUtil.util.getConnection();
			st = con.createStatement();
			rs = st.executeQuery("select * from book where id = " + id);
			if (rs.next()) {
				book = Book.builder().id(rs.getInt("id")).title(rs.getString("title")).price(rs.getFloat("price"))
						.build();

			}
		} catch (Exception e) {
			System.out.println("While loading books :" + e);
		}
		return book;
	}

}
