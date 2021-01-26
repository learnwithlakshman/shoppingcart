package com.careerit.shoppingcart.service;

import com.careerit.shoppingcart.domain.User;

public interface UserService {

		public User registerUser(User user);
		public User loadUserByEmail(String email);
		public boolean login(String email,String password);
}
