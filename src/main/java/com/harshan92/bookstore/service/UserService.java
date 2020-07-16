package com.harshan92.bookstore.service;

import com.harshan92.bookstore.domain.User;
import com.harshan92.bookstore.domain.security.PasswordResetToken;

public interface UserService {
    PasswordResetToken getPasswordResetToken(final String token);
    void createPasswordResetTokenForUser(final User user, final String token);
}
