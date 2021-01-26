package com.careerit.shoppingcart.service;

import java.util.Objects;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.careerit.shoppingcart.dao.UserDao;
import com.careerit.shoppingcart.dao.UserDaoImpl;
import com.careerit.shoppingcart.domain.User;

public class UserServiceImpl implements UserService {

	private static Logger logger = LogManager.getLogger(UserServiceImpl.class);
	private UserDao userDao = new UserDaoImpl();

	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User loadUserByEmail(String email) {
		Objects.requireNonNull(email, "Email id can't be empty or null");
		User user = userDao.loadUserByEmail(email);
		return Optional.ofNullable(user)
				.orElseThrow(() -> new UserNotFoundException("User not found with given " + email));
	}

	@Override
	public boolean login(String email, String password) {
		Objects.requireNonNull(email, "Email id can't be empty or null");
		Objects.requireNonNull(password, "Password can't be empty or null");
		logger.info("User requested with email:"+email);
		try {
			User user = loadUserByEmail(email);
			if (user.getPassword().equals(password)) {
				logger.info("User provided valid credentials");
				return true;
			}
		} catch (UserNotFoundException e) {
			logger.error("Bad credentials" + e);
		}
		return false;
	}

}
