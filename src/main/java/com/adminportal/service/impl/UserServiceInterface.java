package com.adminportal.service.impl;

import java.util.Set;

import com.adminportal.domain.User;
import com.adminportal.domain.security.PasswordResetToken;
import com.adminportal.domain.security.UserRole;


public interface UserServiceInterface {
	
	User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
	User save(User user);

	PasswordResetToken getPasswordResetToken(String token);

	void createPasswordResetTokenForUser(User user, String token);

	User findByUsername(String username);

	User findByEmail(String email);
}
