package com.harshan92.bookstore.service;

import com.harshan92.bookstore.domain.User;
import com.harshan92.bookstore.domain.security.PasswordResetToken;
import com.harshan92.bookstore.domain.security.UserRole;

import java.util.Set;

public interface UserService {
    PasswordResetToken getPasswordResetToken(final String token);
    void createPasswordResetTokenForUser(final User user, final String token);
    User findByUsername(String username);
    User findByEmail(String email);
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;
}
