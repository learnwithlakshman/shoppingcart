package com.careerit.shoppingcart.dao;

import com.careerit.shoppingcart.domain.User;

public interface UserDao {

			public User register(User user);
			public User loadUserByEmail(String email);
}
