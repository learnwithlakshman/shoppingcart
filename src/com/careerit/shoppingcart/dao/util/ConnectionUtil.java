package com.careerit.shoppingcart.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.careerit.shoppingcart.dao.util.AppConstants.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum ConnectionUtil {
	util;

	private static Logger logger = LogManager.getLogger(ConnectionUtil.class);

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch (Exception e) {
			logger.error("While loading driver :"+e);
		}
	}
	
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			logger.error("While connecting with DB : " + e);
		}
		return con;
	}

	public void close(ResultSet rs, Statement st, Connection con) {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			logger.error("While closing resources : " + e);
		}
	}

	public void close(Statement st, Connection con) {
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			logger.error("While closing resources : " + e);
		}
	}
}
