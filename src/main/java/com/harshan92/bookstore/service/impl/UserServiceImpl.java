package com.harshan92.bookstore.service.impl;

import com.harshan92.bookstore.domain.User;
import com.harshan92.bookstore.domain.security.PasswordResetToken;
import com.harshan92.bookstore.repository.PasswordResetTokenRepository;
import com.harshan92.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;
    @Override
    public PasswordResetToken getPasswordResetToken(String token) {
        return passwordResetTokenRepository.findByToken(token);
    }

    @Override
    public void createPasswordResetTokenForUser(User user, String token) {
        final PasswordResetToken myToken=new PasswordResetToken(token, user);
        passwordResetTokenRepository.save(myToken);
    }
}
