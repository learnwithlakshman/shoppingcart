package com.careerit.shoppingcart.dao;

import static com.careerit.shoppingcart.dao.util.ConnectionUtil.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.careerit.shoppingcart.domain.User;

public class UserDaoImpl implements UserDao {

	private static final String FIND_USER_BY_EMAIL = "select username,email,password from user where email = ?";
	private static Logger logger = LogManager.getLogger(UserDaoImpl.class);

	@Override
	public User register(User user) {

		return null;
	}

	@Override
	public User loadUserByEmail(String emailId) {
		logger.info("User with email:" + emailId + " is trying login");
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		User user = null;
		try {
			con = util.getConnection();
			st = con.prepareStatement(FIND_USER_BY_EMAIL);
			st.setString(1, emailId);
			rs = st.executeQuery();
			if (rs.next()) {
				String email = rs.getString("email");
				String username = rs.getString("username");
				String password = rs.getString("password");
				user = User.builder().email(email).password(password).username(username).build();
				logger.info("User found with name :" + username + " for given email :" + emailId);
			}
		} catch (SQLException e) {
			logger.error("While getting the user with email:" + emailId + " got :" + e);
		} finally {
			util.close(rs, st, con);
		}
		return user;
	}

}
